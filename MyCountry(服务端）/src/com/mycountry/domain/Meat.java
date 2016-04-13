package com.mycountry.domain;

/**
 * 肉类信息实体Bean
 * 
 */
public class Meat {
	private String meat_type;
	private Integer meat_id; // id
	private String meat_title; // 标题
	private String country_name;// 村庄名
	private String meat_content; // 详情
	private String meat_picture;// 图片
	private String meat_time;// 上传时间
	private String meat_price;// 上传时间
	private String meat_sales;// 上传时间
	private String meat_distance;

	public Integer getMeat_id() {
		return meat_id;
	}

	public void setMeat_id(Integer meat_id) {
		this.meat_id = meat_id;
	}

	public String getMeat_title() {
		return meat_title;
	}

	public void setMeat_title(String meat_title) {
		this.meat_title = meat_title;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getMeat_content() {
		return meat_content;
	}

	public void setMeat_content(String meat_content) {
		this.meat_content = meat_content;
	}

	public String getMeat_picture() {
		return meat_picture;
	}

	public void setMeat_picture(String meat_picture) {
		this.meat_picture = meat_picture;
	}

	public String getMeat_time() {
		return meat_time;
	}

	public void setMeat_time(String meat_time) {
		this.meat_time = meat_time;
	}

	public String getMeat_price() {
		return meat_price;
	}

	public void setMeat_price(String meat_price) {
		this.meat_price = meat_price;
	}

	public String getMeat_sales() {
		return meat_sales;
	}

	public void setMeat_sales(String meat_sales) {
		this.meat_sales = meat_sales;
	}

	public String getMeat_type() {
		return meat_type;
	}

	public void setMeat_type(String meat_type) {
		this.meat_type = meat_type;
	}

	public String getMeat_distance() {
		return meat_distance;
	}

	public void setMeat_distance(String meat_distance) {
		this.meat_distance = meat_distance;
	}
}