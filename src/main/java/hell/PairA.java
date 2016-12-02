package hell;

/**
 * 相互再帰型変数のサンプル
 *
 * @author nagise
 *
 * @param <A>
 * @param <B>
 */
public interface PairA
<A extends PairA<? super A, ? super B>,
B extends PairB<? super A,? super B>> {

	B getPairB();
}
