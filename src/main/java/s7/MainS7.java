package s7;

/**
 * �����N���X�̃T���v��
 * @author nagise
 */
public class MainS7 {
	public static void main(String[] args) {
		// �܂�outer�̃C���X�^���X�����
		Outer<String> outer = new Outer<String>();
		// ����outer.new �œ����N���X�̃C���X�^���X�����
		Outer<String>.Inner inner = outer.new Inner();
	}
}
