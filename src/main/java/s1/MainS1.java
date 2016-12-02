package s1;

import java.util.ArrayList;

public class MainS1 {
	public static void main(String[] args) {
		// *** IS-A関係
		UserList userList = new UserList();
		userList.add(new User("なぎせ", 0x24));
		userList.add(new User("いのうえ", 17));
		// ArrayListとしての機能を一通り使うことができる
		userList.remove(0);
		// ArrayList<User>を継承しているので、ArrayList<User>として扱える
		ArrayList<User> arrayList = userList;
		System.out.println(arrayList);
		
		// *** HAS-A関係
		Users users = new Users();
		users.add(new User("なぎせ", 0x24));
		users.add(new User("いのうえ", 17));
		// 実装した機能しか利用することができない
		System.out.println(users.get(0));
	}
}
