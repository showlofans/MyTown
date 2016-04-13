package com.mycountry.utils;

import com.example.menutab.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class NetReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if (ConnectivityManager.CONNECTIVITY_ACTION.equals(action)) {
			boolean isConnected = NetUtils.isNetworkConnected(context);
	        System.out.println("����״̬��" + isConnected);
	        System.out.println("wifi״̬��" + NetUtils.isWifiConnected(context));
	        System.out.println("�ƶ�����״̬��" + NetUtils.isMobileConnected(context));
	        System.out.println("�����������ͣ�" + NetUtils.getConnectedType(context));
	        if (isConnected) {
	        	Toast.makeText(context, "�Ѿ���������", Toast.LENGTH_LONG).show();
	        } else {
	        	Toast.makeText(context, "�Ѿ��Ͽ�����", Toast.LENGTH_LONG).show();
	        	context.setTheme(R.layout.item_published_grida);
	        }
		}
	} 
	
}
