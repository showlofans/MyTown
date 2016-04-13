package com.mycountry.service;

import java.sql.*;
import java.util.*;
import com.mycountry.domain.User;
import com.mycountry.util.ConnectionFactory;

public class UserService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<User> find() {
		try {
			ArrayList<User> list = new ArrayList<User>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append(" select * from user_info ");
			// sql.append(" where note_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			User user = null;
			while (rs.next()) {
				user = new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setUser_type(rs.getString("user_type"));
				user.setUser_address(rs.getString("user_address"));	
				user.setUser_picture(rs.getString("user_picture"));
				user.setUser_email(rs.getString("user_email"));
				list.add(user);
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
