package com.mycountry.activity;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menutab.R;
import com.mycountry.adapter.PushAdapter;
import com.mycountry.details.PushDetail;
import com.mycountry.menu.LoginActivity;
import com.mycountry.menu.MessageActivity;
import com.mycountry.menu.SettingsActivity;
import com.mycountry.model.Push;
import com.mycountry.service.CollectService;
import com.mycountry.service.FruitService;
import com.mycountry.service.GanhuoService;
import com.mycountry.service.GreenSearch;
import com.mycountry.service.LiangyouService;
import com.mycountry.service.MeatService;
import com.mycountry.service.Push1Service;
import com.mycountry.service.Push2Service;
import com.mycountry.service.Push3Service;
import com.mycountry.service.Push4Service;
import com.mycountry.service.TechanService;
import com.mycountry.service.TourService;
import com.mycountry.service.UserService;
import com.mycountry.service.VegetableService;
import com.mycountry.service.WineService;
import com.mycountry.utils.Constant;
import com.mycountry.utils.NetUtils;
import com.mycountry.utils.PageService;
import com.mycountry.utils.RefreshableView;
import com.mycountry.utils.RefreshableView.PullToRefreshListener;
import com.mycountry.utils.Util;
import com.mycountry.utils.ZoomBitmap;
import com.slidingmenu.lib.SlidingMenu;

public class HomepageActivity extends Activity implements OnClickListener {

	private Context context;
	private ImageView menubtn, headimg;
	private ImageButton baidumap;
	private SlidingMenu menu;
	private EditText search;
	private TextView tour, techan, vegetable, meat, ganhuo, fruit, liangyou,
			wine, push1, push2, push3, push4;
	private ListView lv;
	private List<Push> list;
	private Handler handler;
	private PushAdapter adapter;
	public String x;
	ListView listview;
	private LinearLayout ll, pll;
	private TextView headname;
	private String headnametv;
	private RefreshableView refreshableView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		KeyBoardCancle();
		context = this;
		menu = new SlidingMenu(this);
		menu.setMode(SlidingMenu.LEFT);
		menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		menu.setShadowWidthRes(R.dimen.shadow_width);
		menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		menu.setFadeDegree(0.35f);
		menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		View view = LayoutInflater.from(this).inflate(R.layout.menu_item, null);
		menu.setMenu(view);
		menubtn = (ImageView) findViewById(R.id.menu);
		search = (EditText) findViewById(R.id.edt_search_homepage);
		baidumap = (ImageButton) findViewById(R.id.location);
		menubtn.setOnClickListener(this);
		lv = (ListView) findViewById(R.id.lvPush);// 找到listview
		// LayoutInflater inflater = getLayoutInflater();
		// View view2 = inflater.inflate(R.layout.header_view, null);
		// lv.addHeaderView(view2);
		tour = (TextView) findViewById(R.id.tv_tour);
		techan = (TextView) findViewById(R.id.tv_techan);
		vegetable = (TextView) findViewById(R.id.tv_vegetable);
		meat = (TextView) findViewById(R.id.tv_meat);
		ganhuo = (TextView) findViewById(R.id.tv_ganhuo);
		fruit = (TextView) findViewById(R.id.tv_fruit);
		liangyou = (TextView) findViewById(R.id.tv_liangyou);
		wine = (TextView) findViewById(R.id.tv_wine);
		push1 = (TextView) findViewById(R.id.tv_push1);
		push2 = (TextView) findViewById(R.id.tv_push2);
		push3 = (TextView) findViewById(R.id.tv_push3);
		push4 = (TextView) findViewById(R.id.tv_push4);

		headimg = (ImageView) view.findViewById(R.id.headImage);
		headname = (TextView) view.findViewById(R.id.headname);
		headnametv = headname.getText().toString();

		final String str = Environment.getExternalStorageDirectory()
				+ "/image.jpg";
		File mFile = new File(str);
		if (mFile.exists()) {
			Bitmap bitmap2 = BitmapFactory.decodeFile(str);
			Bitmap smallBitmap = ZoomBitmap.zoomImage(bitmap2,
					bitmap2.getWidth() / 2, bitmap2.getHeight() / 2);
			headimg.setImageBitmap(Util.toRoundBitmap(this, smallBitmap));
		} else {
			// Toast.makeText(HomepageActivity.this,
			// getResources().getString(R.string.toast_isfile),
			// Toast.LENGTH_LONG).show();
		}
		// 搜索
		search.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(HomepageActivity.this,
						GreenSearch.class);
				startActivity(intent);
			}
		});
		// 百度地图

		baidumap.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						FruitService.class);
				startActivity(intent);
			}
		});

		// 旅游
		tour.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						TourService.class);
				startActivity(intent);
			}
		});

		// 特产
		techan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						TechanService.class);
				startActivity(intent);
			}
		});
		// 蔬菜
		vegetable.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						VegetableService.class);
				startActivity(intent);

			}
		});
		// 肉类
		meat.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						MeatService.class);
				startActivity(intent);

			}
		});
		// 干货
		ganhuo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						GanhuoService.class);
				startActivity(intent);

			}
		});
		// 水果
		fruit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						FruitService.class);
				startActivity(intent);

			}
		});
		// 粮油
		liangyou.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						LiangyouService.class);
				startActivity(intent);

			}
		});
		// 酒
		wine.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						WineService.class);
				startActivity(intent);

			}
		});

		push1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						Push1Service.class);
				startActivity(intent);

			}
		});
		push2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						Push2Service.class);
				startActivity(intent);

			}
		});
		push3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						Push3Service.class);
				startActivity(intent);

			}
		});
		push4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						Push4Service.class);
				startActivity(intent);

			}
		});

		LinearLayout imagepic = (LinearLayout) findViewById(R.id.headlayout);
		imagepic.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						UserService.class);
				// intent.putExtra("image", str);
				// intent.putExtra("name", headnametv);
				startActivity(intent);

				// startActivityForResult(intent, 0);
			}
		});

		// 消息按钮监听事件
		Button notice = (Button) findViewById(R.id.btn_notice);
		notice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						MessageActivity.class);
				startActivity(intent);

			}
		});
		// 收藏按钮监听事件
		Button collect = (Button) findViewById(R.id.btn_collect);
		collect.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(HomepageActivity.this,
						CollectService.class);
				startActivity(intent);

			}
		});
		// 登录按钮跳转
		Button login = (Button) findViewById(R.id.menu_login);
		login.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						LoginActivity.class);
				startActivity(intent);

			}
		});

		// 注册按钮跳转
		Button register = (Button) findViewById(R.id.menu_register);
		register.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						SMSActivity.class);
				startActivity(intent);

			}
		});
		// 设置按钮跳转
		Button settings = (Button) findViewById(R.id.btn_settings);
		settings.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(HomepageActivity.this,
						SettingsActivity.class);
				startActivity(intent);

			}
		});

		// 璁剧疆閫夐」琚崟鍑荤殑鐩戝惉鍣?
		lv.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(HomepageActivity.this,
						PushDetail.class);
				intent.putExtra("push", adapter.getItem(position));
				startActivity(intent);

			}
		});

		list = new ArrayList<Push>();
		if (NetUtils.isNetworkConnected(HomepageActivity.this)) {
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
				adapter = new PushAdapter(HomepageActivity.this, list);
				lv.setAdapter(adapter);
				super.handleMessage(msg);
			}
		};
		refreshableView = (RefreshableView) findViewById(R.id.refreshable_view_push);
		refreshableView.setOnRefreshListener(new PullToRefreshListener() {
			@Override
			public void onRefresh() {
				// Thread.sleep(3000);
				new Thread(new Runnable() {
					public void run() {
						Log.i("run(", " 叱炭 始");
						x = send();// 氐 址
						list = jxJSON(x);
						Message msg = handler.obtainMessage();
						handler.sendMessage(msg);
					}
				}).start();
				refreshableView.finishRefreshing();
			}
		}, 0);
	}

	/*
	 * @Override protected void onActivityResult(int requestCode, int
	 * resultCode, Intent data) { switch (requestCode) { //
	 * resultCode娑撳搫娲栨导鐘垫畱閺嶅洩顔囬敍灞惧灉閸λ欐稉顓炴礀娴肩姷娈戦弰鐤狤SULT_OK case 0: TextView
	 * headname = (TextView) findViewById(R.id.headname); headnametv =
	 * data.getStringExtra("headname");
	 * 
	 * Bundle b = data.getExtras(); // data濞戞挾鐦斿☉鎿冨幖濞叉牗瀵奸悩鍨暠Intent String
	 * String str = b.getString("photo");// str闁告鍘栫拹鐔煎炊閻愭壆鐐婇柣銊ュ閿熸枻鎷?Hello, //
	 * this is B speaking" headname.setText(headnametv); break; default: break;
	 * 
	 * } }
	 */
	private long mExitTime;

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (menu.isMenuShowing() || menu.isSecondaryMenuShowing()) {
				menu.showContent();
			} else {
				if ((System.currentTimeMillis() - mExitTime) > 2000) {
					Toast.makeText(this, "�ٰ�һ���˳�", Toast.LENGTH_SHORT)
							.show();
					mExitTime = System.currentTimeMillis();
				} else {
					finish();
				}
			}
			return true;
		}
		// ����MENU��ť����¼����������κβ���
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			menu.toggle();
			return false;
		}
		return super.onKeyDown(keyCode, event);
	}

	private List<Push> jxJSON(String result) {
		List<Push> ll = new ArrayList<Push>();
		if (result == null) {
			return null;
		}
		try {
			JSONArray jsonarr = new JSONArray(result);
			for (int i = 0; i < jsonarr.length(); i++) {
				JSONObject obj = jsonarr.getJSONObject(i);
				String push_title = obj.getString("push_title");
				String push_sales = obj.getString("push_sales");
				String push_price = obj.getString("push_price");
				String push_distance = obj.getString("push_distance");
				byte[] pic = PageService.getImage(Constant.aURL
						+ obj.getString("push_picture"));
				Push sa = new Push(push_title, push_price, push_sales,
						push_distance, pic);
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
		String url = Constant.pushURL;
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost request = new HttpPost(url);
		Log.i("send(", "try澶栭潰");
		HttpResponse response;
		try {
			Log.i("send(", "鎵ц璇锋眰1");
			response = httpclient.execute(request);
			Log.i("response", response.toString());
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				str = EntityUtils.toString(response.getEntity()).trim();
				Log.i("send(", str);
				return str;
			} else {
				str = "璇锋眰澶辫触";
				Log.i("send(", "璇锋眰澶辫触");
				return str;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;

	}

	/**
	 * 关闭软键盘方法
	 * */

	public void KeyBoardCancle() {
		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN
						| WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//		View view = getWindow().peekDecorView();
//		if (view != null) {
//			InputMethodManager inputmanger = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
//			inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
//		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			Toast.makeText(context, "锟斤拷锟斤拷1", 1).show();
			break;
		case R.id.button2:
			Toast.makeText(context, "锟斤拷锟斤拷2", 1).show();
			break;
		case R.id.menu:
			menu.toggle();
			break;
		}
	}
}
