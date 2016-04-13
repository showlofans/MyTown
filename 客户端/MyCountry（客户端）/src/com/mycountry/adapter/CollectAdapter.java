package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.menutab.R;
import com.mycountry.model.Collect;

public class CollectAdapter extends BaseAdapter {
	private Context context;
	private List<Collect> list = new ArrayList<Collect>();

	public CollectAdapter(Context context, List<Collect> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public Collect getItem(int position) {
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
		Collect model = list.get(position);

		// 将xml布局转换为view对象
		convertView = inflater.inflate(R.layout.item, null);
		// 利用view对象，找到布局中的组件
		TextView collect_title = (TextView) convertView.findViewById(R.id.tvTitle);
		TextView collect_content = (TextView) convertView.findViewById(R.id.tvDesc);
		TextView country_name = (TextView) convertView.findViewById(R.id.tvTime);
		ImageView picture = (ImageView) convertView.findViewById(R.id.ivPic);
 
		collect_title.setText(model.getCollect_title());
		collect_content.setText(model.getCollect_content());
		country_name.setText(model.getCountry_name());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getCollect_picture(), 0,
				model.getCollect_picture().length); // 将图片流转化为bitmap类型
		picture.setImageBitmap(bit);
		return convertView;
	}
}

