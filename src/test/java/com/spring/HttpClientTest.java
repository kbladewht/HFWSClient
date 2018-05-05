package com.spring;

import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.google.common.collect.Lists;

public class HttpClientTest {
	

//sdfsfsdfsdfsdf
	String URL = "http://192.168.1.111:8080/hello-world";

	@Test
	public void test() throws Exception {
ddd
sss

		List<NameValuePair> params = Lists.newArrayList();
		params.add(new BasicNameValuePair("name", "Wang He di"));
		String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));

		HttpGet httpGet = new HttpGet(URL+"?"+str);
		
	//ddd
		HttpClient httpClient = HttpClients.createMinimal();
		HttpResponse httpResponse = httpClient.execute(httpGet);
		
		safasfd
		String response = EntityUtils.toString(httpResponse.getEntity());
		System.out.println(response);
		SayingFH s = new ObjectMapper().readValue(response, SayingFH.class);
		System.out.print(s);
	}

}
