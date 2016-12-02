package s6;

import java.io.Serializable;

import s3.A;
import s3.B;
import s3.B2;
import s3.C;

public class MainS6 {
	public static void main(String[] args) {
		new Hoge<A>(); // �� NG
		new Hoge<B>(); // �� OK
		new Hoge<B2>(); // �� NG
		new Hoge<C>(); // �� OK
		
		Bar bar = new Bar();
		// ���\�b�h�̖߂�l�����ی^��Foo�łȂ��A��ی^��Bar�ł���_�ɒ���
		Bar bar2 = bar.getConcreteObject();
	}

	/**
	 * @param <T> ���E�̂���^�ϐ��Bsuper�̓_��
	 */
	static class Hoge<T extends B> {}

	/**
	 * @param <T> ���E�̂���^�ϐ��B
	 * 	& �Ōq���ŃC���^�t�F�[�X�����E�ɉ����邱�Ƃ��ł���
	 */
	static class Piyo<T extends A & Serializable> {}

	/**
	 * �ċN�W�F�l���N�X�̃T���v��
	 * @param <T> ����T�ɂ�Foo�̋�ی^���p���Ńo�C���h����
	 */
	abstract static class Foo<T extends Foo<T>> {
		public abstract T getConcreteObject();
	}
	
	/**
	 * ��ی^�̃o�C���h
	 */
	static class Bar extends Foo<Bar> {
		@Override
		public Bar getConcreteObject() {
			return this;
		}
	}
}
