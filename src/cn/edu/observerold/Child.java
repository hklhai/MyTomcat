package cn.edu.observerold;

public class Child implements Runnable{

	private boolean wakeup = false;

	public boolean isWakeup() {
		return wakeup;
	}

	public void setWakeup(boolean wakeup) {
		this.wakeup = wakeup;
	}

	public void wakeup() {
		wakeup = true;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		wakeup();
	}

}
