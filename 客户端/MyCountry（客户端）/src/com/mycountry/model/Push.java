package com.mycountry.model;

import java.io.Serializable;

public class Push implements Serializable {
	private String push_title;
	private String push_price;
	private String push_sales;
	private String push_distance;

	private byte[] push_picture;

	public String getPush_title() {
		return push_title;
	}

	public void setPush_title(String push_title) {
		this.push_title = push_title;
	}

	public String getPush_price() {
		return push_price;
	}

	public void setPush_price(String push_price) {
		this.push_price = push_price;
	}

	public String getPush_sales() {
		return push_sales;
	}

	public void setPush_sales(String push_sales) {
		this.push_sales = push_sales;
	}

	public byte[] getPush_picture() {
		return push_picture;
	}

	public String getPush_distance() {
		return push_distance;
	}

	public void setPush_distance(String push_distance) {
		this.push_distance = push_distance;
	}

	public void setPush_picture(byte[] push_picture) {
		this.push_picture = push_picture;
	}

	public Push(String push_title, String push_sales, String push_price, String push_distance,
			byte[] push_picture) {
		super();
		this.push_title = push_title;
		this.push_sales = push_sales;
		this.push_price = push_price;
		this.push_distance = push_distance;
		this.push_picture = push_picture;
	}

	public Push(String push_title, String push_price, String push_sales,
			String push_distance) {
		super();
		this.push_title = push_title;
		this.push_price = push_price;
		this.push_sales = push_sales;
		this.push_distance = push_distance;
	}
	

}
