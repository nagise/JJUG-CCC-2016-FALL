package s4;

/**
 * ���܂��B
 * �R���X�g���N�^�X�R�[�v�̃W�F�l���N�X�̌Ăяo���T���v��
 * 
 * @author nagise
 */
public class MainS4_2 {
	public static void main(String[] args) {
		// �R���X�g���N�^�X�R�[�v�̃W�F�l���N�X�̖����I�o�C���h
		Hoge h1 = new <String>Hoge("hoge");
		// �R���X�g���N�^�X�R�[�v�̃W�F�l���N�X�̌^���_
		Hoge h2 = new Hoge("hoge");
	
		// �_�u��
		Piyo p1 = new <String>Piyo<Integer>(123, "piyo");
	}

	static class Hoge {
		/**
		 * �R���X�g���N�^�X�R�[�v�̌^�ϐ������R���X�g���N�^
		 * @param <T> �T���v���p�_�~�[
		 */
		public <T> Hoge(T t) {}
	}

	/**
	 * @param <T1> �T���v���p�_�~�[
	 */
	static class Piyo<T1> {
		/**
		 * �R���X�g���N�^�X�R�[�v�̌^�ϐ������R���X�g���N�^
		 * @param <T2> �T���v���p�_�~�[
		 */
		public <T2> Piyo(T1 t1, T2 t2) {}
	}
}
