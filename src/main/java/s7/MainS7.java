package s7;

/**
 * 内部クラスのサンプル
 * @author nagise
 */
public class MainS7 {
	public static void main(String[] args) {
		// まずouterのインスタンスを作る
		Outer<String> outer = new Outer<String>();
		// 次にouter.new で内部クラスのインスタンスを作る
		Outer<String>.Inner inner = outer.new Inner();
	}
}
