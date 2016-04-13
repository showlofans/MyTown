package com.mycountry.model;

import java.io.Serializable;

public class Ganhuo implements Serializable {
	private String ganhuo_title;
	private String country_name;
	private String ganhuo_price;
	private String ganhuo_sales;
	private String ganhuo_distance;
	private byte[] ganhuo_picture;

	public String getGanhuo_title() {
		return ganhuo_title;
	}

	public void setGanhuo_title(String ganhuo_title) {
		this.ganhuo_title = ganhuo_title;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getGanhuo_sales() {
		return ganhuo_sales;
	}

	public void setGanhuo_sales(String ganhuo_sales) {
		this.ganhuo_sales = ganhuo_sales;
	}

	public String getGanhuo_price() {
		return ganhuo_price;
	}

	public void setGanhuo_price(String ganhuo_price) {
		this.ganhuo_price = ganhuo_price;
	}

	public byte[] getGanhuo_picture() {
		return ganhuo_picture;
	}

	public void setGanhuo_picture(byte[] ganhuo_picture) {
		this.ganhuo_picture = ganhuo_picture;
	}

	public String getGanhuo_distance() {
		return ganhuo_distance;
	}

	public void setGanhuo_distance(String ganhuo_distance) {
		this.ganhuo_distance = ganhuo_distance;
	}

	public Ganhuo(String ganhuo_title, String country_name, String ganhuo_sales,
			String ganhuo_price, String ganhuo_distance, byte[] ganhuo_picture) {
		super();
		this.ganhuo_title = ganhuo_title;
		this.country_name = country_name;
		this.ganhuo_sales = ganhuo_sales;
		this.ganhuo_price = ganhuo_price;
		this.ganhuo_distance = ganhuo_distance;
		this.ganhuo_picture = ganhuo_picture;
	}

}
