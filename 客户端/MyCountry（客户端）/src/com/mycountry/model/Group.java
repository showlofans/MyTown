package com.mycountry.model;

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
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class Group extends Activity {
	String[] listArray;// ѧ���б�����
	private String aurl = Constant.aURL + "/astudentlist.jsp";
	Handler handler;
 
	public void onCreate(Bundle savedInsatanceState) {
		super.onCreate(savedInsatanceState);
		setContentView(R.layout.group);
		final Map<String, String> params = new HashMap<String, String>();
		params.put("parame1", "wok");
		new Thread() { // �����߳�
			public void run() {
				String msgStr = HttpUploadUtil.postWithoutFile(aurl, params);
				Bundle b = new Bundle();
				b.putString("msg", msgStr);
				Message msg = new Message();
				msg.setData(b);
				msg.what = Constant.WORKER;
				handler.sendMessage(msg);
			}
		}.start();

		// ΪImageButton����¼�
//		Button od = (Button) findViewById(R.id.btn_back);
//		od.setOnClickListener(new View.OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				finish();
//			}
//		});

		handler = new Handler() {
			public void handleMessage(Message msg) {
				super.handleMessage(msg);// ���ø���
				Bundle b;
				b = msg.getData();// ��ȡ��Ϣ�е�����
				String msgStr = b.getString("msg");// ��ȡ�����ַ���
				initListViewt(msgStr, Constant.ORDERLISTVIEW01);

				// Toast.makeText(WorkerManage.this, msgStr,
				// Toast.LENGTH_SHORT).show();

			}
		};

	}// oncreate

	// Ϊ�б���ͼ׼������
	public void initListViewt(String msgStr, int list) {
		listArray = msgStr.split("\\|");
		final int count = listArray.length / 4;// ������Դ������

		// ΪListView׼������������
		BaseAdapter baa = new BaseAdapter() {
			@Override
			public int getCount() {
				return count;
			}

			@Override
			public Object getItem(int arg0) {
				return null;
			}

			@Override
			public long getItemId(int arg0) {
				return 0;
			}

			@Override
			public View getView(int arg0, View arg1, ViewGroup arg2) {
				LinearLayout ll = new LinearLayout(Group.this);
				ll.setOrientation(LinearLayout.HORIZONTAL);

				// ll.setLayoutParams(null);
				ll.setBackgroundColor(getResources().getColor(R.color.deep));

				// ѧ��ѧ��
				TextView tv = new TextView(Group.this);
				tv.setWidth(30);// �������
				tv.setGravity(1);
				tv.setText(listArray[arg0 * 4]);
				tv.setTextSize(15);
				tv.setTextColor(getResources().getColor(R.color.gray));
				ll.addView(tv);

				// ѧ������
				TextView tv1 = new TextView(Group.this);
				tv1.setWidth(140);//
				tv1.setText(listArray[arg0 * 4 + 1]);
				tv1.setTextSize(15);
				tv1.setGravity(1);
				tv1.setTextColor(getResources().getColor(R.color.gray));
				ll.addView(tv1);

				// ѧ������ѧԺ
				TextView tv2 = new TextView(Group.this);
				tv2.setWidth(40);//
				tv2.setText(listArray[arg0 * 4 + 2]);
				tv2.setTextSize(15);
				tv2.setGravity(1);
				tv2.setTextColor(getResources().getColor(R.color.gray));
				ll.addView(tv2);

				// ѧ���Ա�
				TextView tv3 = new TextView(Group.this);
				tv3.setWidth(100);//
				tv3.setText(listArray[arg0 * 4 + 3]);
				tv3.setTextSize(15);
				tv3.setGravity(1);
				tv3.setTextColor(getResources().getColor(R.color.gray));
				ll.addView(tv3);
				return ll;
			}
		};

		ListView lvv = (ListView) findViewById(R.id.lvGroup);
		lvv.setAdapter(baa);// ΪListView��������������
		// ����ѡ������ļ�����
		lvv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {// ��дѡ������¼��Ĵ�����

				/*String workid = listArray[arg2 * 4].toString().trim();

				Intent intent2 = new Intent(WorkerManage.this,
						WorkerDetail.class);
				Bundle b2 = new Bundle();
				b2.putCharSequence("workid", workid);
				intent2.putExtras(b2);
				startActivity(intent2);*/

			}
		});

	}// /////////initListView

}
