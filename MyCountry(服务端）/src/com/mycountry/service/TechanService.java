package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Fruit;
import com.mycountry.domain.Techan;
import com.mycountry.util.ConnectionFactory;



public class TechanService {
	// �������Ӷ���
		private Connection conn = null;
		private PreparedStatement pstm = null;
		private ResultSet rs = null;

	public ArrayList<Techan> find() {
		try {
			ArrayList<Techan> list = new ArrayList<Techan>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by techan_id desc) as id from techan");
			//sql.append(" where techan_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Techan techan = null;
			while (rs.next()) {
				techan = new Techan();
				techan.setTechan_id(rs.getInt("techan_id"));
				techan.setTechan_title(rs.getString("techan_title"));
				techan.setTechan_content(rs.getString("techan_content"));
				techan.setTechan_picture(rs.getString("techan_picture"));
				techan.setTechan_time(rs.getString("techan_time"));
				techan.setTechan_price(rs.getString("techan_price"));
				techan.setTechan_sales(rs.getString("techan_sales"));
				techan.setTechan_distance(rs.getString("techan_distance"));
				list.add(techan);
			}
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}

	public ArrayList<Techan> Serch(String str) {
		try {
			ArrayList<Techan> list = new ArrayList<Techan>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from techan where techan_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Techan techan = null;
			while (rs.next()) {
				techan = new Techan();
				techan.setTechan_id(rs.getInt("techan_id"));
				techan.setTechan_title(rs.getString("techan_title"));
				techan.setTechan_content(rs.getString("techan_content"));
				techan.setTechan_picture(rs.getString("techan_picture"));
				techan.setTechan_time(rs.getString("techan_time"));
				techan.setTechan_price(rs.getString("techan_price"));
				techan.setTechan_sales(rs.getString("techan_sales"));
				techan.setTechan_distance(rs.getString("techan_distance"));
				list.add(techan);
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
	/*public static void main(String[] args) {
		NoteService dao = new NoteService();
		List<Note> list = dao.find("1");
		Note model = new Note();
	//	model = list.get(1);
	//	String x = model.getNote_title();
		System.out.println(list);*/

	
	}


