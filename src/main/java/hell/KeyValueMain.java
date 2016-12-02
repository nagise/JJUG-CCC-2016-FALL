package hell;

public class KeyValueMain {
	public static void main(String[] args) {
		KeyValue<KeyGroupImpl> map = new KeyValue<KeyGroupImpl>();

		// KEY_1にはString型
		map.put(KeyGroupImpl.KEY_1, "hoge");
		String string = map.get(KeyGroupImpl.KEY_1);
		System.out.println(string);

		// KEY_2にはInteger型
		map.put(KeyGroupImpl.KEY_2, 123);
		Integer integer = map.get(KeyGroupImpl.KEY_2);
		System.out.println(integer);
	}
}
