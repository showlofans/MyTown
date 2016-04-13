package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Business;
import com.mycountry.domain.Fruit;
import com.mycountry.util.ConnectionFactory;

public class BusinessService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Business> find() {
		try {
			ArrayList<Business> list = new ArrayList<Business>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by business_id desc) as id from business");
			// sql.append(" where note_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Business business = null;
			while (rs.next()) {
				business = new Business();
				business.setBusiness_id(rs.getInt("business_id"));
				business.setCountry_name(rs.getString("country_name"));
				business.setBusiness_title(rs.getString("business_title"));
				business.setBusiness_content(rs.getString("business_content"));
				business.setBusiness_sales(rs.getString("business_sales"));
				business.setBusiness_price(rs.getString("business_price"));
				business.setBusiness_tel(rs.getString("business_tel"));
				business.setBusiness_picture(rs.getString("business_picture"));
				business.setBusiness_time(rs.getString("business_time"));
				business.setBusiness_distance(rs.getString("business_distance"));
				list.add(business);  
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}
	
	public ArrayList<Business> Serch(String str) {
		try {
			ArrayList<Business> list = new ArrayList<Business>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from business where business_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Business business = null;
			while (rs.next()) {
				business = new Business();
				business.setBusiness_id(rs.getInt("business_id"));
				business.setCountry_name(rs.getString("country_name"));
				business.setBusiness_title(rs.getString("business_title"));
				business.setBusiness_content(rs.getString("business_content"));
				business.setBusiness_sales(rs.getString("business_sales"));
				business.setBusiness_price(rs.getString("business_price"));
				business.setBusiness_tel(rs.getString("business_tel"));
				business.setBusiness_picture(rs.getString("business_picture"));
				business.setBusiness_time(rs.getString("business_time"));
				business.setBusiness_distance(rs.getString("business_distance"));
				list.add(business);  
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
