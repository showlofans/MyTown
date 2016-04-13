package com.mycountry.domain;

/**
 * 水果信息实体Bean
 * 
 */
public class Fruit {
	private Integer fruit_id; // id
	private String country_name;
	private String fruit_title; // 标题
	private String fruit_content; // 详情
	private String fruit_sales;// 销量
	private String fruit_picture;// 图片
	private String fruit_time;// 上传时间
	private String fruit_price;// 价钱
	private String fruit_type;
	private String fruit_distance;

	public Integer getFruit_id() {
		return fruit_id;
	}

	public void setFruit_id(Integer fruit_id) {
		this.fruit_id = fruit_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getFruit_title() {
		return fruit_title;
	}

	public void setFruit_title(String fruit_title) {
		this.fruit_title = fruit_title;
	}

	public String getFruit_content() {
		return fruit_content;
	}

	public void setFruit_content(String fruit_content) {
		this.fruit_content = fruit_content;
	}

	public String getFruit_sales() {
		return fruit_sales;
	}

	public void setFruit_sales(String fruit_sales) {
		this.fruit_sales = fruit_sales;
	}

	public String getFruit_picture() {
		return fruit_picture;
	}

	public void setFruit_picture(String fruit_picture) {
		this.fruit_picture = fruit_picture;
	}

	public String getFruit_time() {
		return fruit_time;
	}

	public void setFruit_time(String fruit_time) {
		this.fruit_time = fruit_time;
	}

	public String getFruit_price() {
		return fruit_price;
	}

	public void setFruit_price(String fruit_price) {
		this.fruit_price = fruit_price;
	}

	public String getFruit_type() {
		return fruit_type;
	}

	public void setFruit_type(String fruit_type) {
		this.fruit_type = fruit_type;
	}

	public String getFruit_distance() {
		return fruit_distance;
	}

	public void setFruit_distance(String fruit_distance) {
		this.fruit_distance = fruit_distance;
	}
}
