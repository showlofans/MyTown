package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Fruit;
import com.mycountry.domain.Wine;
import com.mycountry.util.ConnectionFactory;

public class WineService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Wine> find() {
		try {
			ArrayList<Wine> list = new ArrayList<Wine>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by wine_id desc) as id from wine");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Wine wine = null;
			while (rs.next()) {
				wine = new Wine();
				wine.setWine_id(rs.getInt("wine_id"));
				wine.setCountry_name(rs.getString("country_name"));
				wine.setWine_title(rs.getString("wine_title"));
				wine.setWine_content(rs.getString("wine_content"));
				wine.setWine_picture(rs.getString("wine_picture"));
				wine.setWine_time(rs.getString("wine_time"));
				wine.setWine_price(rs.getString("wine_price"));
				wine.setWine_sales(rs.getString("wine_sales"));
				wine.setWine_distance(rs.getString("wine_distance"));
				list.add(wine);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}
	
	public ArrayList<Wine> Serch(String str) {
		try {
			ArrayList<Wine> list = new ArrayList<Wine>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from wine where wine_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Wine wine = null;
			while (rs.next()) {
				wine = new Wine();
				wine.setWine_id(rs.getInt("wine_id"));
				wine.setCountry_name(rs.getString("country_name"));
				wine.setWine_title(rs.getString("wine_title"));
				wine.setWine_content(rs.getString("wine_content"));
				wine.setWine_picture(rs.getString("wine_picture"));
				wine.setWine_time(rs.getString("wine_time"));
				wine.setWine_price(rs.getString("wine_price"));
				wine.setWine_sales(rs.getString("wine_sales"));
				wine.setWine_distance(rs.getString("wine_distance"));
				list.add(wine);
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
