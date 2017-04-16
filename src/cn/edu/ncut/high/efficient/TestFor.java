package cn.edu.ncut.high.efficient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestFor {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < 10000000; i++) {
			list.add(i);
		}

		int size = list.size();

		Long t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++)
			for (int j = 0; j < size; j++)
				list.get(j);
		Long t2 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++)
			for (Integer in : list) {
			}
		Long t3 = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			Iterator<Integer> iterator = list.iterator();
			while (iterator.hasNext()) {
				iterator.next();
			}
		}
		Long t4 = System.currentTimeMillis();

		System.out.println("for:" + (t2 - t1));
		System.out.println("foreach:" + (t3 - t2));
		System.out.println("Iterator:" + (t4 - t3));

		
		int a =1;
		Integer b =1;
		
		//44行存在3个对象，其中i,12,13均存在堆内存； 45行存在1个对象存在堆内存，11,12存在栈中
		Integer[] i = {11,12};
		int[] ii = {11,12};
		
		//同步代码块粒度越小则执行效率越高，因为竞争锁只会锁定同步的方法，等待的时间会少   
		//HashMap
		
		
		
	}

}
