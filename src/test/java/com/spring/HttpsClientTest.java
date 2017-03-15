package com.spring;

import java.security.SecureRandom;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.google.common.collect.Lists;

public class HttpsClientTest {

	String URL = "https://localhost:8080/hello-world";

	@Test
	public void test() throws Exception {

		List<NameValuePair> params = Lists.newArrayList();
		params.add(new BasicNameValuePair("name", "Wang He di"));
		String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));

		HttpGet httpGet = new HttpGet(URL + "?" + str);

		HttpClient httpClient = getHttpClient();
		HttpResponse httpResponse = httpClient.execute(httpGet);

		String response = EntityUtils.toString(httpResponse.getEntity());
		System.out.println(response);
		SayingFH s = new ObjectMapper().readValue(response, SayingFH.class);
		System.out.print(s);
	}

	protected HttpClient getHttpClient() throws Exception {

		HttpClientBuilder builder = HttpClientBuilder.create();

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, new TrustManager[] { new HX509TrustManager() }, new SecureRandom());

		builder.setSSLSocketFactory(new SSLConnectionSocketFactory(sc));

		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
				.register("https", new SSLConnectionSocketFactory(sc)).build();

		builder.setConnectionManager(new BasicHttpClientConnectionManager(registry));

		return builder.build();

	}
}
