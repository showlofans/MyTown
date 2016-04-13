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
		setContentView(R.layout.success);	//���ø�Activity��Ҫ��ʾ��������ͼ
		Intent intent=getIntent();	//��ȡIntent����
		Bundle bundle=intent.getExtras();	//��ȡ���ݵ����ݰ�
		TextView user=(TextView)findViewById(R.id.User_Name);		//��ȡ��ʾ�û�����TextView���
		user.setText("�û�����"+bundle.getString("User_Name"));		//��ȡ������û�������ʾ��TextView�����
		TextView pwd=(TextView)findViewById(R.id.Password);		//��ȡ��ʾ�����TextView���
		pwd.setText("���룺"+bundle.getString("Password"));		//��ȡ��������벢��ʾ��TextView�����
		TextView email=(TextView)findViewById(R.id.Email);		//��ȡ��ʾE-mail��TextView���
		email.setText("E-mail��"+bundle.getString("Email"));		//��ȡ�����E-mail����ʾ��TextView�����
		
		//���ذ�ť��ת
		 Button menu=(Button)findViewById(R.id.menu);
	        menu.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SuccessActivity.this,RegisterActivity.class);
					startActivity(intent);
				}
			});
		//��¼��ť��ת
		 Button button1=(Button)findViewById(R.id.button1);
	        button1.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent intent = new Intent(SuccessActivity.this,LoginActivity.class);
					startActivity(intent);
				}
			});
	        
		//�˳���ť��ת
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
