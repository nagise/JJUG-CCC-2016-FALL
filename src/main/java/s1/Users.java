package s1;

import java.util.ArrayList;

/**
 * Userの一覧を表す型。
 * HAS-A関係のサンプルとしてフィールドにArrayListをもたせた。
 * ArrayListは隠蔽されており、直接操作することはできない。
 * 
 * @author nagise
 */
public class Users {
	ArrayList<User> userList = new ArrayList<>();

	/**
	 * ユーザーの追加
	 * @param user 追加するユーザー
	 */
	public void add(User user) {
		this.userList.add(user);
	}
	/**
	 * ユーザーの取得
	 * @param index 取得対象となるインデックス
	 * @return 取得されたユーザー
	 */
	public User get(int index) {
		return this.userList.get(index);
	}
}
