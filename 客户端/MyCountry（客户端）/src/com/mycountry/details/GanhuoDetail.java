package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddFruit;
import com.mycountry.model.Ganhuo;
import com.mycountry.service.GanhuoService;

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

public class GanhuoDetail extends Activity {

	private Ganhuo ganhuo;
	TextView ganhuo_title, ganhuo_price, ganhuo_sales;
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
				Intent intent = new Intent(GanhuoDetail.this,
						GanhuoService.class);
				startActivity(intent);
			}
		});
		// 添加按钮跳转
		ImageButton plus = (ImageButton) findViewById(R.id.add_buying_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GanhuoDetail.this, AddFruit.class);
				startActivity(intent);
			}
		});
		ganhuo_title = (TextView) findViewById(R.id.detail_title);
		ganhuo_price = (TextView) findViewById(R.id.detail_price);
		ganhuo_sales = (TextView) findViewById(R.id.detail_sales);
		picture = (ImageView) findViewById(R.id.detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			ganhuo = (Ganhuo) bundle.get("ganhuo");
		}
		if (ganhuo != null) {// 开始渲染数据到界面上

			// 开始渲染当前商品信息
			ganhuo_title.setText(ganhuo.getGanhuo_title());
			ganhuo_price.setText(ganhuo.getGanhuo_price());
			ganhuo_sales.setText(ganhuo.getGanhuo_sales());
			Bitmap bit = BitmapFactory.decodeByteArray(ganhuo.getGanhuo_picture(), 0,
					ganhuo.getGanhuo_picture().length); // 将图片流转化为bitmap类型
			picture.setImageBitmap(bit);
		}
	}

}
