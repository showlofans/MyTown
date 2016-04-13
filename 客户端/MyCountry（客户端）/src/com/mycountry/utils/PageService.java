package com.mycountry.utils;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class PageService {
	public static byte[] getImage(String htmlpath) throws Exception {
		byte[] imagearray = null;    //����һ���ֽ�����
		URL url = new URL(htmlpath); //����һ���µĶ���url
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setConnectTimeout(5000);
		// conn.setRequestMethod("GET");
		conn.connect();
		if (conn.getResponseCode() == 200) {
			byte[] buffer = new byte[1024];
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			InputStream inputStream = conn.getInputStream();
			//���ļ�����д��λ������
			while ((inputStream.read(buffer)) != -1) {
				arrayOutputStream.write(buffer, 0, buffer.length);
			}
			//���ַ���ʽ��ʾλ����������
			imagearray = arrayOutputStream.toByteArray();
		}
		return imagearray;
	}
}
