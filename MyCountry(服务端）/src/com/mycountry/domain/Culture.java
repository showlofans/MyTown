package com.mycountry.domain;

/**
 * ��ׯ�Ļ�ʵ��Bean
 * 
 */
public class Culture {
	private Integer culture_id; // id
	private String culture_title; // ����
	private String country_name;// ��ׯ��
	private String culture_content; // ����
	private String culture_picture;// ͼƬ
	private String culture_time;// �ϴ�ʱ��

	public Integer getCulture_id() {
		return culture_id;
	}

	public void setCulture_id(Integer culture_id) {
		this.culture_id = culture_id;
	}

	public String getCulture_title() {
		return culture_title;
	}

	public void setCulture_title(String culture_title) {
		this.culture_title = culture_title;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public String getCulture_content() {
		return culture_content;
	}

	public void setCulture_content(String culture_content) {
		this.culture_content = culture_content;
	}

	public String getCulture_picture() {
		return culture_picture;
	}

	public void setCulture_picture(String culture_picture) {
		this.culture_picture = culture_picture;
	}

	public String getCulture_time() {
		return culture_time;
	}

	public void setCulture_time(String culture_time) {
		this.culture_time = culture_time;
	}
}
