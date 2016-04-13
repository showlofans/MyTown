package com.mycountry.menu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.menutab.R;

public class SettingsActivity extends Activity{
	private Button modify_password,modify_ID,mycountry_about;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		
		modify_password=(Button)findViewById(R.id.modify_password);
		modify_ID=(Button)findViewById(R.id.modify_ID);
		mycountry_about=(Button)findViewById(R.id.mycountry_about);
		
		modify_password.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(SettingsActivity.this,  getResources().getString(R.string.toast_title), Toast.LENGTH_LONG).show();
			}
			
		});
		modify_ID.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(SettingsActivity.this,  getResources().getString(R.string.toast_title), Toast.LENGTH_LONG).show();
			}
			
		});
		ImageView menu=(ImageView)findViewById(R.id.back_settings);
		 menu.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					finish();
				}
			});
		 Button login=(Button)findViewById(R.id.setting_login);
		 login.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(SettingsActivity.this,LoginActivity.class);
					startActivity(intent);
				}
			});
		 Button register=(Button)findViewById(R.id.setting_register);
		 register.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new Intent(SettingsActivity.this,RegisterActivity.class);
					startActivity(intent);
				}
			});
		 
		 mycountry_about.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SettingsActivity.this,MyCountryAbout.class);
				startActivity(intent);
				overridePendingTransition(android.R.anim.slide_in_left,
						android.R.anim.slide_out_right);
			//MyCountryAbout	
			}
			 
		 });

}
}