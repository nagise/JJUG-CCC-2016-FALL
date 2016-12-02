package s3;

/**
 * ArrayStoreException のサンプル
 * @author nagise
 */
public class MainS3_2 {
	public static void main(String[] args) {
		String[] stringArray = {"甲", "乙", "丙"};
		Object[] objectArray = stringArray;
		
		objectArray[1] = 123;
		// java.lang.ArrayStoreException が投げられる
	}
}
