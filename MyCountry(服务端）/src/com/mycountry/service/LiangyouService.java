package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Fruit;
import com.mycountry.domain.Liangyou;
import com.mycountry.util.ConnectionFactory;

public class LiangyouService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Liangyou> find() {
		try {
			ArrayList<Liangyou> list = new ArrayList<Liangyou>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by liangyou_id desc) as id from liangyou");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Liangyou liangyou = null;
			while (rs.next()) {
				liangyou = new Liangyou();
				liangyou.setLiangyou_id(rs.getInt("liangyou_id"));
				liangyou.setCountry_name(rs.getString("country_name"));
				liangyou.setLiangyou_title(rs.getString("liangyou_title"));
				liangyou.setLiangyou_content(rs.getString("liangyou_content"));
				liangyou.setLiangyou_picture(rs.getString("liangyou_picture"));
				liangyou.setLiangyou_time(rs.getString("liangyou_time"));
				liangyou.setLiangyou_price(rs.getString("liangyou_price"));
				liangyou.setLiangyou_sales(rs.getString("liangyou_sales"));
				liangyou.setLiangyou_distance(rs.getString("liangyou_distance"));
				list.add(liangyou);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}

	public ArrayList<Liangyou> Serch(String str) {
		try {
			ArrayList<Liangyou> list = new ArrayList<Liangyou>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from liangyou where liangyou_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Liangyou liangyou = null;
			while (rs.next()) {
				liangyou = new Liangyou();
				liangyou.setLiangyou_id(rs.getInt("liangyou_id"));
				liangyou.setCountry_name(rs.getString("country_name"));
				liangyou.setLiangyou_title(rs.getString("liangyou_title"));
				liangyou.setLiangyou_content(rs.getString("liangyou_content"));
				liangyou.setLiangyou_picture(rs.getString("liangyou_picture"));
				liangyou.setLiangyou_time(rs.getString("liangyou_time"));
				liangyou.setLiangyou_price(rs.getString("liangyou_price"));
				liangyou.setLiangyou_sales(rs.getString("liangyou_sales"));
				liangyou.setLiangyou_distance(rs.getString("liangyou_distance"));
				list.add(liangyou);
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
