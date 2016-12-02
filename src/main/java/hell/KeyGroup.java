package hell;

/**
 * 型安全なkey / valueストア用のキーの列挙
 * 
 * @author nagise
 */
public class KeyGroup<S extends KeyGroup<? super S>> {
	public class Key<T> {
	}
}