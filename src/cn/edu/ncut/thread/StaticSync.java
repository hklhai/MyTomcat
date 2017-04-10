package cn.edu.ncut.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StaticSync {
	static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	public void a() {
		System.out.println("Current Thread:" + Thread.currentThread().getName() + " Current Time:" + df.format(new Date()) + "Call A!");

	}

	public static synchronized void c() {
		System.out.println("Current Thread:" + Thread.currentThread().getName() + "  Current Time:" + df.format(new Date()) + "Call Sync C!");

		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static synchronized void b() {
		System.out.println("Current Thread:" + Thread.currentThread().getName() + "  Current Time:" + df.format(new Date()) + "Call Sync B!");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
