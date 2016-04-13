package com.mycountry.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycountry.domain.Push2;
import com.mycountry.domain.Push3;
import com.mycountry.util.ConnectionFactory;

public class Push3Service {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet;
	public ArrayList<Push3>find(){
		try {
			ArrayList<Push3> list = new ArrayList<Push3>();
			connection = ConnectionFactory.getConnection();
			StringBuffer sqlBuffer = new StringBuffer();
			sqlBuffer.append("select *,row_number() over (order by push3_id desc) as id from push3");
			preparedStatement = connection.prepareStatement(sqlBuffer.toString());
			resultSet = preparedStatement.executeQuery();
			Push3 push3 = null;
			
			while (resultSet.next()) {
				push3 = new Push3();
				push3.setPush3_id(resultSet.getInt("push3_id"));
				push3.setCountry_name(resultSet.getString("country_name"));
				push3.setPush3_picture(resultSet.getString("push3_picture"));
				push3.setPush3_title(resultSet.getString("push3_title"));
				push3.setPush3_content(resultSet.getString("push3_content"));
				push3.setPush3_sales(resultSet.getString("push3_sales"));
				push3.setPush3_price(resultSet.getString("push3_price"));
				push3.setPush3_distance(resultSet.getString("push3_distance"));
				push3.setPush3_time(resultSet.getString("push3_time"));
				list.add(push3);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(connection, preparedStatement, resultSet);
		}
		return null;
	}

	public ArrayList<Push3> Serch(String str) {
		try {
			ArrayList<Push3> list = new ArrayList<Push3>();
			connection = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from push3 where push3_title like  '");
			sql.append(str);
			sql.append("%'");
			preparedStatement = connection.prepareStatement(sql.toString());// ִ��SQL
			resultSet = preparedStatement.executeQuery();
			Push3 push3 = null;
			while (resultSet.next()) {
				push3 = new Push3();
				push3.setPush3_id(resultSet.getInt("push3_id"));
				push3.setCountry_name(resultSet.getString("country_name"));
				push3.setPush3_picture(resultSet.getString("push3_picture"));
				push3.setPush3_title(resultSet.getString("push3_title"));
				push3.setPush3_content(resultSet.getString("push3_content"));
				push3.setPush3_sales(resultSet.getString("push3_sales"));
				push3.setPush3_price(resultSet.getString("push3_price"));
				push3.setPush3_distance(resultSet.getString("push3_distance"));
				push3.setPush3_time(resultSet.getString("push3_time"));
				list.add(push3);
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
