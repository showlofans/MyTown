package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Fruit;
import com.mycountry.domain.Nongjia;
import com.mycountry.util.ConnectionFactory;

public class NongjiaService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Nongjia> find() {
		try {
			ArrayList<Nongjia> list = new ArrayList<Nongjia>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by nongjia_id desc) as id from nongjia");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Nongjia nongjia = null;
			while (rs.next()) {
				nongjia = new Nongjia();
				nongjia.setNongjia_id(rs.getInt("nongjia_id"));
				nongjia.setNongjia_title(rs.getString("nongjia_title"));
				nongjia.setNongjia_content(rs.getString("nongjia_content"));
				nongjia.setNongjia_picture(rs.getString("nongjia_picture"));
				nongjia.setNongjia_time(rs.getString("nongjia_time"));
				nongjia.setNongjia_price(rs.getString("nongjia_price"));
				nongjia.setNongjia_sales(rs.getString("nongjia_sales"));
				nongjia.setNongjia_distance(rs.getString("nongjia_distance"));
				nongjia.setCountry_name(rs.getString("country_name"));
				list.add(nongjia);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}

	public ArrayList<Nongjia> Serch(String str) {
		try {
			ArrayList<Nongjia> list = new ArrayList<Nongjia>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from nongjia where nongjia_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Nongjia nongjia = null;
			while (rs.next()) {
				nongjia = new Nongjia();
				nongjia.setNongjia_id(rs.getInt("nongjia_id"));
				nongjia.setNongjia_title(rs.getString("nongjia_title"));
				nongjia.setNongjia_content(rs.getString("nongjia_content"));
				nongjia.setNongjia_picture(rs.getString("nongjia_picture"));
				nongjia.setNongjia_time(rs.getString("nongjia_time"));
				nongjia.setNongjia_price(rs.getString("nongjia_price"));
				nongjia.setNongjia_sales(rs.getString("nongjia_sales"));
				nongjia.setNongjia_distance(rs.getString("nongjia_distance"));
				nongjia.setCountry_name(rs.getString("country_name"));
				list.add(nongjia);
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
