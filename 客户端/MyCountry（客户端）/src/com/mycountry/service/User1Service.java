/*package com.mycountry.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.menutab.R;
import com.mycountry.model.User;
import com.mycountry.utils.Constant;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class User1Service extends Activity {  
    private LinearLayout mLinearLayout;  
    private ListView mListView;  
    //使用IP不能使用localhost或者127.0.0.1，因为android模拟器默认绑定这个IP，这里应该访问局域网IP   
    private static final String urlPath = Constant.userURL;  
    private static final String TAG = "MainActivity";  
    private List<User> persons;  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.menu_item);  
        mLinearLayout = (LinearLayout) findViewById(R.id.headlayout);  
        mListView = (ListView) findViewById(R.id.listView1);  
        mLinearLayout.setOnClickListener(new MyOnClickListener());  
    }  
  
    private class MyOnClickListener implements OnClickListener {  
        @Override  
        public void onClick(View v) {  
            try {  
                // 得到Json解析成功之后数据   
                persons = JsonParse.getListUser(urlPath);  
                List<HashMap<String, Object>> data = new ArrayList<HashMap<String, Object>>();  
                for (int i = 0; i < persons.size(); i++) {  
                    HashMap<String, Object> map = new HashMap<String, Object>();  
                    map.put("user_name", persons.get(i).getUser_name());  
                    map.put("user_address", persons.get(i).getUser_address());  
                    map.put("user_email", persons.get(i).getUser_email());  
                    map.put("user_type", persons.get(i).getUser_type());
                    data.add(map);  
                }  
                //初始化适配器，并且绑定数据   
                SimpleAdapter _Adapter = new SimpleAdapter(User1Service.this,  
                        data, R.layout.me, new String[] { "user_name",  
                                "user_address", "user_email", "user_type" }, new int[] { R.id.tv_name,  
                                R.id.tv_address, R.id.tv_email ,R.id.tv_type });  
                mListView.setAdapter(_Adapter);  
            } catch (Exception e) {  
                Toast.makeText(User1Service.this, "解析失败", 2000).show();  
                Log.i(TAG, e.toString());  
  
            }  
        }  
    }
}

*/