package com.mycountry.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menutab.R;
import com.mycountry.menu.LoginActivity;
import com.mycountry.service.GreenSearch;
import com.thinkland.sdk.sms.SMSCaptcha;
import com.thinkland.sdk.util.BaseData.ResultCallBack;

public class SMSActivity extends BaseActivity implements OnClickListener,
		TextWatcher {

	private EditText etPhoneNum;
	private TextView tvCountryNum;
	private ImageView ivClear;
	private Button btnNext;
	private Button btnLogin;
	private Button btnBack;
	private SMSCaptcha captcha;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_register);
		captcha = SMSCaptcha.getInstance();
		initView();
	}

	private void initView() {
		TextView tv = (TextView) findViewById(R.id.tv_title);
		tv.setText(R.string.smssdk_regist);

		btnNext = (Button) findViewById(R.id.btn_next);
		tvCountryNum = (TextView) findViewById(R.id.tv_country_num);
		ivClear = (ImageView) findViewById(R.id.iv_clear);
		etPhoneNum = (EditText) findViewById(R.id.et_write_phone);
		btnBack = (Button) findViewById(R.id.sms_back);
		
		btnLogin = (Button) findViewById(R.id.sms_login);
		etPhoneNum.addTextChangedListener(this);
		etPhoneNum.setText("");
		etPhoneNum.requestFocus();
		if (etPhoneNum.getText().length() > 0) {
			btnNext.setEnabled(true);
			ivClear.setVisibility(View.VISIBLE);
			btnNext.setBackgroundResource(R.drawable.smssdk_btn_enable);
		}
		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		btnLogin.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SMSActivity.this,
						LoginActivity.class);
				startActivity(intent);
			}
		});
		btnNext.setOnClickListener(this);
		ivClear.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.btn_next:
			String phone = etPhoneNum.getText().toString().trim()
					.replaceAll("\\s*", "");
			String code = tvCountryNum.getText().toString().trim();
			checkPhoneNum(phone, code);
			break;
		case R.id.iv_clear:
			etPhoneNum.getText().clear();
			break;
		default:
			break;
		}

	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		if (s.length() > 0) {
			btnNext.setEnabled(true);
			ivClear.setVisibility(View.VISIBLE);
			btnNext.setBackgroundResource(R.drawable.smssdk_btn_enable);
		} else {
			btnNext.setEnabled(false);
			ivClear.setVisibility(View.GONE);
			btnNext.setBackgroundResource(R.drawable.smssdk_btn_disenable);
		}
	}

	@Override
	public void afterTextChanged(Editable s) {
		// TODO Auto-generated method stub

	}

	private void checkPhoneNum(String phone, String code) {

		if (TextUtils.isEmpty(phone)) {
			Toast.makeText(this, R.string.smssdk_write_mobile_phone,
					Toast.LENGTH_SHORT).show();
			return;
		}

		showDialog(phone, code);

	}

	public void showDialog(final String phone, String code) {
		String phoneNum = code + " " + splitPhoneNum(phone);
		String strContent = getResources().getString(
				R.string.smssdk_make_sure_mobile_detail)
				+ phoneNum;
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

		builder.setTitle("我的村")
				.setIcon(R.drawable.icon_50)
				.setCancelable(false)
				.setMessage(strContent)
				.setPositiveButton(R.string.smssdk_ok,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								showDialog(getResources()
										.getString(
												R.string.smssdk_get_verification_code_content));
								captcha.sendCaptcha(phone,
										new ResultCallBack() {

											@Override
											public void onResult(int arg0,
													String arg1, String arg2) {
												// TODO Auto-generated method
												// stub
												closeDialog();
												if (arg0 == 0) {
													afterCaptchaRequested();
												}

											}
										});

							}
						})
				.setNegativeButton(R.string.smssdk_cancel,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								dialog.dismiss();
							}
						});

		AlertDialog dlg = builder.create();
		dlg.show();

	}

	private void afterCaptchaRequested() {
		String phone = etPhoneNum.getText().toString().trim()
				.replaceAll("\\s*", "");
		String code = tvCountryNum.getText().toString().trim();
		String fomatedPhone = code + " " + splitPhoneNum(phone);

		Toast.makeText(this, "�ɹ�!", Toast.LENGTH_SHORT).show();
		Intent intent = new Intent(SMSActivity.this, CaptchaActivity.class);
		intent.putExtra("formatedPhone", fomatedPhone);
		intent.putExtra("phone", phone);
		startActivity(intent);
	}

	private String splitPhoneNum(String phone) {
		StringBuilder builder = new StringBuilder(phone);
		builder.reverse();
		for (int i = 4, len = builder.length(); i < len; i += 5) {
			builder.insert(i, ' ');
		}

		builder.reverse();
		return builder.toString();

	}
}
