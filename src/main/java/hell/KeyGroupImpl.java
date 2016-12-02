package hell;

public class KeyGroupImpl extends KeyGroup<KeyGroupImpl> {
	private static final KeyGroupImpl singleton = new KeyGroupImpl();

	/** KEY_1�ł͒l��String�^ */
	public static final Key<String> KEY_1 = singleton.new Key<String>();

	/** KEY_2�ł͒l��Integer�^ */
	public static final Key<Integer> KEY_2 = singleton.new Key<Integer>();
}
