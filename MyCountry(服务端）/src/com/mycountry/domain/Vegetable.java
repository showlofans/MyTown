package com.mycountry.domain;

/**
 * 蔬菜信息实体Bean
 * 
 */
public class Vegetable {
	private String vegetable_type;
	private Integer vegetable_id; // id
	private String vegetable_title; // 标题
	private String country_name;// 村庄名
	private String vegetable_content; // 详情
	private String vegetable_picture;// 图片
	private String vegetable_time;// 上传时间
	private String vegetable_price;// 上传时间
	private String vegetable_sales;// 销量
	private String vegetable_distance;

	public Integer getVegetable_id() {
		return vegetable_id;
	}

	public void setVegetable_id(Integer vegetable_id) {
		this.vegetable_id = vegetable_id;
	}

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

	public String getVegetable_content() {
		return vegetable_content;
	}

	public void setVegetable_content(String vegetable_content) {
		this.vegetable_content = vegetable_content;
	}

	public String getVegetable_picture() {
		return vegetable_picture;
	}

	public void setVegetable_picture(String vegetable_picture) {
		this.vegetable_picture = vegetable_picture;
	}

	public String getVegetable_time() {
		return vegetable_time;
	}

	public void setVegetable_time(String vegetable_time) {
		this.vegetable_time = vegetable_time;
	}

	public String getVegetable_price() {
		return vegetable_price;
	}

	public void setVegetable_price(String vegetable_price) {
		this.vegetable_price = vegetable_price;
	}

	public String getVegetable_sales() {
		return vegetable_sales;
	}

	public void setVegetable_sales(String vegetable_sales) {
		this.vegetable_sales = vegetable_sales;
	}

	public String getVegetable_type() {
		return vegetable_type;
	}

	public void setVegetable_type(String vegetable_type) {
		this.vegetable_type = vegetable_type;
	}

	public String getVegetable_distance() {
		return vegetable_distance;
	}

	public void setVegetable_distance(String vegetable_distance) {
		this.vegetable_distance = vegetable_distance;
	}
}
