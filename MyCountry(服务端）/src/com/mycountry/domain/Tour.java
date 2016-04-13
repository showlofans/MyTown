package com.mycountry.domain;

/**
 * 民情日记信息实体Bean
 * 
 */
public class Tour {
	private String tour_type;
	private Integer tour_id; // id
	private String tour_title; // 标题
	private String tour_content; // 详情
	private String tour_picture;// 图片
	private String tour_time;// 上传时间
	private String tour_price;// 价钱
	private String tour_sales;// 销量
	private String tour_distance;

	public Integer getTour_id() {
		return tour_id;
	}

	public void setTour_id(Integer tour_id) {
		this.tour_id = tour_id;
	}

	public String getTour_title() {
		return tour_title;
	}

	public void setTour_title(String tour_title) {
		this.tour_title = tour_title;
	}

	public String getTour_content() {
		return tour_content;
	}

	public void setTour_content(String tour_content) {
		this.tour_content = tour_content;
	}

	public String getTour_picture() {
		return tour_picture;
	}

	public void setTour_picture(String tour_picture) {
		this.tour_picture = tour_picture;
	}

	public String getTour_time() {
		return tour_time;
	}

	public void setTour_time(String tour_time) {
		this.tour_time = tour_time;
	}

	public String getTour_price() {
		return tour_price;
	}

	public void setTour_price(String tour_price) {
		this.tour_price = tour_price;
	}

	public String getTour_sales() {
		return tour_sales;
	}

	public void setTour_sales(String tour_sales) {
		this.tour_sales = tour_sales;
	}

	public String getTour_type() {
		return tour_type;
	}

	public void setTour_type(String tour_type) {
		this.tour_type = tour_type;
	}

	public String getTour_distance() {
		return tour_distance;
	}

	public void setTour_distance(String tour_distance) {
		this.tour_distance = tour_distance;
	}

}
