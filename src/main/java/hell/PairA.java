package hell;

/**
 * ‘ŠŒİÄ‹AŒ^•Ï”‚ÌƒTƒ“ƒvƒ‹
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
