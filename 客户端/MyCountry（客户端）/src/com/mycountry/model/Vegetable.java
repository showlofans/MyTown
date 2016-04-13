package com.mycountry.model;

import java.io.Serializable;

public class Vegetable implements Serializable {
	private String vegetable_title;
	private String country_name;
	private String vegetable_price;
	private String vegetable_sales;
	private String vegetable_distance;
	private byte[] vegetable_picture;

	public String getVegetable_title() {
		return vegetable_title;
	}

	public void setVegetable_title(String vegetable_title) {
		this.vegetable_title = vegetable_title;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getVegetable_sales() {
		return vegetable_sales;
	}

	public void setVegetable_sales(String vegetable_sales) {
		this.vegetable_sales = vegetable_sales;
	}

	public String getVegetable_price() {
		return vegetable_price;
	}

	public void setVegetable_price(String vegetable_price) {
		this.vegetable_price = vegetable_price;
	}

	public String getVegetable_distance() {
		return vegetable_distance;
	}

	public void setVegetable_distance(String vegetable_distance) {
		this.vegetable_distance = vegetable_distance;
	}

	public byte[] getVegetable_picture() {
		return vegetable_picture;
	}

	public void setVegetable_picture(byte[] vegetable_picture) {
		this.vegetable_picture = vegetable_picture;
	}

	public Vegetable(String vegetable_title, String country_name, String vegetable_sales,
			String vegetable_price, String vegetable_distance,
			byte[] vegetable_picture) {
		super();
		this.vegetable_title = vegetable_title;
		this.country_name = country_name;
		this.vegetable_sales = vegetable_sales;
		this.vegetable_price = vegetable_price;
		this.vegetable_distance = vegetable_distance;
		this.vegetable_picture = vegetable_picture;
	}

}
