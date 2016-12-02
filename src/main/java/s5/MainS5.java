package s5;

import java.util.ArrayList;
import java.util.List;

import s3.*;

/**
 * �p�����^���C�Y�h�^�C�v�̕ϐ��̃T���v��
 * 
 * @author nagise
 */
public class MainS5 {
	public static void main(String[] args) {
		// ��ϐ�
		List<A> listA = new ArrayList<A>();
		List<B> listB = listA; // NG

		// ���ϐ�
		// �߂�l�̌^�ϐ��͎g����
		// �����̌^�ϐ��͎g���Ȃ�(null������)
		List<? extends A> listExA = new ArrayList<B>();
		A a = listExA.get(0); // A�^�Ƃ��Ď擾�ł���
		listExA.add(null); // null������add�ł���

		// ���ϐ�
		// �߂�l�̌^�ϐ��͎g���Ȃ�(Object�^����)
		// �����̌^�ϐ��͎g����
		List<? super C> listSuC = new ArrayList<B>();
		Object o = listSuC.get(0); // �S�Ă̐eObject�^�Ƃ��Ă����擾�ł���
		listSuC.add(new C()); // C�^��add�ł���
	}
}
