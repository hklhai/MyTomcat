package cn.edu.ncut.hashmap;

public class MeHashMap<K,V> implements MeMap<K, V> {

	private static Integer defaultLength = 16;//2的倍数
	private static double defaultLoad = 0.75;
	private Entry<K,V>[] table = null;
	private int size = 0;
	
	MeHashMap(Integer defaultLength,double defaultLoad)
	{
		this.defaultLength=defaultLength;
		this.defaultLoad=defaultLoad;
		table = new Entry[defaultLength];
	}
	
	public MeHashMap()
	{
		this(defaultLength,defaultLoad);
	}
	
	@Override
	public V put(K key, V value) {
		// 根据key和hash函数取到数组中的下标
		int index = getIndex(key);
		
		// 根据这个下标判断该位置是否有数据
		Entry<K,V> e = table[index]; 
		
		if(null==e)
		{
			table[index] = new Entry(key,value,null,index);
			size++;
		}
		else//将原来的元素放在新元素的后，然后将新元素代替老元素
		{
			  Entry newEntry = new Entry(key,value,e,index);
			  table[index] = newEntry;
			  size++;
		}
		
		return table[index].getValue();
	}
	
	//先定义一个hash函数
	private int  getIndex(K key)
	{
		int m = defaultLength - 1;
		return key.hashCode()%m;
	}
	

	@Override
	public V get(K key) {
		// 根据key和hash函数取到数组中的下标
		int index = getIndex(key);
		
		return table[index].getValue() == null? null:table[index].getValue();
	}

	@Override
	public int siez() {
		return size;
	}
	
	//entry是HashMap的一个内部类，实现Map的内部接口
	class Entry<K,V> implements MeMap.Entry<K, V>
	{
		K key;
		V value;
		Entry<K,V> next;
		int index;
		  		
		
		
		public Entry(K key, V value, Entry<K, V> next, int index) {
			super();
			this.key = key;
			this.value = value;
			this.next = next;
			this.index = index;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}
		
		
		
	}	
	
}
