package com.mycountry.model;

import java.io.Serializable;

public class Tb_pwd implements Serializable{
	private int id;
	private String username;
	private String password;
	private String repassword;
	private String email;
	public Tb_pwd() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tb_pwd(String username, String password, String repassword, String email) {
		super();
		this.username = username;
		this.password = password;
		this.repassword = repassword;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**@Override
	public String toString() {
		return "Tb_pwd [id=" + id + ", username=" + User_Name + ", password="
				+ Password + ", repassword=" + Repassword + ", email=" + Email + "]";
	}**/
	
}
