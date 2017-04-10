package cn.edu.mytomcat3;

import java.io.IOException;

public class RegisterServlet extends HttpServlet{

	@Override
	public void service(Request request, Response response) throws IOException {
		response.writeFile("html/regSuccess.html");
	}
}
