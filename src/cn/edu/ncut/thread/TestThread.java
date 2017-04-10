package cn.edu.ncut.thread;

import java.text.SimpleDateFormat;
import java.util.Date;


public class TestThread extends Thread {

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	
	public static void main(String[] args) {
		new TestThread().start();
		new TestThread().start();
		
	}
	
	@Override
	public void run() {
		while(true)
		{
			System.out.println("Current Thread:"+Thread.currentThread().getName()+"   Current Time:"+df.format(new Date()));
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
