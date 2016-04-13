package com.mycountry.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.menutab.R;
import com.mycountry.adapter.PifaAdapter;
import com.mycountry.details.GanhuoDetail;
import com.mycountry.model.Pifa;
import com.mycountry.utils.Constant;
import com.mycountry.utils.PageService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class PifaService extends FragmentActivity {
	private ListView lv;
	private List<Pifa> list;
	private Handler handler;
	private PifaAdapter adapter;
	public String x;
	ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pifa);
		lv = (ListView) findViewById(R.id.lvPifa);// 找到listview
		// 设置选项被单击的监听器
				lv.setOnItemClickListener(new OnItemClickListener() {

					@Override
					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {

						Intent intent = new Intent(PifaService.this,
								GanhuoDetail.class);
						intent.putExtra("ganhuo", adapter.getItem(position));
						startActivity(intent);
					}
				});
	
		list = new ArrayList<Pifa>();

		new Thread(new Runnable() {
			public void run() {
				Log.i("run(", "线程开始");
				x = send();// 调用send()获取返回的字符串。
				list = jxJSON(x);
				Message msg = handler.obtainMessage();
				handler.sendMessage(msg);
			}
		}).start();
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				adapter = new PifaAdapter(PifaService.this, list);
				lv.setAdapter(adapter);
				super.handleMessage(msg);
			}
		};
	}

	private List<Pifa> jxJSON(String result) {
		List<Pifa> ll = new ArrayList<Pifa>();
		if (result == null) {
			return null;
		}
		try {
			JSONArray jsonarr = new JSONArray(result);
			for (int i = 0; i < jsonarr.length(); i++) {
				JSONObject obj = jsonarr.getJSONObject(i);

				String pifa_title = obj.getString("pifa_title");
				String pifa_price = obj.getString("pifa_price");
				String pifa_sales=obj.getString("pifa_sales");
				byte[] pic = PageService
						.getImage(Constant.aURL+ obj.getString("pifa_picture"));
				Pifa sa = new Pifa(pifa_title, pifa_price,pifa_sales, pic);
				ll.add(sa);
			}  
			return ll;  
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private String send() {
		String str = null;
		String url =Constant.pifaURL;
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost request = new HttpPost(url);
		Log.i("send(", "try外面");
		HttpResponse response;
		try {
			Log.i("send(", "执行请求1");
			response = httpclient.execute(request);// 执行请求
			Log.i("response", response.toString());
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 如果请求成功
				str = EntityUtils.toString(response.getEntity()).trim();
				Log.i("send(", str);
				return str;
			} else {
				str = "请求失败";
				Log.i("send(", "请求失败");
				return str;

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;

	}

//	@Override
//	public void onClick(View v) {
//		// TODO 自动生成的方法存根
//		
//	}
}
