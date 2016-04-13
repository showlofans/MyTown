package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddFruit;
import com.mycountry.model.Meat;
import com.mycountry.service.MeatService;

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

public class MeatDetail extends Activity {

	private Meat meat;
	TextView meat_title, meat_price, meat_sales;
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
				Intent intent = new Intent(MeatDetail.this, MeatService.class);
				startActivity(intent);
			}
		});
		// ��Ӱ�ť��ת
		ImageButton plus = (ImageButton) findViewById(R.id.add_buying_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MeatDetail.this, AddFruit.class);
				startActivity(intent);
			}
		});
		meat_title = (TextView) findViewById(R.id.detail_title);
		meat_price = (TextView) findViewById(R.id.detail_price);
		meat_sales = (TextView) findViewById(R.id.detail_sales);
		picture = (ImageView) findViewById(R.id.detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			meat = (Meat) bundle.get("meat");
		}
		if (meat != null) {// ��ʼ��Ⱦ���ݵ�������

			// ��ʼ��Ⱦ��ǰ��Ʒ��Ϣ
			meat_title.setText(meat.getMeat_title());
			meat_price.setText(meat.getMeat_price());
			meat_sales.setText(meat.getMeat_sales());
			Bitmap bit = BitmapFactory.decodeByteArray(meat.getMeat_picture(),
					0, meat.getMeat_picture().length); // ��ͼƬ��ת��Ϊbitmap����
			picture.setImageBitmap(bit);
		}
	}

}
