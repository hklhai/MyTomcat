package cn.edu.mytomcat2;

import java.io.IOException;

public class LoginServlet {
	public void service(Request request,Response response) throws IOException {
		String username = request.getParamValue("name");
		String passwd = request.getParamValue("passwd");
		if(username!=null&&username.equals("admin")&&passwd!=null&&passwd.equals("123"))
		{
			response.writeFile("html/success.html");
		}else
		{
			response.writeFile("html/fail.html");
		}
	}
}
