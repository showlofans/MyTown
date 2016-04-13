package com.mycountry.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import com.example.menutab.R;
import com.mycountry.adapter.GreenAdapter;
import com.mycountry.details.GreenDetail;
import com.mycountry.model.Green;
import com.mycountry.utils.Constant;
import com.mycountry.utils.PageService;
import com.mycountry.utils.RefreshableView;
import com.mycountry.utils.RefreshableView.PullToRefreshListener;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.DialogPreference;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class GreenSearch extends Activity implements OnClickListener {
	private ListView lv;
	private List<Green> list;
	private Handler handler;
	private GreenAdapter adapter;
	public String x;
	ListView listview;
	private EditText edt;
	private ImageView back;
	private String p;
	private Handler h;
	private RefreshableView refreshableView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.greenfood_search);
		back = (ImageView) findViewById(R.id.back_greenfood);
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
		lv = (ListView) findViewById(R.id.lvGreen_search);// 找到listview
		// 设置选项被单击的监听器
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(GreenSearch.this, GreenDetail.class);
				intent.putExtra("green", adapter.getItem(position));
				startActivity(intent);
			}
		});

		// 搜索按钮跳转
		TextView plus = (TextView) findViewById(R.id.sarch_greenfood_search);
		edt = (EditText) findViewById(R.id.edt_search);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (edt.getText().toString().equals("")
						|| edt.getText().toString() == null) {
					Toast.makeText(GreenSearch.this, "请输入搜索内容", Toast.LENGTH_LONG).show();
				} else {
					new Thread(new Runnable() {
						@Override
						public void run() {
							p = Serch(edt.getText().toString());
							list = jxJSON(p);
							Message msg = h.obtainMessage();
							h.sendMessage(msg);
						}
					}).start();
				}
			}
		});
		h = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				adapter = new GreenAdapter(GreenSearch.this, list);
				lv.setAdapter(adapter);
				if(p.equals("ABC")){
					AlertDialog dialog = new AlertDialog.Builder(GreenSearch.this).create();
					dialog.setButton(DialogInterface.BUTTON_NEUTRAL, "继续其他搜索",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog, int which) {
									edt.setText("");
								}
							});
				}
				super.handleMessage(msg);
			}
		};
		list = new ArrayList<Green>();

//		new Thread(new Runnable() {
//			public void run() {
//				Log.i("run(", "线程开始");
//				x = send();// 调用send()获取返回的字符串。
//				list = jxJSON(x);
//				Message msg = handler.obtainMessage();
//				handler.sendMessage(msg);
//			}
//		}).start();
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				adapter = new GreenAdapter(GreenSearch.this, list);
				lv.setAdapter(adapter);
				super.handleMessage(msg);
			}
		};
		refreshableView = (RefreshableView) findViewById(R.id.refreshable_view_green);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				// Thread.sleep(3000);
				new Thread(new Runnable() {
					public void run() {
						Log.i("run(", " ߳̿ ʼ");
						x = send();// send() ȡ ص ַ
						list = jxJSON(x);
						Message msg = handler.obtainMessage();
						handler.sendMessage(msg);
					}
				}).start();
				refreshableView.finishRefreshing();
			}
		}, 0);
	}

	private String Serch(String string) {
		String sss = null;
		String url = Constant.searchURL;
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost request = new HttpPost(url);
		try {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("search", string)); // 用户名
			request.setEntity(new UrlEncodedFormEntity(params, "utf-8")); // 设置编码方式
			HttpResponse response = httpclient.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				sss = EntityUtils.toString(response.getEntity()).trim(); // 获取返回的字符串
			} else {
				sss = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sss;
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
				String green_time = obj.getString("green_time");
				String green_distance = obj.getString("green_distance");
				byte[] pic = PageService.getImage(Constant.aURL
						+ obj.getString("green_picture"));
				Green sa = new Green(green_title, green_content, green_price, green_sales,
						gcountry_name, green_distance, pic, green_time);
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
		String url = Constant.greenURL;
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
