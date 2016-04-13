package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Fruit;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class FruitAdapter extends BaseAdapter {
	private Context context;
	private List<Fruit> list = new ArrayList<Fruit>();

	public FruitAdapter(Context context, List<Fruit> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public Fruit getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		Fruit model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView fruit_title = (TextView) convertView.findViewById(R.id.title);
		TextView country_name = (TextView) convertView.findViewById(R.id.location);
		TextView fruit_price = (TextView) convertView.findViewById(R.id.price);
		TextView fruit_sales = (TextView) convertView.findViewById(R.id.sales);
		TextView fruit_distance = (TextView ) convertView.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);
 
		fruit_title.setText(model.getFruit_title());
		country_name.setText(model.getCountry_name());
		fruit_sales.setText(model.getFruit_sales());
		fruit_price.setText(model.getFruit_price());
		fruit_distance.setText(model.getFruit_distance());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getFruit_picture(), 0,
				model.getFruit_picture().length);
		picture.setImageBitmap(bit);
		return convertView;
	}
} 
