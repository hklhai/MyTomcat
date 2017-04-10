package cn.edu.mytomcat2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

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
		int len=0;
		
		while((len=fileInputStream.read(bs))!=-1)
		{
			outputStream.write(bs, 0, len);
		}
		fileInputStream.close();
		outputStream.flush();
		outputStream.close();
	}

}
