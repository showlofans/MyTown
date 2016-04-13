package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Business;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class BusinessAdapter extends BaseAdapter {
	private Context context;
	private List<Business> list = new ArrayList<Business>();

	public BusinessAdapter(Context context, List<Business> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public Business getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		// 加载布局管理器
		Business model = list.get(position);

		// 将xml布局转换为view对象
		convertView = inflater.inflate(R.layout.item, null);
		// 利用view对象，找到布局中的组件
		TextView business_title = (TextView) convertView.findViewById(R.id.tvTitle);
		TextView business_content = (TextView) convertView.findViewById(R.id.tvDesc);
		TextView country_name = (TextView) convertView.findViewById(R.id.tvTime);
		ImageView picture = (ImageView) convertView.findViewById(R.id.ivPic);
 
		business_title.setText(model.getBusiness_title());
		business_content.setText(model.getBusiness_content());
		country_name.setText(model.getCountry_name());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getBusiness_picture(), 0,
				model.getBusiness_picture().length); // 将图片流转化为bitmap类型
		picture.setImageBitmap(bit);
		return convertView;
	}
}
