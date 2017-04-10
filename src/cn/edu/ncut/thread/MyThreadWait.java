package cn.edu.ncut.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThreadWait {

	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	String[] flag = { "true" };

	int count = 0;

	public static void main(String[] args) {
		MyThreadWait myThreadWait = new MyThreadWait();
		myThreadWait.new ThreadA().start();
		myThreadWait.new ThreadA().start();
		myThreadWait.new ThreadA().start();
		myThreadWait.new ThreadA().start();
		myThreadWait.new ThreadB().start();

	}

	class ThreadA extends Thread {
		@Override
		public void run() {
			while (flag[0] != "false") {
				if (count >= 100) {
					try {
						System.out.println("Current Thread:" + Thread.currentThread().getName() + "   Current Time:" + df.format(new Date()) + "Start Wait!");
						long currentTime = System.currentTimeMillis();

						synchronized (flag) {
							flag.wait();
						}

						System.out.println("Current Thread:" + Thread.currentThread().getName() + "   Current Time:" + df.format(new Date()) + "Wait During:" + (System.currentTimeMillis() - currentTime));

					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("Current Thread:" + Thread.currentThread().getName() + "   Current Time:" + df.format(new Date()) + "count:" + count++);

				}

			}
		}
	}

	class ThreadB extends Thread {

		@Override
		public void run() {
			try {
				sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Current Thread:" + Thread.currentThread().getName() + "   Current Time:" + df.format(new Date()) + "notify Thread A ");

			synchronized (flag) {
				flag[0] = "false";
				flag.notifyAll();
			}
		}
	}
}
