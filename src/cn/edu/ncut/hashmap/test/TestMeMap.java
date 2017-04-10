package cn.edu.ncut.hashmap.test;

import org.junit.Test;

import cn.edu.ncut.hashmap.MeHashMap;
import cn.edu.ncut.hashmap.MeMap;

public class TestMeMap {

	@Test
	public void test() {
		MeMap m = new MeHashMap();
		m.put("12", "lh");
		m.put("13", "lyy");
		m.put("14", "ww");
		m.put("15", "wzl");
		
		System.out.println(m.get("12")+" "+m.get("15"));
		
	}

}
