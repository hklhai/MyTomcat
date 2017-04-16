package cn.edu.observerold;

public class LookChild {

	public static void main(String[] args) {
		Child child= new Child();
		new Thread(child).start();
		new Thread(new Dad(child)).start();
	}

}
