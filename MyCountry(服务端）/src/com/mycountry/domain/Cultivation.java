package com.mycountry.domain;

/**
 * �а���ֳ��Ϣʵ��Bean
 * 
 */
public class Cultivation {
	private Integer cultivation_id; // id
	private String cultivation_title; // ����
	private String ccountry_name;//��ׯ�� 
	private String cultivation_content; // ����
	private String cultivation_picture;//ͼƬ
	private String cultivation_time;//�ϴ�ʱ��
	

	

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
