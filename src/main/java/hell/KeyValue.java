package hell;

import java.util.HashMap;
import java.util.Map;

/**
 * �^���S��Key / Value �X�g�A�B
 * �\��Key��񋓂��Ă����K�v������
 * 
 * @author nagise
 *
 * @param <KG>
 */
public class KeyValue<KG extends KeyGroup<KG>> {
	Map<Object, Object> map = new HashMap<>();
	
	/**
	 * �X�g�A�ɒl���i�[����
	 * @param key �L�[��\����
	 * @param value �l
	 */
	public <T> void put(KeyGroup<KG>.Key<T> key, T value){
		map.put(key, value);
	}

	/**
	 * �X�g�A����l���擾����
	 * @param key �L�[��\����
	 * @return �l
	 */
	@SuppressWarnings("unchecked")
	public <T> T get(KeyGroup<KG>.Key<T> key) {
		return (T) map.get(key);
	}
}