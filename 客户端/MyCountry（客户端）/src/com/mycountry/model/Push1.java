package com.mycountry.model;

import java.io.Serializable;

public class Push1 implements Serializable {

	//private Integer push1_id;
	private String country_name;
	private String push1_title;
	private String push1_content;
	private String push1_sales;
	private String push1_price;
	private String push1_distance;
	//private String push1_time;
	private byte[] push1_picture;

	/*public Integer getPush1_id() {
		return push1_id;
	}

	public void setPush1_id(Integer push1_id) {
		this.push1_id = push1_id;
	}
*/
	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getPush1_title() {
		return push1_title;
	}

	public void setPush1_title(String push1_title) {
		this.push1_title = push1_title;
	}

	public String getPush1_content() {
		return push1_content;
	}

	public void setPush1_content(String push1_content) {
		this.push1_content = push1_content;
	}

	public String getPush1_sales() {
		return push1_sales;
	}

	public void setPush1_sales(String push1_sales) {
		this.push1_sales = push1_sales;
	}

	public String getPush1_price() {
		return push1_price;
	}

	public void setPush1_price(String push1_price) {
		this.push1_price = push1_price;
	}

	public String getPush1_distance() {
		return push1_distance;
	}

	public void setPush1_distance(String push1_distance) {
		this.push1_distance = push1_distance;
	}

/*	public String getPush1_time() {
		return push1_time;
	}

	public void setPush1_time(String push1_time) {
		this.push1_time = push1_time;
	}
*/
	public byte[] getPush1_picture() {
		return push1_picture;
	}

	public void setPush1_picture(byte[] push1_picture) {
		this.push1_picture = push1_picture;
	}

	public Push1(String country_name, String push1_title, String push1_content,
			String push1_sales, String push1_price, String push1_distance,
			byte[] push1_picture) {
		super();
		this.country_name = country_name;
		this.push1_content = push1_content;
		this.push1_sales = push1_sales;
		this.push1_price = push1_price;
		this.push1_distance = push1_distance;
		this.push1_picture = push1_picture;
		this.push1_title = push1_title;
	}
}
