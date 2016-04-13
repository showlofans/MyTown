package com.mycountry.menu;

import com.example.menutab.R;
import com.mycountry.menu.LoginActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SuccessActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.success);	//设置该Activity中要显示的内容视图
		Intent intent=getIntent();	//获取Intent对象
		Bundle bundle=intent.getExtras();	//获取传递的数据包
		TextView user=(TextView)findViewById(R.id.User_Name);		//获取显示用户名的TextView组件
		user.setText("用户名："+bundle.getString("User_Name"));		//获取输入的用户名并显示到TextView组件中
		TextView pwd=(TextView)findViewById(R.id.Password);		//获取显示密码的TextView组件
		pwd.setText("密码："+bundle.getString("Password"));		//获取输入的密码并显示到TextView组件中
		TextView email=(TextView)findViewById(R.id.Email);		//获取显示E-mail的TextView组件
		email.setText("E-mail："+bundle.getString("Email"));		//获取输入的E-mail并显示到TextView组件中
		
		//返回按钮跳转
		 Button menu=(Button)findViewById(R.id.menu);
	        menu.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SuccessActivity.this,RegisterActivity.class);
					startActivity(intent);
				}
			});
		//登录按钮跳转
		 Button button1=(Button)findViewById(R.id.button1);
	        button1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SuccessActivity.this,LoginActivity.class);
					startActivity(intent);
				}
			});
	        
		//退出按钮跳转
		 Button button2=(Button)findViewById(R.id.button2);
	        button2.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					finish();
				}
			});
		
	}

}
