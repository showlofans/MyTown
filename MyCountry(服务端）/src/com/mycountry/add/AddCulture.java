package com.mycountry.add;

import java.sql.*;

import com.mycountry.util.DB;

public class AddCulture {

	Connection conn = null;
	DB db = new DB();
	private String culture_title;
	private String culture_content;
	private String culture_time;
	private String culture_picture;

	

	public String getCulture_title() {
		return culture_title;
	}

	public void setCulture_title(String culture_title) {
		this.culture_title = culture_title;
	}

	public String getCulture_content() {
		return culture_content;
	}

	public void setCulture_content(String culture_content) {
		this.culture_content = culture_content;
	}

	public String getCulture_time() {
		return culture_time;
	}

	public void setCulture_time(String culture_time) {
		this.culture_time = culture_time;
	}

	public String getCulture_picture() {
		return culture_picture;
	}

	public void setCulture_picture(String culture_picture) {
		this.culture_picture = culture_picture;
	}

	public AddCulture() {

		conn = db.getConn();
	}

	/**
	 * 添加信息
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String Add_Culture(String culture_title, String culture_content,
			String culture_picture, String culture_time) {

		String flag2 = existCulture(culture_title);
		if (flag2.equals("culturexist")) {
			String sql = "Insert into culture(culture_title,culture_content ,culture_picture,culture_time)values(";
			sql = sql+"'"+culture_title+"',"+"'"+culture_content+"',"+"'"+culture_picture+"',"+"'"+culture_time+"')";
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

	public String existCulture(String culture_title) {
		String sqla = "select * from  culture where culture_title ='" + culture_title
				+ "'";
		String f = "culturexist";
		ResultSet rs = null;
		try {
			rs = db.execSelect(sqla);
			if (rs.next()) {
				f = "exist";
			}

		} catch (Exception e) {
			e.printStackTrace();
			f = "culturexist";

		}
		return f;
	}


	public void setConnClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}

	}

}
