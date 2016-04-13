package com.mycountry.service;

import java.sql.*;
import java.util.*;

import com.mycountry.domain.Fruit;
import com.mycountry.domain.Group;
import com.mycountry.util.ConnectionFactory;



public class GroupService {
	// �������Ӷ���
		private Connection conn = null;
		private PreparedStatement pstm = null;
		private ResultSet rs = null;

	public ArrayList<Group> find() {
		try {
			ArrayList<Group> list = new ArrayList<Group>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by group_id desc) as id from group");
			//sql.append(" where note_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Group group = null;
			while (rs.next()) {
				group = new Group();
				group.setGroup_id(rs.getInt("group_id"));
				group.setGroup_title(rs.getString("group_title"));
				//group.setGcountry_name(rs.getString("group_name"));
				group.setGroup_content(rs.getString("group_content"));
				group.setGroup_picture(rs.getString("group_picture"));
				group.setGroup_time(rs.getString("group_time"));
				list.add(group);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {// ��return֮ǰִ��
			ConnectionFactory.close(conn, pstm, rs);
		}
		return null;
	}

	public ArrayList<Group> Serch(String str) {
		try {
			ArrayList<Group> list = new ArrayList<Group>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select * from group where group_title like  '");
			sql.append(str);
			sql.append("%'");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Group group = null;
			while (rs.next()) {
				group = new Group();
				group.setGroup_id(rs.getInt("group_id"));
				group.setGroup_title(rs.getString("group_title"));
				//group.setGcountry_name(rs.getString("group_name"));
				group.setGroup_content(rs.getString("group_content"));
				group.setGroup_picture(rs.getString("group_picture"));
				group.setGroup_time(rs.getString("group_time"));
				list.add(group);
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


