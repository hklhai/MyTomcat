package cn.edu.ncut.thread;

public class TestThreadV2 extends Thread {

	MyClass myClass;

	public TestThreadV2(MyClass myClass) {
		this.myClass = myClass;
	}

	public static void main(String[] args) {
		MyClass myClass2 = new MyClass();
		TestThreadV2 testThread1 = new TestThreadV2(myClass2);
		TestThreadV2 testThread2 = new TestThreadV2(myClass2);
		testThread1.start();
		testThread2.start();
	}

	@Override
	public void run() {
		while (true) {
			myClass.v();

		}
	}
}
