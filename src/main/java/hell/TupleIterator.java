package hell;

import java.util.Iterator;

/**
 * �^�v���̊e�v�f���������Ă�Ǝv���˂�
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
	 * 2��Itarator����TupleIterator�����
	 */
	public TupleIterator(Iterator<? extends T1> ite1, Iterator<? extends T2> ite2) {
		this.ite1 = ite1;
		this.ite2 = ite2;
	}

	/**
	 * @throws IllegalStateException �ӂ���Itarator�̗v�f�����s��v�̏ꍇ
	 */
	@Override
	public boolean hasNext() {
		boolean n1 = ite1.hasNext();
		boolean n2 = ite2.hasNext();
		if (n1 ^ n2) {
			throw new IllegalStateException("���̕s��v");
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

	/** �g�� */
	public class Ex<T3> extends TupleIterator<Tuple<T1, T2>, T3> {
		public Ex(Iterator<? extends T3> ite3) {
			super(TupleIterator.this, ite3);
		}
	}

}