package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Nongjia;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NongjiaAdapter extends BaseAdapter {
	private Context context;
	private List<Nongjia> list = new ArrayList<Nongjia>();

	public NongjiaAdapter(Context context, List<Nongjia> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Nongjia getItem(int position) {
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
		Nongjia model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView title = (TextView) convertView.findViewById(R.id.title);
		TextView price = (TextView) convertView.findViewById(R.id.price);
		TextView sales = (TextView) convertView.findViewById(R.id.sales);
		TextView country_name = (TextView) convertView
				.findViewById(R.id.location);
		TextView distance = (TextView) convertView.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);

		title.setText(model.getNongjia_title());
		price.setText(model.getNongjia_price());
		sales.setText(model.getNongjia_sales());
		country_name.setText(model.getCountry_name());
		distance.setText(model.getNongjia_distance());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getNongjia_picture(),
				0, model.getNongjia_picture().length);
		picture.setImageBitmap(bit);
		return convertView;
	}
}
