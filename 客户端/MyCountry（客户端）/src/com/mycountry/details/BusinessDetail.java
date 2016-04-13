package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddNote;
import com.mycountry.model.Business;
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

public class BusinessDetail extends Activity {

	private Business business;
	TextView title;
	TextView business_title;
	TextView business_content;
	TextView country_name;
	TextView business_time;
	ImageView picture;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_detail);
		
		ImageView menu = (ImageView) findViewById(R.id.back_news_detail);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		ImageButton plus = (ImageButton) findViewById(R.id.share_news_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(BusinessDetail.this, AddNote.class);
				startActivity(intent);
			}
		});
		title = (TextView) findViewById(R.id.textView_title);
		business_title = (TextView) findViewById(R.id.news_detail_title);
		business_content = (TextView) findViewById(R.id.news_detail_content);
		country_name = (TextView) findViewById(R.id.news_detail_name);
		business_time = (TextView) findViewById(R.id.news_detail_time);
		picture = (ImageView) findViewById(R.id.news_detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			business = (Business) bundle.get("business");
		}
		if (business != null) {
			
			title.setText("招商加盟");
			business_title.setText(business.getBusiness_title());
			business_content.setText(business.getBusiness_content());
			country_name.setText(business.getCountry_name());
			business_time.setText(business.getBusiness_time());
			Bitmap bit = BitmapFactory.decodeByteArray(business.getBusiness_picture(), 0,
					business.getBusiness_picture().length); // ��ͼƬ��ת��Ϊbitmap����
			picture.setImageBitmap(bit);
		}
	}

}
