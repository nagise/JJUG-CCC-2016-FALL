package hell;

public class KeyGroupImpl extends KeyGroup<KeyGroupImpl> {
	private static final KeyGroupImpl singleton = new KeyGroupImpl();

	/** KEY_1‚Å‚Í’l‚ÍStringŒ^ */
	public static final Key<String> KEY_1 = singleton.new Key<String>();

	/** KEY_2‚Å‚Í’l‚ÍIntegerŒ^ */
	public static final Key<Integer> KEY_2 = singleton.new Key<Integer>();
}
