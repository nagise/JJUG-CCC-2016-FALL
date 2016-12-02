package hell;

public class KeyGroupImpl extends KeyGroup<KeyGroupImpl> {
	private static final KeyGroupImpl singleton = new KeyGroupImpl();

	/** KEY_1では値はString型 */
	public static final Key<String> KEY_1 = singleton.new Key<String>();

	/** KEY_2では値はInteger型 */
	public static final Key<Integer> KEY_2 = singleton.new Key<Integer>();
}
