package com.mycountry.domain;

/**
 * �����ռ���Ϣʵ��Bean
 * 
 */
public class Note {
	//private Integer note_id; // id
	private String note_title; 
	private String note_content; 
	private String note_picture;
    /*private String ImagePath2;
    private String ImagePath3;
    private String ImagePath4;
    private String ImagePath5;
    private String ImagePath6;*/
	private String note_time;
    /**
	 * @return the imagePath1
	 */
	public String getNote_picture() {
		return note_picture;
	}

	public void setNote_picture(String note_picture) {
		this.note_picture = note_picture;
	}


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
}
