package com.mycountry.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

public class HttpUtil implements Runnable {
	public static String httpUrl = "http://192.168.56.1:8080/MyCountry/";
	public static String result = "";
	public static Bitmap bitmap = null;
	public String url = null;
	List<NameValuePair> list;

	public HttpUtil(String url, List<NameValuePair> list) {
		this.list = list;
		this.url = url;
	}

	@Override
	public void run() {
		try {
			// http post杩炴帴瀵硅薄url
			HttpPost httppost = new HttpPost(url);
			// 璁剧疆瀛楃闆�
			HttpEntity httpentity = new UrlEncodedFormEntity(list, "utf-8");
			// 璁剧疆鏌ヨ鍙傛暟
			httppost.setEntity(httpentity);
			// 鍒涘缓涓�涓猦ttp杩炴帴瀹炰緥
			HttpClient httpclient = new DefaultHttpClient();
			// 鍙栧緱榛樿鐨勬煡璇㈢粨鏋滃疄渚�
			HttpResponse response = httpclient.execute(httppost);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				// 鍙栧緱杩斿洖鐨勫瓧绗︿覆
				 result = EntityUtils.toString(response.getEntity(),"utf-8");
			//	 bitmap=BitmapFactory.decodeFile(result);
				 
				// 鍙栧緱鍥剧墖瀛楄妭娴�
				HttpEntity httpEntity = response.getEntity();
				InputStream is =  httpEntity.getContent();
				bitmap = BitmapFactory.decodeStream(is);
				is.close();
			} else {
				result = "璇锋眰閿欒!";
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
