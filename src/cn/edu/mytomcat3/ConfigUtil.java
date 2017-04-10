package cn.edu.mytomcat3;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigUtil {

	public static Map<String, String> getClassName(String path) throws Exception {
		 Map<String, String> handlerMap = new HashMap<String, String>();
		 
		 SAXReader saxReader  =new SAXReader();
		 File file =new File(path);
		 Document document = saxReader.read(file);
		 Element root = document.getRootElement();
		 
		 List<Element> elements = root.elements();
		 for (Element element : elements) {
			 String key = element.element("url-pattern").getText();
			 String value = element.element("servlet-class").getText();
			 handlerMap.put(key, value);
		}
		 
		 return handlerMap;
	}

}
