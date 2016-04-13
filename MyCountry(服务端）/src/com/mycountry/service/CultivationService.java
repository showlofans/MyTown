package com.mycountry.service;

import java.sql.*;
import java.util.*;
import com.mycountry.domain.Cultivation;
import com.mycountry.util.ConnectionFactory;

public class CultivationService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Cultivation> find() {
		try {
			ArrayList<Cultivation> list = new ArrayList<Cultivation>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by cultivation_id desc) as id from cultivation");
			// sql.append(" where note_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Cultivation cultivation = null;
			while (rs.next()) {
				cultivation = new Cultivation();
				cultivation.setCultivation_id(rs.getInt("cultivation_id"));
				cultivation.setCultivation_title(rs
						.getString("cultivation_title"));
				cultivation.setCcountry_name(rs.getString("ccountry_name"));
				cultivation.setCultivation_content(rs
						.getString("cultivation_content"));
				cultivation.setCultivation_picture(rs
						.getString("cultivation_picture"));
				cultivation.setCultivation_time(rs
						.getString("cultivation_time"));
				list.add(cultivation);
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
