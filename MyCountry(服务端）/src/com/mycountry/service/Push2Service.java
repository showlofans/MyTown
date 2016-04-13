package com.mycountry.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycountry.domain.Fruit;
import com.mycountry.domain.Push2;
import com.mycountry.util.ConnectionFactory;

public class Push2Service {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet rs = null;

	public ArrayList<Push2> find() {
		try {
			ArrayList<Push2> list = new ArrayList<Push2>();
			connection = ConnectionFactory.getConnection();
			StringBuffer sqlBuffer = new StringBuffer();
			sqlBuffer
					.append("select *,row_number() over (order by push2_id desc) as id from push2");
			preparedStatement = connection.prepareStatement(sqlBuffer.toString());
			rs = preparedStatement.executeQuery();

			Push2 push2 = null;
			while (rs.next()) {
				push2 = new Push2();
				push2.setPush2_id(rs.getInt("push2_id"));
				push2.setCountry_name(rs.getString("country_name"));
				push2.setPush2_title(rs.getString("push2_title"));
				push2.setPush2_content(rs.getString("push2_content"));
				push2.setPush2_sales(rs.getString("push2_sales"));
				push2.setPush2_price(rs.getString("push2_price"));
				push2.setPush2_time(rs.getString("push2_time"));
				push2.setPush2_distance(rs.getString("push2_distance"));
				push2.setPush2_picture(rs.getString("push2_picture"));
				list.add(push2);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(connection, preparedStatement, rs);
		}
		return null;
	}
	public ArrayList<Push2> Serch(String str) {
		try {
			ArrayList<Push2> list = new ArrayList<Push2>();
			connection = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from push2 where push2_title like  '");
			sql.append(str);
			sql.append("%'");
			preparedStatement = connection.prepareStatement(sql.toString());// ִ��SQL
			rs = preparedStatement.executeQuery();
			Push2 push2 = null;
			while (rs.next()) {
				push2 = new Push2();
				push2.setPush2_id(rs.getInt("push2_id"));
				push2.setCountry_name(rs.getString("country_name"));
				push2.setPush2_title(rs.getString("push2_title"));
				push2.setPush2_content(rs.getString("push2_content"));
				push2.setPush2_sales(rs.getString("push2_sales"));
				push2.setPush2_price(rs.getString("push2_price"));
				push2.setPush2_time(rs.getString("push2_time"));
				push2.setPush2_distance(rs.getString("push2_distance"));
				push2.setPush2_picture(rs.getString("push2_picture"));
				list.add(push2);
			}
			if (list.equals("")) {
				return null;
			} else {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(connection, preparedStatement, rs);
		}
		return null;
	}
}
