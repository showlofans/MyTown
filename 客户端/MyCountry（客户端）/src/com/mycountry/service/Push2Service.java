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
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.menutab.R;
import com.mycountry.activity.AddFruit;
import com.mycountry.activity.MainActivity;
import com.mycountry.adapter.Push2Adapter;
import com.mycountry.details.MeatDetail;
import com.mycountry.model.Push2;
import com.mycountry.utils.Constant;
import com.mycountry.utils.PageService;
import com.mycountry.utils.RefreshableView;
import com.mycountry.utils.RefreshableView.PullToRefreshListener;

public class Push2Service extends Activity implements OnClickListener {
	private static final String TAG = "Push2Service";// 定义当前标签
	private ListView lv;
	private List<Push2> list;
	private Handler handler;
	private Push2Adapter adapter;
	public String x;
	private String et_title="push2";
	private TextView title;
	ListView listview;
	private RefreshableView refreshableView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.goods_list);
		title = (TextView) findViewById(R.id.goods_title);
		title.setText("周边游");
		lv = (ListView) findViewById(R.id.goods_listView);// 找到listview
		// 设置选项被单击的监听器
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(Push2Service.this, MeatDetail.class);
				intent.putExtra("push2", adapter.getItem(position));
				startActivity(intent);
			}
		});

		// 返回按钮跳转
		ImageView menu = (ImageView) findViewById(R.id.goods_back);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		// 添加按钮跳转
		ImageButton plus = (ImageButton) findViewById(R.id.goods_add);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(Push2Service.this, AddFruit.class);
				intent.putExtra("fromtype", et_title);
				startActivity(intent);
			}
		});
		list = new ArrayList<Push2>();

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
				adapter = new Push2Adapter(Push2Service.this, list);
				lv.setAdapter(adapter);
				super.handleMessage(msg);
			}
		};
		refreshableView = (RefreshableView) findViewById(R.id.goods_refreshable_view);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				//Thread.sleep(3000);
				new Thread(new Runnable() {
					public void run() {
						Log.i("run(", " ߳̿ ʼ");
						x = send();
						list = jxJSON(x);
						Message msg = handler.obtainMessage();
						handler.sendMessage(msg);
					}
				}).start();
				refreshableView.finishRefreshing();
			}
		}, 0);
	}

	private List<Push2> jxJSON(String result) {
		List<Push2> ll = new ArrayList<Push2>();
		if (result == null) {
			return null;
		}
		try {
			JSONArray jsonarr = new JSONArray(result);
			for (int i = 0; i < jsonarr.length(); i++) {
				JSONObject obj = jsonarr.getJSONObject(i);

				String title = obj.getString("push2_title");
				String content = obj.getString("push2_price");
				String sales = obj.getString("push2_sales");
				String price = obj.getString("push2_price");
				String location = obj.getString("country_name");
				String distance = obj.getString("push2_distance");
				byte[] pic = PageService.getImage(Constant.aURL
						+ obj.getString("push2_picture"));
				Push2 sa = new Push2(title, content, sales, price, location, distance, pic);
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
		String url = Constant.push2URL;
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
