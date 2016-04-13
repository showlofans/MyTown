package com.mycountry.model;

import java.io.Serializable;

public class Pifa implements Serializable{
	private String pifa_title;// 商品名称
	private String pifa_price;// 价钱
	private String pifa_sales;// 销量
	private byte[] pifa_picture;// 图片

	public String getPifa_title() {
		return pifa_title;
	}

	public void setPifa_title(String pifa_title) {
		this.pifa_title = pifa_title;
	}

	public String getPifa_price() {
		return pifa_price;
	}

	public void setPifa_price(String pifa_price) {
		this.pifa_price = pifa_price;
	}
	public String getPifa_sales() {
		return pifa_sales;
	}

	public void setPifa_sales(String pifa_sales) {
		this.pifa_sales = pifa_sales;
	}

	public byte[] getPifa_picture() {
		return pifa_picture;
	}

	public void setPifa_picture(byte[] pifa_picture) {
		this.pifa_picture = pifa_picture;
	} 


	public Pifa(String pifa_title, String pifa_price,String pifa_sales,
			byte[] pifa_picture) {
		super();
		this.pifa_title = pifa_title;
		this.pifa_price = pifa_price;
		this.pifa_sales = pifa_sales;
		this.pifa_picture = pifa_picture;
	} 

}
