package com.mycountry.add;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mycountry.util.DB;

public class AddTechan {
	Connection conn = null;
	DB db = new DB();
	private String techan_type;
	private String techan_title; // 标题
	private String techan_content; // 详情
	private String techan_picture;//图片
	private String techan_time;//上传时间
	private String techan_price;//价格
	private String techan_sales;//销量
	

	public String getTechan_type() {
		return techan_type;
	}

	public void setTechan_type(String techan_type) {
		this.techan_type = techan_type;
	}

	public String getTechan_title() {
		return techan_title;
	}

	public void setTechan_title(String techan_title) {
		this.techan_title = techan_title;
	}
	

	public String getTechan_content() {
		return techan_content;
	}

	public void setTechan_content(String techan_content) {
		this.techan_content = techan_content;
	}
	public String getTechan_picture() {
		return techan_picture;
	}

	public void setTechan_picture(String techan_picture) {
		this.techan_picture = techan_picture;
	}
	public String getTechan_time() {
		return techan_time;
	}

	public void setTechan_time(String techan_time) {
		this.techan_time = techan_time;
	}
	public String getTechan_price() {
		return techan_price;
	}

	public void setTechan_price(String techan_price) {
		this.techan_price = techan_price;
	}
	public String getTechan_sales() {
		return techan_sales;
	}

	public void setTechan_sales(String techan_sales) {
		this.techan_sales = techan_sales;
	}
	
	public AddTechan(){
		conn=db.getConn();
	}
	/**
	 * 添加学生信息
	 * 
	 * @param meat
	 * @param password
	 * @return
	 */
	public String Add_Techan(String techan_type, String techan_sales,String techan_title, String techan_content,
			String techan_picture, String techan_time,String techan_price) {

		String flag2 = existTechan(techan_title);	
		if (flag2.equals("notexist")) {
			String sql = "Insert into techan(tcountry_name,techan_title,techan_content ,techan_picture,techan_time,techan_price,techan_sales) values(";
			sql = sql+"'"+techan_type+"','"+techan_title+"',"+"'"+techan_content+"',"+"'"+techan_picture+"',"+"'"+techan_time+"',"+"'"+techan_price+"','"+techan_sales+"')";
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

	public String existTechan(String techan_title) {
		String sqla = "select * from  techan where techan_title ='"+techan_title+"'";
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
