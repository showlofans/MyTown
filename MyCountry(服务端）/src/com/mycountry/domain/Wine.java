package com.mycountry.domain;

/**
 * 酒信息实体Bean
 * 
 */
public class Wine {
	private String Wine_type;
	private Integer wine_id; // id
	private String country_name;
	private String wine_title; // 标题
	private String wine_name;// 村庄名
	private String wine_content; // 详情
	private String wine_picture;// 图片
	private String wine_time;// 上传时间
	private String wine_price;// 价钱
	private String wine_sales;// 销量
	private String wine_distance;

	public Integer getWine_id() {
		return wine_id;
	}

	public void setWine_id(Integer wine_id) {
		this.wine_id = wine_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getWine_title() {
		return wine_title;
	}

	public void setWine_title(String wine_title) {
		this.wine_title = wine_title;
	}

	public String getWine_name() {
		return wine_name;
	}

	public void setWine_name(String wine_name) {
		this.wine_name = wine_name;
	}

	public String getWine_content() {
		return wine_content;
	}

	public void setWine_content(String wine_content) {
		this.wine_content = wine_content;
	}

	public String getWine_picture() {
		return wine_picture;
	}

	public void setWine_picture(String wine_picture) {
		this.wine_picture = wine_picture;
	}

	public String getWine_time() {
		return wine_time;
	}

	public void setWine_time(String wine_time) {
		this.wine_time = wine_time;
	}

	public String getWine_price() {
		return wine_price;
	}

	public void setWine_price(String wine_price) {
		this.wine_price = wine_price;
	}

	public String getWine_sales() {
		return wine_sales;
	}

	public void setWine_sales(String wine_sales) {
		this.wine_sales = wine_sales;
	}

	public String getWine_type() {
		return Wine_type;
	}

	public void setWine_type(String wine_type) {
		Wine_type = wine_type;
	}

	public String getWine_distance() {
		return wine_distance;
	}

	public void setWine_distance(String wine_distance) {
		this.wine_distance = wine_distance;
	}
}
