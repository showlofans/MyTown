package com.mycountry.service;

import java.sql.*;
import java.util.*;
import com.mycountry.domain.User;
import com.mycountry.util.ConnectionFactory;

public class UserService {
	// 建立连接对象
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<User> find() {
		try {
			ArrayList<User> list = new ArrayList<User>();
			conn = ConnectionFactory.getConnection();// 开始连接
			StringBuffer sql = new StringBuffer();
			sql.append(" select * from user_info ");
			// sql.append(" where note_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// 执行SQL
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
		} finally {// 在return之前执行
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}

}
