package s3;

/**
 * ArrayStoreException �̃T���v��
 * @author nagise
 */
public class MainS3_2 {
	public static void main(String[] args) {
		String[] stringArray = {"�b", "��", "��"};
		Object[] objectArray = stringArray;
		
		objectArray[1] = 123;
		// java.lang.ArrayStoreException ����������
	}
}
