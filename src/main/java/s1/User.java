package s1;

/**
 * ���[�U�[�p�̌^�B
 * �T���v���Ȃ̂Œ�`�͓K���ł��B
 * 
 * @author nagise
 */
public class User {
	public String name;
	public int age;

	/** �f�t�H���g�R���X�g���N�^ */
	public User() {}
	/** �R���X�g���N�^ */
	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + this.name + ", age=" + this.age + "]";
	}
}
