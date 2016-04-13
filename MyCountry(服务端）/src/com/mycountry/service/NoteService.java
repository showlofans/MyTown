package com.mycountry.service;

import java.sql.*;
import java.util.*;
import com.mycountry.domain.Note;
import com.mycountry.util.ConnectionFactory;

public class NoteService {
	// �������Ӷ���
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;

	public ArrayList<Note> find() {
		try {
			ArrayList<Note> list = new ArrayList<Note>();
			conn = ConnectionFactory.getConnection();// ��ʼ����
			StringBuffer sql = new StringBuffer();
			sql.append("select *,row_number() over (order by note_id desc) as id from note");
			// sql.append(" where note_id=?  ");
			pstm = conn.prepareStatement(sql.toString());// ִ��SQL
			rs = pstm.executeQuery();
			Note note = null;
			while (rs.next()) {
				note = new Note();
				// note.setNote_id(rs.getInt("note_id"));
				note.setNote_title(rs.getString("note_title"));
				note.setNote_content(rs.getString("note_content"));
				note.setNote_picture(rs.getString("note_picture"));
				note.setNote_time(rs.getString("note_time"));
				list.add(note);
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
}
