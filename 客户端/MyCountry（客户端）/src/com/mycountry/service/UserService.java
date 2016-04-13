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
import com.mycountry.activity.AddNote;
import com.mycountry.activity.MainActivity;
import com.mycountry.adapter.UserAdapter;
import com.mycountry.details.CultureDetail;
import com.mycountry.menu.MeActivity;
import com.mycountry.menu.MessageActivity;
import com.mycountry.model.User;
import com.mycountry.utils.Constant;
import com.mycountry.utils.PageService;
import com.mycountry.utils.RefreshableView;
import com.mycountry.utils.RefreshableView.PullToRefreshListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class UserService extends Activity implements OnClickListener {
	private ListView lv;
	private List<User> list;
	private Handler handler;
	private UserAdapter adapter;
	public String x;
	ListView listview;
	private RefreshableView refreshableView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.me);
		lv = (ListView) findViewById(R.id.lvMe);// 找到listview
//		Bundle bundle = getIntent().getExtras();
//		if(bundle!=null){
//			bundle.getString("image");
//			bundle.getString("name");
//		}
		// 设置选项被单击的监听器
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(UserService.this,
						CultureDetail.class);
				intent.putExtra("culture", adapter.getItem(position));
				startActivity(intent);
			}
		});
		// 返回按钮跳转
		ImageView menu = (ImageView) findViewById(R.id.back_me);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		
		ImageView edit = (ImageView) findViewById(R.id.edit_me);
		edit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(UserService.this, MeActivity.class);
				startActivity(intent);
			}
		});

		list = new ArrayList<User>();

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
				adapter = new UserAdapter(UserService.this, list);
				lv.setAdapter(adapter);
				super.handleMessage(msg);
			}
		};
		refreshableView = (RefreshableView) findViewById(R.id.refreshable_view_me);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				// Thread.sleep(3000);
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

	private List<User> jxJSON(String result) {
		List<User> ll = new ArrayList<User>();
		if (result == null) {
			return null;
		}
		try {
			JSONArray jsonarr = new JSONArray(result);
			for (int i = 0; i < jsonarr.length(); i++) {
				JSONObject obj = jsonarr.getJSONObject(i);

				String user_name = obj.getString("user_name");
				String user_email = obj.getString("user_email");
				String user_address = obj.getString("user_address");
				String user_type = obj.getString("user_type");
				byte[] pic = PageService.getImage(Constant.aURL
						+ obj.getString("user_picture"));
				User sa = new User(user_name, user_email, user_address, user_type ,pic);
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
		String url = Constant.userURL;
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
