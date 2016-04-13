package com.mycountry.menu;

import java.util.HashMap;
import java.util.Map;
import com.example.menutab.R;
import com.mycountry.utils.Constant;
import com.mycountry.utils.HttpUploadUtil;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

public class RegisterActivity extends Activity {
	Handler hd;
	private String name = "";
	private String email = "";
	private String password = "";
	private String passwordRe = "";
	private String type = ""; // 用户类别

	final String url = Constant.aURL + "/register.jsp";

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);

		Button btn2 = (Button) findViewById(R.id.register_cancel);
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});// btn2
			// 返回按钮跳转
		ImageView cancle = (ImageView) findViewById(R.id.back_register);
		cancle.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});// 返回按扭
		
		Button btn = (Button) findViewById(R.id.btn_register);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// 准备URL

				// 获取用户名
				final EditText nameET = (EditText) findViewById(R.id.register_username);
				name = nameET.getText().toString();
				// 获取邮箱
				/*
				 * final EditText email = (EditText) findViewById(R.id.email);
				 * name = nameET.getText().toString();
				 */
				// 获取密码
				final EditText passwordET = (EditText) findViewById(R.id.register_password);
				password = passwordET.getText().toString();
				// 确认密码
				final EditText passwordREET = (EditText) findViewById(R.id.register_repassword);
				passwordRe = passwordREET.getText().toString();

				// 获取类别
				type = "普通用户";
				RadioButton rbman = (RadioButton) findViewById(R.id.register_normal);
				if (rbman.isChecked()) {
					type = "管理员";
				}

				// /验证数据有效性

				if (name.matches("")) {
					Toast.makeText(RegisterActivity.this, "请输入用户名",
							Toast.LENGTH_SHORT).show();

					// else if(!(name.matches("^[a-zA-Z][a-zA-Z0-9_]{5,9}$")) )
					// {
					// Toast.makeText(AddWorker.this,"用户名长度为6到10字节，允许数字下划线",
					// Toast.LENGTH_SHORT).show();
					// }
				} else if (password.matches("")) {
					Toast.makeText(RegisterActivity.this, "请输入密码",
							Toast.LENGTH_SHORT).show();
				} else if (password.length() < 6) {
					Toast.makeText(RegisterActivity.this, "密码长度不能小于6",
							Toast.LENGTH_SHORT).show();
				} else if (passwordRe.matches("")) {
					Toast.makeText(RegisterActivity.this, "请再次输入密码",
							Toast.LENGTH_SHORT).show();
				} else if (!password.trim().equals(passwordRe.trim())) {
					Toast.makeText(RegisterActivity.this, "密码输入不一致，请重新输入",
							Toast.LENGTH_SHORT).show();
				}
				// else if(phonenumber.matches(""))
				// {
				// Toast.makeText(AddWorker.this, "请输入手机号码",
				// Toast.LENGTH_SHORT).show();
				// }
				// else if(!phonenumber.matches("^1[3,5]{1}[0-9]{1}[0-9]{8}$"))
				// {
				// Toast.makeText(AddWorker.this, "手机号码格式不正确",
				// Toast.LENGTH_SHORT).show();
				// }

				/*
				 * else if(email.matches("")) {
				 * Toast.makeText(RegisterActivity.this, "请输入邮箱",
				 * Toast.LENGTH_SHORT).show(); } else if(!email.matches(
				 * "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$"
				 * )) { Toast.makeText(RegisterActivity.this, "邮箱格式不正确",
				 * Toast.LENGTH_SHORT).show(); }
				 */
				else {// /否则满足条件
						// 准备参数列表
					final Map<String, String> params = new HashMap<String, String>();
					// 传递用户名
					params.put("name", name);
					// 传递邮箱号
					// params.put("email", email);
					// 传递密码
					params.put("password", password);

					// 传递性别
					params.put("type", type);

					// System.out.println("name="+name+"sex="+sex);

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

							// addworker(); //
							// Message m = hd.obtainMessage(); // 获取一个Message
							// hd.sendMessage(m); // 发送消息

						} // run

					}.start();// thread

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
				Toast.makeText(RegisterActivity.this, msgStr,
						Toast.LENGTH_SHORT).show();

				// finish();

				// if (result != null) {
				// Toast.makeText(AddWorker.this, result,
				// Toast.LENGTH_SHORT).show();
				// finish(); // 关闭当前Activity
				// }

			}
		};// //handler

	}// /onCreate 

	// public void addworker() {
	// String target =url; // 要提交的目标地址
	// HttpPost httpRequest = new HttpPost(target); // 创建HttpPost对象
	// // 将要传递的参数保存到List集合中
	// List<NameValuePair> params = new ArrayList<NameValuePair>();
	// params.add(new BasicNameValuePair("name", name)); // 用户名
	// params.add(new BasicNameValuePair("password", password)); // 密码
	// params.add(new BasicNameValuePair("phonenumber", phonenumber)); // 电话号码
	// params.add(new BasicNameValuePair("email", email)); // 邮箱
	// params.add(new BasicNameValuePair("sex", sex)); // 性别
	//
	// try {
	// httpRequest.setEntity(new UrlEncodedFormEntity(params, "utf-8")); //
	// 设置编码方式
	// HttpResponse httpResponse = MainActivity.httpclient.execute(httpRequest);
	// // 执行HttpClient请求
	// if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
	// // 如果请求成功
	// result += EntityUtils.toString(httpResponse.getEntity()); // 获取返回的字符串
	// } else {
	// result = "请求失败！";
	// }
	// } catch (UnsupportedEncodingException e1) {
	// e1.printStackTrace(); // 输出异常信息
	// } catch (ClientProtocolException e) {
	// e.printStackTrace(); // 输出异常信息
	// } catch (IOException e) {
	// e.printStackTrace(); // 输出异常信息
	// }
	// }

}
