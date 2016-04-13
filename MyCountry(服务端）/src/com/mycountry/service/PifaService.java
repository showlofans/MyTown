package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Pifa;
import com.mycountry.util.ConnectionFactory;

public class PifaService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Pifa> find() {
		try {
			ArrayList<Pifa> list = new ArrayList<Pifa>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by pifa_id desc) as id from pifa");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Pifa pifa = null;
			while (rs.next()) {
				pifa = new Pifa();
				pifa.setPifa_id(rs.getInt("pifa_id"));
				pifa.setPifa_title(rs.getString("pifa_title"));
				pifa.setPifa_content(rs.getString("pifa_content"));
				pifa.setPifa_picture(rs.getString("pifa_picture"));
				pifa.setPifa_time(rs.getString("pifa_time"));

				list.add(pifa);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}

}
