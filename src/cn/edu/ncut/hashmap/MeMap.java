package cn.edu.ncut.hashmap;

public interface MeMap<K,V> {
	
	V put(K key,V value);
	V get(K key);
	
	int siez();
	
	interface Entry<K,V>
	{
		K getKey();
		
		V getValue();
	}
	
}
