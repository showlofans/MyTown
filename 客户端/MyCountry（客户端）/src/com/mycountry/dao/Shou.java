package com.mycountry.dao;

public class Shou {
    private String id;
    private String title;
    private String sales;
    private String price;
    private String picture;
    
	public Shou(String id, String title, String sales, String price,
			String picture2) {
		super();
		this.id = id;
		this.title = title;
		this.sales = sales;
		this.price = price;
		this.picture = picture2;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
}
