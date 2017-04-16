package cn.edu.observer3;

public class LookChild {

	public static void main(String[] args) {
		Child child = new Child();
		child.addWakupListener(new GrandFather());
		child.addWakupListener(new Dad());
		new Thread(child).start();
	}

}
