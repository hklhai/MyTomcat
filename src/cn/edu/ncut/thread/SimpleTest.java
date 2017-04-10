package cn.edu.ncut.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleTest {
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public static void main(String[] args) {
		SimpleTest simpleTest = new SimpleTest();
		MyClass myClass = simpleTest.new MyClass();
//		simpleTest.new MyTest(myClass).start();
//		simpleTest.new MyTest(myClass).start();
//		simpleTest.new MyTest(simpleTest.new MyClass()).start();
//		simpleTest.new MyTest(simpleTest.new MyClass()).start();
		simpleTest.new MyTest(myClass).start();
		simpleTest.new MyTest2(myClass).start();
	}

	class MyClass {
		public void a() {
			System.out.println("Current Thread:" + Thread.currentThread().getName() + " Current Time:" + df.format(new Date()) + "Call A!");

		}

		public synchronized void c() {
			System.out.println("Current Thread:" + Thread.currentThread().getName() + "  Current Time:" + df.format(new Date()) + "Call Sync C!");

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
 		
		public synchronized void b() {
			System.out.println("Current Thread:" + Thread.currentThread().getName() + "  Current Time:" + df.format(new Date()) + "Call Sync B!");

			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	class MyTest extends Thread{
		MyClass myClass ;

		public MyTest(MyClass myClass) {
			this.myClass = myClass;
		}

		@Override
		public void run() {
			myClass.b();
		}
	}
	
	class MyTest2 extends Thread{
		MyClass myClass ;

		public MyTest2(MyClass myClass) {
			this.myClass = myClass;
		}

		@Override
		public void run() {
			myClass.c();
		}
	}
}
