package cn.edu.ncut.regex;

public class RegexDemo2 {

	// 我我我爱......爱爱...挑挑挑挑挑战....战战战战
	// IP 排序：192.168.10.34 127.0.0.1 3.3.3.3 105.70.11.55
	// 邮箱校验
	public static void main(String[] args) {
		mail();
	}

	private static void test() {
		// 1 . 把.去掉 \\.+
		String str = "我我我爱......爱爱...挑挑挑挑挑战....战战战战";
		String replaceAll = str.replaceAll("\\.+", "");
		System.out.println(replaceAll);
		// 2. 叠词化为一个
		String replaceAll2 = replaceAll.replaceAll("(.)\\1+", "$1");
		System.out.println(replaceAll2);
	}

	private static void mail() {
		String  str="1219307900@qq.com";
		//+ 出现一次或多次
		String regex = "[a-zA-z0-9]+@[a-zA-z0-9]+(\\.+[a-zA-z]{1,3})";
		boolean matches = str.matches(regex);
		System.out.println(matches);
		
	}

}
