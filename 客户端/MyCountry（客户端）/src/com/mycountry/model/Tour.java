package com.mycountry.model;

import java.io.Serializable;

public class Tour implements Serializable {
	private String tour_title;
	private String tour_price;
	private String tour_sales;
	private String tour_distance;
	private byte[] tour_picture;

	public String getTour_title() {
		return tour_title;
	}

	public void setTour_title(String tour_title) {
		this.tour_title = tour_title;
	}

	public String getTour_price() {
		return tour_price;
	}

	public void setTour_price(String tour_price) {
		this.tour_price = tour_price;
	}

	public String getTour_sales() {
		return tour_sales;
	}

	public void setTour_sales(String tour_sales) {
		this.tour_sales = tour_sales;
	}

	public String getTour_distance() {
		return tour_distance;
	}

	public void setTour_distance(String tour_distance) {
		this.tour_distance = tour_distance;
	} 

	public byte[] getTour_picture() {
		return tour_picture;
	}

	public void setTour_picture(byte[] tour_picture) {
		this.tour_picture = tour_picture;
	}

	public Tour(String tour_title, String tour_price, String tour_sales, String tour_distance,
			byte[] tour_picture) {
		super();
		this.tour_title = tour_title;
		this.tour_price = tour_price;
		this.tour_sales = tour_sales;
		this.tour_distance = tour_distance;
		this.tour_picture = tour_picture;
	}

}
