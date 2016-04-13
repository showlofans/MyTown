package com.mycountry.details;

import com.example.menutab.R;
import com.mycountry.activity.AddNote;
import com.mycountry.model.Note;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class NoteDetail extends Activity {

	private Note note;
	TextView note_title, note_content, note_time;
	ImageView picture;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news_detail);
		
		// ���ذ�ť��ת
		ImageView menu = (ImageView) findViewById(R.id.back_news_detail);
		menu.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		// ��Ӱ�ť��ת
		ImageButton plus = (ImageButton) findViewById(R.id.share_news_detail);
		plus.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(NoteDetail.this, AddNote.class);
				startActivity(intent);
			}
		});
		note_title = (TextView) findViewById(R.id.news_detail_title);
		note_content = (TextView) findViewById(R.id.news_detail_content);
		note_time = (TextView) findViewById(R.id.news_detail_time);
		picture = (ImageView) findViewById(R.id.news_detail_pic);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			note = (Note) bundle.get("note");
		}
		if (note != null) {// ��ʼ��Ⱦ��ݵ�������

			// ��ʼ��Ⱦ��ǰ��Ʒ��Ϣ
			note_title.setText(note.getNote_title());
			note_content.setText(note.getNote_content());
			note_time.setText(note.getNote_time());
			Bitmap bit = BitmapFactory.decodeByteArray(note.getNote_picture(), 0,
					note.getNote_picture().length); // ��ͼƬ��ת��Ϊbitmap����
			picture.setImageBitmap(bit);
		}
	}

}
