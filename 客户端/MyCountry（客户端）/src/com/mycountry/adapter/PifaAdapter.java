package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Ganhuo;
import com.mycountry.model.Pifa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PifaAdapter extends BaseAdapter {
	private Context context;
	private List<Pifa> list = new ArrayList<Pifa>();

	public PifaAdapter(Context context, List<Pifa> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Pifa getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		Pifa model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView pifa_title = (TextView) convertView.findViewById(R.id.title);
		TextView pifa_price = (TextView) convertView.findViewById(R.id.price);
		TextView pifa_sales = (TextView) convertView.findViewById(R.id.sales);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);
 
		pifa_title.setText(model.getPifa_title()); 
		pifa_price.setText(model.getPifa_price());
		pifa_sales.setText(model.getPifa_sales());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getPifa_picture(), 0,
				model.getPifa_picture().length); // ��ͼƬ��ת��Ϊbitmap����
		picture.setImageBitmap(bit);
		return convertView;
	}
}
