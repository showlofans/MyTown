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
import com.mycountry.adapter.NoteAdapter;
import com.mycountry.details.NoteDetail;
import com.mycountry.model.Note;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class NoteService extends Activity {
	private static final String TAG = "NoteService";// 定义当前标签
	// private String et_title="民情日记";
	private ListView lv;
	private static List<Note> list;
	private static String note;
	private Handler handler;
	private NoteAdapter adapter;
	private TextView title;
	public String x;
	private RefreshableView refreshableView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.goods_list);
		title = (TextView) findViewById(R.id.goods_title);
		title.setText("民情日记");

		lv = (ListView) findViewById(R.id.goods_listView);// 找到listview
		// 设置选项被单击的监听器
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(NoteService.this, NoteDetail.class);
				intent.putExtra("note", adapter.getItem(position));
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
				Intent intent = new Intent(NoteService.this, AddNote.class);
				// intent.putExtra("fromtype", et_title);
				startActivity(intent);
			}
		});
		list = new ArrayList<Note>();
		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			note = (String) bundle.get("12");
			if (note.equals("note")) {
				new Thread(new Runnable() {
					public void run() {
						Log.i("run(", "线程开始");
						x = send();// 调用send()获取返回的字符串。
						list = jxJSON(x);
						Message msg = handler.obtainMessage();
						handler.sendMessage(msg);
					}
				}).start();
			}
		} 
		
		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				adapter = new NoteAdapter(NoteService.this, list);
				lv.setAdapter(adapter);
				note = null;
				super.handleMessage(msg);
			}
		};

		refreshableView = (RefreshableView) findViewById(R.id.goods_refreshable_view);
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

	private List<Note> jxJSON(String result) {
		List<Note> ll = new ArrayList<Note>();
		if (result == null) {
			return null;
		}
		try {
			JSONArray jsonarr = new JSONArray(result);
			for (int i = 0; i < jsonarr.length(); i++) {
				JSONObject obj = jsonarr.getJSONObject(i);

				String note_title = obj.getString("note_title");
				String note_content = obj.getString("note_content");
				String note_time = obj.getString("note_time");
				byte[] note_picture = PageService.getImage(Constant.aURL
						+ obj.getString("note_picture"));
				Note sa = new Note(note_title, note_content, note_time,
						note_picture);
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
		String url = Constant.noteURL;
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
