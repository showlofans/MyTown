package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Green;
import com.mycountry.domain.Push;
import com.mycountry.util.ConnectionFactory;

public class PushService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Push> find() {
		try {
			ArrayList<Push> list = new ArrayList<Push>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by push_id desc) as id from push");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Push push = null;
			while (rs.next()) {
				push = new Push();
				push.setPush_id(rs.getInt("push_id"));
				push.setPush_title(rs.getString("push_title"));
				push.setPush_content(rs.getString("push_content"));
				push.setPush_picture(rs.getString("push_picture"));
				push.setPush_time(rs.getString("push_time"));
				push.setPush_price(rs.getString("push_price"));
				push.setPush_sales(rs.getString("push_sales"));
				push.setPush_distance(rs.getString("push_distance"));
				list.add(push);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}
	
	public ArrayList<Push> Serch(String str) {
		try {
			ArrayList<Push> list = new ArrayList<Push>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from push where green_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Push push = null;
			while (rs.next()) {
				push = new Push();
				push.setPush_id(rs.getInt("push_id"));
				push.setPush_title(rs.getString("push_title"));
				push.setPush_content(rs.getString("push_content"));
				push.setPush_picture(rs.getString("push_picture"));
				push.setPush_time(rs.getString("push_time"));
				push.setPush_price(rs.getString("push_price"));
				push.setPush_sales(rs.getString("push_sales"));
				push.setPush_distance(rs.getString("push_distance"));
				list.add(push);
			}
			if (list.equals("")) {
				return null;
			} else {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}
}
