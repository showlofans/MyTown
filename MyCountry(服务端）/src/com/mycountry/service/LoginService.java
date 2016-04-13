package com.mycountry.service;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mycountry.util.ConnectionFactory;



public class LoginService {
	public boolean login(String username,String userpwd) 
	{
		boolean b = false;
		ConnectionFactory getConn=new ConnectionFactory();
		ResultSet rs = null;
		Connection conn=getConn.getConnection();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from userinfo where username=? and userpwd=?");
			ps.setString(1,username);
			ps.setString(2,userpwd);
			rs=ps.executeQuery();
			if (rs.next())
			{
				b=true;
			}
			else
			{
				b=false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

}
