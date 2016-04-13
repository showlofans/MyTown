package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddNote;
import com.mycountry.model.Wine;
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

public class WineDetail extends Activity {

	private Wine wine;
	TextView wine_title, wine_price, wine_sales;
	ImageView picture;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buying_detail);
		
		// 返回按钮跳转
		ImageView menu = (ImageView) findViewById(R.id.back_buying_detail);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				WineDetail.this.finish();
			}
		});
		// 添加按钮跳转
		ImageButton plus = (ImageButton) findViewById(R.id.add_buying_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(WineDetail.this, AddNote.class);
				startActivity(intent);
			}
		});
		wine_title = (TextView) findViewById(R.id.detail_title);
		wine_price = (TextView) findViewById(R.id.detail_price);
		wine_sales = (TextView) findViewById(R.id.detail_sales);
		picture = (ImageView) findViewById(R.id.detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			wine = (Wine) bundle.get("ganhuo");
		}
		if (wine != null) {// 开始渲染数据到界面上

			// 开始渲染当前商品信息
			wine_title.setText(wine.getWine_title());
			wine_price.setText(wine.getWine_price());
			wine_sales.setText(wine.getWine_sales());
			Bitmap bit = BitmapFactory.decodeByteArray(wine.getWine_picture(), 0,
					wine.getWine_picture().length); // 将图片流转化为bitmap类型
			picture.setImageBitmap(bit);
		}
	}

}
