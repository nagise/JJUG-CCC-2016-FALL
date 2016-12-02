package hell;

/**
 * 相互再帰のサンプル
 * 
 * @author nagise
 */
public class PairFactory {
	PairAImpl pairA;
	PairBImpl pairB;
	{
		pairA = new PairAImpl();
		pairB = new PairBImpl();
	}

	public class PairAImpl implements PairA<PairAImpl, PairBImpl> {
		@Override
		public PairBImpl getPairB() {
			return pairB;
		}
	}

	public class PairBImpl implements PairB<PairAImpl, PairBImpl> {
		@Override
		public PairAImpl getPairA() {
			return pairA;
		}

	}
}
