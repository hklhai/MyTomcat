package cn.edu.mytomcat3;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import cn.edu.ncut.util.FileUtil;

public class Response {
	OutputStream outputStream = null;

	public Response(OutputStream outputStream) {
		this.outputStream = outputStream;
	}

	/**
	 * 静态方法
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void writeHtmlToFile(String path) throws IOException {
		String readFile = FileUtil.readFile(path);
		writeContent(readFile);
	}

	/**
	 * 动态方法
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void writeContent(String content) throws IOException {
		outputStream.write(content.getBytes());
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * 
	 * @param path
	 * @throws IOException
	 */
	public void writeFile(String path) throws IOException {
		FileInputStream fileInputStream = new FileInputStream(path);
		byte[] bs = new byte[512];
		int len = 0;

		// 增加返回Http header
		// String str = "Content-Type:text/html";
		// byte[] b = str.getBytes();

		PrintStream writer = new PrintStream(outputStream);
		writer.println("HTTP/1.0 200 OK");// 返回应答消息,并结束应答
		writer.println("Content-Type:text/html");
		// writer.println("Content-Length:" + fileToSend.length());// 返回内容字节数
		writer.println();// 根据 HTTP 协议, 空行将结束头信息

		while ((len = fileInputStream.read(bs)) != -1) {
			outputStream.write(bs, 0, len);
		}
		fileInputStream.close();
		outputStream.flush();
		outputStream.close();
	}

}
