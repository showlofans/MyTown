package com.mycountry.model;

import java.io.Serializable;

public class Wine implements Serializable {
	private Integer wine_id;// id
	private String country_name;
	private String wine_title;// ��Ʒ���
	private String wine_price;// ����
	private String wine_sales;// ����
	private String wine_distance;

	private byte[] wine_picture;// ͼƬ

	public Integer getWine_id() {
		return wine_id;
	}

	public void setWine_id(Integer wine_id) {
		this.wine_id = wine_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getWine_title() {
		return wine_title;
	}

	public void setWine_title(String wine_title) {
		this.wine_title = wine_title;
	}

	public String getWine_sales() {
		return wine_sales;
	}

	public void setWine_sales(String wine_sales) {
		this.wine_sales = wine_sales;
	}

	public String getWine_price() {
		return wine_price;
	}

	public void setWine_price(String wine_price) {
		this.wine_price = wine_price;
	}

	public byte[] getWine_picture() {
		return wine_picture;
	}

	public void setWine_picture(byte[] wine_picture) {
		this.wine_picture = wine_picture;
	}

	public String getWine_distance() {
		return wine_distance;
	}

	public void setWine_distance(String wine_distance) {
		this.wine_distance = wine_distance;
	}

	public Wine(String wine_title, String country_name, String wine_sales,
			String wine_price, String wine_distance, byte[] wine_picture) {
		super();
		this.country_name = country_name;
		this.wine_title = wine_title;
		this.wine_sales = wine_sales;
		this.wine_price = wine_price;
		this.wine_distance = wine_distance;
		this.wine_picture = wine_picture;
	}

}
