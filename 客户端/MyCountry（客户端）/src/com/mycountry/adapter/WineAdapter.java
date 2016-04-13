package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Ganhuo;
import com.mycountry.model.Wine;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class WineAdapter extends BaseAdapter {
	private Context context;
	private List<Wine> list = new ArrayList<Wine>();

	public WineAdapter(Context context, List<Wine> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public Wine getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		Wine model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView wine_title = (TextView) convertView.findViewById(R.id.title);
		TextView country_name = (TextView) convertView.findViewById(R.id.location);
		TextView wine_price = (TextView) convertView.findViewById(R.id.price);
		TextView wine_sales = (TextView) convertView.findViewById(R.id.sales);
		TextView wine_distance = (TextView) convertView.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);
 
		country_name.setText(model.getCountry_name());
		wine_title.setText(model.getWine_title());
		wine_sales.setText(model.getWine_sales());
		wine_price.setText(model.getWine_price());
		wine_distance.setText(model.getWine_distance());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getWine_picture(), 0,
				model.getWine_picture().length); 
		picture.setImageBitmap(bit);
		return convertView;
	}
}