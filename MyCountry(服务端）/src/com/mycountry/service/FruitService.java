package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Fruit;
import com.mycountry.domain.Green;
import com.mycountry.util.ConnectionFactory;

public class FruitService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Fruit> find() { 
		try {
			ArrayList<Fruit> list = new ArrayList<Fruit>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by fruit_id desc) as id from fruit ");
			// sql.append(" where note_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Fruit fruit = null;
			while (rs.next()) {
				fruit = new Fruit();
				fruit.setFruit_id(rs.getInt("fruit_id"));
				fruit.setCountry_name(rs.getString("country_name"));
				fruit.setFruit_title(rs.getString("fruit_title"));
				fruit.setFruit_content(rs.getString("fruit_content"));
				fruit.setFruit_sales(rs.getString("fruit_sales"));
				fruit.setFruit_picture(rs.getString("fruit_picture"));
				fruit.setFruit_time(rs.getString("fruit_time"));
				fruit.setFruit_price(rs.getString("fruit_price"));
//				fruit.setFruit_distance(rs.getString("fruit_distance"));
				list.add(fruit);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}
	
	public ArrayList<Fruit> Serch(String str) {
		try {
			ArrayList<Fruit> list = new ArrayList<Fruit>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from fruit where fruit_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Fruit fruit = null;
			while (rs.next()) {	
				fruit = new Fruit();
				fruit.setFruit_id(rs.getInt("fruit_id"));
				fruit.setCountry_name(rs.getString("country_name"));
				fruit.setFruit_title(rs.getString("fruit_title"));
				fruit.setFruit_content(rs.getString("fruit_content"));
				fruit.setFruit_sales(rs.getString("fruit_sales"));
				fruit.setFruit_picture(rs.getString("fruit_picture"));
				fruit.setFruit_time(rs.getString("fruit_time"));
				fruit.setFruit_price(rs.getString("fruit_price"));
				fruit.setFruit_distance(rs.getString("fruit_distance"));
				list.add(fruit);
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
