package com.mycountry.pic;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import com.example.menutab.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class TestPicActivity extends Activity {
	// ArrayList<Entity> dataList;//鐢ㄦ潵瑁呰浇鏁版嵁婧愮殑鍒楄�?
	List<ImageBucket> dataList;
	GridView gridView;
	ImageBucketAdapter adapter;// 鑷畾涔夌殑閫傞厤锟�??
	AlbumHelper helper;
	public static final String EXTRA_IMAGE_LIST = "imagelist";
	public static Bitmap bimap;  
	TextView cancel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image_bucket);

		helper = AlbumHelper.getHelper();
		helper.init(getApplicationContext());

		initData();
		initView();
		cancel=(TextView)findViewById(R.id.canceltext);
		cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				TestPicActivity.this.finish();
			}
		});
	}

	/**
	 * 鍒濆鍖栨暟锟�?
	 */
	private void initData() {
		// /**
		// * 杩欓噷锛屾垜浠亣璁惧凡缁忎粠缃戠粶鎴栵�??鏈湴瑙ｆ�?�濂戒簡鏁版嵁锛屾墍浠ョ洿鎺ュ湪杩欓噷妯℃嫙锟�?0涓疄浣撶被锛岀洿鎺ヨ杩涘垪琛ㄤ腑
		// */
		// dataList = new ArrayList<Entity>();
		// for(int i=-0;i<10;i++){
		// Entity entity = new Entity(R.drawable.picture, false);
		// dataList.add(entity);
		// }
		dataList = helper.getImagesBucketList(false);	
		bimap=BitmapFactory.decodeResource(
				getResources(),
				0);
	}

	/**
	 * 鍒濆鍖杤iew瑙嗗�?
	 */ 
	private void initView() {
		gridView = (GridView) findViewById(R.id.gridview);
		adapter = new ImageBucketAdapter(TestPicActivity.this, dataList);
		gridView.setAdapter(adapter);

		gridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				/**
				 * 鏍规嵁position鍙傛暟锛屽彲浠ヨ幏寰楄窡GridView鐨勫瓙View鐩哥粦�?�氱殑�?�炰綋绫伙紝鐒跺悗鏍规嵁瀹冪殑isSelected鐘讹�??锟�?
				 * 鏉ュ垽鏂槸鍚︽樉绀猴拷?涓晥鏋滐拷? 鑷充簬閫変腑鏁堟灉鐨勮鍒欙紝涓嬮潰閫傞厤鍣ㄧ殑浠ｇ爜涓細鏈夎锟�??
				 */
				// if(dataList.get(position).isSelected()){
				// dataList.get(position).setSelected(false);
				// }else{
				// dataList.get(position).setSelected(true);
				// }
				/**
				 * 閫氱煡閫傞厤鍣紝缁戝畾鐨勬暟鎹彂鐢熶簡鏀瑰彉锛屽簲褰撳埛鏂拌锟�??
				 */
				// adapter.notifyDataSetChanged();
				Intent intent = new Intent(TestPicActivity.this,
						ImageGridActivity.class);
				
				intent.putExtra(TestPicActivity.EXTRA_IMAGE_LIST,
						(Serializable) dataList.get(position).imageList);
				startActivity(intent);
				finish();
			}

		});
	}
}
