package com.mycountry.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menutab.R;
import com.mycountry.service.*;

public class MyCountryActivity extends Activity {
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_country);

		// ���Ļ�������ת
		TextView culture = (TextView) findViewById(R.id.tv_culture);
		culture.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent2 = new Intent(MyCountryActivity.this,
						CultureService.class);
				startActivity(intent2);
			}
		});
		// ���ռǽ�����ת
		TextView note = (TextView) findViewById(R.id.tv_note);
		note.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent3 = new Intent(MyCountryActivity.this,
						NoteService.class);
				intent3.putExtra("12", "note");
				startActivity(intent3);
			}
		});

		TextView calendar = (TextView) findViewById(R.id.tv_calendar);
		calendar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent2 = new Intent(MyCountryActivity.this,
						Calendar.class);
				startActivity(intent2);
			}
		});

		TextView image = (TextView) findViewById(R.id.tv_camera);
		image.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent3 = new Intent(MyCountryActivity.this,
						ImageActivity.class);
				startActivity(intent3);
			}
		});

	}
}