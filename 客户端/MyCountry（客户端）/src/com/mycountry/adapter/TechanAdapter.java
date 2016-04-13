package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Techan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TechanAdapter extends BaseAdapter {
	private Context context;
	private List<Techan> list = new ArrayList<Techan>();

	public TechanAdapter(Context context, List<Techan> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public Techan getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	}  

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		Techan model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView techan_title = (TextView) convertView.findViewById(R.id.title);
		TextView techan_price = (TextView) convertView.findViewById(R.id.price);
		TextView techan_sales = (TextView) convertView.findViewById(R.id.sales);
		TextView techan_distance = (TextView) convertView.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);
 
		techan_title.setText(model.getTechan_title());
		techan_sales.setText(model.getTechan_sales());
		techan_price.setText(model.getTechan_price());
		techan_distance.setText(model.getTechan_distance());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getTechan_picture(), 0,
				model.getTechan_picture().length); // ��ͼƬ��ת��Ϊbitmap����
		picture.setImageBitmap(bit);
		return convertView;
	}
}
