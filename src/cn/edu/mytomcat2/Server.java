package cn.edu.mytomcat2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Server {

	private static int count = 0;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String format = simpleDateFormat.format(new Date());

		try {

			serverSocket = new ServerSocket(7777);
			System.out.println("Server init Finish! Waiting for client access!");
			while (true) {

				socket = serverSocket.accept();
				count++;
				System.out.println("第" + count + "连接服务器" + format);

				// 从流中取出
				InputStream inputStream = socket.getInputStream();
				Request request = new Request(inputStream);

				// 获取服务器给客户端信息
				OutputStream outputStream = socket.getOutputStream();
				Response response = new Response(outputStream);

				// 业务逻辑
				String uri = request.getUri();
				if (isStatic(uri)) {
					response.writeFile(uri.substring(1));
					// response.writeHtmlToFile(uri.substring(1));
				}else if(uri.endsWith(".action"))
				{
					if(uri.endsWith("login.action"))
					{
						 LoginServlet loginServlet = new LoginServlet();
						loginServlet.service(request, response);
					}
				}
				

				// 判断静态资源 html css img js
				socket.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static boolean isStatic(String uri) {
		String[] strs = { "html", "css", "jpg", "png", "jpeg", "js" };
		boolean isStatic = false;
		for (String string : strs) {
			if (uri.endsWith("." + string)) {
				isStatic = true;
				break;
			}
		}
		return isStatic;
	}
}
