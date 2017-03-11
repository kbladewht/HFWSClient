package com.spring;
import java.util.HashMap;
import java.util.Map;
//对接口进行测试
public class TestMain2 {
	private String url = "https://passport.baidu.com/center";
	private String charset = "utf-8";
	private HttpClientUtil httpClientUtil = null;
	
	public TestMain2(){
		httpClientUtil = new HttpClientUtil();
	}
	
	public void test(){
		String httpOrgCreateTest = url;
		String httpOrgCreateTestRtn = httpClientUtil.doGet(httpOrgCreateTest,charset);
		System.out.println("result:"+httpOrgCreateTestRtn);
	}
	
	public static void main(String[] args){
		TestMain2 main = new TestMain2();
		main.test();
	}
}