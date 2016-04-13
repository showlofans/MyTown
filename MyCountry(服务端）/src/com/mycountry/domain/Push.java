package com.mycountry.domain;

/**
 * 民情日记信息实体Bean
 * 
 */
public class Push {
	private Integer push_id; // id
	private String push_title; // 标题
	private String push_content; // 详情
	private String push_picture;// 图片
	private String push_time;// 上传时间
	private String push_price;// 价钱
	private String push_sales;// 销量
	private String push_distance;

	public Integer getPush_id() {
		return push_id;
	}

	public void setPush_id(Integer push_id) {
		this.push_id = push_id;
	}

	public String getPush_title() {
		return push_title;
	}

	public void setPush_title(String push_title) {
		this.push_title = push_title;
	}

	public String getPush_content() {
		return push_content;
	}

	public void setPush_content(String push_content) {
		this.push_content = push_content;
	}

	public String getPush_picture() {
		return push_picture;
	}

	public void setPush_picture(String push_picture) {
		this.push_picture = push_picture;
	}

	public String getPush_time() {
		return push_time;
	}

	public void setPush_time(String push_time) {
		this.push_time = push_time;
	}

	public String getPush_price() {
		return push_price;
	}

	public void setPush_price(String push_price) {
		this.push_price = push_price;
	}

	public String getPush_sales() {
		return push_sales;
	}

	public void setPush_sales(String push_sales) {
		this.push_sales = push_sales;
	}

	public String getPush_distance() {
		return push_distance;
	}

	public void setPush_distance(String push_distance) {
		this.push_distance = push_distance;
	}

}
