package s1;

import java.util.ArrayList;

public class MainS1 {
	public static void main(String[] args) {
		// *** IS-A�֌W
		UserList userList = new UserList();
		userList.add(new User("�Ȃ���", 0x24));
		userList.add(new User("���̂���", 17));
		// ArrayList�Ƃ��Ă̋@�\����ʂ�g�����Ƃ��ł���
		userList.remove(0);
		// ArrayList<User>���p�����Ă���̂ŁAArrayList<User>�Ƃ��Ĉ�����
		ArrayList<User> arrayList = userList;
		System.out.println(arrayList);
		
		// *** HAS-A�֌W
		Users users = new Users();
		users.add(new User("�Ȃ���", 0x24));
		users.add(new User("���̂���", 17));
		// ���������@�\�������p���邱�Ƃ��ł��Ȃ�
		System.out.println(users.get(0));
	}
}
