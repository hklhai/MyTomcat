package cn.edu.ncut.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSimple {

	/**
	 * 1、匹配 就是使用String类中的matches方法 2、切割 使用String类中的split方法 3、替换
	 * 使用String类中的replaceAll()方法 4、获取 使用Pattern实例获取匹配器后再拿到匹配的字符串
	 */
	public static void main(String[] args) {
		// isMobile();
		fun5();
	}

	// 匹配
	public static void isMobile() {
		String mobile = "15565279865";
		String regex = "[1][358][0-9]{9}"; // 或者regex = "[1][358]\\d{9}";
		boolean matches = mobile.matches(regex);
		System.out.println(mobile + ":" + matches);
	}

	// 切割1
	public static void fun() {
		String str = "lyy   lh     wzl ww hwj   xxz";
		String[] split = str.split(" +");// 匹配一个或多个空格
		for (String string : split) {
			System.out.println(string);
		}
	}

	// 切割2
	public static void fun2() {
		String str = "lyy.lh.wzl.ww";
		String[] split = str.split("[.]");// 或者\\.
		for (String string : split) {
			System.out.println(string);
		}
	}

	// 切割3
	public static void fun3() {
		String str = "lyyxxxxxxxlhrrrrrrrwzlttttttww";
		//String[] split = str.split("(.)\\1+");// 第二个参数使用第一个参数的值
		String[] split = str.split("(.)\\1{2,}?");// 第二个参数使用第一个参数的值
		for (String string : split) {
			System.out.println(string);
		}
	}

	// 替换
	public static void fun4() {
		String str = "zwlxxxxxxxlhrrrrrrrwzlttttttwh";
		// 将重复此替换成一个
		String string = str.replaceAll("(.)\\1+", "$1");// (.) 以任意字符分组 //1 表示第一组
		System.out.println(string);
		
		//替换电话号码
		String tel = "18813030755";
		String replaceAll = tel.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
		System.out.println(replaceAll);
	}

	
	// 获取
	public static void fun5() {
		String str = "wo jiu shi wo,mei yi tian dou jing cai du guo";
		String regex = "\\b[a-z]{3}\\b";
		
		Pattern compile = Pattern.compile(regex); 
		Matcher matcher = compile.matcher(str);
		while(matcher.find())
		{
			System.out.println(matcher.group());
			System.out.println(matcher.start()+" "+matcher.end());
		}
	}
}
