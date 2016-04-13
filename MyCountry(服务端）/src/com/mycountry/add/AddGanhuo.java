package com.mycountry.add;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mycountry.util.DB;

public class AddGanhuo {
	Connection conn = null;
	DB db = new DB();
	private String ganhuo_type;
	private String ganhuo_title; // 标题
	private String ganhuo_content; // 详情
	private String ganhuo_picture;// 图片
	private String ganhuo_time;// 上传时间
	private String ganhuo_price;//价钱
	private String ganhuo_sales;//价钱
	
	//String ganhuo_title

	public String getGanhuo_title() {
		return ganhuo_title;
	}

	public void setGanhuo_title(String ganhuo_title) {
		this.ganhuo_title = ganhuo_title;
	}

	public String getGanhuo_content() {
		return ganhuo_content;
	}

	public void setGanhuo_content(String ganhuo_content) {
		this.ganhuo_content = ganhuo_content;
	}

	public String getGanhuo_picture() {
		return ganhuo_picture;
	}

	public void setGanhuo_picture(String ganhuo_picture) {
		this.ganhuo_picture = ganhuo_picture;
	}

	public String getGanhuo_time() {
		return ganhuo_time;
	}

	public void setGanhuo_time(String ganhuo_time) {
		this.ganhuo_time = ganhuo_time;
	}
	public String getGanhuo_price() {
		return ganhuo_price;
	}

	public void setGanhuo_price(String ganhuo_price) {
		this.ganhuo_price = ganhuo_price;
	}
	public String getGanhuo_sales() {
		return ganhuo_sales;
	}

	public void setGanhuo_sales(String ganhuo_sales) {
		this.ganhuo_sales = ganhuo_sales;
	}
	public AddGanhuo() {

		conn = db.getConn();
	}

	/**
	 * 添加学生信息
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String Add_Ganhuo(String ganhuo_type,String ganhuo_title,String ganhuo_content,String ganhuo_picture, 
			 String ganhuo_time,String ganhuo_price,String ganhuo_sales) {

		String flag2 = existGanhuo(ganhuo_title);	
		if (flag2.equals("notexist")) {
			String sql = "Insert into ganhuo(gcountry_name,ganhuo_title,ganhuo_content ,ganhuo_picture,ganhuo_time,ganhuo_price,ganhuo_sales) values(";
			sql = sql+"'"+ganhuo_type+"','"+ganhuo_title+"',"+"'"+ganhuo_content+"',"+"'"+ganhuo_picture+"',"+"'"+ganhuo_time+"',"+"'"+ganhuo_price+"',"+ganhuo_sales+"')";
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
	 * 判断学生是否存在重复记录
	 */

	public String existGanhuo(String ganhuo_title) {
		String sqla = "select * from  ganhuo where ganhuo_title ='"+ganhuo_title+"'";
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
	/*public String mod_Worker(int workid, String name, String sex,
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

	// 删除员工信息

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
*/
	public void setConnClose() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception ex) {
			}
		}

	}

	public String getGanhuo_type() {
		return ganhuo_type;
	}

	public void setGanhuo_type(String ganhuo_type) {
		this.ganhuo_type = ganhuo_type;
	}



}
