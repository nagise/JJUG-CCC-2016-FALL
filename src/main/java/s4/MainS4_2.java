package s4;

/**
 * おまけ。
 * コンストラクタスコープのジェネリクスの呼び出しサンプル
 * 
 * @author nagise
 */
public class MainS4_2 {
	public static void main(String[] args) {
		// コンストラクタスコープのジェネリクスの明示的バインド
		Hoge h1 = new <String>Hoge("hoge");
		// コンストラクタスコープのジェネリクスの型推論
		Hoge h2 = new Hoge("hoge");
	
		// ダブル
		Piyo p1 = new <String>Piyo<Integer>(123, "piyo");
	}

	static class Hoge {
		/**
		 * コンストラクタスコープの型変数をもつコンストラクタ
		 * @param <T> サンプル用ダミー
		 */
		public <T> Hoge(T t) {}
	}

	/**
	 * @param <T1> サンプル用ダミー
	 */
	static class Piyo<T1> {
		/**
		 * コンストラクタスコープの型変数をもつコンストラクタ
		 * @param <T2> サンプル用ダミー
		 */
		public <T2> Piyo(T1 t1, T2 t2) {}
	}
}
