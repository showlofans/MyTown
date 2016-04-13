package com.mycountry.service;

import java.sql.*;
import java.util.*;
import com.mycountry.domain.Join;
import com.mycountry.util.ConnectionFactory;

public class JoinService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Join> find() {
		try {
			ArrayList<Join> list = new ArrayList<Join>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by join_id desc) as id from join");
			// sql.append(" where note_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Join join = null;
			while (rs.next()) {
				join = new Join();
				join.setJoin_id(rs.getInt("join_id"));
				join.setJoin_title(rs.getString("join_title"));
				join.setJoin_content(rs.getString("join_content"));
				join.setJoin_picture(rs.getString("join_picture"));
				join.setJoin_time(rs.getString("join_time"));
				list.add(join);
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
