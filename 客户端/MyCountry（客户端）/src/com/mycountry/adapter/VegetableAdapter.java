package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Ganhuo;
import com.mycountry.model.Vegetable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class VegetableAdapter extends BaseAdapter {
	private Context context;
	private List<Vegetable> list = new ArrayList<Vegetable>();

	public VegetableAdapter(Context context, List<Vegetable> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public Vegetable getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		Vegetable model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView vegetable_title = (TextView) convertView.findViewById(R.id.title);
		TextView country_name = (TextView) convertView.findViewById(R.id.location);
		TextView vegetable_price = (TextView) convertView.findViewById(R.id.price);
		TextView vegetable_sales = (TextView) convertView.findViewById(R.id.sales);
		TextView vegetable_distance = (TextView) convertView.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);
 
		vegetable_title.setText(model.getVegetable_title());
		country_name.setText(model.getCountry_name());
		vegetable_sales.setText(model.getVegetable_sales());
		vegetable_price.setText(model.getVegetable_price());
		vegetable_distance.setText(model.getVegetable_distance());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getVegetable_picture(), 0,
				model.getVegetable_picture().length);
		picture.setImageBitmap(bit);
		return convertView;
	}
}
