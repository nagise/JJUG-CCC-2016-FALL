package hell;

import java.util.HashMap;
import java.util.Map;

/**
 * 型安全なKey / Value ストア。
 * 予めKeyを列挙しておく必要がある
 * 
 * @author nagise
 *
 * @param <KG>
 */
public class KeyValue<KG extends KeyGroup<KG>> {
	Map<Object, Object> map = new HashMap<>();
	
	/**
	 * ストアに値を格納する
	 * @param key キーを表す列挙
	 * @param value 値
	 */
	public <T> void put(KeyGroup<KG>.Key<T> key, T value){
		map.put(key, value);
	}

	/**
	 * ストアから値を取得する
	 * @param key キーを表す列挙
	 * @return 値
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(KeyGroup<KG>.Key<T> key) {
		return (T) map.get(key);
	}
}