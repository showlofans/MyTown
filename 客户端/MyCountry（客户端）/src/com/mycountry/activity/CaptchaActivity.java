package com.mycountry.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.menutab.R;
import com.mycountry.menu.LoginActivity;
import com.thinkland.sdk.sms.SMSCaptcha;
import com.thinkland.sdk.util.BaseData.ResultCallBack;

public class CaptchaActivity extends BaseActivity implements OnClickListener,
		TextWatcher {

	private final String tag = "CaptchaActivity";
	private static final int RETRY_INTERVAL = 60;
	private String phone;
	private String formatedPhone;
	private int time = RETRY_INTERVAL;

	private EditText etIdentifyNum;
	private TextView tvTitle;
	private TextView tvPhone;
	private TextView tvIdentifyNotify;
	private TextView tvUnreceiveIdentify;
	private ImageView ivClear;
	private Button btnSubmit;
	private Button btnLogin;
	private Button btnBack;
	private SMSCaptcha smsCaptcha;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_captcha);
		smsCaptcha = SMSCaptcha.getInstance();
		Intent intent = getIntent();
		this.formatedPhone = intent.getStringExtra("formatedPhone");
		this.phone = intent.getStringExtra("phone");

		btnSubmit = (Button) this.findViewById(R.id.btn_submit);
		btnSubmit.setOnClickListener(this);
		btnSubmit.setEnabled(false);

		btnLogin = (Button) findViewById(R.id.sms_login);
		btnBack = (Button) findViewById(R.id.sms_back);

		tvTitle = (TextView) this.findViewById(R.id.tv_title);
		tvTitle.setText(R.string.smssdk_write_identify_code);

		etIdentifyNum = (EditText) findViewById(R.id.et_put_identify);
		etIdentifyNum.addTextChangedListener(this);

		tvIdentifyNotify = (TextView) findViewById(R.id.tv_identify_notify);
		String text = getResources().getString(
				R.string.smssdk_send_mobile_detail);
		tvIdentifyNotify.setText(Html.fromHtml(text));

		tvPhone = (TextView) findViewById(R.id.tv_phone);
		tvPhone.setText(formatedPhone);

		tvUnreceiveIdentify = (TextView) findViewById(R.id.tv_unreceive_identify);
		String unReceive = getResources().getString(
				R.string.smssdk_receive_msg, time);
		tvUnreceiveIdentify.setText(Html.fromHtml(unReceive));

		tvUnreceiveIdentify.setOnClickListener(this);
		tvUnreceiveIdentify.setEnabled(false);

		ivClear = (ImageView) findViewById(R.id.iv_clear);
		ivClear.setOnClickListener(this);

		countDown();
	}

	private void countDown() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (time-- > 0) {
					String unReceive = CaptchaActivity.this.getResources()
							.getString(R.string.smssdk_receive_msg, time);
					updateTvUnreceive(unReceive);
					Log.i("time is about ", unReceive);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				String unReceive = getResources().getString(
						R.string.smssdk_unreceive_identify_code, time);
				updateTvUnreceive(unReceive);
				time = RETRY_INTERVAL;
			}
		}).start();
	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		if (s.length() > 0) {
			btnSubmit.setEnabled(true);
			ivClear.setVisibility(View.VISIBLE);
			btnSubmit.setBackgroundResource(R.drawable.smssdk_btn_enable);
		} else {
			btnSubmit.setEnabled(false);
			ivClear.setVisibility(View.GONE);
			btnSubmit.setBackgroundResource(R.drawable.smssdk_btn_disenable);
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {

	}

	@Override
	public void afterTextChanged(Editable s) {

	}

	@Override
	public void onClick(View v) {
		
		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});

		btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(CaptchaActivity.this,
						LoginActivity.class);
				startActivity(intent);
			}
		});

	
		int id = v.getId();

		if (id == R.id.btn_submit) {
			//
			showDialog();
			String captcha = etIdentifyNum.getText().toString().trim();
			smsCaptcha.commitCaptcha(phone, captcha, new ResultCallBack() {

				@Override
				public void onResult(int code, String reason, String result) {
					closeDialog();
					Log.v(tag, "code:" + code + ";reason:" + reason);
					showToast(reason);
					if (code == 0) {
						finish();
					}

				}
			});

		} else if (id == R.id.tv_unreceive_identify) {
			//
			showDialog();
		} else if (id == R.id.iv_clear) {
			//
			etIdentifyNum.getText().clear();
		}

	}

	//
	private void showDialog() {
		String strContent = getResources().getString(
				R.string.smssdk_resend_identify_code);
		AlertDialog.Builder builder = new AlertDialog.Builder(
				CaptchaActivity.this);
		builder.setTitle("SMSSDK Demo")
				.setIcon(R.drawable.ic_launcher)
				.setCancelable(false)
				.setMessage(strContent)
				.setPositiveButton(R.string.smssdk_ok,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								showDialog(getResources()
										.getString(
												R.string.smssdk_get_verification_code_content));

								smsCaptcha.sendCaptcha(phone.trim(),
										new ResultCallBack() {

											@Override
											public void onResult(int code,
													String reason, String result) {
												// stub
												closeDialog();
												Log.v(tag, "code:" + code
														+ ";reason:" + reason);
											}
										});
							}
						})
				.setNegativeButton(R.string.smssdk_back,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();
								finish();
							}
						});
	}

	private void showNotifyDialog() {
		String strContent = this.getResources().getString(
				R.string.smssdk_close_identify_page_dialog);
		AlertDialog.Builder builder = new AlertDialog.Builder(
				CaptchaActivity.this);
		builder.setTitle("Captcha Demo")
				.setIcon(R.drawable.ic_launcher)
				.setCancelable(false)
				.setMessage(strContent)
				.setPositiveButton(R.string.smssdk_wait,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();
							}
						})
				.setNegativeButton(R.string.smssdk_back,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								dialog.dismiss();
								finish();
							}
						});
		builder.create().show();
	}

	@Override
	public void onBackPressed() {

		showNotifyDialog();
	}

	private void updateTvUnreceive(final String unReceive) {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				tvUnreceiveIdentify.setText(Html.fromHtml(unReceive));
				tvUnreceiveIdentify.setEnabled(false);
			}
		});
	}

}
