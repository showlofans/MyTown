package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddNote;
import com.mycountry.model.Culture;

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

public class CultureDetail extends Activity {

	private Culture culture;
	TextView culture_title, culture_content,culture_time;
	ImageView picture;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_detail);
		
		ImageView menu = (ImageView) findViewById(R.id.back_news_detail);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				CultureDetail.this.finish();
			}
		});
		// ��Ӱ�ť��ת
		ImageButton plus = (ImageButton) findViewById(R.id.share_news_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CultureDetail.this, AddNote.class);
				startActivity(intent);
			}
		});
		culture_title = (TextView) findViewById(R.id.news_detail_title);
		culture_content = (TextView) findViewById(R.id.news_detail_content);
		culture_time=(TextView)findViewById(R.id.news_detail_time);
		picture = (ImageView) findViewById(R.id.news_detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			culture = (Culture) bundle.get("culture");
		}
		if (culture != null) {

			culture_title.setText(culture.getCulture_title());
			culture_content.setText(culture.getCulture_content());
			culture_time.setText(culture.getCulture_time());
			Bitmap bit = BitmapFactory.decodeByteArray(culture.getCulture_picture(), 0,
					culture.getCulture_picture().length); 
			picture.setImageBitmap(bit);
		}
	}

}
