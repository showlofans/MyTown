package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Fruit;
import com.mycountry.domain.Green;
import com.mycountry.domain.Tour;
import com.mycountry.util.ConnectionFactory;

public class TourService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Tour> find() {
		try {
			ArrayList<Tour> list = new ArrayList<Tour>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by tour_id desc) as id from tour");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Tour tour = null;
			while (rs.next()) {
				tour = new Tour();
				tour.setTour_id(rs.getInt("tour_id"));
				tour.setTour_title(rs.getString("tour_title"));
				tour.setTour_content(rs.getString("tour_content"));
				tour.setTour_picture(rs.getString("tour_picture"));
				tour.setTour_time(rs.getString("tour_time"));
				tour.setTour_price(rs.getString("tour_price"));
				tour.setTour_sales(rs.getString("tour_sales"));
				tour.setTour_distance(rs.getString("tour_distance"));

				list.add(tour);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}
	
	public ArrayList<Tour> Serch(String str) {
		try {
			ArrayList<Tour> list = new ArrayList<Tour>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from tour where tour_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Tour tour = null;
			while (rs.next()) {
				tour = new Tour();
				tour.setTour_id(rs.getInt("tour_id"));
				tour.setTour_title(rs.getString("tour_title"));
				tour.setTour_content(rs.getString("tour_content"));
				tour.setTour_picture(rs.getString("tour_picture"));
				tour.setTour_time(rs.getString("tour_time"));
				tour.setTour_price(rs.getString("tour_price"));
				tour.setTour_sales(rs.getString("tour_sales"));
				tour.setTour_distance(rs.getString("tour_distance"));

				list.add(tour);
			}
			if (list.equals("")) {
				return null;
			} else {
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}
	// System.out.println(temp.);

	// str = temp.split(" ");
	// for(int i = 0 ; i < str.length ; i++){
	// System.out.println(str[i]);
	// }
	// System.out.println(str.length);
}
