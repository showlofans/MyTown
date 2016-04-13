package com.mycountry.model;

import java.io.Serializable;

public class Green implements Serializable {
	private String green_title;// ��Ʒ���
	private String green_content;
	private String green_price;// ��Ǯ
	private String green_sales;// ����
	private String gcountry_name;
	private String green_distance;
	private byte[] green_picture;// ͼƬ
	private String green_time;

	public String getGreen_title() {
		return green_title;
	}

	public void setGreen_title(String green_title) {
		this.green_title = green_title;
	}

	public String getGreen_content() {
		return green_content;
	}

	public void setGreen_content(String green_content) {
		this.green_content = green_content;
	}

	public String getGreen_price() {
		return green_price;
	}

	public void setGreen_price(String green_price) {
		this.green_price = green_price;
	}

	public String getGreen_sales() {
		return green_sales;
	}

	public void setGreen_sales(String green_sales) {
		this.green_sales = green_sales;
	}

	public String getGcountry_name() {
		return gcountry_name;
	}

	public void setGcountry_name(String gcountry_name) {
		this.gcountry_name = gcountry_name;
	}

	public String getGreen_distance() {
		return green_distance;
	}

	public void setGreen_distance(String green_distance) {
		this.green_distance = green_distance;
	}

	public byte[] getGreen_picture() {
		return green_picture;
	}

	public void setGreen_picture(byte[] green_picture) {
		this.green_picture = green_picture;
	}

	public String getGreen_time() {
		return green_time;
	}

	public void setGreen_time(String green_time) {
		this.green_time = green_time;
	}

	
	public Green(String green_title, String green_content, String green_price,
			String green_sales, String gcountry_name, String green_distance,
			byte[] green_picture, String green_time) {
		super();
		this.green_title = green_title;
		this.green_content = green_content;
		this.green_price = green_price;
		this.green_sales = green_sales;
		this.gcountry_name = gcountry_name;
		this.green_distance = green_distance;
		this.green_picture = green_picture;
		this.green_time = green_time;
	}

	public Green(String green_title, String green_content, String green_price,
			String green_sales, String gcountry_name, String green_distance,
			byte[] green_picture) {
		super();
		this.green_title = green_title;
		this.green_content = green_content;
		this.green_price = green_price;
		this.green_sales = green_sales;
		this.gcountry_name = gcountry_name;
		this.green_distance = green_distance;
		this.green_picture = green_picture;
	}

}
