package com.mycountry.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class File2StringUtil {
	/**
	 * 杩斿洖鍥剧墖鐨勫瓧绗︿覆锟�?
	 * @param filePath
	 * @return
	 */
	public static String file2String(String filePath) {
		File file = null;
		if(filePath == null)
			return null;
		else
			file= new File(filePath);
		FileInputStream fis = null;
		ByteArrayOutputStream bous = null;
		byte[] buffer = null, result = null;
		try {
			fis = new FileInputStream(file);
			bous = new ByteArrayOutputStream();
			buffer = new byte[4*1024];
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
	 * 鎶婂浘鐗囦簩杩涘埗娴佽浆涓哄瓧绗︿覆
	 * @param b
	 * @return
	 */
	public static String byte2hex(byte[] b) // 娴滃矁绻橀崚鎯版祮鐎涙顑佹稉锟�?	
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
	 * 鎶婂瓧绗︿覆娴佽浆涓轰簩杩涘埗锟�?	 * @param str
	 * @return
	 */
	public static byte[] hex2byte(String str) { 	
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
	 * 鏈嶅姟鍣ㄧ鍙戣繃鏉ョ殑鍥剧墖瀛楃涓叉祦
	 *  @param bytes
	 *  @return
	 */
	public static Bitmap getImageFromBytes(String strImage) {
		byte[] bytes = null;
		bytes = hex2byte(strImage);
		if (bytes != null)
			return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
		return null;
	}
}
