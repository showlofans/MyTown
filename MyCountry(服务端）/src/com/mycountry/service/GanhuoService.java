package com.mycountry.service;

import java.sql.*;
import java.util.*;

import javax.naming.ldap.Rdn;

import com.mycountry.domain.Fruit;
import com.mycountry.domain.Ganhuo;
import com.mycountry.util.ConnectionFactory;

public class GanhuoService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Ganhuo> find() {
		try {
			ArrayList<Ganhuo> list = new ArrayList<Ganhuo>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by ganhuo_id desc) as id from ganhuo");
			// sql.append(" where Ganhuo_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Ganhuo ganhuo = null;
			while (rs.next()) {
				ganhuo = new Ganhuo();
				ganhuo.setGanhuo_id(rs.getInt("ganhuo_id"));
				ganhuo.setGanhuo_title(rs.getString("ganhuo_title"));
				ganhuo.setGanhuo_content(rs.getString("ganhuo_content"));
				ganhuo.setCountry_name(rs.getString("country_name"));
				ganhuo.setGanhuo_picture(rs.getString("ganhuo_picture"));
				ganhuo.setGanhuo_time(rs.getString("ganhuo_time"));
				ganhuo.setGanhuo_price(rs.getString("ganhuo_price"));
				ganhuo.setGanhuo_sales(rs.getString("ganhuo_sales"));
				ganhuo.setGanhuo_distance(rs.getString("ganhuo_distance"));
				list.add(ganhuo);
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
	public ArrayList<Ganhuo> Serch(String str) {
		try {
			ArrayList<Ganhuo> list = new ArrayList<Ganhuo>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from ganhuo where ganhuo_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Ganhuo ganhuo = null;
			while (rs.next()) {
				ganhuo = new Ganhuo();
				ganhuo.setGanhuo_id(rs.getInt("ganhuo_id"));
				ganhuo.setGanhuo_title(rs.getString("ganhuo_title"));
				ganhuo.setGanhuo_content(rs.getString("ganhuo_content"));
				ganhuo.setCountry_name(rs.getString("country_name"));
				ganhuo.setGanhuo_picture(rs.getString("ganhuo_picture"));
				ganhuo.setGanhuo_time(rs.getString("ganhuo_time"));
				ganhuo.setGanhuo_price(rs.getString("ganhuo_price"));
				ganhuo.setGanhuo_sales(rs.getString("ganhuo_sales"));
				ganhuo.setGanhuo_distance(rs.getString("ganhuo_distance"));
				list.add(ganhuo);
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
