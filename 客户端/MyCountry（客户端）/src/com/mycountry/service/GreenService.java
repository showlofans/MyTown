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

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.menutab.R;
import com.mycountry.activity.HomepageActivity;
import com.mycountry.adapter.GreenAdapter;
import com.mycountry.adapter.ImageAdapter;
import com.mycountry.details.GreenDetail;
import com.mycountry.model.Green;
import com.mycountry.utils.AutoPlayGallery;
import com.mycountry.utils.Constant;
import com.mycountry.utils.NetUtils;
import com.mycountry.utils.PageService;
import com.mycountry.utils.RefreshableView;
import com.mycountry.utils.RefreshableView.PullToRefreshListener;

public class GreenService extends Activity {
	private static final String TAG = "GreenService";// 定义当前标签
	private ListView lv;
	private static List<Green> list;
	private Handler handler;
	private GreenAdapter adapter;
	public String x;
	public RelativeLayout rl;
	private RefreshableView refreshableView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.greenfood);
		
		
		rl = (RelativeLayout) findViewById(R.id.layout_top);
		rl.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GreenService.this, GreenSearch.class);
				startActivity(intent);
			}
		});
		
		
		lv = (ListView) findViewById(R.id.lvGreen);// 找到listview
		// 设置选项被单击的监听器
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(GreenService.this,
						GreenDetail.class);
				intent.putExtra("green", adapter.getItem(position));
				startActivity(intent);
			}
		});

		list = new ArrayList<Green>();
		if (NetUtils.isNetworkConnected(GreenService.this)) {
			new Thread(new Runnable() {
				public void run() {
					Log.i("run(", "线程开始");
					x = send();
					list = jxJSON(x);
					Message msg = handler.obtainMessage();
					handler.sendMessage(msg);
				}
			}).start();
		}
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				adapter = new GreenAdapter(GreenService.this, list);
				lv.setAdapter(adapter);
				super.handleMessage(msg);
			}
		};
		
		AutoPlayGallery g = (AutoPlayGallery) findViewById(R.id.greenAutoGallery);
        ArrayList<Drawable> drawables = new ArrayList<Drawable>();
        drawables.add(getResources().getDrawable(R.drawable.tuijian_001));
        drawables.add(getResources().getDrawable(R.drawable.tuijian_002));
        drawables.add(getResources().getDrawable(R.drawable.tuijian_003));
        ImageAdapter adapter = new ImageAdapter(this, drawables);
        g.setAdapter(adapter);

		refreshableView = (RefreshableView) findViewById(R.id.refreshable_view_green);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				// Thread.sleep(3000);
				new Thread(new Runnable() {
					public void run() {
						Log.i("run(", " ߳̿ ʼ");
						x = send();// send() ȡص ַ
						list = jxJSON(x);
						Message msg = handler.obtainMessage();
						handler.sendMessage(msg);
					}
				}).start();
				refreshableView.finishRefreshing();
			}
		}, 0);
	}

	private List<Green> jxJSON(String result) {
		List<Green> ll = new ArrayList<Green>();
		if (result == null) {
			return null;
		}
		try {
			JSONArray jsonarr = new JSONArray(result);
			for (int i = 0; i < jsonarr.length(); i++) {
				JSONObject obj = jsonarr.getJSONObject(i);

				String green_title = obj.getString("green_title");
				String green_content = obj.getString("green_content");
				String green_price = obj.getString("green_price");
				String green_sales = obj.getString("green_sales");
				String gcountry_name = obj.getString("gcountry_name");
				String green_distance = obj.getString("green_distance");
				byte[] pic = PageService.getImage(Constant.aURL
						+ obj.getString("green_picture"));
				Green sa = new Green(green_title, green_content, green_price, green_sales, gcountry_name, green_distance, pic);
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
		String url = Constant.greenURL2;
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
}
