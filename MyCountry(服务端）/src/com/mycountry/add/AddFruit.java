package com.mycountry.add;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mycountry.util.DB;

public class AddFruit {
	Connection conn = null;
	DB db = new DB();
	private String fromtype;
	private String fruit_type;
	private String fruit_title; // ����
	private String fruit_content; // ����
	private String fruit_sales;// ����
	private String fruit_picture;// ͼƬ
	private String fruit_time;// �ϴ�ʱ��
	private String fruit_price;// ��Ǯ

	public String getFruit_type() {
		return fruit_type;
	}

	public void setFruit_type(String fruit_type) {
		this.fruit_type = fruit_type;
	}

	public String getFromtype() {
		return fromtype;
	}

	public void setFromtype(String fromtype) {
		this.fromtype = fromtype;
	}

	public String getFruit_title() {
		return fruit_title;
	}

	public void setFruit_title(String fruit_title) {
		this.fruit_title = fruit_title;
	}

	public String getFruit_content() {
		return fruit_content;
	}

	public void setFruit_content(String fruit_content) {
		this.fruit_content = fruit_content;
	}

	public String getFruit_sales() {
		return fruit_sales;
	}

	public void setFruit_sales(String fruit_sales) {
		this.fruit_sales = fruit_sales;
	}

	public String getFruit_picture() {
		return fruit_picture;
	}

	public void setFruit_picture(String fruit_picture) {
		this.fruit_picture = fruit_picture;
	}

	public String getFruit_time() {
		return fruit_time;
	}

	public void setFruit_time(String fruit_time) {
		this.fruit_time = fruit_time;
	}

	public String getFruit_price() {
		return fruit_price;
	}

	public void setFruit_price(String fruit_price) {
		this.fruit_price = fruit_price;
	}

	public AddFruit() {

		conn = db.getConn();
	}

	/**
	 * ���ѧ����Ϣ
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public String Add_Fruit(String fruit_type, String fruit_sales,
			String fruit_title, String fruit_content, String fruit_picture,
			String fruit_time, String fruit_price) {

		String flag2 = existFruit(fruit_title);
		if (flag2.equals("notexist")) {
			String sql = "Insert into fruit(country_name,fruit_sales,fruit_title,fruit_content,fruit_picture,fruit_time,fruit_price) values(";
			sql = sql+"'"+fruit_type+"','"+fruit_sales+"','"+fruit_title+"',"+"'"+fruit_content+"',"+"'"+fruit_picture+"',"+"'"+fruit_time+"',"+"'"+fruit_price+"')";
			System.out.println(sql);
			try {
				db.execUpdate(sql);
				flag2 = "sucess";
			} catch (Exception e) {         
				e.printStackTrace();
				flag2 = "error";
			}
		} else {
			flag2 = "exist";
		}
		return flag2;
	}

	/**
	 * �ж�ѧ���Ƿ�����ظ���¼
	 */

	public String existFruit(String fruit_title) {
		String sqla ="select * from  fruit where fruit_title ='"+fruit_title+"'";
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
	// /�޸�Ա����Ϣ
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
	 * // ɾ��Ա����Ϣ
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
