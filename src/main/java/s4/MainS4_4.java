package s4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * インスタンススコープのジェネリクスのサンプル
 * 
 * @author nagise
 */
public class MainS4_4 {
	/** ひどいパラメタライズドタイプの例 */
	Map<String, Map<Integer, List<String>>> sample1;

	/** 途中で委譲クラスを挟めばそれなりにマシに */
	Map<String, HogeMap> sample2;

	/**
	 * なにかを管理するクラス
	 */
	static class HogeMap {
		Map<Integer, List<String>> map = new HashMap<>();
		
		/**
		 * 所定番号に値を追加する
		 * @param no 番号
		 * @param value 追加する値
		 */
		public void add(int no, String value) {
			List<String> list = map.get(no);
			if (list == null) {
				list = new ArrayList<>();
				map.put(no, list);
			}
			list.add(value);
		}
		/**
		 * 所定番号に登録された値の一覧を取得
		 * @param no 番号
		 * @return 一覧 (本当は可変な参照で返すと内部構造を暴露するのでよくない)
		 */
		public List<String> get(int no) {
			return map.get(no);
		}
	}
}
