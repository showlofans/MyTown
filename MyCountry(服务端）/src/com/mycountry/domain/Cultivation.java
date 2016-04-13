package com.mycountry.domain;

/**
 * 承包养殖信息实体Bean
 * 
 */
public class Cultivation {
	private Integer cultivation_id; // id
	private String cultivation_title; // 标题
	private String ccountry_name;//村庄名 
	private String cultivation_content; // 详情
	private String cultivation_picture;//图片
	private String cultivation_time;//上传时间
	

	

	public Integer getCultivation_id() {
		return cultivation_id;
	}

	public void setCultivation_id(Integer cultivation_id) {
		this.cultivation_id = cultivation_id;
	}

	public String getCultivation_title() {
		return cultivation_title;
	}

	public void setCultivation_title(String cultivation_title) {
		this.cultivation_title = cultivation_title;
	}
	public String getCcountry_name() {
		return ccountry_name;
	}

	public void setCcountry_name(String ccountry_name) {
		this.ccountry_name = ccountry_name;
	}

	public String getCultivation_content() {
		return cultivation_content;
	}

	public void setCultivation_content(String cultivation_content) {
		this.cultivation_content = cultivation_content;
	}
	public String getCultivation_picture() {
		return cultivation_picture;
	}

	public void setCultivation_picture(String cultivation_picture) {
		this.cultivation_picture = cultivation_picture;
	}
	public String getCultivation_time() {
		return cultivation_time;
	}

	public void setCultivation_time(String cultivation_time) {
		this.cultivation_time = cultivation_time;
	}
}
