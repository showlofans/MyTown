package com.mycountry.add;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mycountry.util.DB;

public class AddWine {
	Connection conn = null;
	DB db = new DB();
	private String wine_title; // 标题
	private String wine_name;// 村庄名
	private String wine_content; // 详情
	private String wine_picture;// 图片
	private String wine_time;// 上传时间
	private String wine_price;// 价钱
	private String wine_sales;// 销量


	public String getWine_title() {
		return wine_title;
	}

	public void setWine_title(String wine_title) {
		this.wine_title = wine_title;
	}

	public String getWine_name() {
		return wine_name;
	}

	public void setWine_name(String wine_name) {
		this.wine_name = wine_name;
	}

	public String getWine_content() {
		return wine_content;
	}

	public void setWine_content(String wine_content) {
		this.wine_content = wine_content;
	}

	public String getWine_picture() {
		return wine_picture;
	}

	public void setWine_picture(String wine_picture) {
		this.wine_picture = wine_picture;
	}

	public String getWine_time() {
		return wine_time;
	}

	public void setWine_time(String wine_time) {
		this.wine_time = wine_time;
	}
	public String getWine_price() {
		return wine_price;
	}

	public void setWine_price(String wine_price) {
		this.wine_price = wine_price;
	}

	public String getWine_sales() {
		return wine_sales;
	}

	public void setWine_sales(String wine_sales) {
		this.wine_sales = wine_sales;
	}
	public AddWine() {

		conn = db.getConn();
	}

	/**
	 * 添加学生信息
	 * 
	 * @param ganhuo
	 * @param password
	 * @return
	 */
	public String Add_Wine(String wine_type,String wine_sales, String wine_title, String wine_content,
			String wine_picture, String wine_time,String wine_price) {

		String flag2 = existWine(wine_title);	
		if (flag2.equals("notexist")) {
			String sql = "Insert into wine(wcountry_name,wine_sales, wine_title,wine_content ,wine_picture,wine_time,wine_price) values(";
			sql = sql+"'"+wine_type+"','"+wine_sales+"','"+wine_title+"',"+"'"+wine_content+"',"+"'"+wine_picture+"',"+"'"+wine_time+"',"+"'"+wine_price+"')";
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

	public String existWine(String wine_title) {
		String sqla = "select * from  wine where wine_title ='"+wine_title+"'";
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
