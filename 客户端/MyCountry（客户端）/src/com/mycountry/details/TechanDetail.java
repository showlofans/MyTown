package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddNote;
import com.mycountry.model.Techan;
import com.mycountry.service.TechanService;

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

public class TechanDetail extends Activity {

	private Techan techan;
	TextView techan_title, techan_price, techan_sales;
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
				Intent intent = new Intent(TechanDetail.this,
						TechanService.class);
				startActivity(intent);
			}
		});
		// ��Ӱ�ť��ת
		ImageButton plus = (ImageButton) findViewById(R.id.add_buying_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(TechanDetail.this, AddNote.class);
				startActivity(intent);
			}
		});
		techan_title = (TextView) findViewById(R.id.detail_title);
		techan_price = (TextView) findViewById(R.id.detail_price);
		techan_sales = (TextView) findViewById(R.id.detail_sales);
		picture = (ImageView) findViewById(R.id.detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			techan = (Techan) bundle.get("techan");
		}
		if (techan != null) {// ��ʼ��Ⱦ���ݵ�������

			// ��ʼ��Ⱦ��ǰ��Ʒ��Ϣ
			techan_title.setText(techan.getTechan_title());
			techan_price.setText(techan.getTechan_price());
			techan_sales.setText(techan.getTechan_sales());
			Bitmap bit = BitmapFactory.decodeByteArray(
					techan.getTechan_picture(), 0,
					techan.getTechan_picture().length); // ��ͼƬ��ת��Ϊbitmap����
			picture.setImageBitmap(bit);
		}
	}

}
