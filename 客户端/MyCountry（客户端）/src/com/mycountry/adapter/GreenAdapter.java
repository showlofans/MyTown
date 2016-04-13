package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Green;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GreenAdapter extends BaseAdapter {
	private Context context;
	private List<Green> list = new ArrayList<Green>();

	public GreenAdapter(Context context, List<Green> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Green getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position)
				: null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		Green model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView green_title = (TextView) convertView.findViewById(R.id.title);
		TextView green_price = (TextView) convertView.findViewById(R.id.price);
		TextView green_sales = (TextView) convertView.findViewById(R.id.sales);
		TextView gcountry_name = (TextView) convertView.findViewById(R.id.location);
		TextView green_distance = (TextView) convertView.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);

		green_title.setText(model.getGreen_title());
		green_price.setText(model.getGreen_price());
		green_sales.setText(model.getGreen_sales());
		gcountry_name.setText(model.getGcountry_name());
		green_distance.setText(model.getGreen_distance());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getGreen_picture(), 0,
				model.getGreen_picture().length); 
		picture.setImageBitmap(bit);
		return convertView;
	}
}
