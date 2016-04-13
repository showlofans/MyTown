package com.mycountry.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher.ViewFactory;

import com.example.menutab.R;

public class ImageActivity extends Activity {
	private int[] imageId = new int[] { R.drawable.daocao, R.drawable.daoxiang,
			R.drawable.dong, R.drawable.qing, R.drawable.shan, R.drawable.shui,
			R.drawable.yan, }; // ���岢��ʼ������ͼƬid������

	private ImageSwitcher imageSwitcher; // ����һ��ͼ���л�������

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.image);

		// ���ذ�ť��ת
		Button menu = (Button) findViewById(R.id.back_image);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		// ��Ӱ�ť��ת
		Button edit = (Button) findViewById(R.id.edit);
		edit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ImageActivity.this, AddNote.class);
				startActivity(intent);
			}
		});
		Gallery gallery = (Gallery) findViewById(R.id.gallery1); // ��ȡGallery���
		imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1); // ��ȡͼ���л���
		// ���ö���Ч��  
		imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in)); // ���õ��붯��
		imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out)); // ���õ�������
		imageSwitcher.setFactory(new ViewFactory() {

			@Override
			public View makeView() {
				ImageView imageView = new ImageView(ImageActivity.this); // ʵ����һ��ImageView��Ķ���
				imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // ���ñ����ݺ�Ⱦ�������ͼ��
				imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
				return imageView; // ����imageView����
			}

		});
		/********************** ʹ��BaseAdapterָ��Ҫ��ʾ������ *****************************/
		BaseAdapter adapter = new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				ImageView imageview; // ����ImageView�Ķ���
				if (convertView == null) {
					imageview = new ImageView(ImageActivity.this); // ʵ����ImageView�Ķ���
					imageview.setScaleType(ImageView.ScaleType.FIT_XY); // �������ŷ�ʽ
					imageview
							.setLayoutParams(new Gallery.LayoutParams(180, 135));
					TypedArray typedArray = obtainStyledAttributes(R.styleable.Gallery);
					imageview.setBackgroundResource(typedArray.getResourceId(
							R.styleable.Gallery_android_galleryItemBackground,
							0));
					imageview.setPadding(5, 0, 5, 0); // ����ImageView���ڱ߾�
				} else {
					imageview = (ImageView) convertView;
				}
				imageview.setImageResource(imageId[position]); // ΪImageView����Ҫ��ʾ��ͼƬ
				return imageview; // ����ImageView
			}

			/*
			 * ���ܣ���õ�ǰѡ���ID (non-Javadoc)
			 * 
			 * @see android.widget.Adapter#getItemId(int)
			 */
			@Override
			public long getItemId(int position) {
				return position;
			}

			/*
			 * ���ܣ���õ�ǰѡ�� (non-Javadoc)
			 * 
			 * @see android.widget.Adapter#getItem(int)
			 */
			@Override
			public Object getItem(int position) {
				return position;
			}

			/*
			 * ������� (non-Javadoc)
			 * 
			 * @see android.widget.Adapter#getCount()
			 */
			@Override
			public int getCount() {
				return imageId.length;
			}
		};
		gallery.setAdapter(adapter); // ����������Gallery����
		/*********************************************************************************/
		gallery.setSelection(imageId.length / 2); // ���м��ͼƬѡ��
		gallery.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				imageSwitcher.setImageResource(imageId[position]);// ��ʾѡ�е�ͼƬ
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}

		});

	}

}
