package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.User;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class UserAdapter extends BaseAdapter {
	private Context context;
	private List<User> list = new ArrayList<User>();

	public UserAdapter(Context context, List<User> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public User getItem(int position) {
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
		User model = list.get(position);

		// 将xml布局转换为view对象
		convertView = inflater.inflate(R.layout.me_listview, null);
		// 利用view对象，找到布局中的组件
		
		TextView user_name = (TextView) convertView.findViewById(R.id.tv_name);
		TextView user_email = (TextView) convertView.findViewById(R.id.tv_email);
		TextView user_address = (TextView) convertView.findViewById(R.id.tvMycountry);
		TextView user_type = (TextView) convertView.findViewById(R.id.tv_type);
		ImageView user_picture = (ImageView) convertView.findViewById(R.id.head_imageview);
 
		user_name.setText(model.getUser_name());
		user_email.setText(model.getUser_email());
		user_address.setText(model.getUser_address());
		user_type.setText(model.getUser_type());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getUser_picture(), 0,
				model.getUser_picture().length); // 将图片流转化为bitmap类型
		user_picture.setImageBitmap(bit);
		return convertView;
	}
}
