package s2;

public class MainS2 {
	public static void main(String[] args) {
		ImmutableUser user = new MutableUser("�Ȃ���", 0x24);
		System.out.println(user);
		
		MutableUser mutableUser = (MutableUser)user;
		mutableUser.setName("nagise");

		System.out.println(user);
	}
}
