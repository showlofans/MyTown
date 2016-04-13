package com.mycountry.model;

public class Join {
	//private Integer join_id;
	private String join_title;
	private String join_content;
	private String join_time;
	private String join_picture;
	//private String content_url;
	//private String pic_url;
	
	public Join(String join_title, String join_content, 
			String join_time,String join_picture){
		setJoin_title(join_title);
		setJoin_content(join_content);
		setJoin_time(join_time);
		setJoin_picture(join_picture);
//		setContent_url(content_url);
//		setPic_url(pic_url);
	}
//	public Integer getJoin_id() {
//		return join_id;
//	}
//	public void setJoin_id(Integer join_id) {
//		this.join_id = join_id;
//	}
	public String getJoin_title() {
		return join_title;
	}
	public void setJoin_title(String join_title) {
		this.join_title = join_title;
	}
	public String getJoin_content() {
		return join_content;
	}
	public void setJoin_content(String join_content) {
		this.join_content = join_content;
	}
	public String getJoin_time() {
		return join_time;
	}
	public void setJoin_time(String join_time) {
		this.join_time = join_time;
	}
	public String getJoin_picture() {
		return join_picture;
	}
	public void setJoin_picture(String join_picture) {
		this.join_picture = join_picture;
	}
//	public String getContent_url() {
//		return content_url;
//	}
//	public void setContent_url(String content_url) {
//		this.content_url = content_url;
//	}
//	public String getPic_url() {
//		return pic_url;
//	}
//	public void setPic_url(String pic_url) {
//		this.pic_url = pic_url;
//	}
	
}
