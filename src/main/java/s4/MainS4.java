package s4;

/**
 * メソッドスコープのジェネリクスの呼び出しサンプル
 * 
 * @author nagise
 */
public class MainS4 {
	public static void main(String[] args) {
		MainS4 m = new MainS4();
		m.test();
	}
	public void test() {
		// メソッドスコープのジェネリクスの呼び出し
		MainS4.<String>hoge("hello!");
		// 型推論
		MainS4.hoge("hello!");

		// インスタンスメソッドの場合
		this.<String>piyo("hello!");
		// 型推論
		this.piyo("hello!");
	}

	/**
	 * メソッドスコープのジェネリクス例 staticメソッド版
	 * @param <T> サンプル用ダミー
	 */
	public static <T> void hoge(T t) {
		System.out.println("hoge : "+t);
	}

	/**
	 * メソッドスコープのジェネリクス例 インスタンスメソッド版
	 * @param <T> サンプル用ダミー
	 */
	public <T> void piyo(T t) {
		System.out.println("piyo : "+t);
	}
}
