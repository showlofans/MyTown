package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;
import com.example.menutab.R;
import com.mycountry.model.Push1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Push1Adapter extends BaseAdapter {
	private Context context;
	private List<Push1> list = new ArrayList<Push1>();

	public Push1Adapter(Context context, List<Push1> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public Push1 getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		Push1 model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView title = (TextView) convertView.findViewById(R.id.title);
		TextView price = (TextView) convertView.findViewById(R.id.price);
		TextView sales = (TextView) convertView.findViewById(R.id.sales);
		TextView country_name = (TextView) convertView.findViewById(R.id.location);
		TextView distance = (TextView) convertView.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);
 
		title.setText(model.getPush1_title());
		sales.setText(model.getPush1_sales());
		price.setText(model.getPush1_price());
		country_name.setText(model.getCountry_name());
		distance.setText(model.getPush1_distance());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getPush1_picture(), 0,
				model.getPush1_picture().length);
		picture.setImageBitmap(bit);
		return convertView;
	}
} 