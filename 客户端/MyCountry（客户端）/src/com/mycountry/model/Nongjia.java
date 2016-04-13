package com.mycountry.model;

import java.io.Serializable;

public class Nongjia implements Serializable {
	private String nongjia_title;
	private String nongjia_price;
	private String nongjia_sales;
	private String country_name;
	private String nongjia_distance;
	private byte[] nongjia_picture;

	public String getNongjia_title() {
		return nongjia_title;
	}

	public void setNongjia_title(String nongjia_title) {
		this.nongjia_title = nongjia_title;
	}

	public String getNongjia_price() {
		return nongjia_price;
	}

	public void setNongjia_price(String nongjia_price) {
		this.nongjia_price = nongjia_price;
	}

	public String getNongjia_sales() {
		return nongjia_sales;
	}

	public void setNongjia_sales(String nongjia_sales) {
		this.nongjia_sales = nongjia_sales;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getNongjia_distance() {
		return nongjia_distance;
	}

	public void setNongjia_distance(String nongjia_distance) {
		this.nongjia_distance = nongjia_distance;
	}

	public byte[] getNongjia_picture() {
		return nongjia_picture;
	}

	public void setNongjia_picture(byte[] nongjia_picture) {
		this.nongjia_picture = nongjia_picture;
	}

	public Nongjia(String nongjia_title, String nongjia_price,
			String nongjia_sales, String country_name, String nongjia_distance,
			byte[] nongjia_picture) {
		super();
		this.nongjia_title = nongjia_title;
		this.nongjia_price = nongjia_price;
		this.nongjia_sales = nongjia_sales;
		this.country_name = country_name;
		this.nongjia_distance = nongjia_distance;
		this.nongjia_picture = nongjia_picture;
	}

}
