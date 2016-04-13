package com.mycountry.dao;

public class theGoodes {
	private String title;
    private String sales;
    private String price;
    private byte[] picture;
    
	public theGoodes(String title, String sales, String price, byte[] picture) {
		super();
		this.title = title;
		this.sales = sales;
		this.price = price;
		this.picture = picture;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSales() {
		return sales;
	}
	public void setSales(String sales) {
		this.sales = sales;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public byte[] getPicture() {
		return picture;
	}
	public void setPicture(byte[] picture) {
		this.picture = picture;
	}
}
