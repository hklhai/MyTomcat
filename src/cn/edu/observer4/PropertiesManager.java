package cn.edu.observer4;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * @author lenovo
 *
 */
public class PropertiesManager {
	public static Map<String, String> getConfig() {
		Map<String, String> map = new HashMap<>();
		Properties properties = new Properties();

		try {
			InputStreamReader inputStreamReader = new InputStreamReader(PropertiesManager.class.getClassLoader().getResourceAsStream("config.properties"), "UTF-8");
			properties.load(inputStreamReader);
			Iterator<String> iterator = properties.stringPropertyNames().iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				map.put(key, properties.getProperty(key));
			}
			inputStreamReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}
}
