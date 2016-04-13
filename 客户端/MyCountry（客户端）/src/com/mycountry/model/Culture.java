package com.mycountry.model;

import java.io.Serializable;

public class Culture implements Serializable{
//	private int note_id;// ��š�
	private String culture_title;// ��Ʒ���
	private String culture_content;// ����
	private String culture_time;
	private byte[] culture_picture;// ͼƬ

	public String getCulture_time() {
		return culture_time;
	}

	public void setCulture_time(String culture_time) {
		this.culture_time = culture_time;
	}

	public String getCulture_title() {
		return culture_title;
	}

	public void setCulture_title(String culture_title) {
		this.culture_title = culture_title;
	}

	public String getCulture_content() {
		return culture_content;
	}

	public void setCulture_content(String culture_content) {
		this.culture_content = culture_content;
	}

	public byte[] getCulture_picture() {
		return culture_picture;
	}

	public void setCulture_picture(byte[] culture_picture) {
		this.culture_picture = culture_picture;
	}


	public Culture(String culture_title, String culture_content,
			String culture_time,byte[] culture_picture) {
		super();
		this.culture_title = culture_title;
		this.culture_content = culture_content;
		this.culture_time = culture_time;
		this.culture_picture = culture_picture;
	}

}
