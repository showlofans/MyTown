package com.mycountry.domain;

/**
 * 粮油信息实体Bean
 * 
 */
public class Liangyou {
	private String Liangyou_type;
	private Integer liangyou_id; // id
	private String country_name;
	private String liangyou_title; // 标题
	private String liangyou_content; // 详情
	private String liangyou_picture;// 图片
	private String liangyou_time;// 上传时间
	private String liangyou_price;// 图片
	private String liangyou_sales;// 上传时间
	private String liangyou_distance;

	public Integer getLiangyou_id() {
		return liangyou_id;
	}

	public void setLiangyou_id(Integer liangyou_id) {
		this.liangyou_id = liangyou_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getliangyou_title() {
		return liangyou_title;
	}

	public void setLiangyou_title(String liangyou_title) {
		this.liangyou_title = liangyou_title;
	}

	public String getLiangyou_content() {
		return liangyou_content;
	}

	public void setLiangyou_content(String liangyou_content) {
		this.liangyou_content = liangyou_content;
	}

	public String getLiangyou_picture() {
		return liangyou_picture;
	}

	public void setLiangyou_picture(String liangyou_picture) {
		this.liangyou_picture = liangyou_picture;
	}

	public String getLiangyou_time() {
		return liangyou_time;
	}

	public void setLiangyou_time(String liangyou_time) {
		this.liangyou_time = liangyou_time;
	}

	public String getLiangyou_price() {
		return liangyou_price;
	}

	public void setLiangyou_price(String liangyou_price) {
		this.liangyou_price = liangyou_price;
	}

	public String getLiangyou_sales() {
		return liangyou_sales;
	}

	public void setLiangyou_sales(String liangyou_sales) {
		this.liangyou_sales = liangyou_sales;
	}

	public String getLiangyou_type() {
		return Liangyou_type;
	}

	public void setLiangyou_type(String liangyou_type) {
		Liangyou_type = liangyou_type;
	}

	public String getLiangyou_distance() {
		return liangyou_distance;
	}

	public void setLiangyou_distance(String liangyou_distance) {
		this.liangyou_distance = liangyou_distance;
	}
}
