package s4;

/**
 * ���\�b�h�X�R�[�v�̃W�F�l���N�X�̌Ăяo���T���v��
 * 
 * @author nagise
 */
public class MainS4 {
	public static void main(String[] args) {
		MainS4 m = new MainS4();
		m.test();
	}
	public void test() {
		// ���\�b�h�X�R�[�v�̃W�F�l���N�X�̌Ăяo��
		MainS4.<String>hoge("hello!");
		// �^���_
		MainS4.hoge("hello!");

		// �C���X�^���X���\�b�h�̏ꍇ
		this.<String>piyo("hello!");
		// �^���_
		this.piyo("hello!");
	}

	/**
	 * ���\�b�h�X�R�[�v�̃W�F�l���N�X�� static���\�b�h��
	 * @param <T> �T���v���p�_�~�[
	 */
	public static <T> void hoge(T t) {
		System.out.println("hoge : "+t);
	}

	/**
	 * ���\�b�h�X�R�[�v�̃W�F�l���N�X�� �C���X�^���X���\�b�h��
	 * @param <T> �T���v���p�_�~�[
	 */
	public <T> void piyo(T t) {
		System.out.println("piyo : "+t);
	}
}
