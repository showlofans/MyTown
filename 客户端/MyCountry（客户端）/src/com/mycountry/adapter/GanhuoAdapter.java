package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Ganhuo;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GanhuoAdapter extends BaseAdapter {
	private Context context;
	private List<Ganhuo> list = new ArrayList<Ganhuo>();

	public GanhuoAdapter(Context context, List<Ganhuo> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public Ganhuo getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		Ganhuo model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView ganhuo_title = (TextView) convertView.findViewById(R.id.title);
		TextView country_name = (TextView) convertView.findViewById(R.id.location);
		TextView ganhuo_price = (TextView) convertView.findViewById(R.id.price);
		TextView ganhuo_sales = (TextView) convertView.findViewById(R.id.sales);
		TextView ganhuo_distance = (TextView) convertView.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);
 
		ganhuo_title.setText(model.getGanhuo_title());
		country_name.setText(model.getCountry_name());
		ganhuo_sales.setText(model.getGanhuo_sales());
		ganhuo_price.setText(model.getGanhuo_price());
		ganhuo_distance.setText(model.getGanhuo_distance());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getGanhuo_picture(), 0,
				model.getGanhuo_picture().length); 
		picture.setImageBitmap(bit);
		return convertView;
	}
}
