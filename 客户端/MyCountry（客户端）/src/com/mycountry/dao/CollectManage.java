package com.mycountry.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.menutab.R.string;
import com.mycountry.model.Fruit;

/**
 * �ղع���
 * 
 * @author: wll
 */
public class CollectManage {
	String fruittitle;
	String fruitprice;
	String country_name;
	String fruit_distance;
	/**
	 * ����ݿ��м���һ����¼
	 * 
	 * @param fruit
	 * @param context
	 */
	private String fruitsales;
	private byte[] fruitpicture;
	private Fruit fruit;
	public void init()
	{
	this.fruittitle = fruit.getFruit_title();
	this.country_name = fruit.getCountry_name();
	this.fruitpicture = fruit.getFruit_picture();
	this.fruitprice = fruit.getFruit_price();
	this.fruitsales = fruit.getFruit_sales();
	this.fruit_distance = fruit.getFruit_distance();
	}
	
	public void addFruit(Fruit fruit, Context context) {
		SQLiteDatabase sqLiteDatabase = DatabaseHelper.getInstance(context)
				.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		init();
		contentValues.put("fruitTitle", fruittitle);
		contentValues.put("country_name", country_name);
		contentValues.put("fruitPrice", fruitprice);
		contentValues.put("fruitSales", fruitsales);
		contentValues.put("fruitPicture", fruitpicture);
		contentValues.put("fruit_distance", fruit_distance);
		if (sqLiteDatabase != null) {
			sqLiteDatabase.insert("CollectList", null, contentValues);
			sqLiteDatabase.close();
			DatabaseHelper.closeDB();
		}
	}

	/**
	 * ȡ��Product�������
	 * 
	 * @param context
	 * @return
	 */
	public List<Fruit> getProducts(Context context, String type) {
		List<Fruit> fruits = new ArrayList<Fruit>();
		SQLiteDatabase sqLiteDatabase = DatabaseHelper.getInstance(context)
				.getReadableDatabase();

		if (sqLiteDatabase != null) {
			Cursor cursor = sqLiteDatabase.query("CollectList", null, null,
					null, null, null, null);
			while (cursor.moveToNext()) {
				//fruittitle,fruitprice,fruitsales,fruitpicture
				Fruit fruit = new Fruit(fruittitle,country_name,fruitprice,fruitsales,fruit_distance,fruitpicture);

				fruit.setFruit_title(cursor.getString(cursor
						.getColumnIndex("fruitTitle")));
				fruit.setFruit_price(cursor.getString(cursor
						.getColumnIndex("fruitPrice")));
				fruit.setFruit_sales(cursor.getString(cursor
						.getColumnIndex("fruitSales")));//fruitPrice fruitSales fruitPicture
				fruit.setFruit_picture(cursor.getBlob(cursor
						.getColumnIndex("fruitPicture")));
				//fruit.setUrl(cursor.getString(cursor.getColumnIndex("url")));

				fruits.add(fruit);
			}
			sqLiteDatabase.close();
			DatabaseHelper.closeDB();
		}
		return fruits;
	}

}
