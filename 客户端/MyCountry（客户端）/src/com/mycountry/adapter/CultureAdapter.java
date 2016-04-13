package com.mycountry.adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.Culture;
import com.mycountry.model.Ganhuo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CultureAdapter extends BaseAdapter {
	private Context context;
	private List<Culture> list = new ArrayList<Culture>();

	public CultureAdapter(Context context, List<Culture> list) {
		super();
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Culture getItem(int position) {
		return (list != null && list.size() > position) ? list.get(position) : null;
	} 

	@Override
	public long getItemId(int position) {
		return 0;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = LayoutInflater.from(context);
		// ���ز��ֹ�����
		Culture model = list.get(position);

		// ��xml����ת��Ϊview����
		convertView = inflater.inflate(R.layout.item, null);
		// ����view�����ҵ������е����
		TextView culture_title = (TextView) convertView.findViewById(R.id.tvTitle);
		TextView culture_content = (TextView) convertView.findViewById(R.id.tvDesc);
		TextView culture_time= (TextView)convertView.findViewById(R.id.tvTime);
		ImageView picture = (ImageView) convertView.findViewById(R.id.ivPic);
 
		culture_title.setText(model.getCulture_title());
		culture_content.setText(model.getCulture_content());
		culture_time.setText(model.getCulture_time());
		Bitmap bit = BitmapFactory.decodeByteArray(model.getCulture_picture(), 0,
				model.getCulture_picture().length); // ��ͼƬ��ת��Ϊbitmap����
		picture.setImageBitmap(bit);
		return convertView;
	}
}
