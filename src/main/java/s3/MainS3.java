package s3;

public class MainS3 {
	public static void main(String[] args) {
		Object[] o = new String[]{"hoge"};
		o[0] = 123;
		{
			A a = new B();  // OK
			B b = (B) a;  // この変換は安全とは限らない
			System.out.println(b);
		}

		{
			A a = new B2();  // OK
			B b = (B) a;  // ClassCastException 実体はB2であるため
			System.out.println(b);
		}
	}
}
