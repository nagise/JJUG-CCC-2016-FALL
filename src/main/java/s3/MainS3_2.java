package s3;

/**
 * ArrayStoreException ‚ÌƒTƒ“ƒvƒ‹
 * @author nagise
 */
public class MainS3_2 {
	public static void main(String[] args) {
		String[] stringArray = {"b", "‰³", "•¸"};
		Object[] objectArray = stringArray;
		
		objectArray[1] = 123;
		// java.lang.ArrayStoreException ‚ª“Š‚°‚ç‚ê‚é
	}
}
