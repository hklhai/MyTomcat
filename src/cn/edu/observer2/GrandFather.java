package cn.edu.observer2;

public class GrandFather {
	private Child child;

	public void actionTOWakeUP(WakeUpEvent wakeUpEvent) {
		if(wakeUpEvent.isFeedTime())
			this.feed(child);
		else
			this.play(child);
	}

	public GrandFather() {
		super();
	}

	public GrandFather(Child child) {
		this.child = child;
	}

	public void feed(Child child) {
		System.out.println("已经吃完！");
	}

	public void play(Child child) {
		System.out.println("去玩耍！");
	}
}
