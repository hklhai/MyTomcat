package cn.edu.ncut.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String str = "hello";
		// 1.实例化的对象  获取字节码
		Class clazz1 = str.getClass();
		
		// 2.类直接.class
		Class clazz2 = String.class;
		
		// 3.Class.fromName
		Class clazz3 = Class.forName("java.lang.String");
		
		System.out.println(clazz1==clazz2);
		System.out.println(clazz2==clazz3);
		System.out.println(clazz1==clazz3);
		
		System.out.println(Integer.class == int.class);
		System.out.println(Integer.TYPE == int.class);
		
		Constructor<?> constructor = Class.forName("java.lang.String").getConstructor(StringBuffer.class);
		String newInstance = (String)constructor.newInstance(new StringBuffer("abc"));
		System.out.println(newInstance.charAt(2));
	}

}
