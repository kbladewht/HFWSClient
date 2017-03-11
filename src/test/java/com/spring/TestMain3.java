package com.spring;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

//对接口进行测试
public class TestMain3 {
	
	static {  
	    System.setProperty("javax.net.ssl.trustStore", "C:\\bmob.keystore");  
	    System.setProperty("javax.net.ssl.trustStorePassword", "password");  
	} 
	/**
	 * 添加例子
	 * 
	 * @see <a href=
	 *      'http://docs.bmob.cn/restful/developdoc/index.html?menukey=develop_doc&key=develop_restful#index_添加数据'>
	 *      例子</a>
	 */
	public static void add() throws Exception {
		
		
		// 构建请求
		URL postUrl = new URL("");

		HttpsURLConnection con = (HttpsURLConnection) postUrl.openConnection();// 打开连接
		con.setRequestMethod("POST");// post方式提交

		con.setDoOutput(true);// 打开读写属性，默认均为false
		con.setDoInput(true);
		con.setUseCaches(false);// Post请求不能使用缓存
		con.setInstanceFollowRedirects(true);

		// 添加头信息
//		con.setRequestProperty("X-Bmob-Application-Id", APP_ID);
//		con.setRequestProperty("X-Bmob-REST-API-Key", API_Key);
		con.setRequestProperty("Content-Type", "application/json");

		DataOutputStream out = new DataOutputStream(con.getOutputStream());

		// 发送请求
		String data = "{\"name\":\"tom\"}";
		out.writeBytes(data);
		out.flush();
		out.close();

		// 接收数据
		BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String line;
		StringBuffer responseText = new StringBuffer();
		while ((line = reader.readLine()) != null) {
			responseText.append(line).append("\r\n");
		}
		reader.close();
		con.disconnect();
		System.out.println(responseText.toString());
	}

	public static void main(String[] args) {
		TestMain3 main = new TestMain3();
//		main.test();
	}
}