package s4;

/**
 * �C���X�^���X�X�R�[�v�̃W�F�l���N�X�̃T���v��
 * 
 * @author nagise
 */
public class MainS4_3 {

	public static void main(String[] args) {
		// �C���X�^���X�X�R�[�v�̃W�F�l���N�X�̃T���v��
		Hoge<String> hoge = new Hoge<String>();
		
		// �_�C�������h�I�y���[�^�[
		Hoge<String> hoge2 = new Hoge<>();
	}

	/**
	 * �^�ϐ������N���X�̐錾�T���v��
	 * 
	 * @param <T> �^�ϐ��̐錾�T���v��
	 */
	static class Hoge<T> {}
}
