package com.mycountry.domain;

/**
 * �ɻ��ռ���Ϣʵ��Bean
 * 
 */
public class Ganhuo {
	private Integer ganhuo_id; // id
	private String ganhuo_type;
	private String ganhuo_title; // ����
	private String ganhuo_content; // ����
	private String country_name;
	private String ganhuo_picture;// ͼƬ
	private String ganhuo_time;// �ϴ�ʱ��
	private String ganhuo_price;// ��Ǯ
	private String ganhuo_sales;// ��Ǯ
	private String ganhuo_distance;

	public Integer getGanhuo_id() {
		return ganhuo_id;
	}

	public void setGanhuo_id(Integer ganhuo_id) {
		this.ganhuo_id = ganhuo_id;
	}

	public String getGanhuo_title() {
		return ganhuo_title;
	}

	public void setGanhuo_title(String ganhuo_title) {
		this.ganhuo_title = ganhuo_title;
	}

	public String getGanhuo_content() {
		return ganhuo_content;
	}

	public void setGanhuo_content(String ganhuo_content) {
		this.ganhuo_content = ganhuo_content;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getGanhuo_picture() {
		return ganhuo_picture;
	}

	public void setGanhuo_picture(String ganhuo_picture) {
		this.ganhuo_picture = ganhuo_picture;
	}

	public String getGanhuo_time() {
		return ganhuo_time;
	}

	public void setGanhuo_time(String ganhuo_time) {
		this.ganhuo_time = ganhuo_time;
	}

	public String getGanhuo_price() {
		return ganhuo_price;
	}

	public void setGanhuo_price(String ganhuo_price) {
		this.ganhuo_price = ganhuo_price;
	}

	public String getGanhuo_sales() {
		return ganhuo_sales;
	}

	public void setGanhuo_sales(String ganhuo_sales) {
		this.ganhuo_sales = ganhuo_sales;
	}

	public String getGanhuo_type() {
		return ganhuo_type;
	}

	public void setGanhuo_type(String ganhuo_type) {
		this.ganhuo_type = ganhuo_type;
	}

	public String getGanhuo_distance() {
		return ganhuo_distance;
	}

	public void setGanhuo_distance(String ganhuo_distance) {
		this.ganhuo_distance = ganhuo_distance;
	}
}
