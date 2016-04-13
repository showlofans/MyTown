package com.mycountry.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycountry.domain.Fruit;
import com.mycountry.domain.Push1;
import com.mycountry.util.ConnectionFactory;

public class Push1Service {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	public ArrayList<Push1> find(){
		try {
			ArrayList<Push1> list = new ArrayList<Push1>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by push1_id desc) as id from push1");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Push1 push1 = null;
			while (rs.next()) {
				push1 = new Push1();
				push1.setPush1_id(rs.getInt("push1_id"));
				push1.setCountry_name(rs.getString("country_name"));
				push1.setPush1_title(rs.getString("push1_title"));
				push1.setPush1_content(rs.getString("push1_content"));
				push1.setPush1_picture(rs.getString("push1_picture"));
				push1.setPush1_sales(rs.getString("push1_sales"));
				push1.setPush1_price(rs.getString("push1_price"));
				push1.setPush1_distance(rs.getString("push1_distance"));
				push1.setPush1_time(rs.getString("push1_time"));
				list.add(push1);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}
	
	public ArrayList<Push1> Serch(String str) {
		try {
			ArrayList<Push1> list = new ArrayList<Push1>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from push1 where push1_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Push1 push1 = null;
			while (rs.next()) {
				push1 = new Push1();
				push1.setPush1_id(rs.getInt("push1_id"));
				push1.setCountry_name(rs.getString("country_name"));
				push1.setPush1_title(rs.getString("push1_title"));
				push1.setPush1_content(rs.getString("push1_content"));
				push1.setPush1_picture(rs.getString("push1_picture"));
				push1.setPush1_sales(rs.getString("push1_sales"));
				push1.setPush1_price(rs.getString("push1_price"));
				push1.setPush1_distance(rs.getString("push1_distance"));
				push1.setPush1_time(rs.getString("push1_time"));
				list.add(push1);
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
