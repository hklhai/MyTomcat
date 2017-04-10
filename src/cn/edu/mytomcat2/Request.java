package cn.edu.mytomcat2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Request {

	private String uri;

	private Map<String, String> paramMap = new HashMap<>();

	
	public String getParamValue(String key)
	{
		return paramMap.get(key);
	}
	
	// 主要拿到请求的URL
	public Request(InputStream inputStream) throws IOException {
		byte[] bs = new byte[1024];
		int len = inputStream.read(bs);
		if (len > 0) {
			String str = new String(bs, 0, len);
			// 截取字符串
			// uri = str.substring(str.indexOf("/"), str.indexOf("HTTP/1.1")-1);
			// 判断GET或POST请求
			getURI(str);

			// 获取POST请求体中的参数
			if (str.startsWith("POST")) {
				int paramStart = str.lastIndexOf("\n");
				String paramStr = str.substring(paramStart + 1);
				System.out.println("POST BODY:========" + paramStr);
				// 拆分请求参数
				String[] splits = paramStr.split("&");
				for (String split : splits) {
					String[] splitvalues = split.split("=");
					paramMap.put(splitvalues[0], splitvalues[1]);
				}
				// for (Map.Entry<String, String> map : paramMap.entrySet()) {
				// System.out.println(map.getKey() + " : " + map.getValue());
				// }
			}

			// System.out.println("===================Request Content===================");
			// System.out.println(str);
			// System.out.println("===================Request Content===================");

			// System.out.println("URI:" + uri);
		} else {
			System.out.println("Bas Request!");
		}
	}

	private void getURI(String str) {
		int start = str.indexOf("GET") + 4;
		if (str.indexOf("POST") != -1)
			start = str.indexOf("POST") + 5;
		int end = str.indexOf("HTTP/1.1") - 1;
		uri = str.substring(start, end);
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}
