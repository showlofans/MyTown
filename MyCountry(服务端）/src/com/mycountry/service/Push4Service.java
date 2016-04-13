package com.mycountry.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycountry.domain.Push3;
import com.mycountry.domain.Push4;
import com.mycountry.util.ConnectionFactory;

public class Push4Service {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet;
	public ArrayList<Push4>find(){
		try {
			ArrayList<Push4> list = new ArrayList<Push4>();
			connection = ConnectionFactory.getConnection();
			StringBuffer sqlBuffer = new StringBuffer();
			sqlBuffer.append("select *,row_number() over (order by push4_id desc) as id from push4");
			preparedStatement = connection.prepareStatement(sqlBuffer.toString());
			resultSet = preparedStatement.executeQuery();
			Push4 push4 = null;
			
			while (resultSet.next()) {
				push4 = new Push4();
				push4.setPush4_id(resultSet.getInt("push4_id"));
				push4.setCountry_name(resultSet.getString("country_name"));
				push4.setPush4_picture(resultSet.getString("push4_picture"));
				push4.setPush4_title(resultSet.getString("push4_title"));
				push4.setPush4_content(resultSet.getString("push4_content"));
				push4.setPush4_sales(resultSet.getString("push4_sales"));
				push4.setPush4_price(resultSet.getString("push4_price"));
				push4.setPush4_distance(resultSet.getString("push4_distance"));
				push4.setPush4_time(resultSet.getString("push4_time"));
				list.add(push4);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(connection, preparedStatement, resultSet);
		}
		return null;
	}

	public ArrayList<Push4> Serch(String str) {
		try {
			ArrayList<Push4> list = new ArrayList<Push4>();
			connection = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from push4 where push4_title like  '");
			sql.append(str);
			sql.append("%'");
			preparedStatement = connection.prepareStatement(sql.toString());// ִ��SQL
			resultSet = preparedStatement.executeQuery();
			Push4 push4 = null;
			while (resultSet.next()) {
				push4 = new Push4();
				push4.setPush4_id(resultSet.getInt("push4_id"));
				push4.setCountry_name(resultSet.getString("country_name"));
				push4.setPush4_picture(resultSet.getString("push4_picture"));
				push4.setPush4_title(resultSet.getString("push4_title"));
				push4.setPush4_content(resultSet.getString("push4_content"));
				push4.setPush4_sales(resultSet.getString("push4_sales"));
				push4.setPush4_price(resultSet.getString("push4_price"));
				push4.setPush4_distance(resultSet.getString("push4_distance"));
				push4.setPush4_time(resultSet.getString("push4_time"));
				list.add(push4);
			}
			if (list.equals("")) {
				return null;
			} else {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(connection, preparedStatement, resultSet);
		}
		return null;
	}
	
}
