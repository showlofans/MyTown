package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Ganhuo;
import com.mycountry.model.Liangyou;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class LiangyouAdapter extends BaseAdapter {
	private Context context;
	private List<Liangyou> list = new ArrayList<Liangyou>();

	public LiangyouAdapter(Context context, List<Liangyou> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public Liangyou getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		Liangyou model = list.get(position);

 
		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView liangyou_title = (TextView) convertView.findViewById(R.id.title);
		TextView country_name = (TextView) convertView.findViewById(R.id.location);
		TextView liangyou_price = (TextView) convertView.findViewById(R.id.price);
		TextView liangyou_sales = (TextView) convertView.findViewById(R.id.sales);
		TextView liangyou_distance = (TextView) convertView.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);
 
		liangyou_title.setText(model.getLiangyou_title());
		country_name.setText(model.getCountry_name());
		liangyou_sales.setText(model.getLiangyou_sales());
		liangyou_price.setText(model.getLiangyou_price());
		liangyou_distance.setText(model.getLiangtou_distance());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getLiangyou_picture(), 0,
				model.getLiangyou_picture().length);
		picture.setImageBitmap(bit);
		return convertView;
	}
}
