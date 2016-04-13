package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Push3;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Push3Adapter extends BaseAdapter {

	private Context context;
	private List<Push3> list = new ArrayList<Push3>();

	public Push3Adapter(Context context, List<Push3> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Push3 getItem(int position) {
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
		Push3 model = list.get(position);
		convertView = inflater.inflate(R.layout.item_buying, null);

		TextView push3_title = (TextView) convertView.findViewById(R.id.title);
		TextView push3_price = (TextView) convertView.findViewById(R.id.price);
		TextView push3_sales = (TextView) convertView.findViewById(R.id.sales);
		TextView push3_location = (TextView) convertView
				.findViewById(R.id.location);
		TextView push3_distance = (TextView) convertView
				.findViewById(R.id.distance);
		ImageView push3_picture = (ImageView) convertView
				.findViewById(R.id.pic);

		push3_title.setText(model.getPush3_title());
		push3_price.setText(model.getPush3_price());
		push3_sales.setText(model.getPush3_sales());
		push3_location.setText(model.getCountry_name());
		push3_distance.setText(model.getPush3_distance());
		Bitmap bitmap = BitmapFactory.decodeByteArray(model.getPush3_picture(),
				0, model.getPush3_picture().length);
		push3_picture.setImageBitmap(bitmap);
		return convertView;
	}
	
	public void setListViewHeightBasedOnChildren(ListView listView){
		ListAdapter listAdapter = listView.getAdapter();
		if (listAdapter == null) {
			return;
		}
		int totalHeight = 0;
		for (int i = 0; i < listAdapter.getCount(); i++) {
			View listItem = listAdapter.getView(i, null, listView);
			listItem.measure(0, 0); // 计算子项View的宽高
			// 统计所有子项的总高度
			totalHeight += listItem.getMeasuredHeight();
			System.out
					.println(listItem.getMeasuredHeight() + "===========" + i);
		}
		// listView.getDividerHeight()获取子项间分隔符占用的高度
		// params.height最后得到整个ListView完整显示需要的高度
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 3));
		((MarginLayoutParams) params).setMargins(10, 10, 10, 10);
		listView.setLayoutParams(params);
	}

}
