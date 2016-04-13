package com.mycountry.model;

import java.io.Serializable;

public class Liangyou implements Serializable {
	private String country_name;
	private String liangyou_title;// ��Ʒ���
	private String liangyou_price;// ����
	private String liangyou_sales;// ����
	private String liangtou_distance;

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	private byte[] liangyou_picture;// ͼƬ

	public String getLiangyou_title() {
		return liangyou_title;
	}

	public void setLiangyou_title(String liangyou_title) {
		this.liangyou_title = liangyou_title;
	}

	public String getLiangyou_sales() {
		return liangyou_sales;
	}

	public void setLiangyou_sales(String liangyou_sales) {
		this.liangyou_sales = liangyou_sales;
	}

	public String getLiangyou_price() {
		return liangyou_price;
	}

	public void setLiangyou_price(String liangyou_price) {
		this.liangyou_price = liangyou_price;
	}

	public byte[] getLiangyou_picture() {
		return liangyou_picture;
	}

	public void setLiangyou_picture(byte[] liangyou_picture) {
		this.liangyou_picture = liangyou_picture;
	}

	public String getLiangtou_distance() {
		return liangtou_distance;
	}

	public void setLiangtou_distance(String liangtou_distance) {
		this.liangtou_distance = liangtou_distance;
	}

	public Liangyou(String liangyou_title, String country_name, String liangyou_sales,
			String liangyou_price, String liangyou_distance, byte[] liangyou_picture) {
		super();
		this.country_name = country_name;
		this.liangyou_title = liangyou_title;
		this.liangyou_sales = liangyou_sales;
		this.liangyou_price = liangyou_price;
		this.liangtou_distance = liangyou_distance;
		this.liangyou_picture = liangyou_picture;
	}

}
