package com.mycountry.activity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menutab.R;
import com.mycountry.pic.FileUtils;
import com.mycountry.pic.PhotoActivity;
import com.mycountry.pic.TestPicActivity;
import com.mycountry.utils.Bimp;
import com.mycountry.utils.Constant;
import com.mycountry.utils.File2StringUtil;
import com.mycountry.utils.HttpUploadUtil;

public class AddFruit extends Activity {
	Handler hd;
	private String fruit_titles;
	private String fruit_content;
	private String fruit_price, fruit_type, fruit_sales;
	private String result = "";
	final String url = Constant.addfruitURL;
	private String path = "";
	private String name_edit;
	private EditText fruit_typeE, fruit_salesE, fruit_titlesE, fruit_contentE,
			fruit_priceE;

	private static final String TAG = "AddFruit";// 定义当前标签
	private GridAdapter adapter;
	String fruit_picture = "";// 发送图片的string字符串
	File[] fileArray = null;
	TextView send;
	private TextView tv_edit;
	private String fileName = "/MyCountry";
	// private File file;
	// ��ʾͼƬ
	private GridView image;
	private Button up, cancel, menu;
	// ���߳�ͨ��
	private Handler myHandler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_fruit);
		initViews();
		name_edit = getIntent().getStringExtra("fromtype");
		tv_edit.setText(name_edit);
		//image.setSelector(new ColorDrawable(Color.TRANSPARENT));
		adapter = new GridAdapter(this);
		adapter.update();
		image.setAdapter(adapter);
		image.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// 关闭软键盘
				KeyBoardCancle();
				if (arg2 == Bimp.bmp.size()) {
					new PopupWindows(AddFruit.this, image);
				} else {
					Intent intent = new Intent(AddFruit.this,
							PhotoActivity.class);
					intent.putExtra("ID", arg2);
					startActivity(intent);
				}
			}
		});

		/**
		 * 在sd卡上创建文件夹
		 */

		if (Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState())) {
			File sdPath = Environment.getExternalStorageDirectory();
			path = sdPath.getPath() + fileName;
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
				// Log.i(TAG, fileName + "文件夹已创建");
			}
		}
		
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		up.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				fruit_titles = fruit_titlesE.getText().toString();
				fruit_content = fruit_contentE.getText().toString();
				fruit_sales = fruit_salesE.getText().toString();
				fruit_type = fruit_typeE.getText().toString();
				fruit_price = fruit_priceE.getText().toString();
				if (fruit_titles.matches("")) {
					Toast.makeText(AddFruit.this, "标题不能为空", Toast.LENGTH_SHORT)
							.show();
				} else if (fruit_content.matches("")) {
					Toast.makeText(AddFruit.this, "产品介绍不能为空", Toast.LENGTH_SHORT)
							.show();
				} else if (fruit_sales.matches("")) {
					Toast.makeText(AddFruit.this, "产品单价不能为空", Toast.LENGTH_SHORT)
							.show();
				} else if (fruit_type.matches("")) {
					Toast.makeText(AddFruit.this, "剩余库存不能为空", Toast.LENGTH_SHORT)
							.show();
				} else if (fruit_price.matches("")) {
					Toast.makeText(AddFruit.this, "产品编号不能为空", Toast.LENGTH_SHORT)
							.show();
				}

				else {// /否则满足条件
					File file = new File("/mnt/sdcard/MyCountry");
					// 准备参数列表
					final Map<String, String> params = new HashMap<String, String>();
					if (file.isDirectory()) {
						fileArray = file.listFiles();

						if (null == fileArray || 0 == fileArray.length) {
							// Log.i(TAG, fileName + "文件夹已创建");

						}
						if (null != fileArray) {
							
							String picfile = File2StringUtil
									.file2String("/mnt/sdcard/MyCountry/"
											+ fileArray[0].getName());
							fruit_picture = picfile;
							params.put("fruit_picture", fruit_picture);
						}
					}
					
					params.put("fromtype", name_edit);
					
					// fruit_type,
					// fcountry_name,fruit_titles,fruit_content,fruit_price;
					// 传递用户名
					params.put("fruit_type", fruit_type);
					params.put("fruit_type", fruit_type);
					// 传递密码
					params.put("fruit_sales", fruit_sales);

					params.put("fruit_titles", fruit_titles);
					// 传递密码
					params.put("fruit_content", fruit_content);

					params.put("fruit_price", fruit_price);

					new Thread() {
						public void run() {
							String msgStr = HttpUploadUtil.postWithoutFile(url,
									params);
							Bundle b = new Bundle();
							// 将内容字符串放进数据Bundle中
							b.putString("msg", msgStr);
							// 、创建消息对象
							Message msg = new Message();
							// 设置数据Bundle到消息中
							msg.setData(b);
							// 设置消息标识
							msg.what = Constant.ADDWORKER;
							// 发送消息
							hd.sendMessage(msg);

						} // run

					}.start();// thread
					
					/**
					 * 转换照片格式
					 * */
					/*
							*//**
					 * 线程发送信息
					 * */
					/*
					 * new Thread(new Runnable() { public void run() { upload();
					 * // 发送报警信息
					 * 
					 * Message m = myHandler.obtainMessage(); // 获取一个Message
					 * myHandler.sendMessage(m); // 发送消息 } }).start(); // 开启线程
					 * myHandler = new Handler() {
					 * 
					 * @Override public void handleMessage(Message msg) {
					 * Log.i("2", result); super.handleMessage(msg); if
					 * (result.equals(null) || result.equals("")) {
					 * Toast.makeText(AddNote.this, "请检查您的网络",
					 * Toast.LENGTH_SHORT).show(); } if
					 * (result.equals("success")) { Toast.makeText(AddNote.this,
					 * "发表成功", Toast.LENGTH_SHORT).show(); } } }; }// 判断是否有照片终止
					 * // 点击事件终止
					 * 
					 * }
					 */

				}// /if

			}
		});// ///onclick

		hd = new Handler() {
			@Override
			public void handleMessage(Message msg) {

				super.handleMessage(msg);
				Bundle b;
				b = msg.getData();// 获取消息中的数据
				String msgStr = b.getString("msg");// 获取内容字符串
				if(msgStr.equals("发表成功!!")){
					FileUtils.deleteDir();
					AddFruit.this.finish();
				}
				Toast.makeText(AddFruit.this, msgStr, Toast.LENGTH_SHORT)
				.show();

			}
		};// //handler

	}// /onCreate

	public class PopupWindows extends PopupWindow {

		public PopupWindows(Context mContext, View parent) {

			View view = View
					.inflate(mContext, R.layout.item_popupwindows, null);
			view.startAnimation(AnimationUtils.loadAnimation(mContext,
					R.anim.fade_ins));
			LinearLayout ll_popup = (LinearLayout) view
					.findViewById(R.id.ll_popup);
			ll_popup.startAnimation(AnimationUtils.loadAnimation(mContext,
					R.anim.push_bottom_in_2));

			setWidth(LayoutParams.FILL_PARENT);
			setHeight(LayoutParams.FILL_PARENT);
			setBackgroundDrawable(new BitmapDrawable());
			setFocusable(true);
			setOutsideTouchable(true);
			setContentView(view);
			showAtLocation(parent, Gravity.BOTTOM, 0, 0);
			update();

			Button bt1 = (Button) view
					.findViewById(R.id.item_popupwindows_camera);
			Button bt2 = (Button) view
					.findViewById(R.id.item_popupwindows_Photo);
			Button bt3 = (Button) view
					.findViewById(R.id.item_popupwindows_cancel);
			bt1.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					photo();
					dismiss();
				}
			});
			bt2.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					Intent intent = new Intent(AddFruit.this,
							TestPicActivity.class);
					startActivity(intent);
					dismiss();
				}
			});
			bt3.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					dismiss();
				}
			});

		}
	}

	/**
	 * 关闭软键盘方法
	 * */
	public void KeyBoardCancle() {
		View view = getWindow().peekDecorView();
		if (view != null) {
			InputMethodManager inputmanger = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
			inputmanger.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}

	@SuppressLint("HandlerLeak")
	public class GridAdapter extends BaseAdapter {
		private LayoutInflater inflater; // 视图容器
		private int selectedPosition = -1;// 选中的位置
		private boolean shape;

		public boolean isShape() {
			return shape;
		}

		public void setShape(boolean shape) {
			this.shape = shape;
		}

		public GridAdapter(Context context) {
			inflater = LayoutInflater.from(context);
		}

		public void update() {
			loading();
		}

		public int getCount() {
			return (Bimp.bmp.size() + 1);
		}

		public Object getItem(int arg0) {

			return null;
		}

		public long getItemId(int arg0) {

			return 0;
		}

		public void setSelectedPosition(int position) {
			selectedPosition = position;
		}

		public int getSelectedPosition() {
			return selectedPosition;
		}

		/**
		 * ListView Item设置
		 */
		public View getView(int position, View convertView, ViewGroup parent) {
			ViewHolder holder = null;
			if (convertView == null) {

				convertView = inflater.inflate(R.layout.item_published_grida,
						parent, false);
				holder = new ViewHolder();
				holder.image = (ImageView) convertView
						.findViewById(R.id.item_grida_image);
				convertView.setTag(holder);
			} else {
				holder = (ViewHolder) convertView.getTag();
			}

			if (position == Bimp.bmp.size()) {
				holder.image.setImageBitmap(BitmapFactory.decodeResource(
						getResources(), R.drawable.icon_addpic_unfocused));
				if (position == 6) {
					holder.image.setVisibility(View.VISIBLE);
					Toast.makeText(AddFruit.this,
							"您已经选好了图片\n请点击以下选好的的图片\n进行删除重选", 3000).show();
				}
			} else {
				holder.image.setImageBitmap(Bimp.bmp.get(position));
			}

			return convertView;
		}

		public class ViewHolder {
			public ImageView image;
		}

		Handler handler = new Handler() {
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 1:
					adapter.notifyDataSetChanged();
					break;
				}
				super.handleMessage(msg);
			}
		};

		public void loading() {
			new Thread(new Runnable() {
				public void run() {
					while (true) {
						if (Bimp.max == Bimp.drr.size()) {
							Message message = new Message();
							message.what = 1;
							handler.sendMessage(message);
							break;
						} else {
							try {
								String path = Bimp.drr.get(Bimp.max);
								System.out.println(path);
								Bitmap bm = Bimp.revitionImageSize(path);
								Bimp.bmp.add(bm);
								String newStr = path.substring(
										path.lastIndexOf("/") + 1,
										path.lastIndexOf("."));
								FileUtils.saveBitmap(bm, "" + newStr);
								Bimp.max += 1;
								Message message = new Message();
								message.what = 1;
								handler.sendMessage(message);
							} catch (IOException e) {

								e.printStackTrace();
							}
						}
					}
				}
			}).start();
		}

	}

	public void photo() {
		Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		long currentTime = System.currentTimeMillis();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date(currentTime);
		File file = new File(path, formatter.format(date) + ".JPEG");
		path = file.getPath();
		Uri imageUri = Uri.fromFile(file);
		openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		startActivityForResult(openCameraIntent, 1);
	}

	/*
	 * public void onClick(View v) { switch (v.getId()) {
	 * 
	 * case R.id.cancle_edit: AddFruit.this.finish(); Bimp.bmp.clear();
	 * Bimp.drr.clear(); Bimp.max = 0; FileUtils.deleteDir(); break; case
	 * R.id.take_photo: photo(); break; case R.id.selete_image: Intent
	 * seleteintent = new Intent(AddFruit.this, TestPicActivity.class);
	 * startActivityForResult(seleteintent, 2); break; } }
	 */
	public String getString(String s) {
		String path = null;
		if (s == null)
			return "";
		for (int i = s.length() - 1; i > 0; i++) {
			s.charAt(i);
		}
		return path;
	}

	protected void onRestart() {
		adapter.update();
		super.onRestart();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {

		switch (requestCode) {
		case 1:
			if (Bimp.drr.size() < 6 && resultCode == -1) {
				Bimp.drr.add(path);
			}
			break;
		case 2:
			if (Bimp.drr.size() < 6 && resultCode == -1) {
				Bimp.drr.add(path);
			}
			break;
		}

	}

	protected String getAbsoluteImagePath(Uri uri) {
		String[] proj = { MediaStore.Images.Media.DATA };
		@SuppressWarnings("deprecation")
		Cursor cursor = managedQuery(uri, proj, null, null, null);

		int column_index = cursor
				.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}

	private void initViews() {
		up = (Button) this.findViewById(R.id.goods_pro);
		menu = (Button) this.findViewById(R.id.add_cancel);
		tv_edit = (TextView) this.findViewById(R.id.tv_title);
		image = (GridView) this.findViewById(R.id.fruit_grid);
		fruit_typeE = (EditText) findViewById(R.id.fruit_type);
		fruit_salesE = (EditText) findViewById(R.id.fcountry_name);
		fruit_titlesE = (EditText) findViewById(R.id.fruit_titles);
		fruit_contentE = (EditText) findViewById(R.id.fruit_content);
		fruit_priceE = (EditText) findViewById(R.id.fruit_price);
	}

	/*@Override
	public void onClick(View v) {

	}*/

}
