package com.mycountry.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fruit implements Serializable {
	private static final long serialVersionUID = -1010711775392052966L;
	private double latitude;
	private double longitude;
	private String fruit_title;
	private String country_name;
	private String fruit_price;
	private String fruit_sales;
	private String fruit_distance;

	private byte[] fruit_picture;

	// public static List<Fruit> fruits = new ArrayList<Fruit>();
	// static{
	// fruits.add(new Fruit(34.242652, 108.971171, byte[] fruit_picture,
	// "英伦贵族小旅馆",
	// "距离209米", 1456));
	// fruits.add(new Fruit(34.242952, 108.972171, R.drawable.a02, "沙井国际洗浴会所",
	// "距离897米", 456));
	// fruits.add(new Fruit(34.242852, 108.973171, R.drawable.a03, "五环服装城",
	// "距离249米", 1456));
	// fruits.add(new Fruit(34.242152, 108.971971, R.drawable.a04, "老米家泡馍小炒",
	// "距离679米", 1456));
	//
	// }

	public String getFruit_title() {
		return fruit_title;
	}

	public void setFruit_title(String fruit_title) {
		this.fruit_title = fruit_title;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getFruit_price() {
		return fruit_price;
	}

	public void setFruit_price(String fruit_price) {
		this.fruit_price = fruit_price;
	}

	public String getFruit_sales() {
		return fruit_sales;
	}

	public void setFruit_sales(String fruit_sales) {
		this.fruit_sales = fruit_sales;
	}

	public byte[] getFruit_picture() {
		return fruit_picture;
	}

	public void setFruit_picture(byte[] fruit_picture) {
		this.fruit_picture = fruit_picture;
	}

	public String getFruit_distance() {
		return fruit_distance;
	}

	public void setFruit_distance(String fruit_distance) {
		this.fruit_distance = fruit_distance;
	}

	public Fruit(String fruit_title, String country_name, String fruit_price, 
			String fruit_sales, String fruit_content, byte[] fruit_picture) {
		super();
		this.fruit_title = fruit_title;
		this.country_name = country_name;
		this.fruit_price = fruit_price;
		this.fruit_sales = fruit_sales;
		this.fruit_distance = fruit_content;
		this.fruit_picture = fruit_picture;
	}

}
