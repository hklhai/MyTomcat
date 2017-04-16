package cn.edu.observer4;

public class WakeUpEvent {
	private boolean isFeedTime;

	Child child;

	public WakeUpEvent(boolean isFeedTime, Child child) {
		this.child = child;
	}

	public boolean isFeedTime() {
		return isFeedTime;
	}

	public void setFeedTime(boolean isFeedTime) {
		this.isFeedTime = isFeedTime;
	}

}
