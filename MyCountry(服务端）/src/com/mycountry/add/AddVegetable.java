package com.mycountry.add;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mycountry.util.DB;

public class AddVegetable {
	Connection conn = null;
	DB db = new DB();
	private String vegetable_title; // 标题
	private String vegetable_content; // 详情
	private String vegetable_picture;// 图片
	private String vegetable_time;// 上传时间
	private String vegetable_price;// 上传时间
	private String vegetable_sales;// 销量

	public String getVegetable_title() {
		return vegetable_title;
	}

	public void setVegetable_title(String vegetable_title) {
		this.vegetable_title = vegetable_title;
	}
	public String getVegetable_content() {
		return vegetable_content;
	}

	public void setVegetable_content(String vegetable_content) {
		this.vegetable_content = vegetable_content;
	}

	public String getVegetable_picture() {
		return vegetable_picture;
	}

	public void setVegetable_picture(String vegetable_picture) {
		this.vegetable_picture = vegetable_picture;
	}

	public String getVegetable_time() {
		return vegetable_time;
	}

	public void setVegetable_time(String vegetable_time) {
		this.vegetable_time = vegetable_time;
	}
	public String getVegetable_price() {
		return vegetable_price;
	}

	public void setVegetable_price(String vegetable_price) {
		this.vegetable_price = vegetable_price;
	}
	public String getVegetable_sales() {
		return vegetable_sales;
	}

	public void setVegetable_sales(String vegetable_sales) {
		this.vegetable_sales = vegetable_sales;
	}

	public AddVegetable() {

		conn = db.getConn();
	}

	/**
	 * 添加学生信息
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String Add_Vegetable(String vegetable_type,String vegetable_title, String vegetable_content,
			String vegetable_picture, String vegetable_time,String vegetable_sales,String vegetable_price) {

		String flag2 = existVegetable(vegetable_title);	
		if (flag2.equals("notexist")) {
			String sql = "Insert into vegetable(vcountry_name,vegetable_title,vegetable_content ,vegetable_picture,vegetable_time,vegetable_sales,vegetable_price) values(";
			sql = sql+"'"+vegetable_type+"','"+vegetable_title+"',"+"'"+vegetable_content+"',"+"'"+vegetable_picture+"',"+"'"+vegetable_time+"',"+"'"+vegetable_sales+"',"+"'"+vegetable_price+"')";
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

	public String existVegetable(String vegetable_title) {
		String sqla = "select * from  vegetable where vegetable_title ='"+vegetable_title+"'";
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
