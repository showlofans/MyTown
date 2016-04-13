package com.mycountry.details;


import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.menutab.R;
import com.mycountry.dao.Shou;


import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class ShouCang extends Activity{
     private ListView result;
     private Context mContext;
     private ContentResolver myResolver;
     @Override
     public void onCreate(Bundle savedInstanceState){
    	 super.onCreate(savedInstanceState);
    	 setContentView(R.layout.my_shoucang);
    	 result=(ListView)findViewById(R.id.result);
    	 List<Shou>  res=query();
    	 Log.i("这是", "嘻嘻1");
    	 ShoucangAdapter adapter=new ShoucangAdapter(mContext,res);
    //	 SimpleAdapter adapter=new SimpleAdapter(ShouCang.this, res, R.layout.item_shoucang,new String[]{"id","title","sales","price","picture"}
     //    ,new int[]{R.id.title,R.id.sales,R.id.price,R.id.item_image});
         result.setAdapter(adapter);		 
     }
	//@SuppressWarnings("unchecked")
	private List<Shou> query() {
		// TODO 自动生成的方法存根
		List<Shou> records = new ArrayList<Shou>();
		Cursor cursor=myResolver.query(Uri.parse("content://com.mycountry.details/shop"), null, null, null, null);
		while(cursor.moveToNext()){
			//Map<Shou,String> item=new HashMap<Shou,String>(); //创建对象
			String id=cursor.getString(0);
			String title=cursor.getString(1);
			String price=cursor.getString(2);
			String sales=cursor.getString(3);
			String picture=cursor.getString(4);
		/*	item.put(id, cursor.getInt(0)); //存放元素
    		item.put("title",cursor.getString(1));
    		item.put("price",cursor.getString(2)
    		item.put("sales",cursor.getString(3));
    		item.put("picture",cursor.getString(4));
    		//System.out.println(cursor.getString(3));*/
    		records.add( new Shou(id,title,sales,price,picture));
    		Log.i("这是", "嘻嘻1");
		}
		return records;
	}
	
}
class ShoucangAdapter extends BaseAdapter{
	private List<Shou> records = new ArrayList<Shou>();
    public AsynctaskImageLoad loader = new AsynctaskImageLoad();
    private Context mContext;
	public ShoucangAdapter(Context context, List<Shou> res) {
		mContext=context;
		records=res;
	}

	@Override
	public int getCount() {
		
		return records.size();
	}
    //获得指定位置的元素
	@Override
	public Object getItem(int position) {
		// TODO 自动生成的方法存根
		return records.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO 自动生成的方法存根
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 自动生成的方法存根
		convertView=LayoutInflater.from(mContext.getApplicationContext()).inflate(R.layout.item_shoucang, null);
		Shou modle=(Shou) records.get(position);
		ImageView iv=(ImageView) convertView.findViewById(R.id.item_image);
		TextView title=(TextView) convertView.findViewById(R.id.title);
		TextView sales=(TextView) convertView.findViewById(R.id.sales);
		TextView price=(TextView) convertView.findViewById(R.id.price);
		try{
			title.setText(modle.getTitle());
			sales.setText(modle.getSales());
			price.setText(modle.getPrice());
			loadImage(modle.getPicture(),iv);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return convertView;
	}

	private void loadImage(String url, ImageView img) {
		CallbackImpl callbackImpl = new CallbackImpl(img);
		Drawable cacheImage = loader.loadDrawable(url, callbackImpl);
		if(cacheImage != null){
			img.setImageDrawable(cacheImage);
		}
	}
}
	
	

