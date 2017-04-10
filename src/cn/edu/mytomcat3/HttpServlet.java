package cn.edu.mytomcat3;

import java.io.IOException;

public abstract class HttpServlet {
	public abstract void service(Request request, Response response) throws IOException ;
}
