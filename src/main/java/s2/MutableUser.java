package s2;

/**
 * 可変なユーザーのサンプル
 * 
 * @author nagise
 */
public class MutableUser extends ImmutableUser {
	/** コンストラクタ */
	public MutableUser(String name, int age) {
		super(name, age);
	}

	/** @param name ユーザー名を設定 */
	public void setName(String name) {
		this.name = name;
	}

	/** @param age 年齢を設定 */
	public void setAge(int age) {
		this.age = age;
	}
}
