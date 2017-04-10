package cn.edu.ncut.thread;

public class TestStaticSync {

	public static void main(String[] args) {
		TestStaticSync testStaticSync = new TestStaticSync();
		StaticSync staticSync = new StaticSync();
		// testStaticSync.new MyTest(staticSync).start();
		// testStaticSync.new MyTest(staticSync).start();
		testStaticSync.new MyTest(new StaticSync()).start();
		testStaticSync.new MyTest2(new StaticSync()).start();
	}

	class MyTest extends Thread {
		StaticSync myClass;

		public MyTest(StaticSync myClass) {
			this.myClass = myClass;
		}

		@Override
		public void run() {
			StaticSync.b();
		}
	}
	
	class MyTest2 extends Thread {
		StaticSync myClass;

		public MyTest2(StaticSync myClass) {
			this.myClass = myClass;
		}

		@Override
		public void run() {
			StaticSync.c();
		}
	}
}
