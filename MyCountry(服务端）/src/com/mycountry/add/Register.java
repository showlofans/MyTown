package com.mycountry.add;

import java.sql.*;

import com.mycountry.util.DB;

public class Register {

	Connection conn = null;
	DB db = new DB();
	private String name;
	private String userpwd;
	private String usertype;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public Register() {

		conn = db.getConn();
	}

	/**
	 * 娣诲姞瀛︾敓淇℃伅
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String Add_Worker(String name, String userpwd, String usertype) {

		String flag2 = existWorker(name);
		if (flag2.equals("notexist")) {
			String sql = "Insert into userinfo(username,userpwd,usertype) values(";
			sql = sql + "'" + name + "'," + "'" + userpwd + "'," + "'"
					+ usertype + "')";
			// System.out.println(sql);
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
	 * 鍒ゆ柇瀛︾敓鏄惁瀛樺湪閲嶅璁板綍
	 */

	public String existWorker(String name) {
		String sqla = "select * from  userinfo   where username ='" + name
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
	// /淇敼鍛樺伐淇℃伅
	public String mod_Worker(int workid, String name, String sex,
			String telephone, String email) {

		String flag2 = "";
		String sql = "update td_employees set name='" + name + "', sex='" + sex
				+ "', telephone='" + telephone + "', email='" + email
				+ "' where _id='" + workid + "'";
		try {
			db.execUpdate(sql);
			flag2 = "sucess";
		} catch (Exception e) {
			e.printStackTrace();
			flag2 = "error";
		}

		return flag2;
	}

	// 鍒犻櫎鍛樺伐淇℃伅

	public String delete_Worker(int workid) {

		String flag2 = "";
		String sql = "delete td_employees where _id='" + workid + "'";
		try {
			db.execUpdate(sql);
			flag2 = "sucess";
		} catch (Exception e) {
			e.printStackTrace();
			flag2 = "error";
		}

		return flag2;
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
