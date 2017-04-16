package cn.edu.ncut.high.efficient;

import java.util.ArrayList;
import java.util.LinkedList;

public class TestFinal {

	public static void main(String[] args) {
		FinalTest finalTest = new FinalTest();
		FinalTestV2 finalTestV2 = new FinalTestV2();
		
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 1000000000; i++) {
			finalTest.getName();
		}
		long t2 = System.currentTimeMillis();

		for (int i = 0; i < 1000000000; i++) {
			finalTestV2.getName();
		}
		long t3 = System.currentTimeMillis();
		
		System.out.println("No Final:"+(t2-t1));
		System.out.println("Final:"+(t3-t2));
		
		
		//ArrayList Vector LinkedList
	}

}
