package cn.edu.observerold;

public class Dad implements Runnable {
	private Child child;

	public Dad(Child child) {
		this.child = child;
	}

	public void feed(Child child) {
		System.out.println("已经吃完！");

	}

	@Override
	public void run() {
		while (!child.isWakeup()) {
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(1000);
					System.out.println(i+1);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.feed(child);
	}

}
