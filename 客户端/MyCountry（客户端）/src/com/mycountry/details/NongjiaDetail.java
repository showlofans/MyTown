package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddNote;
import com.mycountry.model.Nongjia;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class NongjiaDetail extends Activity {

	private Nongjia nongjia;
	TextView nongjia_title; 
	TextView nongjia_price;
	TextView nongjia_sales;
	TextView collect;
	Button shopping;
	Button buying;
	ImageView picture;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buying_detail);
		
		ImageView menu = (ImageView) findViewById(R.id.back_buying_detail);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				NongjiaDetail.this.finish();
			}
		});
		ImageButton plus = (ImageButton) findViewById(R.id.add_buying_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(NongjiaDetail.this, AddNote.class);
				startActivity(intent);
			}
		});
		nongjia_title = (TextView) findViewById(R.id.detail_title);
		nongjia_price = (TextView) findViewById(R.id.detail_price);
		nongjia_sales = (TextView) findViewById(R.id.detail_sales);
		picture = (ImageView) findViewById(R.id.detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			nongjia = (Nongjia) bundle.get("nongjia");
		}
		if (nongjia != null) {
			nongjia_title.setText(nongjia.getNongjia_title());
			nongjia_price.setText(nongjia.getNongjia_price());
			nongjia_sales.setText(nongjia.getNongjia_sales());
			Bitmap bit = BitmapFactory.decodeByteArray(nongjia.getNongjia_picture(), 0,
					nongjia.getNongjia_picture().length); 
			picture.setImageBitmap(bit);
		}
	}
}
