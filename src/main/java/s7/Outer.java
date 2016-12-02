package s7;

/**
 * 外側のクラス
 * @author nagise
 *
 * @param <T>
 */
public class Outer<T> {

	/**
	 * 内部クラス。staticではない点に注意
	 */
	public class Inner {
		/** 外側の型変数 T が使える */
		T genericField;
	}
}
