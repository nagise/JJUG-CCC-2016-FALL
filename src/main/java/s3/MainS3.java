package s3;

public class MainS3 {
	public static void main(String[] args) {
		Object[] o = new String[]{"hoge"};
		o[0] = 123;
		{
			A a = new B();  // OK
			B b = (B) a;  // ‚±‚Ì•ÏŠ·‚ÍˆÀ‘S‚Æ‚ÍŒÀ‚ç‚È‚¢
			System.out.println(b);
		}

		{
			A a = new B2();  // OK
			B b = (B) a;  // ClassCastException ŽÀ‘Ì‚ÍB2‚Å‚ ‚é‚½‚ß
			System.out.println(b);
		}
	}
}
