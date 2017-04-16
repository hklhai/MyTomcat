package cn.edu.observer;

public class Child implements Runnable {

	private boolean wakeup = false;

	private Dad dad;

	public Child(Dad dad) {
		this.dad = dad;
	}

	public boolean isWakeup() {
		return wakeup;
	}

	public void setWakeup(boolean wakeup) {
		this.wakeup = wakeup;
	}

	public void wakeup() {
		wakeup = true;
		this.dad.feed(this);
	}

	@Override
	public void run() {
		while (!this.isWakeup()) {
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(1000);
					System.out.println(i + 1);
				}
				this.wakeup();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
