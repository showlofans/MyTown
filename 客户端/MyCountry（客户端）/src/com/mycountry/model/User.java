package com.mycountry.model;

import java.io.Serializable;

public class User implements Serializable {
	private String user_name;
	private String user_email;
	private String user_address;
	private String user_type;
	private byte[] user_picture;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public byte[] getUser_picture() {
		return user_picture;
	}

	public void setUser_picture(byte[] user_picture) {
		this.user_picture = user_picture;
	}

	public User(String user_name, String user_email, String user_type,
			String user_address, byte[]user_picture) {
		super();
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_type = user_type;
		this.user_address = user_address;
		this.user_picture = user_picture;
	}

}
