package com.mycountry.details;

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
import android.widget.Toast;

import com.example.menutab.R;
import com.mycountry.activity.AddNote;
import com.mycountry.dao.CollectManage;
import com.mycountry.dao.ShoppingManage;
import com.mycountry.model.Fruit;

public class FruitDetail extends Activity implements OnClickListener{

	private Fruit fruit;
	private TextView fruit_title, fruit_price, fruit_sales,love_tv;
	private ImageView picture;
	private Button shop_bt,buy_bt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.buying_detail);
		initView();
		shop_bt.setOnClickListener(this);
		buy_bt.setOnClickListener(this);
		love_tv.setOnClickListener(this);
		
		// 返回按钮跳转
		ImageView menu = (ImageView) findViewById(R.id.back_buying_detail);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		// 添加按钮跳转
		ImageButton plus = (ImageButton) findViewById(R.id.add_buying_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FruitDetail.this, AddNote.class);
				startActivity(intent);
			}
		});
		fruit_title = (TextView) findViewById(R.id.detail_title);
		fruit_price = (TextView) findViewById(R.id.detail_price);
		fruit_sales = (TextView) findViewById(R.id.detail_sales);
		picture = (ImageView) findViewById(R.id.detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			fruit = (Fruit) bundle.get("fruit");
		}
		if (fruit != null) {// 开始渲染数据到界面上 

			// 开始渲染当前商品信息
			fruit_title.setText(fruit.getFruit_title());
			fruit_price.setText(fruit.getFruit_price());
			fruit_sales.setText(fruit.getFruit_sales());
			Bitmap bit = BitmapFactory.decodeByteArray(fruit.getFruit_picture(), 0,
					fruit.getFruit_picture().length); // 将图片流转化为bitmap类型
			picture.setImageBitmap(bit);
		}
	}

	private void initView() {
		shop_bt=(Button)findViewById(R.id.shopping);
		buy_bt=(Button)findViewById(R.id.buying);
		love_tv=(TextView)findViewById(R.id.love);
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
		case R.id.shopping:
			new ShoppingManage().addFruit(fruit, getApplicationContext());
			break;
		case R.id.buying:
			Toast.makeText(getApplicationContext(), "暂不支持此服务",
					Toast.LENGTH_SHORT).show();
			break;
		case R.id.love: 
			new CollectManage().addFruit(fruit, getApplicationContext());
			break;
		}
	}

}