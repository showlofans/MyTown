package com.mycountry.model;

import java.io.Serializable;

public class Push3 implements Serializable {

	private Integer push3_id;
	private String push3_content;
	private String push3_sales;
	private String push3_price;
	private String push3_distance;
	private String country_name;
	private String push3_time;
	private byte[] push3_picture;
	private String push3_title;

	public Integer getPush3_id() {
		return push3_id;
	}

	public void setPush3_id(Integer push3_id) {
		this.push3_id = push3_id;
	}

	public String getPush3_content() {
		return push3_content;
	}

	public void setPush3_content(String push3_content) {
		this.push3_content = push3_content;
	}

	public String getPush3_sales() {
		return push3_sales;
	}

	public void setPush3_sales(String push3_sales) {
		this.push3_sales = push3_sales;
	}

	public String getPush3_price() {
		return push3_price;
	}

	public void setPush3_price(String push3_price) {
		this.push3_price = push3_price;
	}

	public String getPush3_distance() {
		return push3_distance;
	}

	public void setPush3_distance(String push3_distance) {
		this.push3_distance = push3_distance;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getPush3_time() {
		return push3_time;
	}

	public void setPush3_time(String push3_time) {
		this.push3_time = push3_time;
	}

	public byte[] getPush3_picture() {
		return push3_picture;
	}

	public void setPush3_picture(byte[] push3_picture) {
		this.push3_picture = push3_picture;
	}

	public String getPush3_title() {
		return push3_title;
	}

	public void setPush3_title(String push3_title) {
		this.push3_title = push3_title;
	}

	public Push3(String push3_title, String push3_content, String push3_sales,
			String push3_price, String country_name, String push3_distance,
			byte[] push3_picture) {
		super();
		this.country_name = country_name;
		this.push3_content = push3_content;
		this.push3_sales = push3_sales;
		this.push3_price = push3_price;
		this.push3_distance = push3_distance;
		this.push3_picture = push3_picture;
		this.push3_title = push3_title;
	}
}
