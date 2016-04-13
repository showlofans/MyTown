package com.mycountry.menu;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.menutab.R;
import com.mycountry.utils.Util;
import com.mycountry.utils.ZoomBitmap;

public class MeActivity extends Activity {
	private static final int PHOTO_WITH_DATA = 18;  //閿熸枻鎷稴D閿熸枻鎷烽敓鍙緱纰夋嫹鍥剧墖
	private static final int PHOTO_WITH_CAMERA = 37;// 閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷风墖
	private final static int REQUEST_CODE=1;  
	private int resultCode = 0;  
	//private EditText 
	private ImageView head_imageview,menu,save;
	private EditText et_headname;
	private String imgName = "";
	private String path="";
	private String headpath,headname;
	private Handler hd;
	//private Uri uripic;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork() 
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().detectLeakedClosableObjects()
				.penaltyLog().penaltyDeath().build());
		super.onCreate(savedInstanceState);
		setContentView(R.layout.me_edit);
		initViews();
		Intent mIntent=getIntent();
		et_headname.setText(mIntent.getStringExtra("name"));
		path=mIntent.getStringExtra("image");
		File mFile=new File(path);
        if (mFile.exists()) {
            Bitmap bitmap2=BitmapFactory.decodeFile(path);
            Bitmap smallBitmap = ZoomBitmap.zoomImage(bitmap2, bitmap2.getWidth() / 2, bitmap2.getHeight() / 2);
            head_imageview.setImageBitmap(Util.toRoundBitmap(this, smallBitmap));
        }else{
        	Toast.makeText(MeActivity.this, getResources().getString(R.string.toast_title), Toast.LENGTH_LONG).show();
        }
		
		save.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog();
				//Toast.makeText(MeActivity.this,  getResources().getString(R.string.toast_title), Toast.LENGTH_LONG).show();
			}
		});
		/*path=Environment.getExternalStorageDirectory()+"/image.jpg";
		File mFile=new File(path);
        //閿熸枻鎷烽敓鏂ゆ嫹閿熶茎纭锋嫹閿熸枻鎷烽敓鏂ゆ嫹
        if (mFile.exists()) {
            Bitmap bitmap2=BitmapFactory.decodeFile(path);
            Bitmap smallBitmap = ZoomBitmap.zoomImage(bitmap2, bitmap2.getWidth() / 2, bitmap2.getHeight() / 2);
            head_imageview.setImageBitmap(Util.toRoundBitmap(this, smallBitmap));
        }else{
        	Toast.makeText(MeActivity.this, getResources().getString(R.string.toast_title), Toast.LENGTH_LONG).show();
        }
		*//*try {
			String path = Bimp.drr.get(Bimp.max);
			System.out.println(path);
			Bitmap bm = Bimp.revitionImageSize(path);
			Bimp.bmp.add(bm);
			String newStr = path.substring(
					path.lastIndexOf("/") + 1,
					path.lastIndexOf("."));
			FileUtils.saveBitmap(bm, "" + newStr);
			} catch (IOException e) {
				e.printStackTrace();
			}*/
				
				
//		Button button3=(Button)findViewById(R.id.button3);
//		button3.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				AlertDialog alert=new AlertDialog.Builder(MeActivity.this).setTitle("閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷峰師閿熸枻鎷烽敓璇細").setIcon(
//			     android.R.drawable.ic_dialog_info).setView(
//			     new EditText(MeActivity.this)).setPositiveButton("纭敓鏂ゆ嫹", null)
//			     .setNegativeButton("鍙栭敓鏂ゆ嫹", null).show();
//			}
//		});
		//閿熸枻鎷烽敓鎴》鎷烽敓鏂ゆ嫹閿燂拷
		 menu.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					/*Intent aintent = new Intent(MeActivity.this, HomepageActivity.class);
					aintent.putExtra("photo", path);
					 鐏忓棙鏆熼幑顔藉ⅵ閸栧懎鍩宎intent Bundle 閻ㄥ嫯绻冪粙瀣殣 
					setResult(RESULT_OK,aintent);*/
					dialog();
				}
			});
		 
		 head_imageview.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				doTakePhoto();
				
				//openPictureSelectDialog();
				/*Intent intent = new Intent();
				intent.setClass(MeActivity.this, Poupic.class);
				startActivityForResult(intent, REQUEST_CODE);
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left);
				//uripic=Bundle.getString("imageUri");
*/			}
		});
}
	 
		  @Override
			protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			   
				if(resultCode == RESULT_OK) {  //閿熸枻鎷烽敓鎴垚鐧告嫹
					switch (requestCode) {
					case PHOTO_WITH_CAMERA:  {//閿熸枻鎷烽敓绉镐紮鎷峰彇鍥剧墖
						String status = Environment.getExternalStorageState();
						if(status.equals(Environment.MEDIA_MOUNTED)) { //閿熻鍑ゆ嫹閿熸枻鎷稴D閿熸枻鎷?
							
							Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/image.jpg");
							
							imgName = createPhotoFileName();
							//鍐欎竴閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓渚ョ》鎷烽敓鏂ゆ嫹閿熻姤鍒伴敓鏂ゆ嫹搴旈敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷?
			            	savePicture(imgName,bitmap);

			            	if (bitmap != null) {
								//涓洪敓鏂ゆ嫹姝㈠師濮嬪浘鐗囬敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹璇栭敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹灏忓師鍥鹃敓鏂ゆ嫹绀洪敓鏂ゆ嫹鐒堕敓鏂ゆ嫹閿熼叺鍑ゆ嫹鍘熷Bitmap鍗犻敓鐭鎷烽敓鑺傝揪鎷?
								Bitmap smallBitmap = ZoomBitmap.zoomImage(bitmap, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
								
								head_imageview.setImageBitmap(Util.toRoundBitmap(this, smallBitmap));
							}
			            	Toast.makeText(MeActivity.this, "閿熺獤鎲嬫嫹閿熻姤鏈簲閿熺煫纰夋嫹files閿熶茎纭锋嫹閿熸枻鎷烽敓鏂ゆ嫹", Toast.LENGTH_LONG).show();
						}else {
							Toast.makeText(MeActivity.this, "娌￠敓鏂ゆ嫹SD閿熸枻鎷?", Toast.LENGTH_LONG).show();
						}
						break;
					}
/*						case PHOTO_WITH_DATA:  {//閿熸枻鎷峰浘閿熸枻鎷烽敓鏂ゆ嫹閫夐敓鏂ゆ嫹鍥剧墖
							ContentResolver resolver = getContentResolver();
							//閿熸枻鎷风墖閿熸枻鎷峰師濮嬮敓鏂ゆ嫹婧愰敓鏂ゆ嫹鍧€
							Uri originalUri = data.getData();  
							//System.out.println(originalUri.toString());  //" content://media/external/images/media/15838 "

//			                //閿熸枻鎷峰師濮嬭矾閿熸枻鎷疯浆閿熸枻鎷烽敓鏂ゆ嫹鍥剧墖閿熸枻鎷疯矾閿熸枻鎷?
//			                String selectedImagePath = uri2filePath(originalUri);  
//			            	System.out.println(selectedImagePath);  //" /mnt/sdcard/DCIM/Camera/IMG_20130603_185143.jpg "
							try {
								 //浣块敓鏂ゆ嫹ContentProvider閫氶敓鏂ゆ嫹URI閿熸枻鎷峰彇鍘熷鍥剧墖
								Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
								
								imgName = createPhotoFileName();
				       			//鍐欎竴閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓渚ョ》鎷烽敓鏂ゆ嫹閿熻姤鍒伴敓鏂ゆ嫹搴旈敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷?
				            	savePicture(imgName,photo);
				            	
				            	if (photo != null) {
									//涓洪敓鏂ゆ嫹姝㈠師濮嬪浘鐗囬敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹璇栭敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹灏忓師鍥鹃敓鏂ゆ嫹绀洪敓鏂ゆ嫹鐒堕敓鏂ゆ嫹閿熼叺鍑ゆ嫹鍘熷Bitmap鍗犻敓鐭鎷烽敓鑺傝揪鎷?
									Bitmap smallBitmap = ZoomBitmap.zoomImage(photo, photo.getWidth() / 2, photo.getHeight() / 2);
									
									head_imageview.setImageBitmap(smallBitmap);
								}
//				                iv_temp.setImageURI(originalUri);   //閿熻妭鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷风ず鍥剧墖
				            	Toast.makeText(MeActivity.this, "閿熺獤鎲嬫嫹閿熻姤鏈簲閿熺煫纰夋嫹files閿熶茎纭锋嫹閿熸枻鎷烽敓鏂ゆ嫹", Toast.LENGTH_LONG).show();
							} catch (FileNotFoundException e) {
								e.printStackTrace();
							} catch (IOException e) {
								e.printStackTrace();
							}
						break;
						}*/
					}
				}
				super.onActivityResult(requestCode, resultCode, data);
			}

	        /*if (requestCode==REQUEST_CODE)  
	        {  
	            if (resultCode==Poupic.RESULT_CODE)  
	            {  
	            	Imagehello imeuri=new Imagehello();
	            	uripic=imeuri.getUri();
	            	try {
						Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
								.openInputStream(uripic));
						head_imageview.setImageBitmap(bitmap);
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
	            }  
	        }  */
	//    }  
	/*  *//**閿熸触寮€瀵逛紮鎷烽敓鏂ゆ嫹**//*
		private void openPictureSelectDialog() {
			//閿熺殕璁规嫹閿熸枻鎷稢ontext,閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟?
			Context dialogContext = new ContextThemeWrapper(MeActivity.this, R.style.Holo);
			String[] choiceItems= new String[2];
			choiceItems[0] = "閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟?;  //閿熸枻鎷烽敓鏂ゆ嫹
			choiceItems[1] = "閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓锟?;  //閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓绐栤槄鎷烽敓锟?
			ListAdapter adapter = new ArrayAdapter<String>(dialogContext, android.R.layout.simple_list_item_1,choiceItems);
			//閿熺殕浼欐嫹閿熸枻鎷烽敓鏂ゆ嫹閿熻妭鍒氭墠璁规嫹閿熸枻鎷风帿閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿燂拷
			AlertDialog.Builder builder = new AlertDialog.Builder(dialogContext);
			builder.setTitle("閿熸枻鎷烽敓閰佃锟?);
			builder.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
					case 0:  //閿熸枻鎷烽敓锟?
						doTakePhoto();
						break;
					case 1:  //閿熸枻鎷峰浘閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓绐栤埅锟?
						doPickPhotoFromGallery();
						break;
					}
					dialog.dismiss();
				}
			});
			builder.create().show();
		}	
*/
		 
		/**閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷峰彇鍥剧墖**//*
		private void doPickPhotoFromGallery() {
			File outputImage = new File(Environment.getExternalStorageDirectory(),
					"image.jpg");
			Uri imageUri = Uri.fromFile(outputImage);
			
			Intent intent = new Intent();
			intent.setType("image/*");  // 閿熸枻鎷烽敓鏂ゆ嫹Pictures閿熸枻鎷烽敓鏂ゆ嫹Type閿熷€熷畾涓篿mage
			intent.setAction(Intent.ACTION_GET_CONTENT); //浣块敓鏂ゆ嫹Intent.ACTION_GET_CONTENT閿熸枻鎷烽敓绱竎tion 
			//鎸囬敓鏂ゆ嫹閿熸枻鎷风墖閿熸枻鎷烽敓鏂ゆ嫹璺敓鏂ゆ嫹閿熸枻鎷稴D閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷穒mage.jpg涓轰竴閿熸枻鎷烽敓鏂ゆ嫹鏃堕敓渚ョ》鎷烽敓鏂ゆ嫹姣忛敓鏂ゆ嫹閿熸枻鎷烽敓绉哥尨鎷烽敓鏂ゆ嫹閿熼叺璁☆剨鎷烽敓鏂ゆ嫹宀滀紮鎷峰锟?
		    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
			startActivityForResult(intent, PHOTO_WITH_DATA); //鍙栭敓鏂ゆ嫹閿熸枻鎷风墖閿熻杩斿洖纰夋嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷?
		}*/
		
		/**閿熸枻鎷烽敓绉镐紮鎷峰彇閿熸枻鎷风墖**/
		private void doTakePhoto() {
		    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //閿熸枻鎷烽敓鏂ゆ嫹绯荤粺閿熸枻鎷烽敓锟?
		   
		    Uri imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"image.jpg"));
			//鎸囬敓鏂ゆ嫹閿熸枻鎷风墖閿熸枻鎷烽敓鏂ゆ嫹璺敓鏂ゆ嫹閿熸枻鎷稴D閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷穒mage.jpg涓轰竴閿熸枻鎷烽敓鏂ゆ嫹鏃堕敓渚ョ》鎷烽敓鏂ゆ嫹姣忛敓鏂ゆ嫹閿熸枻鎷烽敓绉哥尨鎷烽敓鏂ゆ嫹閿熼叺璁☆剨鎷烽敓鏂ゆ嫹宀滀紮鎷峰锟?
		    intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
	       
		    //鐩撮敓鏂ゆ嫹浣块敓鐭綇鎷锋病閿熸枻鎷烽敓鏂ゆ嫹灏? 
	        startActivityForResult(intent, PHOTO_WITH_CAMERA);  //閿熺煫浼欐嫹閿熸枻鎷烽敓鏂ゆ嫹鑸滈敓鏂ゆ嫹閿熸枻鎷烽敓楗猴拷
		}

		/**閿熸枻鎷烽敓鏂ゆ嫹鍥剧墖閿熸枻鎷峰悓閿熸枻鎷烽敓渚ョ》鎷烽敓鏂ゆ嫹**/
		private String createPhotoFileName() {
			String fileName = "";
			Date date = new Date(System.currentTimeMillis());  //绯荤粺閿熸枻鎷峰墠鏃堕敓鏂ゆ嫹
			SimpleDateFormat dateFormat = new SimpleDateFormat("'IMG'_yyyyMMdd_HHmmss");
			fileName = dateFormat.format(date) + ".jpg";
			return fileName;
		}
		
		 /**閿熸枻鎷峰彇閿熶茎纭锋嫹璺敓鏂ゆ嫹**/
		 public String uri2filePath(Uri uri)  
		    {  
		        String[] projection = {MediaStore.Images.Media.DATA };  
		        Cursor cursor = managedQuery(uri, projection, null, null, null);  
		        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);  
		        cursor.moveToFirst();  
		        String path =  cursor.getString(column_index);
		        return path;  
		    }  
		 
		 /**閿熸枻鎷烽敓鏂ゆ嫹鍥剧墖閿熸枻鎷烽敓鏂ゆ嫹搴旈敓鏂ゆ嫹閿熸枻鎷?*/
		 private void savePicture(String fileName,Bitmap bitmap) {
			   
				FileOutputStream fos =null;
				try {//鐩撮敓鏂ゆ嫹鍐欓敓鏂ゆ嫹閿熸枻鎷疯悕閿熸枻鎷锋閿熺煫浼欐嫹璋㈠矞浼欐嫹杩滈敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熷壙鏂ゆ嫹鏍￠敓琛椾紮鎷锋枩閿熸帴锔兼嫹璨岄敓鏂ゆ嫹鑺婇敓鏂ゆ嫹鍓╅敓鏂ゆ嫹閿熸枻鎷烽敓鏂ゆ嫹閿熸枻鎷烽敓鍙揪鎷烽敓缁撹閿熸枻鎷烽敓鏂ゆ嫹
					fos = MeActivity.this.openFileOutput(fileName, Context.MODE_PRIVATE); 
					bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);// 閿熸枻鎷峰浘鐗囧啓閿熸枻鎷锋寚閿熸枻鎷烽敓渚ョ》鎷烽敓鏂ゆ嫹閿熸枻鎷?
					
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						if(null != fos) {
							fos.close();
							fos = null;
						}
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
	
		 /**
			 * 鏉╂柨娲栨禍瀣╂閻╂垵鎯?
			 * */
			public boolean onKeyDown(int keyCode, KeyEvent event) {
		        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
		        	            dialog();
		                        return false;
		        }
		                        return false;
		      }
			/**
			 * 闁拷閸戠儤褰佺粈鐑樻煙濞夛拷
			 **/
			protected void dialog() {
				AlertDialog alert=new AlertDialog.Builder(MeActivity.this).create();
				alert.setIcon(R.drawable.vegetable);
				alert.setTitle("淇敼璧勬枡");
				alert.setMessage("\n纭淇敼璧勬枡鍚楋紵\n");
				alert.setButton(DialogInterface.BUTTON_NEGATIVE, "鍙栨秷", 
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								//
								//dialog.dismiss();
								finish();
							}
						});
				alert.setButton(DialogInterface.BUTTON_POSITIVE, "瀹屾垚", 
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								headname = et_headname.getText().toString();
								Toast.makeText(MeActivity.this, "璧勬枡淇敼鎴愬姛", Toast.LENGTH_LONG).show();
								Intent mintent=new Intent();
								mintent.putExtra("headname", headname);
								// 鐠佸墽鐤嗙紒鎾寸亯閿涘苯鑻熸潻娑滎攽娴肩娀锟斤拷  
						        setResult(resultCode, mintent); 
								MeActivity.this.finish();
								/*headpath = File2StringUtil
										.file2String(path);
								// 閸戝棗顦崣鍌涙殶閸掓銆?
								final Map<String, String> params = new HashMap<String, String>();
								params.put("fruit_picture", headpath);*/
								/*new Thread() {
									public void run() {
										String msgStr = HttpUploadUtil.postWithoutFile(url,
												params);
										Bundle b = new Bundle();
										// 鐏忓棗鍞寸€圭懓鐡х粭锔胯閺€鎹愮箻閺佺増宓丅undle娑擄拷
										b.putString("msg", msgStr);
										// 閵嗕礁鍨卞鐑樼Х閹垰顕挒锟?
										Message msg = new Message();
										// 鐠佸墽鐤嗛弫鐗堝祦Bundle閸掔増绉烽幁顖欒厬
										msg.setData(b);
										// 鐠佸墽鐤嗗☉鍫熶紖閺嶅洩鐦?
										msg.what = Constant.ADDFRUIT;
										// 閸欐垿锟戒焦绉烽幁锟?
										hd.sendMessage(msg);

									} // run

								}.start();// thread
*/								
							}
						});
				alert.show();
				/*hd = new Handler() {
					@Override
					public void handleMessage(Message msg) {

						super.handleMessage(msg);
						Bundle b;
						b = msg.getData();// 閼惧嘲褰囧☉鍫熶紖娑擃厾娈戦弫鐗堝祦
						String msgStr = b.getString("msg");// 閼惧嘲褰囬崘鍛啇鐎涙顑佹稉锟?
						Toast.makeText(MeActivity.this, msgStr, Toast.LENGTH_SHORT)
								.show();

					}
				};// //handler
*/			}
	private void initViews() {
		head_imageview=(ImageView)findViewById(R.id.head_imageview);
	    menu=(ImageView)findViewById(R.id.back_edit_me);
	    save=(ImageView)findViewById(R.id.save_me);
	    et_headname=(EditText)findViewById(R.id.tv_name);
	}
}
