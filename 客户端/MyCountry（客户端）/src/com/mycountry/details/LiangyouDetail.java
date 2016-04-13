package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddFruit;
import com.mycountry.model.Liangyou;
import com.mycountry.service.LiangyouService;

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

public class LiangyouDetail extends Activity {

	private Liangyou liangyou;
	TextView liangyou_title, liangyou_price, liangyou_sales;
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
				Intent intent = new Intent(LiangyouDetail.this,
						LiangyouService.class);
				startActivity(intent);
			}
		});
		// ��Ӱ�ť��ת
		ImageButton plus = (ImageButton) findViewById(R.id.add_buying_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LiangyouDetail.this, AddFruit.class);
				startActivity(intent);
			}
		});
		liangyou_title = (TextView) findViewById(R.id.detail_title);
		liangyou_price = (TextView) findViewById(R.id.detail_price);
		liangyou_sales = (TextView) findViewById(R.id.detail_sales);
		picture = (ImageView) findViewById(R.id.detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			liangyou = (Liangyou) bundle.get("liangyou");
		}
		if (liangyou != null) {// ��ʼ��Ⱦ���ݵ�������

			// ��ʼ��Ⱦ��ǰ��Ʒ��Ϣ
			liangyou_title.setText(liangyou.getLiangyou_title());
			liangyou_price.setText(liangyou.getLiangyou_price());
			liangyou_sales.setText(liangyou.getLiangyou_sales());
			Bitmap bit = BitmapFactory.decodeByteArray(
					liangyou.getLiangyou_picture(), 0,
					liangyou.getLiangyou_picture().length); // ��ͼƬ��ת��Ϊbitmap����
			picture.setImageBitmap(bit);
		}
	}

}