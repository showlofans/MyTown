package com.mycountry.activity;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;

public class PictureFile {
	/**
	 * ���ļ�תΪ�ַ�����
	 * @param �ϴ����ļ�
	 * @return �ļ����ַ�������
	 */
	public static String file2String(File file) {
		FileInputStream fis = null;
		ByteArrayOutputStream bous = null;
		byte[] buffer = null, result = null;
		if (file == null)
			return null;
		try {
			fis = new FileInputStream(file);
			bous = new ByteArrayOutputStream();
			buffer = new byte[4*1024];
			 //ѭ����ȡͼƬ�ļ� 
			while (fis.read(buffer) != -1)
				bous.write(buffer);
			result = bous.toByteArray();
			fis.close();
			bous.close();
			return byte2hex(result);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	/**
	 * ������ת�ַ���
	 * @param b �ֽ�����
	 * @return �ַ���
	 */
	public static String byte2hex(byte[] b) // ������ת�ַ���
	{
		StringBuffer sb = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0XFF);
			if (stmp.length() == 1) {
				sb.append("0" + stmp);
			} else {
				sb.append(stmp);
			}
		}
		return sb.toString();
	}

	/**
	 * �ַ���ת������
	 * @param str
	 * @return
	 */
	public static byte[] hex2byte(String str) { // �ַ���ת������
		if (str == null)
			return null;
		str = str.trim();
		int len = str.length();
		if (len == 0 || len % 2 == 1)
			return null;
		byte[] b = new byte[len / 2];
		try {
			for (int i = 0; i < str.length(); i += 2) {
				b[i / 2] = (byte) Integer
						.decode("0X" + str.substring(i, i + 2)).intValue();
			}
			return b;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * ���ֽ�����תΪͼƬ
	 * @param bytes
	 * @return
	 */

    public static void byte2Image(String strImage,String time) {
	  // String time=getDate();
       String src="C://Program Files/Apache Software Foundation/Tomcat 6.0/webapps/MyCountry/image";//Police��Ŀ��alarmImage���ڵ��ļ���
       File file = new File(src,time+".jpg");  //����ͼƬ��F�̵�alarmImage�ļ�����
	  // File file = new File("../../WebRoot/image/alarmImage/",time+".jpg");
		try {
			byte[] imageByte=hex2byte(strImage);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(imageByte);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    public static String getDate(){
	Calendar calendar=Calendar.getInstance();
//	int year=calendar.get(Calendar.YEAR);
//	int month=calendar.get(Calendar.MONTH);
//	int day=calendar.get(Calendar.DAY_OF_MONTH);
//	int minute=calendar.get(Calendar.MINUTE);
//	int hour=calendar.get(Calendar.HOUR_OF_DAY);
//	int second=calendar.get(Calendar.SECOND);
	
	String year=calendar.get(Calendar.YEAR)+"";
	String month=(calendar.get(Calendar.MONTH)+1)+"";
	String day=calendar.get(Calendar.DAY_OF_MONTH)+"";
	String minute=calendar.get(Calendar.MINUTE)+"";
	String hour=calendar.get(Calendar.HOUR_OF_DAY)+"";
	String second=calendar.get(Calendar.SECOND)+"";
//	String date=year+(month+1)+(day)+((hour<10)?"0":"")+hour+((minute<10)?"0":"")+minute+((second<10)?"0":"")+second;
	String date=year+month+(day)+hour+minute+second;
	return date;
	
}
}
