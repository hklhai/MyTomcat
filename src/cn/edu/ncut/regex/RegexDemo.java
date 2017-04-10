package cn.edu.ncut.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		String qq = "1238760";
		String regex = "[1-9][0-9]{1,14}";
		boolean matches = qq.matches(regex);
		System.out.println(matches);

		Pattern p = Pattern.compile("a*b");
		Matcher m = p.matcher("aaaaab");
		boolean b = m.matches();
	}
}
