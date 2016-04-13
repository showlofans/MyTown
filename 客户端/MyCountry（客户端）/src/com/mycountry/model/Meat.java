package com.mycountry.model;

import java.io.Serializable;

public class Meat implements Serializable {
	private String meat_title;
	private String country_name;
	private String meat_price;
	private String meat_sales;
	private String meat_distance;
	private byte[] meat_picture;

	public String getMeat_title() {
		return meat_title;
	}

	public void setMeat_title(String meat_title) {
		this.meat_title = meat_title;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getMeat_sales() {
		return meat_sales;
	}

	public void setMeat_sales(String meat_sales) {
		this.meat_sales = meat_sales;
	}

	public String getMeat_price() {
		return meat_price;
	}

	public void setMeat_price(String meat_price) {
		this.meat_price = meat_price;
	}

	public String getMeat_distance() {
		return meat_distance;
	}

	public void setMeat_distance(String meat_distance) {
		this.meat_distance = meat_distance;
	}

	public byte[] getMeat_picture() {
		return meat_picture;
	}

	public void setMeat_picture(byte[] meat_picture) {
		this.meat_picture = meat_picture;
	}

	public Meat(String meat_title, String country_name,String meat_sales, 
			String meat_price, String meat_distance, byte[] meat_picture) {
		super();
		this.meat_title = meat_title;
		this.country_name = country_name;
		this.meat_sales = meat_sales;
		this.meat_price = meat_price;
		this.meat_distance = meat_distance;
		this.meat_picture = meat_picture;
	}

}
