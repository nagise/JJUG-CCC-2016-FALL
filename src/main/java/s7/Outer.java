package s7;

/**
 * �O���̃N���X
 * @author nagise
 *
 * @param <T>
 */
public class Outer<T> {

	/**
	 * �����N���X�Bstatic�ł͂Ȃ��_�ɒ���
	 */
	public class Inner {
		/** �O���̌^�ϐ� T ���g���� */
		T genericField;
	}
}
