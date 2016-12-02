package s3;

import java.util.ArrayList;
import java.util.List;

/**
 * ジェネリクスの変性のサンプル
 * @author nagise
 */
public class MainS3_3 {
	public static void main(String[] args) {
		List<B> list;
		list = new ArrayList<B>(); // OK
		list = new ArrayList<A>(); // 当然ダメ
		list = new ArrayList<C>(); // これもダメ
	}
}
