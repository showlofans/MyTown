package com.mycountry.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycountry.domain.GreenPush;
import com.mycountry.util.ConnectionFactory;

public class GreenPushService {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	public ArrayList<GreenPush> find(){
		
		try {
			ArrayList<GreenPush> list = new ArrayList<GreenPush>();
			conn = ConnectionFactory.getConnection();// 开始连接
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by greenPush_id desc) as id from greenPush");
			pstm = conn.prepareStatement(sql.toString());// 执行SQL
			rs = pstm.executeQuery();
			GreenPush greenPush = null;
			while (rs.next()) {
				greenPush = new GreenPush();
				greenPush.setGreenPush_id(rs.getInt("greenPush_id"));
				greenPush.setCountry_name(rs.getString("country_name"));
				greenPush.setGreenPush_title(rs.getString("greenPush_title"));
				greenPush.setGreenPush_content(rs.getString("greenPush_content"));
				greenPush.setGreenPush_sales(rs.getString("greenPush_sales"));
				greenPush.setGreenPush_price(rs.getString("greenPush_price"));
				greenPush.setGreenPush_time(rs.getString("greenPush_time"));
				greenPush.setGreenPush_picture(rs.getString("greenPush_picture"));
				list.add(greenPush);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 在return之前执行
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}

}
