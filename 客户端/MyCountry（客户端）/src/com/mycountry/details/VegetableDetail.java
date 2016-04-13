package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddNote;
import com.mycountry.model.Vegetable;
import com.mycountry.service.VegetableService;
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

public class VegetableDetail extends Activity {

	private Vegetable vegetable;
	TextView vegetable_title, vegetable_price, vegetable_sales;
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
				Intent intent = new Intent(VegetableDetail.this,
						VegetableService.class);
				startActivity(intent);
			}
		});
		// ��Ӱ�ť��ת
		ImageButton plus = (ImageButton) findViewById(R.id.add_buying_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(VegetableDetail.this, AddNote.class);
				startActivity(intent);
			}
		});
		vegetable_title = (TextView) findViewById(R.id.detail_title);
		vegetable_price = (TextView) findViewById(R.id.detail_price);
		vegetable_sales = (TextView) findViewById(R.id.detail_sales);
		picture = (ImageView) findViewById(R.id.detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			vegetable = (Vegetable) bundle.get("vegetable");
		}
		if (vegetable != null) {// ��ʼ��Ⱦ���ݵ�������

			// ��ʼ��Ⱦ��ǰ��Ʒ��Ϣ
			vegetable_title.setText(vegetable.getVegetable_title());
			vegetable_price.setText(vegetable.getVegetable_price());
			vegetable_sales.setText(vegetable.getVegetable_sales());
			Bitmap bit = BitmapFactory.decodeByteArray(
					vegetable.getVegetable_picture(), 0,
					vegetable.getVegetable_picture().length); // ��ͼƬ��ת��Ϊbitmap����
			picture.setImageBitmap(bit);
		}
	}

}
