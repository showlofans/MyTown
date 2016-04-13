package com.mycountry.service;

import java.sql.*;
import java.util.*;
import com.mycountry.domain.Culture;
import com.mycountry.util.ConnectionFactory;

public class CultureService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Culture> find() {
		try {
			ArrayList<Culture> list = new ArrayList<Culture>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by culture_id desc) as id from culture");
			// sql.append(" where note_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Culture culture = null;
			while (rs.next()) {
				culture = new Culture();
				culture.setCulture_id(rs.getInt("culture_id"));
				culture.setCulture_title(rs.getString("culture_title"));
				culture.setCountry_name(rs.getString("country_name"));
				culture.setCulture_content(rs.getString("culture_content"));
				culture.setCulture_picture(rs.getString("culture_picture"));
				culture.setCulture_time(rs.getString("culture_time"));
				list.add(culture);
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
