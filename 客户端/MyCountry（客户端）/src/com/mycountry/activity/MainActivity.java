package com.mycountry.activity;

import org.apache.http.client.HttpClient;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

import com.example.menutab.R;
import com.mycountry.service.BusinessService;
import com.mycountry.service.GreenService;
import com.mycountry.service.NongjiaService;

public class MainActivity extends TabActivity implements
		OnCheckedChangeListener {
	private TabHost tabHost;
	private RadioGroup radioderGroup;
	protected com.slidingmenu.lib.SlidingMenu side_drawer;
	public static HttpClient httpclient; // 声明一个静态的全局的HttpClient对象
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
						| WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		tabHost = this.getTabHost();
		tabHost.addTab(tabHost.newTabSpec("1").setIndicator("1")
				.setContent(new Intent(this, HomepageActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("2").setIndicator("2")
				.setContent(new Intent(this, GreenService.class)));
		tabHost.addTab(tabHost.newTabSpec("3").setIndicator("3")
				.setContent(new Intent(this, NongjiaService.class)));
		tabHost.addTab(tabHost.newTabSpec("4").setIndicator("4")
				.setContent(new Intent(this, BusinessService.class)));
		tabHost.addTab(tabHost.newTabSpec("5").setIndicator("5")
				.setContent(new Intent(this, MyCountryActivity.class)));

		radioderGroup = (RadioGroup) findViewById(R.id.main_radio);
		radioderGroup.setOnCheckedChangeListener(this);
		radioderGroup.check(R.id.home);// Ĭ�ϵ�һ����ť
	}
	
	//����������η��ؼ��˳�
	
	private long mExitTime;
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if(side_drawer.isMenuShowing() ||side_drawer.isSecondaryMenuShowing()){
				side_drawer.showContent();
			}else {
				if ((System.currentTimeMillis() - mExitTime) > 2000) {
					Toast.makeText(this, "�ٰ�һ���˳�",
							Toast.LENGTH_SHORT).show();
					mExitTime = System.currentTimeMillis();
				} else {
					finish();
				}
			}
			return true;
		}
		//����MENU��ť����¼����������κβ���
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
	

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.home:
			tabHost.setCurrentTabByTag("1");
			break;
		case R.id.greenfood:
			tabHost.setCurrentTabByTag("2");
			break;
		case R.id.town_tour:
			tabHost.setCurrentTabByTag("3");
			break;
		case R.id.business:
			tabHost.setCurrentTabByTag("4");
			break;
		case R.id.my_country:
			tabHost.setCurrentTabByTag("5");
			break;
		}
	}
}
