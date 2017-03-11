package com.spring;

import org.junit.Test;

public class HttpClientObjectReturnTest {

	@Test
	public void test() throws Exception {
		String url = "http://localhost:8080/get-requests/";
		
		
		try {
			String response = HttpClientUtil2.httpGetRequest(url);
			System.out.println(response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

//	protected HttpClient getHttpClient() throws Exception {
//
//		HttpClientBuilder builder = HttpClientBuilder.create();
//
//		SSLContext sc = SSLContext.getInstance("SSL");
//		sc.init(null, new TrustManager[] { new HX509TrustManager() }, new SecureRandom());
//
//		builder.setSSLSocketFactory(new SSLConnectionSocketFactory(sc));
//
//		Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
//				.register("https", new SSLConnectionSocketFactory(sc)).build();
//
//		builder.setConnectionManager(new BasicHttpClientConnectionManager(registry));
//
//		return builder.build();
//
//	}
//
//	String doHttpPut(String url)
//			throws UnsupportedEncodingException, IOException, ClientProtocolException, Exception {
//		HttpGet httpPut = new HttpGet(url);
//
////		httpPut.setHeader("Content-Type", "application/json;charset=UTF-8");
////		httpPut.setEntity(getParamaters(rpmName));
//
//		HttpResponse response = getHttpClient().execute(httpPut);
//		HttpEntity entity = response.getEntity();
//		String html = EntityUtils.toString(entity);
//		return html;
//	}

//	private StringEntity getParamaters(String rpmName) throws UnsupportedEncodingException {
//
//		String componentName = "fddd";
//
//		JSONObject parms = new JSONObject();
//
//		parms.put("ffff", componentName);
//
//		String jsonString = parms.toString();
//		System.out.println(jsonString);
//
//		return new StringEntity(jsonString, ContentType.APPLICATION_JSON);
//	}

}
