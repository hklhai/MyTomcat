package cn.edu.observer4;

import java.util.Map;

public class LookChild {

	public static void main(String[] args) throws Exception {
		Child child = new Child();
		// child.addWakupListener(new GrandFather());
		// child.addWakupListener(new Dad());
		Map<String, String> map = PropertiesManager.getConfig();
		for (Map.Entry<String, String> m : map.entrySet()) {
			System.out.println(m.getKey() + " " + m.getValue());
			WakupListener newInstance = (WakupListener) Class.forName(m.getValue()).newInstance();
			child.addWakupListener(newInstance);

		}
		new Thread(child).start();
	}

}
