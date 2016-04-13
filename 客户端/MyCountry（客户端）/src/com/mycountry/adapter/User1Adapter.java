/*package com.mycountry.adapter;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mycountry.model.User;

public class User1Adapter {  

    public static List<User> getListUser(String urlPath) throws Exception {  
        List<User> mlists = new ArrayList<User>();  
        byte[] data = readParse(urlPath);  
        JSONArray array = new JSONArray(new String(data));  
        for (int i = 0; i < array.length(); i++) {  
            JSONObject item = array.getJSONObject(i);  
            String user_name = item.getString("user_name");  
            String user_email = item.getString("user_email");  
            String user_address = item.getString("user_address"); 
            String user_type = item.getString("user_type");
            //String user_picture = item.getString("user_picture");
            mlists.add(new User(user_name, user_email, user_address, user_type));  
        }  
        return mlists;  
    }  
    *//** 
     * 从指定的url中获取字节数组 
     *  
     * @param urlPath 
     * @return 字节数组 
     * @throws Exception 
     *//*  
    public static byte[] readParse(String urlPath) throws Exception {  
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
        byte[] data = new byte[1024];  
        int len = 0;  
        URL url = new URL(urlPath);  
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
        InputStream inStream = conn.getInputStream();  
        while ((len = inStream.read(data)) != -1) {  
            outStream.write(data, 0, len);  
        }  
        inStream.close();  
        return outStream.toByteArray();  
    }  
}
*/