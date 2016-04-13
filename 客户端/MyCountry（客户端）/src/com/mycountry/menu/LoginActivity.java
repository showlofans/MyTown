package com.mycountry.menu;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import com.example.menutab.R;
import com.mycountry.activity.MainActivity;
import com.mycountry.utils.Constant;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends Activity {
	private String username; // 保存用户名的变量
	private String userpwd; // 保存密码的变量
	private String result = ""; // 保存显示结果的变量
	private Handler handler; // 声明一个Handler对象

	// 定义项目链接

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		// 获取取消按扭
		ImageView back = (ImageView) findViewById(R.id.back_login);
		back.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}
		});// /btn2,取消按扭

		// 注册按钮跳转
		Button register = (Button) findViewById(R.id.login_register);
		register.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(LoginActivity.this,
						RegisterActivity.class);
				startActivity(intent);
			}
		});

		// 获取按扭
		Button btn = (Button) findViewById(R.id.login_login);
		btn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// 获取输入的用户名
				username = ((EditText) findViewById(R.id.login_username))
						.getText().toString();
				// 获取输入的密码
				userpwd = ((EditText) findViewById(R.id.login_password)).getText()
						.toString();

				// 创建一个新线程，实现用户登录
				new Thread(new Runnable() {
					public void run() {
						login(); // 用户登录
						Message m = handler.obtainMessage(); // 获取一个Message
						handler.sendMessage(m); // 发送消息
					}
				}).start(); // 开启线程
			}
		});// onclick

		handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (result != null) {
					Intent intent = getIntent(); // 获取Intent对象
					Bundle bundle = new Bundle(); // 实例化传递的数据包
					bundle.putString("username", username);
					bundle.putString("result", result);
					intent.putExtras(bundle); // 将数据包保存到intent中
					setResult(0x11, intent); // 设置返回的结果码，并返回调用该Activity的Activity
					finish(); // 关闭当前Activity
				}
				super.handleMessage(msg);
			}
		};// //handler
	}// /oncreate

	public void login() {
		String target = Constant.aURL + "/Login.jsp"; // 要提交的目标地址
		HttpPost httpRequest = new HttpPost(target); // 创建HttpPost对象
		// 将要传递的参数保存到List集合中
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("username", username)); // 用户名
		params.add(new BasicNameValuePair("userpwd", userpwd)); // 密码
		try {
			httpRequest.setEntity(new UrlEncodedFormEntity(params, "utf-8")); // 设置编码方式
			HttpResponse httpResponse = MainActivity.httpclient
					.execute(httpRequest); // 执行HttpClient请求
			if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) { // 如果请求成功
				result += EntityUtils.toString(httpResponse.getEntity()); // 获取返回的字符串
			} else {
				result = "请求失败！";
			}
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace(); // 输出异常信息
		} catch (ClientProtocolException e) {
			e.printStackTrace(); // 输出异常信息
		} catch (IOException e) {
			e.printStackTrace(); // 输出异常信息
		}
	}
}
