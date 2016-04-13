package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Note;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NoteAdapter extends BaseAdapter {
	private Context context;
	private List<Note> list = new ArrayList<Note>();

	public NoteAdapter(Context context, List<Note> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	} 

	@Override
	public Note getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		// 加载布局管理器
		Note model = list.get(position);

		// 将xml布局转换为view对象
		convertView = inflater.inflate(R.layout.item, null);
		// 利用view对象，找到布局中的组件
		TextView note_title = (TextView) convertView.findViewById(R.id.tvTitle);
		TextView note_content = (TextView) convertView.findViewById(R.id.tvDesc);
		TextView note_time = (TextView) convertView.findViewById(R.id.tvTime);
		ImageView picture = (ImageView) convertView.findViewById(R.id.ivPic);
 
		note_title.setText(model.getNote_title());
		note_content.setText(model.getNote_content());
		note_time.setText(model.getNote_time());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getNote_picture(), 0,
				model.getNote_picture().length); // 将图片流转化为bitmap类型
		picture.setImageBitmap(bit);
		return convertView;
	}
}
