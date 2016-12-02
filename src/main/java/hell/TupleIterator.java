package hell;

import java.util.Iterator;

/**
 * タプルの各要素が複数個持てると思いねえ
 * 
 * @author nagise
 *
 * @param <T1>
 * @param <T2>
 */
public class TupleIterator<T1, T2>
implements Iterator<Tuple<T1, T2>> {
	Iterator<? extends T1> ite1;
	Iterator<? extends T2> ite2;

	/**
	 * 2つのItaratorからTupleIteratorを作る
	 */
	public TupleIterator(Iterator<? extends T1> ite1, Iterator<? extends T2> ite2) {
		this.ite1 = ite1;
		this.ite2 = ite2;
	}

	/**
	 * @throws IllegalStateException ふたつのItaratorの要素数が不一致の場合
	 */
	@Override
	public boolean hasNext() {
		boolean n1 = ite1.hasNext();
		boolean n2 = ite2.hasNext();
		if (n1 ^ n2) {
			throw new IllegalStateException("個数の不一致");
		}
		return n1;
	}

	@Override
	public Tuple<T1, T2> next() {
		return new Tuple<T1, T2>(ite1.next(), ite2.next());
	}

	@Override
	public void remove() {
		ite1.remove();
		ite2.remove();
	}

	/** 拡張 */
	public class Ex<T3> extends TupleIterator<Tuple<T1, T2>, T3> {
		public Ex(Iterator<? extends T3> ite3) {
			super(TupleIterator.this, ite3);
		}
	}

}