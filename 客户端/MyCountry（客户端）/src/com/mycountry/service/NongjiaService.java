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
import com.mycountry.activity.HomepageActivity;
import com.mycountry.adapter.ImageAdapter;
import com.mycountry.adapter.NongjiaAdapter;
import com.mycountry.details.NongjiaDetail;
import com.mycountry.model.Nongjia;
import com.mycountry.utils.AutoPlayGallery;
import com.mycountry.utils.Constant;
import com.mycountry.utils.NetUtils;
import com.mycountry.utils.PageService;
import com.mycountry.utils.RefreshableView;
import com.mycountry.utils.RefreshableView.PullToRefreshListener;

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
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class NongjiaService extends Activity implements OnClickListener {
	private ListView lv;
	private AutoPlayGallery autoGalley;
	private List<Nongjia> list;
	private Handler handler;
	private NongjiaAdapter adapter;
	public String x;
	ListView listview;
	private RefreshableView refreshableView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nong_jia);
		autoGalley = (AutoPlayGallery) findViewById(R.id.nongjiaAutoGallery);
		autoGalley.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(NongjiaService.this,
						NongjiaDetail.class);
			}
		});

		lv = (ListView) findViewById(R.id.lvNongjia);// 找到listview
		// 设置选项被单击的监听器
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(NongjiaService.this,
						NongjiaDetail.class);
				intent.putExtra("nongjia", adapter.getItem(position));
				startActivity(intent);
			}
		});

		list = new ArrayList<Nongjia>();

		if (NetUtils.isNetworkConnected(NongjiaService.this)) {
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
				adapter = new NongjiaAdapter(NongjiaService.this, list);
				lv.setAdapter(adapter);
				super.handleMessage(msg);
			}
		};

		AutoPlayGallery g = (AutoPlayGallery) findViewById(R.id.nongjiaAutoGallery);
		ArrayList<Drawable> drawables = new ArrayList<Drawable>();
		drawables.add(getResources().getDrawable(R.drawable.tuijian_001));
		drawables.add(getResources().getDrawable(R.drawable.tuijian_002));
		drawables.add(getResources().getDrawable(R.drawable.tuijian_003));
		ImageAdapter adapter = new ImageAdapter(this, drawables);

		g.setAdapter(adapter);
		refreshableView = (RefreshableView) findViewById(R.id.refreshable_view_nongjia);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				// Thread.sleep(3000);
				new Thread(new Runnable() {
					public void run() {
						Log.i("run(", " ߳̿ ʼ");
						x = send();//
						list = jxJSON(x);
						Message msg = handler.obtainMessage();
						handler.sendMessage(msg);
					}
				}).start();
				refreshableView.finishRefreshing();
			}
		}, 0);
	}

	private List<Nongjia> jxJSON(String result) {
		List<Nongjia> ll = new ArrayList<Nongjia>();
		if (result == null) {
			return null;
		}
		try {
			JSONArray jsonarr = new JSONArray(result);
			for (int i = 0; i < jsonarr.length(); i++) {
				JSONObject obj = jsonarr.getJSONObject(i);

				String nongjia_title = obj.getString("nongjia_title");
				String nongjia_price = obj.getString("nongjia_price");
				String nongjia_sales = obj.getString("nongjia_sales");
				String country_name = obj.getString("country_name");
				String nongjia_distance = obj.getString("nongjia_distance");

				byte[] pic = PageService.getImage(Constant.aURL
						+ obj.getString("nongjia_picture"));
				Nongjia sa = new Nongjia(nongjia_title, nongjia_price,
						nongjia_sales, country_name, nongjia_distance, pic);
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
		String url = Constant.nongjiaURL;
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

	@Override
	public void onClick(View v) {

	}
}
