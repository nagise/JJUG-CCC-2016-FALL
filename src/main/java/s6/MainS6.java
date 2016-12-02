package s6;

import java.io.Serializable;

import s3.A;
import s3.B;
import s3.B2;
import s3.C;

public class MainS6 {
	public static void main(String[] args) {
		new Hoge<A>(); // ← NG
		new Hoge<B>(); // ← OK
		new Hoge<B2>(); // ← NG
		new Hoge<C>(); // ← OK
		
		Bar bar = new Bar();
		// メソッドの戻り値が抽象型のFooでなく、具象型のBarである点に注目
		Bar bar2 = bar.getConcreteObject();
	}

	/**
	 * @param <T> 境界のある型変数。superはダメ
	 */
	static class Hoge<T extends B> {}

	/**
	 * @param <T> 境界のある型変数。
	 * 	& で繋いでインタフェースを境界に加えることができる
	 */
	static class Piyo<T extends A & Serializable> {}

	/**
	 * 再起ジェネリクスのサンプル
	 * @param <T> このTにはFooの具象型を継承でバインドする
	 */
	abstract static class Foo<T extends Foo<T>> {
		public abstract T getConcreteObject();
	}
	
	/**
	 * 具象型のバインド
	 */
	static class Bar extends Foo<Bar> {
		@Override
		public Bar getConcreteObject() {
			return this;
		}
	}
}
