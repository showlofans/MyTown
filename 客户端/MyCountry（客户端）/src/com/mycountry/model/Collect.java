package com.mycountry.model;

import java.io.Serializable;

public class Collect implements Serializable{

	private Integer collect_id;
	private String country_name;
	private String collect_title;
	private String collect_content;
	private String collect_sales;
	private String collect_price;
	private String collect_time;
	private String collect_tel;
	private String collect_distance;
	private byte[] collect_picture;
	
	public Integer getCollect_id() {
		return collect_id;
	}
	public void setCollect_id(Integer collect_id) {
		this.collect_id = collect_id;
	}
	public String getCountry_name() {
		return country_name;
	}
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	public String getCollect_title() {
		return collect_title;
	}
	public void setCollect_title(String collect_title) {
		this.collect_title = collect_title;
	}
	public String getCollect_content() {
		return collect_content;
	}
	public void setCollect_content(String collect_content) {
		this.collect_content = collect_content;
	}
	public String getCollect_sales() {
		return collect_sales;
	}
	public void setCollect_sales(String collect_sales) {
		this.collect_sales = collect_sales;
	}
	public String getCollect_price() {
		return collect_price;
	}
	public void setCollect_price(String collect_price) {
		this.collect_price = collect_price;
	}
	public String getCollect_time() {
		return collect_time;
	}
	public void setCollect_time(String collect_time) {
		this.collect_time = collect_time;
	}
	public String getCollect_tel() {
		return collect_tel;
	}
	public void setCollect_tel(String collect_tel) {
		this.collect_tel = collect_tel;
	}
	public String getCollect_distance() {
		return collect_distance;
	}
	public void setCollect_distance(String collect_distance) {
		this.collect_distance = collect_distance;
	}
	public byte[] getCollect_picture() {
		return collect_picture;
	}
	public void setCollect_picture(byte[] collect_picture) {
		this.collect_picture = collect_picture;
	}
	
	public Collect(String collect_title, String collect_content,
			String country_name, byte[] collect_picture){
	super();
	this.collect_title = collect_title;
	this.collect_content = collect_content;
	this.country_name = country_name;
	this.collect_picture = collect_picture;
	}
}
