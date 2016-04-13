package com.mycountry.menu;

import com.example.menutab.R;
import com.mycountry.activity.MainActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

public class MessageActivity extends Activity {
	private TabHost tabHost; 
	private TabWidget tab;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.message);
		ImageView culture = (ImageView) findViewById(R.id.back_message);
		culture.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tab=(TabWidget) findViewById(android.R.id.tabs);
		
		tabHost.setup();

		LayoutInflater inflater = LayoutInflater.from(this);
		inflater.inflate(R.layout.message1, tabHost.getTabContentView());
		inflater.inflate(R.layout.reply, tabHost.getTabContentView());
		inflater.inflate(R.layout.atme, tabHost.getTabContentView());

		tabHost.addTab(tabHost.newTabSpec("tab01").setIndicator("消息")
				.setContent(R.id.message)); 

		tabHost.addTab(tabHost.newTabSpec("tab02").setIndicator("回复")
				.setContent(R.id.reply)); 

		tabHost.addTab(tabHost.newTabSpec("tab03").setIndicator("提醒")
				.setContent(R.id.atme)); 
		
//		int count = tab.getChildCount();//TabHost中有一个getTabWidget()的方法
//		    for (int i = 0; i < count; i++) {
//		     View view = tab.getChildTabViewAt(i);   
//		     view.getLayoutParams().height = 120; //tabWidget.getChildAt(i)
//		     TextView tv = (TextView) tab.getChildAt(i).findViewById(android.R.id.title);
//	         tv.setTextSize(18);
//		    }
		    
		    for (int i = 0; i < tab.getChildCount(); i++) {  
                View child = tab.getChildAt(i);  
               final TextView tv = (TextView)child.findViewById(android.R.id.title);
               RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) tv.getLayoutParams();  
               params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, 0); //取消文字底边对齐  
               params.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE); //设置文字居中对齐  
               child.getLayoutParams().height = 80;  
           }  
	}
}