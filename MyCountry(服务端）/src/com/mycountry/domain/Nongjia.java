package com.mycountry.domain;

/**
 * 民情日记信息实体Bean
 * 
 */
public class Nongjia {
	private Integer nongjia_id; // id
	private String nongjia_title; // 标题
	private String nongjia_content; // 详情
	private String nongjia_picture;// 图片
	private String nongjia_time;// 上传时间
	private String nongjia_price;// 价钱
	private String nongjia_sales;// 销量
	private String nongjia_distance;
	private String country_name;

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public Integer getNongjia_id() {
		return nongjia_id;
	}

	public void setNongjia_id(Integer nongjia_id) {
		this.nongjia_id = nongjia_id;
	}

	public String getNongjia_title() {
		return nongjia_title;
	}

	public void setNongjia_title(String nongjia_title) {
		this.nongjia_title = nongjia_title;
	}

	public String getNongjia_content() {
		return nongjia_content;
	}

	public void setNongjia_content(String nongjia_content) {
		this.nongjia_content = nongjia_content;
	}

	public String getNongjia_picture() {
		return nongjia_picture;
	}

	public void setNongjia_picture(String nongjia_picture) {
		this.nongjia_picture = nongjia_picture;
	}

	public String getNongjia_time() {
		return nongjia_time;
	}

	public void setNongjia_time(String nongjia_time) {
		this.nongjia_time = nongjia_time;
	}

	public String getNongjia_price() {
		return nongjia_price;
	}

	public void setNongjia_price(String nongjia_price) {
		this.nongjia_price = nongjia_price;
	}

	public String getNongjia_sales() {
		return nongjia_sales;
	}

	public void setNongjia_sales(String nongjia_sales) {
		this.nongjia_sales = nongjia_sales;
	}

	public String getNongjia_distance() {
		return nongjia_distance;
	}

	public void setNongjia_distance(String nongjia_distance) {
		this.nongjia_distance = nongjia_distance;
	}

}
