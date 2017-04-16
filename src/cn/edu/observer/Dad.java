package cn.edu.observer;

public class Dad  {
	private Child child;
	
	public Dad() {
	}

	public Dad(Child child) {
		this.child = child;
	}

	public void feed(Child child) {
		System.out.println("已经吃完！");

	}


}
