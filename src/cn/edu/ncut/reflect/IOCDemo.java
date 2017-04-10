package cn.edu.ncut.reflect;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class IOCDemo {

	public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		InputStream is = new FileInputStream("config.properties");
		Properties properties = new Properties();
		properties.load(is);
		String property = properties.getProperty("map");
		Map newInstance = (Map)Class.forName(property).newInstance();
		newInstance.put("aa", "bb");
		newInstance.put("cc", "dd");
		newInstance.put("ee", "ff");
		System.out.println(newInstance.size());
	
	}

}
