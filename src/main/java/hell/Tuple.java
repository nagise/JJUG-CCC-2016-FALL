package hell;

/**
 * 可変長型変数のサンプル。
 * タプルを可変長に。
 * 
 * @author nagise
 *
 * @param <T1>
 * @param <T2>
 */
public class Tuple<T1, T2> {
	public T1 t1;
	public T2 t2;
	public Tuple(T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	@Override
	public String toString() {
		return ""+t1+", "+t2;
	}

	/** タプルの拡張 */
	public class Ex<T3> extends Tuple<Tuple<T1, T2>, T3> {
		public Ex(T3 t3) {
			super (Tuple.this, t3);
		}
	}
}