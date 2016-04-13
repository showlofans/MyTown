package com.mycountry.model;

import java.io.Serializable;

public class Push2 implements Serializable {

	//private Integer push2_id;
	private String push2_content;
	private String push2_sales;
	private String push2_price;
	private String push2_distance;
	private String country_name;
	//private String push2_time;
	private byte[] push2_picture;
	private String push2_title;

	/*public Integer getPush2_id() {
		return push2_id;
	}

	public void setPush2_id(Integer push2_id) {
		this.push2_id = push2_id;
	}*/

	public String getPush2_content() {
		return push2_content;
	}

	public void setPush2_content(String push2_content) {
		this.push2_content = push2_content;
	}

	public String getPush2_sales() {
		return push2_sales;
	}

	public void setPush2_sales(String push2_sales) {
		this.push2_sales = push2_sales;
	}

	public String getPush2_price() {
		return push2_price;
	}

	public void setPush2_price(String push2_price) {
		this.push2_price = push2_price;
	}

	public String getPush2_distance() {
		return push2_distance;
	}

	public void setPush2_distance(String push2_distance) {
		this.push2_distance = push2_distance;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

/*	public String getPush2_time() {
		return push2_time;
	}

	public void setPush2_time(String push2_time) {
		this.push2_time = push2_time;
	}*/

	public byte[] getPush2_picture() {
		return push2_picture;
	}

	public void setPush2_picture(byte[] push2_picture) {
		this.push2_picture = push2_picture;
	}

	public String getPush2_title() {
		return push2_title;
	}

	public void setPush2_title(String push2_title) {
		this.push2_title = push2_title;
	}

	public Push2(String push2_title, String push2_content, String push2_sales,
			String push2_price, String push2_distance, String country_name,
			byte[] push2_picture) {
		super();
		this.country_name = country_name;
		this.push2_content = push2_content;
		this.push2_sales = push2_sales;
		this.push2_price = push2_price;
		this.push2_distance = push2_distance;
		this.push2_picture = push2_picture;
		this.push2_title = push2_title;
	}
}
