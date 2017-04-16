package cn.edu.observer;

public class LookChild {

	public static void main(String[] args) {
		new Thread(new Child(new Dad())).start();
	}

}
