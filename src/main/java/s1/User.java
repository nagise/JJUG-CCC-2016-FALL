package s1;

/**
 * ユーザー用の型。
 * サンプルなので定義は適当です。
 * 
 * @author nagise
 */
public class User {
	public String name;
	public int age;

	/** デフォルトコンストラクタ */
	public User() {}
	/** コンストラクタ */
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + this.name + ", age=" + this.age + "]";
	}
}
