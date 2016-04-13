package com.mycountry.domain;

/**
 * 村庄特产信息实体Bean
 * 
 */
public class Techan {
	private Integer techan_id; // id
	private String techan_type;
	private String techan_title; // 标题
	private String techan_content; // 详情
	private String techan_picture;// 图片
	private String techan_time;// 上传时间
	private String techan_price;// 价格
	private String techan_sales;// 销量
	private String techan_distance;

	public Integer getTechan_id() {
		return techan_id;
	}

	public void setTechan_id(Integer techan_id) {
		this.techan_id = techan_id;
	}

	public String getTechan_title() {
		return techan_title;
	}

	public void setTechan_title(String techan_title) {
		this.techan_title = techan_title;
	}

	public String getTechan_content() {
		return techan_content;
	}

	public void setTechan_content(String techan_content) {
		this.techan_content = techan_content;
	}

	public String getTechan_picture() {
		return techan_picture;
	}

	public void setTechan_picture(String techan_picture) {
		this.techan_picture = techan_picture;
	}

	public String getTechan_time() {
		return techan_time;
	}

	public void setTechan_time(String techan_time) {
		this.techan_time = techan_time;
	}

	public String getTechan_price() {
		return techan_price;
	}

	public void setTechan_price(String techan_price) {
		this.techan_price = techan_price;
	}

	public String getTechan_sales() {
		return techan_sales;
	}

	public void setTechan_sales(String techan_sales) {
		this.techan_sales = techan_sales;
	}

	public String getTechan_type() {
		return techan_type;
	}

	public void setTechan_type(String techan_type) {
		this.techan_type = techan_type;
	}

	public String getTechan_distance() {
		return techan_distance;
	}

	public void setTechan_distance(String techan_distance) {
		this.techan_distance = techan_distance;
	}
}
