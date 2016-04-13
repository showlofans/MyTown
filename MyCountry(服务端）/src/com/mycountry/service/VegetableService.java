package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Fruit;
import com.mycountry.domain.Vegetable;
import com.mycountry.util.ConnectionFactory;

public class VegetableService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Vegetable> find() {
		try {
			ArrayList<Vegetable> list = new ArrayList<Vegetable>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by vegetable_id desc) as id from vegetable");
			// sql.append(" where meat_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Vegetable vegetable = null;
			while (rs.next()) {
				vegetable = new Vegetable();
				vegetable.setVegetable_id(rs.getInt("vegetable_id"));
				vegetable.setVegetable_title(rs.getString("vegetable_title"));
				vegetable.setCountry_name(rs.getString("country_name"));
				vegetable.setVegetable_content(rs.getString("vegetable_content"));
				vegetable.setVegetable_picture(rs.getString("vegetable_picture"));
				vegetable.setVegetable_time(rs.getString("vegetable_time"));
				vegetable.setVegetable_price(rs.getString("vegetable_price"));
				vegetable.setVegetable_sales(rs.getString("vegetable_sales"));
				vegetable.setVegetable_distance(rs.getString("vegetable_distance"));
				list.add(vegetable);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}
	public ArrayList<Vegetable> Serch(String str) {
		try {
			ArrayList<Vegetable> list = new ArrayList<Vegetable>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from vegetable where vegetable_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Vegetable vegetable = null;
			while (rs.next()) {
				vegetable = new Vegetable();
				vegetable.setVegetable_id(rs.getInt("vegetable_id"));
				vegetable.setVegetable_title(rs.getString("vegetable_title"));
				vegetable.setCountry_name(rs.getString("country_name"));
				vegetable.setVegetable_content(rs.getString("vegetable_content"));
				vegetable.setVegetable_picture(rs.getString("vegetable_picture"));
				vegetable.setVegetable_time(rs.getString("vegetable_time"));
				vegetable.setVegetable_price(rs.getString("vegetable_price"));
				vegetable.setVegetable_sales(rs.getString("vegetable_sales"));
				vegetable.setVegetable_distance(rs.getString("vegetable_distance"));
				list.add(vegetable);
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
