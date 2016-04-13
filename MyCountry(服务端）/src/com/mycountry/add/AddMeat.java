package com.mycountry.add;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mycountry.util.DB;

public class AddMeat {
	Connection conn = null;
	DB db = new DB();
	private String meat_title; // 标题
	//private String mcountry_name;//村庄名
	private String meat_content; // 详情
	private String meat_picture;//图片
	private String meat_time;//上传时间
	private String meat_price;//上传时间
	private String meat_sales;//上传时间

	public String getMeat_title() {
		return meat_title;
	}

	public void setMeat_title(String meat_title) {
		this.meat_title = meat_title;
	}
	
	/*public String getMcountry_name() {
		return mcountry_name;
	}

	public void setMcountry_name(String mcountry_name) {
		this.mcountry_name = mcountry_name;
	}*/

	public String getMeat_content() {
		return meat_content;
	}

	public void setMeat_content(String meat_content) {
		this.meat_content = meat_content;
	}
	public String getMeat_picture() {
		return meat_picture;
	}

	public void setMeat_picture(String meat_picture) {
		this.meat_picture = meat_picture;
	}
	public String getMeat_time() {
		return meat_time;
	}

	public void setMeat_time(String meat_time) {
		this.meat_time = meat_time;
	}
	public String getMeat_price() {
		return meat_price;
	}

	public void setMeat_price(String meat_price) {
		this.meat_price = meat_price;
	}
	public String getMeat_sales() {
		return meat_sales;
	}

	public void setMeat_sales(String meat_sales) {
		this.meat_sales = meat_sales;
	}
	public AddMeat(){
		conn=db.getConn();
	}
	/**
	 * 添加学生信息
	 * 
	 * @param meat
	 * @param password
	 * @return
	 */
	public String Add_Meat(String meat_type,String meat_sales, String meat_title, String meat_content,
			String meat_picture, String meat_time,String meat_price) {

		String flag2 = existMeat(meat_title);	
		if (flag2.equals("notexist")) {
			String sql = "Insert into meat(mcountry_name,meat_sales,meat_title,meat_content ,meat_picture,meat_time,meat_price) values(";
			sql = sql+"'"+meat_type+"','"+meat_sales+"','"+meat_title+"',"+"'"+meat_content+"',"+"'"+meat_picture+"',"+"'"+meat_time+"',"+"'"+meat_price+"')";
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

	public String existMeat(String meat_title) {
		String sqla = "select * from  meat where meat_title ='"+meat_title+"'";
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
