package com.mycountry.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.mycountry.domain.GreenFoodPicture;
import com.mycountry.util.ConnectionFactory;

public class GreenFoodPictureService {
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs;

	public ArrayList<GreenFoodPicture> find() {
		try {
			ArrayList<GreenFoodPicture> list = new ArrayList<GreenFoodPicture>();
			conn = ConnectionFactory.getConnection();// 开始连接
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by picture_id desc) as id from greenFood_picture");
			pstm = conn.prepareStatement(sql.toString());// 执行SQL
			rs = pstm.executeQuery();
			GreenFoodPicture greenFoodPicture = null;
			while (rs.next()) {
				greenFoodPicture = new GreenFoodPicture();
				greenFoodPicture.setPicture_id(rs.getInt("picture_id"));
				greenFoodPicture.setCountry_name(rs.getString("country_name"));
				greenFoodPicture.setPicture_title(rs.getString("picture_title"));
				greenFoodPicture.setPicture_content(rs.getString("picture_content"));
				greenFoodPicture.setPicture_picture(rs.getString("picture_picture"));
				greenFoodPicture.setPicture_sales(rs.getString("picture_sales"));
				greenFoodPicture.setPicture_price(rs.getString("picture_price"));
				greenFoodPicture.setPicture_distance(rs.getString("picture_distance"));
				greenFoodPicture.setPicture_time(rs.getString("picture_time"));
				list.add(greenFoodPicture);
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
