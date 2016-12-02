package s5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import s3.*;

/**
 * パラメタライズドタイプの変性のサンプル
 * 
 * @author nagise
 */
public class MainS5_2 {
	public static void main(String[] args) {
		List<B> list = new ArrayList<>();
		list.add(new B());

		// list.stream().map() の引数は
		// Function<? super T,? extends R>型
		
		// <B, B> は当然利用可能
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
