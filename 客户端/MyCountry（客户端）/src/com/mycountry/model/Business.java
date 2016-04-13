package com.mycountry.model;

import java.io.Serializable;

public class Business implements Serializable {
	private Integer business_id;
	private String country_name;
	private String business_title;
	private String business_content;
	private String business_sales;
	private String business_price;
	private String business_time;
	private String business_tel;
	private String business_distance;
	private byte[] business_picture;

	public Integer getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(Integer business_id) {
		this.business_id = business_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getBusiness_title() {
		return business_title;
	}

	public void setBusiness_title(String business_title) {
		this.business_title = business_title;
	}

	public String getBusiness_content() {
		return business_content;
	}

	public void setBusiness_content(String business_content) {
		this.business_content = business_content;
	}

	public String getBusiness_sales() {
		return business_sales;
	}

	public void setBusiness_sales(String business_sales) {
		this.business_sales = business_sales;
	}

	public String getBusiness_price() {
		return business_price;
	}

	public void setBusiness_price(String business_price) {
		this.business_price = business_price;
	}

	public String getBusiness_time() {
		return business_time;
	}

	public void setBusiness_time(String business_time) {
		this.business_time = business_time;
	}

	public String getBusiness_tel() {
		return business_tel;
	}

	public void setBusiness_tel(String business_tel) {
		this.business_tel = business_tel;
	}

	public String getBusiness_distance() {
		return business_distance;
	}

	public void setBusiness_distance(String business_distance) {
		this.business_distance = business_distance;
	}

	public byte[] getBusiness_picture() {
		return business_picture;
	}

	public void setBusiness_picture(byte[] business_picture) {
		this.business_picture = business_picture;
	}

	public Business(String business_title, String business_content,
			String country_name, byte[] business_picture) {
		super();
		this.business_title = business_title;
		this.business_content = business_content;
		this.country_name = country_name;
		this.business_picture = business_picture;
	}

}
