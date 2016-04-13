package com.mycountry.utils;

import java.io.ByteArrayOutputStream;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.util.Base64;

/*
 * 这个类是用来向将服务器发送来的图片进行Base64解码处理，同时将客户端图片进行Base64编码
 * @author shenlei
 * @time  2014-7-28
 */

public class ImageOutput {

	// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理

	public String bitmaptoString(Bitmap bitmap) {
		// 将Bitmap转换成字符串
		String string = null;
		ByteArrayOutputStream bStream = new ByteArrayOutputStream();
		bitmap.compress(CompressFormat.PNG, 100, bStream);
		byte[] bytes = bStream.toByteArray();
		string = Base64.encodeToString(bytes, Base64.DEFAULT);
		return string;
	}

	// 对字节数组字符串进行Base64解码并生成图�?
	public static Bitmap  stringtoBitmap(String string) {
		// 将字符串转换成Bitmap类型
		 Bitmap bitmap = null;
		try {
			byte[] bitmapArray;
			bitmapArray = Base64.decode(string, Base64.DEFAULT);
			bitmap = BitmapFactory.decodeByteArray(bitmapArray, 0,
					bitmapArray.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bitmap;

	}
}
