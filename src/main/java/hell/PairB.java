package hell;

/**
 * ���ݍċA�^�ϐ��̃T���v��
 *
 * @author nagise
 *
 * @param <A>
 * @param <B>
 */
public interface PairB
<A extends PairA<? super A, ? super B>,
B extends PairB<? super A,? super B>> {

	A getPairA();
}
