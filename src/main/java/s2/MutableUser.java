package s2;

/**
 * �ςȃ��[�U�[�̃T���v��
 * 
 * @author nagise
 */
public class MutableUser extends ImmutableUser {
	/** �R���X�g���N�^ */
	public MutableUser(String name, int age) {
		super(name, age);
	}

	/** @param name ���[�U�[����ݒ� */
	public void setName(String name) {
		this.name = name;
	}

	/** @param age �N���ݒ� */
	public void setAge(int age) {
		this.age = age;
	}
}
