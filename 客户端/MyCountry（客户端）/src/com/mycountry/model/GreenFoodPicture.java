package com.mycountry.model;

import java.io.Serializable;

import android.graphics.Picture;

public class GreenFoodPicture implements Serializable {
	private Integer picture_id;
	private String country_name;
	private String picture_title;
	private String picture_content;
	private String picture_sales;
	private String picture_price;
	private String picture_distance;
	private String picture_time;
	private byte[] picture_picture;

	public Integer getPicture_id() {
		return picture_id;
	}


	public void setPicture_id(Integer picture_id) {
		this.picture_id = picture_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getPicture_title() {
		return picture_title;
	}

	public void setPicture_title(String picture_title) {
		this.picture_title = picture_title;
	}

	public String getPicture_content() {
		return picture_content;
	}

	public void setPicture_content(String picture_content) {
		this.picture_content = picture_content;
	}

	public String getPicture_sales() {
		return picture_sales;
	}

	public void setPicture_sales(String picture_sales) {
		this.picture_sales = picture_sales;
	}

	public String getPicture_price() {
		return picture_price;
	}

	public void setPicture_price(String picture_price) {
		this.picture_price = picture_price;
	}

	public String getPicture_distance() {
		return picture_distance;
	}

	public void setPicture_distance(String picture_distance) {
		this.picture_distance = picture_distance;
	}

	public String getPicture_time() {
		return picture_time;
	}

	public void setPicture_time(String picture_time) {
		this.picture_time = picture_time;
	}

	public byte[] getPicture_picture() {
		return picture_picture;
	}

	public void setPicture_picture(byte[] picture_picture) {
		this.picture_picture = picture_picture;
	}
	
	public GreenFoodPicture(String picture_title,String picture_content,byte[]picture_picture){
		super();
		this.picture_title = picture_title;
		this.picture_content = picture_content;
		this.picture_picture = picture_picture;
		
	}
}
