package com.mycountry.add;

import java.sql.*;

import com.mycountry.util.DB;

public class AddNote {

	Connection conn = null;
	DB db = new DB();
	private String note_title;
	private String note_content;
	private String note_time;
	private String note_picture;

	public String getNote_title() {
		return note_title;
	}

	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}

	public String getNote_content() {
		return note_content;
	}

	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}

	public String getNote_time() {
		return note_time;
	}

	public void setNote_time(String note_time) {
		this.note_time = note_time;
	}

	public String getNote_picture() {
		return note_picture;
	}

	public void setNote_picture(String note_picture) {
		this.note_picture = note_picture;
	}

	public AddNote() {

		conn = db.getConn();
	}

	/**
	 * 添加信息
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String Add_Note(String note_title, String note_content,
			String note_picture, String note_time) {

		String flag2 = existNote(note_title);
		if (flag2.equals("notexist")) {
			String sql = "Insert into note(note_title,note_content ,note_picture,note_time)values(";
			sql = sql+"'"+note_title+"',"+"'"+note_content+"',"+"'"+note_picture+"',"+"'"+note_time+"')";
			System.out.println(sql);
			try {
				db.execUpdate(sql);
				flag2 = "sucess";
			} catch (Exception e) {
				e.printStackTrace();
				flag2 = "error";
			}
		} else
			flag2 = "exist";
		return flag2;
	}

	/**
	 * 判断是否存在重复记录
	 */

	public String existNote(String note_title) {
		String sqla = "select * from  note where note_title ='" + note_title
				+ "'";
		String f = "notexist";
		ResultSet rs = null;
		try {
			rs = db.execSelect(sqla);
			if (rs.next()) {
				f = "exist";
			}

		} catch (Exception e) {
			e.printStackTrace();
			f = "notexist";

		}
		return f;
	}

	/*********************************************/
	//
	// /修改员工信息
	/*
	 * public String mod_Worker(int workid, String name, String sex, String
	 * telephone, String email) {
	 * 
	 * String flag2 = ""; String sql = "update td_employees set name='" + name +
	 * "', sex='" + sex + "', telephone='" + telephone + "', email='" + email +
	 * "' where _id='" + workid + "'"; try { db.execUpdate(sql); flag2 =
	 * "sucess"; } catch (Exception e) { e.printStackTrace(); flag2 = "error"; }
	 * 
	 * return flag2; }
	 * 
	 * // 删除员工信息
	 * 
	 * public String delete_Worker(int workid) {
	 * 
	 * String flag2 = ""; String sql = "delete td_employees where _id='" +
	 * workid + "'"; try { db.execUpdate(sql); flag2 = "sucess"; } catch
	 * (Exception e) { e.printStackTrace(); flag2 = "error"; }
	 * 
	 * return flag2; }
	 */
	public void setConnClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}

	}

}
