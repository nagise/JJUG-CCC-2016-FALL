package s5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import s3.*;

/**
 * �p�����^���C�Y�h�^�C�v�̕ϐ��̃T���v��
 * 
 * @author nagise
 */
public class MainS5_2 {
	public static void main(String[] args) {
		List<B> list = new ArrayList<>();
		list.add(new B());

		// list.stream().map() �̈�����
		// Function<? super T,? extends R>�^
		
		// <B, B> �͓��R���p�\
		Function<B, B> func1 = (B b) -> new B();
		list.stream().map(func1);

		// <A, B>
		Function<A, B> func2 = (A a) -> new B();
		list.stream().map(func2);

		// <B, C>
		Function<B, C> func3 = (B b) -> new C();
		list.stream().map(func3);
	}
}
