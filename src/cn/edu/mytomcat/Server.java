package cn.edu.mytomcat;

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
				System.out.println("第" + count + "连接服务器");
				
				//从流中取出
				InputStream inputStream = socket.getInputStream();
				byte[] bs =new byte[1024];
				int len = inputStream.read(bs);
				if(len>0)
				{
					String str =new String(bs, 0, len);
					System.out.println("Request Content!"+str);
				}else{
					System.out.println("Bas Request!");
				}
				
				//获取服务器给客户端信息
				OutputStream outputStream = socket.getOutputStream();
				String html ="<html><title>Hello</title><body>Time Now："+format+"</body></html>";
				outputStream.write(html.getBytes());
				outputStream.flush();
				outputStream.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}

