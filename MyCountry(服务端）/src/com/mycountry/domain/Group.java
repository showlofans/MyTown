package com.mycountry.domain;

/**
 * �����ռ���Ϣʵ��Bean
 * 
 */
public class Group {
	private Integer group_id; // id
	private String group_title; // ����
	private String group_content; // ����
	private String group_picture;//ͼƬ
	private String group_time;//�ϴ�ʱ��
	

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public String getGroup_title() {
		return group_title;
	}

	public void setGroup_title(String group_title) {
		this.group_title = group_title;
	}

	public String getGroup_content() {
		return group_content;
	}

	public void setGroup_content(String group_content) {
		this.group_content = group_content;
	}
	public String getGroup_picture() {
		return group_picture;
	}

	public void setGroup_picture(String group_picture) {
		this.group_picture = group_picture;
	}
	public String getGroup_time() {
		return group_time;
	}

	public void setGroup_time(String group_time) {
		this.group_time = group_time;
	}
}
