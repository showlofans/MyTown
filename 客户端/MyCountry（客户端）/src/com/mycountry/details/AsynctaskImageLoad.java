package com.mycountry.details;

import java.lang.ref.SoftReference;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;

public class AsynctaskImageLoad {
	/**
	 * ͼƬ�������
	 * url��ӦsoftReference�����ͼƬ����
	 */
	private Map<String,SoftReference<Drawable>> imageCache = 
			new HashMap<String,SoftReference<Drawable>>();
	/**
	 * ʵ��ͼƬ�첽����
	 */
	public Drawable loadDrawable(final String imageUrl,final ImageCallback callback ){
		if(imageCache.containsKey(imageUrl)){
			SoftReference<Drawable> softReference = imageCache.get(imageUrl);
			if(softReference.get() != null){
				return softReference.get();//��Ϊ�ա�����softָ���ͼƬ����
			}
		}
		final Handler handler = new Handler(){
			public void handleMessage(Message msg) {
				callback.imageLoaded((Drawable) msg.obj);
			};
		};
		new Thread(){
			public void run(){
				Drawable drawable = loadImageFromUrl(imageUrl);//��4����һ��ͼƬ��
				imageCache.put(imageUrl,new SoftReference<Drawable>(drawable));//�ŵ����档
				Message message = handler.obtainMessage(0,drawable);
				handler.sendMessage(message);
			}
		}.start();
		return null;
	}
	
	/**
	 * ͼƬ���ط�����
	 * @param imageUrl
	 * @return
	 */
	protected Drawable loadImageFromUrl(String imageUrl){
		try{
			return Drawable.createFromStream(new URL(imageUrl).openStream(), "src");//����һ��ͼƬ��
		}catch (Exception e) {
			throw new RuntimeException();//�׳�ִ��ʱ�䡣
		}
	}
	/**
	 * �ص��
	 * @author Administrator
	 */
	public interface ImageCallback{
		public void imageLoaded(Drawable imageDrawable);
	}
}
