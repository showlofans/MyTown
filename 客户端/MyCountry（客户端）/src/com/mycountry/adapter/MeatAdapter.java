package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Meat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MeatAdapter extends BaseAdapter {
	private Context context;
	private List<Meat> list = new ArrayList<Meat>();

	public MeatAdapter(Context context, List<Meat> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public Meat getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		// ���ز��ֹ�����
		Meat model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView meat_title = (TextView) convertView.findViewById(R.id.title);
		TextView country_name = (TextView) convertView.findViewById(R.id.location);
		TextView meat_price = (TextView) convertView.findViewById(R.id.price);
		TextView meat_sales = (TextView) convertView.findViewById(R.id.sales);
		TextView meat_distance = (TextView) convertView.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);
 
		meat_title.setText(model.getMeat_title());
		country_name.setText(model.getCountry_name());
		meat_sales.setText(model.getMeat_sales());
		meat_price.setText(model.getMeat_price());
		meat_distance.setText(model.getMeat_distance());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getMeat_picture(), 0,
				model.getMeat_picture().length); // ��ͼƬ��ת��Ϊbitmap����
		picture.setImageBitmap(bit);
		return convertView;
	}
}
