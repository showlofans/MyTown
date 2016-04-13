package com.mycountry.domain;

/**
 * 招商加盟信息实体Bean
 * 
 */
public class Pifa {
	private Integer pifa_id; // id
	private String pifa_title; // 标题
	private String pifa_content; // 详情
	private String pifa_picture;//图片
	private String pifa_time;//上传时间
	

	public Integer getPifa_id() {
		return pifa_id;
	}

	public void setPifa_id(Integer pifa_id) {
		this.pifa_id = pifa_id;
	}

	public String getPifa_title() {
		return pifa_title;
	}

	public void setPifa_title(String pifa_title) {
		this.pifa_title = pifa_title;
	}

	public String getPifa_content() {
		return pifa_content;
	}

	public void setPifa_content(String pifa_content) {
		this.pifa_content = pifa_content;
	}
	public String getPifa_picture() {
		return pifa_picture;
	}

	public void setPifa_picture(String pifa_picture) {
		this.pifa_picture = pifa_picture;
	}
	public String getPifa_time() {
		return pifa_time;
	}

	public void setPifa_time(String pifa_time) {
		this.pifa_time = pifa_time;
	}
}
