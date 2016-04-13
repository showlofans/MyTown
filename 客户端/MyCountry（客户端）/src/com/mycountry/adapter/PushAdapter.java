package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Push;
import com.mycountry.utils.Constant;
import com.mycountry.utils.ImageLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PushAdapter extends BaseAdapter {
	private Context context;
	private List<Push> list = new ArrayList<Push>();

	public PushAdapter(Context context, List<Push> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Push getItem(int position) {
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
		Push model = list.get(position);

		convertView = inflater.inflate(R.layout.item_buying, null);
		TextView push_title = (TextView) convertView.findViewById(R.id.title);
		TextView push_price = (TextView) convertView.findViewById(R.id.price);
		TextView push_sales = (TextView) convertView.findViewById(R.id.sales);
		TextView push_distance = (TextView) convertView
				.findViewById(R.id.distance);
		ImageView picture = (ImageView) convertView.findViewById(R.id.pic);

		push_title.setText(model.getPush_title());
		push_price.setText(model.getPush_price());
		push_sales.setText(model.getPush_sales());
		push_distance.setText(model.getPush_distance());
		
		ImageLoader imgload = new ImageLoader(context);
		imgload.DisplayImage(Constant.pushURL, picture);
		
//		Bitmap bit = BitmapFactory.decodeByteArray(model.getPush_picture(), 0,
//				model.getPush_picture().length);
//		picture.setImageBitmap(bit);
		return convertView;
	}

	public void setListViewHeightBasedOnChildren(ListView listView) {
		// 获取ListView对应的Adapter
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
				+ (listView.getDividerHeight() * (listAdapter.getCount() - 1));
		((MarginLayoutParams) params).setMargins(10, 10, 10, 10);
		listView.setLayoutParams(params);
	}

	/*
	 * class ViewHolder { TextView tvId, tvItem; CheckBox ckQuality; }
	 */

}
