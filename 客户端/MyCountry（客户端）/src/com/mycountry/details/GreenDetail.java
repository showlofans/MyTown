package com.mycountry.details;

import java.util.ArrayList;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.activity.AddFruit;
import com.mycountry.dao.ShoppingProvider;
import com.mycountry.dao.Shou;
import com.mycountry.dao.theGoodes;
import com.mycountry.model.Green;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
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
import android.widget.Toast;

public class GreenDetail extends Activity {
	final int code = 0x717;
	private Green green;
	TextView green_title, green_price, green_sales;
	ImageView picture;
	ImageButton add_buying_detail;
	Button shopping, buying; // 收藏按钮
	TextView love;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buying_detail);

		// ���ذ�ť��ת
		ImageView menu = (ImageView) findViewById(R.id.back_buying_detail);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				GreenDetail.this.finish();
			}
		});
		// ��Ӱ�ť��ת
		ImageButton plus = (ImageButton) findViewById(R.id.add_buying_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GreenDetail.this, AddFruit.class);
				startActivity(intent);
			}
		});
		green_title = (TextView) findViewById(R.id.detail_title);
		green_price = (TextView) findViewById(R.id.detail_price);
		green_sales = (TextView) findViewById(R.id.detail_sales);
		picture = (ImageView) findViewById(R.id.detail_pic);
		love = (TextView) findViewById(R.id.love);
		shopping = (Button) findViewById(R.id.shopping);
		buying = (Button) findViewById(R.id.buying);
		add_buying_detail = (ImageButton) findViewById(R.id.add_buying_detail);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			green = (Green) bundle.get("green");
		}
		if (green != null) {// ��ʼ��Ⱦ��ݵ�������

			// ��ʼ��Ⱦ��ǰ��Ʒ��Ϣ
			green_title.setText(green.getGreen_title());
			green_price.setText(green.getGreen_price());
			green_sales.setText(green.getGreen_sales());
			Bitmap bit = BitmapFactory.decodeByteArray(
					green.getGreen_picture(), 0,
					green.getGreen_picture().length); // ��ͼƬ��ת��Ϊbitmap����
			picture.setImageBitmap(bit);
		}
		love.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// 保存商品信息到数据库中
				storeData();
				Toast.makeText(GreenDetail.this, "收藏成功！", Toast.LENGTH_LONG)
						.show();
			}
		});
		add_buying_detail.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GreenDetail.this, ShouCang.class);

			}

		});
		shopping.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				/*
				 * List<theGoodes> record = new ArrayList<theGoodes>(); String
				 * title=green.getGreen_title(); String
				 * price=green.getGreen_price(); String
				 * sales=green.getGreen_sales(); byte[]
				 * picture=green.getGreen_picture(); record.add(new
				 * theGoodes(title,sales,price,picture));
				 */
				Intent intent1 = new Intent();
				Bundle bundle = new Bundle();
				// intent1.setClass(GreenDetail.this,GouActivity.class);
				bundle.putString("title1", green.getGreen_title());
				bundle.putString("sales1", green.getGreen_sales());
				bundle.putString("price1", green.getGreen_price());
				bundle.putString("picture1", green.getGreen_price());
				intent1.putExtras(bundle);
				startActivity(intent1);
			}

		});

	}

	// 保存商品数据到数据库中
	protected void storeData() {
		ContentResolver cr = getContentResolver();
		ContentValues valuse = new ContentValues();
		valuse.put(ShoppingProvider.SHOP_TITLE, green.getGreen_title());
		valuse.put(ShoppingProvider.SHOP_PRICE, green.getGreen_price());
		valuse.put(ShoppingProvider.SHOP_SALES, green.getGreen_sales());
		valuse.put(ShoppingProvider.SHOP_PICTURE, green.getGreen_picture());
		cr.insert(ShoppingProvider.SHOP_URI, valuse);
	}

}
