package com.mycountry.model;

import java.io.Serializable;

public class Push4 implements Serializable {

	private Integer push4_id;
	private String push4_content;
	private String push4_sales;
	private String push4_price;
	private String push4_distance;
	private String country_name;
	private String push4_time;
	private byte[] push4_picture;
	private String push4_title;

	public Integer getPush4_id() {
		return push4_id;
	}

	public void setPush4_id(Integer push4_id) {
		this.push4_id = push4_id;
	}

	public String getPush4_content() {
		return push4_content;
	}

	public void setPush4_content(String push4_content) {
		this.push4_content = push4_content;
	}

	public String getPush4_sales() {
		return push4_sales;
	}

	public void setPush4_sales(String push4_sales) {
		this.push4_sales = push4_sales;
	}

	public String getPush4_price() {
		return push4_price;
	}

	public void setPush4_price(String push4_price) {
		this.push4_price = push4_price;
	}

	public String getPush4_distance() {
		return push4_distance;
	}

	public void setPush4_distance(String push4_distance) {
		this.push4_distance = push4_distance;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getPush4_time() {
		return push4_time;
	}

	public void setPush4_time(String push4_time) {
		this.push4_time = push4_time;
	}

	public byte[] getPush4_picture() {
		return push4_picture;
	}

	public void setPush4_picture(byte[] push4_picture) {
		this.push4_picture = push4_picture;
	}

	public String getPush4_title() {
		return push4_title;
	}

	public void setPush4_title(String push4_title) {
		this.push4_title = push4_title;
	}

	public Push4(String push4_title, String push4_content, String push4_sales,
			String push4_price, String push4_distance, String country_name,
			byte[] push4_picture) {
		super();
		this.country_name = country_name;
		this.push4_content = push4_content;
		this.push4_sales = push4_sales;
		this.push4_price = push4_price;
		this.push4_distance = push4_distance;
		this.push4_picture = push4_picture;
		this.push4_title = push4_title;
	}
}
