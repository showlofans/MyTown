package com.mycountry.model;

import java.io.Serializable;

public class Note implements Serializable {
	private String note_title;// 商品名称
	private String note_content;// 厂家
	private String note_time;// 销量
	private byte[] note_picture;// 图片

	public String getNote_title() {
		return note_title;
	}

	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}

	public String getNote_content() {
		return note_content;
	}

	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}

	public String getNote_time() {
		return note_time;
	}

	public void setNote_time(String note_time) {
		this.note_time = note_time;
	}

	public byte[] getNote_picture() {
		return note_picture;
	}

	public void setNote_picture(byte[] note_picture) {
		this.note_picture = note_picture;
	}

	public Note(String note_title, String note_content, String note_time,
			byte[] note_picture) {
		super();
		this.note_title = note_title;
		this.note_content = note_content;
		this.note_time = note_time;
		this.note_picture = note_picture;
	}

}
