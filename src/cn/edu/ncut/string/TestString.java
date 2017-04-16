package cn.edu.ncut.string;

public class TestString {

	public static void main(String[] args) {

			String aa = "aa";
			String aa1 = "aa";
			
			String aa2 = new String("aa");
			System.out.println(aa==aa2);
			System.out.println(aa==aa1);
			
			StringBuffer stringBuffer = new StringBuffer();
			StringBuffer append = stringBuffer.append("aaa").append("bbb");
			
			StringBuilder stringBuilder = new StringBuilder();
					
			
	}

}
