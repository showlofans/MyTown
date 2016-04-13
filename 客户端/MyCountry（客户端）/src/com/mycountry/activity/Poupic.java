/*package com.mycountry.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import com.example.menutab.R;

public class Poupic extends Activity implements OnClickListener {
	//private String path="";
	private Button mbut1,mbut2,mbut3,mbut4;
	private Uri imageUri;
	private ImageView img_take;
	private static final int TAKE_PHOTO = 1;
	private static final int CROP_PHOTO = 2;
	//public static final int RESULT_CODE = 3;
	//private String fileName="/MyCountryHead";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork() 
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
				.penaltyLog().penaltyDeath().build());
		setContentView(R.layout.activity_system);
		initviews();
		mbut1.setOnClickListener(this);
		mbut2.setOnClickListener(this);
		mbut3.setOnClickListener(this);
		mbut4.setOnClickListener(this);
		
		}
	private void initviews() {
		img_take=(ImageView)findViewById(R.id.img_activity);
		mbut1=(Button)findViewById(R.id.mbutton1);
		mbut2=(Button)findViewById(R.id.mbutton2);
		mbut3=(Button)findViewById(R.id.mbutton3);
		mbut4=(Button)findViewById(R.id.mbutton4);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.mbutton1:
			finish();
			break;
		case R.id.mbutton2:
			File outputImage = new File(Environment.getExternalStorageDirectory(),
					"output_image.jpg");
			try {
				if (outputImage.exists()) {
					outputImage.delete();
				}
				outputImage.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			imageUri = Uri.fromFile(outputImage);
			Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
			intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
			startActivityForResult(intent, TAKE_PHOTO);
			break;
		case R.id.mbutton3:
			File outputImage1 = new File(Environment.getExternalStorageDirectory(),
					"output_image.jpg");
			try {
				if (outputImage1.exists()) {
					outputImage1.delete();
				}
				outputImage1.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			imageUri = Uri.fromFile(outputImage1);
			Intent intent2 = new Intent("android.intent.action.GET_CONTENT");
			intent2.setType("image/*");
			intent2.putExtra("crop", true);
			intent2.putExtra("scale", true);
			intent2.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
			startActivityForResult(intent2, CROP_PHOTO);
			break;
		case R.id.mbutton4:

			break;
		default:
			break;
		}
		
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case TAKE_PHOTO:
			if (resultCode == RESULT_OK) {
				Intent intent = new Intent("com.android.camera.action.CROP");
				intent.setDataAndType(imageUri, "image/*");
				intent.putExtra("scale", true);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
				startActivityForResult(intent, CROP_PHOTO);
			}
			break;
		case CROP_PHOTO:
			if (resultCode == RESULT_OK) {
				Intent intent=new Intent();  
				Imagehello image=new Imagehello();
				image.setUri(imageUri);
	            intent.putExtra("back", "image");  
	            setResult(RESULT_CODE, intent);  
				try {
					Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
							.openInputStream(imageUri));
					img_take.setImageBitmap(bitmap);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			break;
		default:
			break;
		}
	}

}
*/