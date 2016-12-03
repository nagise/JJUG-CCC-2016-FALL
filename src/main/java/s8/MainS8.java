package s8;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Stack;
import java.util.function.Supplier;

import com.google.gson.Gson;

import s1.User;

/**
 * 型変数のインスタンスをメソッド内で生成したいケースの考察いろいろ
 * 
 * @author nagise
 */
public class MainS8 {
	public static void main(String[] args) {
		// JSON形式からオブジェクトに変換するライブラリ
		// 引数にClassオブジェクトを渡し、リフレクションでインスタンスを作っている
		Gson gson = new Gson();
		User user = gson.fromJson("{\"name\":\"デューク\",\"age\":20}", User.class);
		System.out.println(user);
		
		// C#的な理想 (型推論がいささか怖いが) (Javaでは普通には無理)
		User u2 = sample1("{}");
		// C#的なバインドの明示パターン (Javaでは普通には無理)
		User u3 = MainS8.<User>sample1("{}");
		// Java的な妥協点
		// デフォルトコンストラクタが必須
		// デフォルトコンストラクタの有無はコンパイル時にチェックできない
		User u4 = MainS8.sample2("{}", User.class);

		// Java8風
		// Supplierを使うことでデフォルトコンストラクタ以外でも対応できる
		// パラメタライズドタイプでも対応できる
		User u5 = MainS8.sample3("{}", User::new);
		ArrayList<User> u6 = MainS8.sample3("[{},{}]", ArrayList::new);
		ArrayList<User> u7 = MainS8.sample3("[{},{}]", ArrayList<User>::new);
		ArrayList<User> u8 = MainS8.sample3("[{},{}]", ()-> new ArrayList<>());
		
		// 裏ワザ
		// デフォルトコンストラクタが必須
		User u9 = MainS8.sample4("{}");
		// 一見理想的に見えるが実はIDEの入力補完とは相性が悪くて使いにくい
		// T...dummy に nullを渡すと、型を取得するための配列が渡されないのでバグる
		// null が T[] とも new T[]{null}とも取れるので表現が曖昧に
//		User u10 = MainS8.sample4("{}", null);
		// テクニックを理解されないとむしろ記述がひどいことに
		User u11 = MainS8.sample4("{}", new User[]{null});

		// Factoryから行く場合だとそちらから型変数にバインドされた型を得ることも
		// シチュエーションさえハマれば使える
		Factory<User> factory = new Factory<User>();
		User u12 = factory.sample5("{}");
	}
	
	public static <T> T sample1(String json) {
		// Javaでは無理
		return null;
	}
	/**
	 * よく見かけるリフレクションで対応する方式。
	 * 弱点としてはArrayListのようなパラメタライズドタイプを扱うのに困る
	 * @param clazz リフレクションでnewするためのClassオブジェクト
	 */
	public static <T> T sample2(String json, Class<T> clazz) {
		try {
			T ret = clazz.newInstance();
			// 本当はここでjsonをパースして値を格納する処理が入る
			return ret;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * Java8からはSupplierとメソッド参照で実装するのが汎用性が高くスッキリする
	 * @param supplier インスタンスを作って返す
	 */
	public static <T> T sample3(String json, Supplier<T> supplier) {
		T ret = supplier.get();
		// 本当はここでjsonをパースして値を格納する処理が入る
		return ret;
	}
	/**
	 * 可変長配列で型を渡す裏ワザ。あまり良くはない
	 * @param json
	 * @param dummy 配列オブジェクトが渡るのでそこからリフレクションで型を得る
	 */
	public static <T> T sample4(String json, T ... dummy) {
		try {
			@SuppressWarnings("unchecked")
			Class<T> type = (Class<T>) dummy.getClass().getComponentType();
			T ret = type.newInstance();
			// 本当はここでjsonをパースして値を格納する処理が入る
			return ret;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Factory を継承して型変数をバインドするケース
	 * @param <T>
	 */
	static class Factory<T> {
		public T sample5(String json) {
			try {
				Class<T> type = getGenericType(this.getClass(),
						Factory.class, "T");
				T ret = type.newInstance();
				// 本当はここでjsonをパースして値を格納する処理が入る
				return ret;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 渡された型から継承階層を登って、
	 * 指定の親の型の指定の名前のジェネリクス型パラメータが
	 * 継承の過程で何型で具現化されているかを走査して返す。
	 * @param clazz 走査開始する型
	 * @param targetClass 走査する対象のジェネリクス型パラメータを持つ型。
	 * 走査開始型の親である必要がある。
	 * @param targetTypeName 何型で具現化されたを確認したい型パラメータのプレースホルダ名
	 * @return 具現化された型
	 */
	public static <T> Class<T> getGenericType(
	    Class<?> clazz, Class<?> targetClass,
	    String targetTypeName) {
	  if (!targetClass.isAssignableFrom(clazz)) {
	    throw new IllegalArgumentException(
	        "型" + clazz.getName() + "は、型"
	        + targetClass.getName() + "を継承していません");
	  }
	  Stack<Class<?>> stack = new Stack<Class<?>>();
	  while (!targetClass.equals(clazz.getSuperclass())) {
	    stack.push(clazz);
	    clazz = clazz.getSuperclass();
	  }
	  return getGenericTypeImpl(clazz, targetTypeName, stack);
	}
	/**
	 * 型パラメータの具象型取得の実装。再帰処理される。
	 * @param clazz 現在の走査対象型
	 * @param targetTypeName 現在の走査対象のジェネリクス型パラメータ名
	 * @param stack 現在の走査対象型以下の継承階層が積まれたStack
	 * @return 該当型パラメータの具現化された型
	 */
	@SuppressWarnings("unchecked")
	private static <T> Class<T> getGenericTypeImpl(Class<?> clazz,
	    String targetTypeName, Stack<Class<?>> stack) {
	  TypeVariable<? extends Class<?>>[] superGenTypeAray
	    = clazz.getSuperclass().getTypeParameters();

	  // 走査対象の型パラメータの名称(Tなど)から宣言のインデックスを取得
	  int index = 0;
	  boolean existFlag = false;
	  for (TypeVariable<? extends Class<?>> type : superGenTypeAray) {
	    if (targetTypeName.equals(type.getName())) {
	      existFlag = true;
	      break;
	    }
	    index++;
	  }
	  if (!existFlag) {
	    throw new IllegalArgumentException(
	        targetTypeName + "に合致するジェネリクス型パラメータがみつかりません");
	  }

	  // 走査対象の型パラメータが何型とされているのかを取得
	  ParameterizedType type = (ParameterizedType) clazz.getGenericSuperclass();
	  Type y = type.getActualTypeArguments()[index];

	  // 具象型で継承されている場合
	  if (y instanceof Class) {
	    return (Class<T>)y;
	  }
	  // ジェネリックパラメータの場合
	  if (y instanceof TypeVariable) {
	    TypeVariable<Class<?>> tv = (TypeVariable<Class<?>>)y;
	    // 再帰して同名の型パラメータを継承階層を下りながら解決を試みる
	    Class<?> sub = stack.pop();
	    return getGenericTypeImpl(sub, tv.getName(), stack);
	  }
	  // ジェネリック型パラメータを持つ型の場合
	  if (y instanceof ParameterizedType) {
	    ParameterizedType pt = (ParameterizedType) y;
	    return (Class<T>) pt.getRawType();
	  }
	  throw new IllegalArgumentException("予期せぬ型 : "
	      + y.toString() + " (" + y.getClass() + ")");
	}
}
