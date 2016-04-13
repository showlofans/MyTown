package com.mycountry.add;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mycountry.util.DB;

public class AddTour {
	Connection conn = null;
	DB db = new DB();
	private String tour_title; // 标题
	private String tour_content; // 详情
	private String tour_picture;//图片
	private String tour_time;//上传时间
	private String tour_price;//价钱
	private String tour_sales;//销量
	
	public String getTour_title() {
		return tour_title;
	}

	public void setTour_title(String tour_title) {
		this.tour_title = tour_title;
	}

	public String getTour_content() {
		return tour_content;
	}

	public void setTour_content(String tour_content) {
		this.tour_content = tour_content;
	}
	public String getTour_picture() {
		return tour_picture;
	}

	public void setTour_picture(String tour_picture) {
		this.tour_picture = tour_picture;
	}
	public String getTour_time() {
		return tour_time;
	}

	public void setTour_time(String tour_time) {
		this.tour_time = tour_time;
	}
	public String getTour_price() {
		return tour_price;
	}

	public void setTour_price(String tour_price) {
		this.tour_price = tour_price;
	}
	public String getTour_sales() {
		return tour_sales;
	}

	public void setTour_sales(String tour_sales) {
		this.tour_sales = tour_sales;
	}
	public AddTour(){
		conn=db.getConn();
	}
	/**
	 * 添加学生信息
	 * 
	 * @param tour
	 * @param password
	 * @return
	 */
	public String Add_Tour(String tour_type,String tour_sales, String tour_title, String tour_content,
			String tour_picture, String tour_time,String tour_price) {

		String flag2 = existTour(tour_title);	
		if (flag2.equals("notexist")) {
			String sql = "Insert into tour(tcountry_name,tour_sales,tour_title,tour_content ,tour_picture,tour_time,tour_price) values(";
			sql = sql+"'"+tour_type+"','"+tour_sales+"','"+tour_title+"',"+"'"+tour_content+"',"+"'"+tour_picture+"',"+"'"+tour_time+"',"+"'"+tour_price+"')";
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

	public String existTour(String tour_title) {
		String sqla = "select * from  tour where tour_title ='"+tour_title+"'";
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
