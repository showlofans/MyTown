package com.mycountry.domain;

/**
 * 民情日记信息实体Bean
 * 
 */
public class Green {
	private Integer green_id; // id
	private String green_title; // 标题
	private String green_content; // 详情
	private String green_picture;// 图片
	private String green_time;// 上传时间
	private String green_sales;// 上传时间
	private String green_price;// 上传时间
	private String gcountry_name;
	private String green_distance;

	public String getGcountry_name() {
		return gcountry_name;
	}

	public void setGcountry_name(String gcountry_name) {
		this.gcountry_name = gcountry_name;
	}

	public Integer getGreen_id() {
		return green_id;
	}

	public void setGreen_id(Integer green_id) {
		this.green_id = green_id;
	}

	public String getGreen_title() {
		return green_title;
	}

	public void setGreen_title(String green_title) {
		this.green_title = green_title;
	}

	public String getGreen_content() {
		return green_content;
	}

	public void setGreen_content(String green_content) {
		this.green_content = green_content;
	}

	public String getGreen_picture() {
		return green_picture;
	}

	public void setGreen_picture(String green_picture) {
		this.green_picture = green_picture;
	}

	public String getGreen_time() {
		return green_time;
	}

	public void setGreen_time(String green_time) {
		this.green_time = green_time;
	}

	public String getGreen_sales() {
		return green_sales;
	}

	public void setGreen_sales(String green_sales) {
		this.green_sales = green_sales;
	}

	public String getGreen_price() {
		return green_price;
	}

	public void setGreen_price(String green_price) {
		this.green_price = green_price;
	}

	public String getGreen_distance() {
		return green_distance;
	}

	public void setGreen_distance(String green_distance) {
		this.green_distance = green_distance;
	}
}
