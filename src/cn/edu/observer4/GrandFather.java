package cn.edu.observer4;

public class GrandFather implements WakupListener {
	private Child child;

	public void actionTOWakeUP(WakeUpEvent wakeUpEvent) {
		if (wakeUpEvent.isFeedTime())
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
		System.out.println(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1) + "：已经吃完！");
	}

	public void play(Child child) {
		System.out.println(this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1) + "+去玩耍！");
	}
}
