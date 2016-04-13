package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddNote;
import com.mycountry.model.Tour;
import com.mycountry.service.TourService;

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

public class TourDetail extends Activity {

	private Tour tour;
	TextView tour_title, tour_price, tour_sales;
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
				Intent intent = new Intent(TourDetail.this, TourService.class);
				startActivity(intent);
			}
		});
		// ��Ӱ�ť��ת
		ImageButton plus = (ImageButton) findViewById(R.id.add_buying_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TourDetail.this, AddNote.class);
				startActivity(intent);
			}
		});
		tour_title = (TextView) findViewById(R.id.detail_title);
		tour_price = (TextView) findViewById(R.id.detail_price);
		tour_sales = (TextView) findViewById(R.id.detail_sales);
		picture = (ImageView) findViewById(R.id.detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			tour = (Tour) bundle.get("tour");
		}
		if (tour != null) {// ��ʼ��Ⱦ��ݵ�������

			// ��ʼ��Ⱦ��ǰ��Ʒ��Ϣ
			tour_title.setText(tour.getTour_title());
			tour_price.setText(tour.getTour_price());
			tour_sales.setText(tour.getTour_sales());
			Bitmap bit = BitmapFactory.decodeByteArray(tour.getTour_picture(),
					0, tour.getTour_picture().length); // ��ͼƬ��ת��Ϊbitmap����
			picture.setImageBitmap(bit);
		}
	}

}
