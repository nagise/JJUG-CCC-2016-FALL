package s5;

import java.util.ArrayList;
import java.util.List;

import s3.*;

/**
 * パラメタライズドタイプの変性のサンプル
 * 
 * @author nagise
 */
public class MainS5 {
	public static void main(String[] args) {
		// 非変性
		List<A> listA = new ArrayList<A>();
		List<B> listB = listA; // NG

		// 共変性
		// 戻り値の型変数は使える
		// 引数の型変数は使えない(nullだけ可)
		List<? extends A> listExA = new ArrayList<B>();
		A a = listExA.get(0); // A型として取得できる
		listExA.add(null); // nullだけをaddできる

		// 反変性
		// 戻り値の型変数は使えない(Object型扱い)
		// 引数の型変数は使える
		List<? super C> listSuC = new ArrayList<B>();
		Object o = listSuC.get(0); // 全ての親Object型としてだけ取得できる
		listSuC.add(new C()); // C型をaddできる
	}
}
