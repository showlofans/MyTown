package com.mycountry.add;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mycountry.util.DB;

public class AddLiangyou {
	Connection conn = null;
	DB db = new DB();
	private String liangyou_title; // 标题
	private String liangyou_content; // 详情
	private String liangyou_picture;//图片
	private String liangyou_time;//上传时间
	private String liangyou_price;//图片
	private String liangyou_sales;//上传时间

	public String getliangyou_title() {
		return liangyou_title;
	}

	public void setLiangyou_title(String liangyou_title) {
		this.liangyou_title = liangyou_title;
	}

	public String getLiangyou_content() {
		return liangyou_content;
	}

	public void setLiangyou_content(String liangyou_content) {
		this.liangyou_content = liangyou_content;
	}
	public String getLiangyou_picture() {
		return liangyou_picture;
	}

	public void setLiangyou_picture(String liangyou_picture) {
		this.liangyou_picture = liangyou_picture;
	}
	public String getLiangyou_time() {
		return liangyou_time;
	}

	public void setLiangyou_time(String liangyou_time) {
		this.liangyou_time = liangyou_time;
	}
	public String getLiangyou_price() {
		return liangyou_price;
	}

	public void setLiangyou_price(String liangyou_price) {
		this.liangyou_price = liangyou_price;
	}
	public String getLiangyou_sales() {
		return liangyou_sales;
	}

	public void setLiangyou_sales(String liangyou_sales) {
		this.liangyou_sales = liangyou_sales;
	}
	
	public AddLiangyou() {

		conn = db.getConn();
	}

	/**
	 * 添加学生信息
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String Add_Liangyou(String liangyou_type,String liangyou_sales, String liangyou_title, String liangyou_content,
			String liangyou_picture, String liangyou_time,String liangyou_price) {

		String flag2 = existLiangyou(liangyou_title);	
		if (flag2.equals("notexist")) {
			String sql = "Insert into liangyou(lcountry_name,liangyou_sales,liangyou_title,liangyou_content ,liangyou_picture,liangyou_time,liangyou_price) values(";
			sql = sql+"'"+liangyou_type+"','"+liangyou_sales+"','"+liangyou_title+"',"+"'"+liangyou_content+"',"+"'"+liangyou_picture+"',"+"'"+liangyou_time+"',"+"'"+liangyou_price+"')";
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

	public String existLiangyou(String liangyou_title) {
		String sqla = "select * from  liangyou where liangyou_title ='"+liangyou_title+"'";
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




}
