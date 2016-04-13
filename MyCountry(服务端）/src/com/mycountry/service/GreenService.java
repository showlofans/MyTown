package com.mycountry.service;

import java.sql.*;
import java.util.*;
import com.mycountry.domain.Green;
import com.mycountry.util.ConnectionFactory;

public class GreenService {
	// 建立连接对象
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Green> find() {
		try {
			ArrayList<Green> list = new ArrayList<Green>();
			conn = ConnectionFactory.getConnection();// 开始连接
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by green_id desc) as id from green_food");
			pstm = conn.prepareStatement(sql.toString());// 执行SQL
			rs = pstm.executeQuery();
			Green green = null;
			while (rs.next()) {
				green = new Green();
				green.setGreen_id(rs.getInt("green_id"));
				green.setGreen_title(rs.getString("green_title"));
				green.setGreen_content(rs.getString("green_content"));
				green.setGreen_picture(rs.getString("green_picture"));
				green.setGreen_time(rs.getString("green_time"));
				green.setGreen_sales(rs.getString("green_sales"));
				green.setGreen_price(rs.getString("green_price"));
				green.setGcountry_name(rs.getString("gcountry_name"));
				green.setGreen_distance(rs.getString("green_distance"));
				list.add(green);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 在return之前执行
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}

	public ArrayList<Green> Serch(String str) {
		try {
			ArrayList<Green> list = new ArrayList<Green>();
			conn = ConnectionFactory.getConnection();// 开始连接
			StringBuffer sql = new StringBuffer();
			sql.append("select * from green_food where green_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// 执行SQL
			rs = pstm.executeQuery();
			Green green = null;
			while (rs.next()) {
				green = new Green();
				green.setGreen_id(rs.getInt("green_id"));
				green.setGreen_title(rs.getString("green_title"));
				green.setGreen_content(rs.getString("green_content"));
				green.setGreen_picture(rs.getString("green_picture"));
				green.setGreen_time(rs.getString("green_time"));
				green.setGreen_sales(rs.getString("green_sales"));
				green.setGreen_price(rs.getString("green_price"));
				green.setGreen_distance(rs.getString("green_distance"));
				green.setGcountry_name(rs.getString("gcountry_name"));
				list.add(green);
			}
			if (list.equals("")) {
				return null;
			} else {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// 在return之前执行
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}

}
