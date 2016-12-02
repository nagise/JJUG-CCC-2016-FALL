package s4;

/**
 * インスタンススコープのジェネリクスのサンプル
 * 
 * @author nagise
 */
public class MainS4_3 {

	public static void main(String[] args) {
		// インスタンススコープのジェネリクスのサンプル
		Hoge<String> hoge = new Hoge<String>();
		
		// ダイヤモンドオペレーター
		Hoge<String> hoge2 = new Hoge<>();
	}

	/**
	 * 型変数をもつクラスの宣言サンプル
	 * 
	 * @param <T> 型変数の宣言サンプル
	 */
	static class Hoge<T> {}
}
