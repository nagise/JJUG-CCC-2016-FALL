package s3;

import java.util.ArrayList;
import java.util.List;

/**
 * �W�F�l���N�X�̕ϐ��̃T���v��
 * @author nagise
 */
public class MainS3_3 {
	public static void main(String[] args) {
		List<B> list;
		list = new ArrayList<B>(); // OK
		list = new ArrayList<A>(); // ���R�_��
		list = new ArrayList<C>(); // ������_��
	}
}
