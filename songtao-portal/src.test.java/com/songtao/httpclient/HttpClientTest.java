package com.songtao.httpclient;

import java.util.ArrayList;

import org.apache.commons.lang3.text.translate.EntityArrays;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.web.bind.annotation.ResponseBody;

public class HttpClientTest {
	
		@Test
		public  void doGet()throws Exception{
			CloseableHttpClient httpClient = HttpClients.createDefault();
			//创建一个get对象
			HttpGet get = new HttpGet("http://www.sogou.com");
			//执行请求
			CloseableHttpResponse response = httpClient.execute(get);
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println(statusCode);
			//取响应结果
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity,"utf-8");
			System.out.println(string);
			//关闭httpclient
			response.close();
			httpClient.close();
			
		}
		
		@Test
		public void doGetWithClient()throws Exception {
			//创建一个httpclient 对象
			CloseableHttpClient httpClient = HttpClients.createDefault();

			//创建一个uri对象
			URIBuilder uriBuilder = new URIBuilder("http://sogou.com/web");
			uriBuilder.addParameter("query", "花千骨");
			HttpGet get = new HttpGet(uriBuilder.build());
			//执行请求
			CloseableHttpResponse response = httpClient.execute(get);
			int statusCode = response.getStatusLine().getStatusCode();
			System.out.println(statusCode);
			//取响应结果
			HttpEntity entity = response.getEntity();
			String string = EntityUtils.toString(entity,"utf-8");
			System.out.println(string);
			//关闭httpclient
			response.close();
			httpClient.close();
		}
		@Test
		public void doPost()throws Exception{
			CloseableHttpClient httpClient = HttpClients.createDefault();
			
			//创建一个post对象
			HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.html");
			//执行post请求
			CloseableHttpResponse response = httpClient.execute(post);
			String string = EntityUtils.toString(response.getEntity());
			System.out.println(string);
			response.close();
			httpClient.close();

			
		}
		
		@Test
		public void doPostwithparam()throws Exception{
			CloseableHttpClient httpClient = HttpClients.createDefault();
			
			//创建一个post对象
			HttpPost post = new HttpPost("http://localhost:8082/httpclient/post.html");
			//创建一个entity模拟一个表单
			ArrayList<NameValuePair> kvlist = new ArrayList<>();
			kvlist.add(new BasicNameValuePair("user", "li"));
			kvlist.add(new BasicNameValuePair("passw", "passw"));
			//包装成实体类
			StringEntity entity = new UrlEncodedFormEntity(kvlist);
			//设置post内容
			post.setEntity(entity);
			//执行post请求
			CloseableHttpResponse response = httpClient.execute(post);
			String string = EntityUtils.toString(response.getEntity());
			System.out.println(string);
			response.close();
			httpClient.close();

			
		}
		
		
}
