package s2;

/**
 * �s�ς�User�̃T���v��
 * 
 * @author nagise
 */
public class ImmutableUser {
	String name;
	int age;

	/** �R���X�g���N�^ */
	public ImmutableUser(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/** @return ���̂��擾 */
	public String getName() {
		return this.name;
	}

	/** @return �N����擾 */
	public int getAge() {
		return this.age;
	}

	@Override
	public String toString() {
		return "User [name=" + this.name + ", age=" + this.age + "]";
	}
}
