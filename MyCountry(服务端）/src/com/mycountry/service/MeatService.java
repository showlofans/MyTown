package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Green;
import com.mycountry.domain.Meat;
import com.mycountry.util.ConnectionFactory;

public class MeatService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Meat> find() {
		try {
			ArrayList<Meat> list = new ArrayList<Meat>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by meat_id desc) as id from meat");
			// sql.append(" where meat_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Meat meat = null;
			while (rs.next()) {
				meat = new Meat();
				meat.setMeat_id(rs.getInt("Meat_id"));
				meat.setMeat_title(rs.getString("Meat_title"));
				meat.setCountry_name(rs.getString("country_name"));
				meat.setMeat_content(rs.getString("Meat_content"));
				meat.setMeat_picture(rs.getString("Meat_picture"));
				meat.setMeat_time(rs.getString("Meat_time"));
				meat.setMeat_price(rs.getString("Meat_price"));
				meat.setMeat_sales(rs.getString("Meat_sales"));
				meat.setMeat_distance(rs.getString("meat_distance"));
				list.add(meat);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}
	public ArrayList<Meat> Serch(String str) {
		try {
			ArrayList<Meat> list = new ArrayList<Meat>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from meat where Meat_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Meat meat = null;
			while (rs.next()) {
				meat = new Meat();
				meat.setMeat_id(rs.getInt("Meat_id"));
				meat.setMeat_title(rs.getString("Meat_title"));
				meat.setCountry_name(rs.getString("country_name"));
				meat.setMeat_content(rs.getString("Meat_content"));
				meat.setMeat_picture(rs.getString("Meat_picture"));
				meat.setMeat_time(rs.getString("Meat_time"));
				meat.setMeat_price(rs.getString("Meat_price"));
				meat.setMeat_sales(rs.getString("Meat_sales"));
				meat.setMeat_distance(rs.getString("meat_distance"));
				list.add(meat);
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
