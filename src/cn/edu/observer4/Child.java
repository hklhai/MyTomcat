package cn.edu.observer4;

import java.util.ArrayList;
import java.util.List;

public class Child implements Runnable {

	private List<WakupListener> wakupListeners = new ArrayList<>();

	private Dad dad;

	public void addWakupListener(WakupListener wakupListener) {
		wakupListeners.add(wakupListener);
	}

	public Child() {
	}

	public Child(Dad dad) {
		this.dad = dad;
	}

	public void wakeup() {
		// dad.actionTOWakeUP(new WakeUpEvent(false, this));
		for (WakupListener wakupListener : wakupListeners) {
			wakupListener.actionTOWakeUP(new WakeUpEvent(true, this));
		}
	}

	@Override
	public void run() {
		boolean flag = true;
		while (flag) {
			try {
				for (int i = 0; i < 5; i++) {
					Thread.sleep(1000);
					System.out.println(i + 1);
				}
				flag = false;
				this.wakeup();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
