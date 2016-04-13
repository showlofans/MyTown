package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddNote;
import com.mycountry.model.Push;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class PushDetail extends Activity {

	private Push push;
	TextView push_title, push_price, push_sales;
	ImageView picture;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buying_detail);

		// ���ذ�ť��ת
		ImageView menu = (ImageView) findViewById(R.id.back_buying_detail);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		ImageButton plus = (ImageButton) findViewById(R.id.add_buying_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PushDetail.this, AddNote.class);
				startActivity(intent);
			}
		});
		push_title = (TextView) findViewById(R.id.detail_title);
		push_price = (TextView) findViewById(R.id.detail_price);
		push_sales = (TextView) findViewById(R.id.detail_sales);
		picture = (ImageView) findViewById(R.id.detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			push = (Push) bundle.get("push");
		}
		if (push != null) {

			push_title.setText(push.getPush_title());
			push_price.setText(push.getPush_price());
			push_sales.setText(push.getPush_sales());
			Bitmap bit = BitmapFactory.decodeByteArray(push.getPush_picture(),
					0, push.getPush_picture().length); // ��ͼƬ��ת��Ϊbitmap����
			picture.setImageBitmap(bit);
		}
	}
}
