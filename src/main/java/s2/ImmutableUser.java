package s2;

/**
 * 不変なUserのサンプル
 * 
 * @author nagise
 */
public class ImmutableUser {
	String name;
	int age;

	/** コンストラクタ */
	public ImmutableUser(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/** @return 名称を取得 */
	public String getName() {
		return this.name;
	}

	/** @return 年齢を取得 */
	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return "User [name=" + this.name + ", age=" + this.age + "]";
	}
}
