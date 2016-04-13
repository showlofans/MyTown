package com.mycountry.domain;

/**
 * 招商加盟信息实体Bean
 * 
 */
public class Join {
	private Integer join_id; // id
	private String join_title; // 标题
	private String jcountry_name;// 村庄名
	private String join_content; // 详情
	private String join_picture;// 图片
	private String join_time;// 上传时间

	public Integer getJoin_id() {
		return join_id;
	}

	public void setJoin_id(Integer join_id) {
		this.join_id = join_id;
	}

	public String getJoin_title() {
		return join_title;
	}

	public void setJoin_title(String join_title) {
		this.join_title = join_title;
	}

	public String getJcountry_name() {
		return jcountry_name;
	}

	public void setJcountry_name(String jcountry_name) {
		this.jcountry_name = jcountry_name;
	}

	public String getJoin_content() {
		return join_content;
	}

	public void setJoin_content(String join_content) {
		this.join_content = join_content;
	}

	public String getJoin_picture() {
		return join_picture;
	}

	public void setJoin_picture(String join_picture) {
		this.join_picture = join_picture;
	}

	public String getJoin_time() {
		return join_time;
	}

	public void setJoin_time(String join_time) {
		this.join_time = join_time;
	}
}
