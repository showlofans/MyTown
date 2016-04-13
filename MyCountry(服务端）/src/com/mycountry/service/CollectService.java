package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Collect;
import com.mycountry.util.ConnectionFactory;

public class CollectService {
	// 建立连接对象
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Collect> find() {
		try {
			ArrayList<Collect> list = new ArrayList<Collect>();
			conn = ConnectionFactory.getConnection();// 开始连接
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by collect_id desc) as id from collect");
			// sql.append(" where note_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// 执行SQL
			rs = pstm.executeQuery();
			Collect collect = null;
			while (rs.next()) {
				collect = new Collect();
				collect.setCollect_id(rs.getInt("collect_id"));
				collect.setCountry_name(rs.getString("country_name"));
				collect.setCollect_title(rs.getString("collect_title"));
				collect.setCollect_content(rs.getString("collect_content"));
				collect.setCollect_sales(rs.getString("collect_sales"));
				collect.setCollect_price(rs.getString("collect_price"));
				collect.setCollect_tel(rs.getString("collect_tel"));
				collect.setCollect_picture(rs.getString("collect_picture"));
				collect.setCollect_time(rs.getString("collect_time"));
				collect.setCollect_distance(rs.getString("collect_distance"));
				list.add(collect);  
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
