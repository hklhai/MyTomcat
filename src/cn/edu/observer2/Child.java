package cn.edu.observer2;

public class Child implements Runnable {

	private Dad dad;

	public Child(Dad dad) {
		this.dad = dad;
	}

	public void wakeup() {
		dad.actionTOWakeUP(new WakeUpEvent(false, this));
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
				flag=false;
				this.wakeup();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
