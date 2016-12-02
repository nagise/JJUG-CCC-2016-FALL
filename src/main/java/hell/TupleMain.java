package hell;

import java.util.ArrayList;
import java.util.List;

/**
 * 内部クラスを用いた可変長タプルの利用サンプル
 * 
 * @author nagise
 */
public class TupleMain {
	public static void main(String[] args) {
		Tuple<String, Integer> t1 =
			new Tuple<>("hoge", 123);
		System.out.println(t1);

		Tuple<String, Integer>.Ex<Boolean> t2 =
			t1.new Ex<>(true);
		System.out.println(t2);

		Tuple<Tuple<String, Integer>,Boolean>.Ex<String> t3 =
			t2.new Ex<>("piyo");
		System.out.println(t3);
		
		// タプルイテレータの利用
		List<String> sList = new ArrayList<>();
		sList.add("いち");
		sList.add("に");
		List<Integer> iList = new ArrayList<>();
		iList.add(123);
		iList.add(234);
		List<Boolean> bList = new ArrayList<>();
		bList.add(true);
		bList.add(false);

		TupleIterator<String, Integer> ti =
				new TupleIterator<>(sList.iterator(), iList.iterator());
		TupleIterator<String, Integer>.Ex<Boolean> ex =
				ti.new Ex<>(bList.iterator());

		while (ex.hasNext()) {
			Tuple<Tuple<String,Integer>,Boolean> next = ex.next();
			System.out.println(next);
		}
	}
}
