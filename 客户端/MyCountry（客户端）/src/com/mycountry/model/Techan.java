package com.mycountry.model;

import java.io.Serializable;

public class Techan implements Serializable {
	private String techan_title;
	private String techan_price;
	private String techan_sales;
	private String techan_distance;

	private byte[] techan_picture;

	public String getTechan_title() {
		return techan_title;
	}

	public void setTechan_title(String techan_title) {
		this.techan_title = techan_title;
	}

	public String getTechan_sales() {
		return techan_sales;
	}

	public void setTechan_sales(String techan_sales) {
		this.techan_sales = techan_sales;
	}

	public String getTechan_price() {
		return techan_price;
	}

	public void setTechan_price(String techan_price) {
		this.techan_price = techan_price;
	}

	public String getTechan_distance() {
		return techan_distance;
	}

	public void setTechan_distance(String techan_distance) {
		this.techan_distance = techan_distance;
	}

	public byte[] getTechan_picture() {
		return techan_picture;
	}

	public void setTechan_picture(byte[] techan_picture) {
		this.techan_picture = techan_picture;
	}

	public Techan(String techan_title, String techan_sales,
			String techan_price, String techan_distance, byte[] techan_picture) {
		super();
		this.techan_title = techan_title;
		this.techan_sales = techan_sales;
		this.techan_price = techan_price;
		this.techan_distance = techan_distance;
		this.techan_picture = techan_picture;
	}

}
