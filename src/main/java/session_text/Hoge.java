package session_text;

public class Hoge {
	public static void main(String[] args) {
		RuntimeException e = m1();
		throw e;
	}
	
	static RuntimeException m1() {
		try {
			m2();
		} catch (RuntimeException e) {
			return e;
		}
		return null;
	}
	static void m2() {
		m3();
	}
	static void m3() {
		throw new RuntimeException();
	}
}
