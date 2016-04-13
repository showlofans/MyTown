package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Tour;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TourAdapter extends BaseAdapter {
	private Context context;
	private List<Tour> list = new ArrayList<Tour>();

	public TourAdapter(Context context, List<Tour> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Tour getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		Tour model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView tour_title = (TextView) convertView.findViewById(R.id.title);
		TextView tour_price = (TextView) convertView.findViewById(R.id.price);
		TextView tour_sales = (TextView) convertView.findViewById(R.id.sales);
		TextView tour_distance = (TextView) convertView.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);
 
		tour_title.setText(model.getTour_title()); 
		tour_price.setText(model.getTour_price());
		tour_sales.setText(model.getTour_sales());
		tour_distance.setText(model.getTour_distance());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getTour_picture(), 0,
				model.getTour_picture().length); 
		picture.setImageBitmap(bit);
		return convertView;
	}
}
