package s3;

public class MainS3 {
	public static void main(String[] args) {
		Object[] o = new String[]{"hoge"};
		o[0] = 123;
		{
			A a = new B();  // OK
			B b = (B) a;  // ���̕ϊ��͈��S�Ƃ͌���Ȃ�
			System.out.println(b);
		}

		{
			A a = new B2();  // OK
			B b = (B) a;  // ClassCastException ���̂�B2�ł��邽��
			System.out.println(b);
		}
	}
}
