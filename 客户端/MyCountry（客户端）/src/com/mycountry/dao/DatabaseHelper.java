package com.mycountry.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

	// 锟斤拷锟斤拷锟斤拷菘锟�
	static String name = "MyCountry.db";
	static int dbVersion = 1;
	private static DatabaseHelper mDataBaseHelper;
	private static boolean isUsing = false;
	private static int times = 0;

	public synchronized static DatabaseHelper getInstance(Context context) {
		if (mDataBaseHelper == null) {
			mDataBaseHelper = new DatabaseHelper(context);
		}
		while (isUsing) {
			try {
				Thread.sleep(1000);
				times++;
				if (times > 5) {
					isUsing = false;
					times = 0;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		isUsing = true;
		return mDataBaseHelper;
	}

	public static void closeDB() {
		isUsing = false;
	}

	
	public DatabaseHelper(Context context) {
		super(context, name, null, dbVersion);
	}

	// 只锟节达拷锟斤拷锟斤拷荼锟�
	public void onCreate(SQLiteDatabase db) {

		//System.out.println("锟斤拷锟斤拷锟斤拷菘饪�...22..");
		//String sql = "create table user(id integer primary key autoincrement,username varchar(20),password varchar(20),repassword varchar(20),email varchar(20))";
		// String
		// sql1="insert INTO user VALUES ('10','ab','123456','10', '锟斤拷')";
		//db.execSQL(sql);
		// db.execSQL(sql1);

		//db.execSQL("create table tb_news(note_id integer primary key,title varchar(20),content varchar(10),"
				//+ "image varchar(20))");// 锟斤拷锟斤拷锟斤拷锟斤拷募锟斤拷锟较拷锟�
		//fruit_title, fruit_price,fruit_sales, pic
		//db.execSQL("create table fruit (fruit_id integer primary key,fruit_title varchar(20),fruit_price varchar(200),fruit_sales varchar(200),pic varchar(200)");
		db.execSQL("create table if not exists ShoppingList (fruit_title varchar(50),fruit_price varchar(50),fruit_sales  varchar(50)"
		+ ",pic varchar(50))");
		db.execSQL("create table if not exists CollectList (fruit_title varchar(50),fruit_price varchar(50),fruit_sales  varchar(50)"
				+ ",pic varchar(50))");
		db.execSQL("create table note (note_id integer primary key,note_title varchar(20),note_content varchar(200),ImagePath1 varchar(200),ImagePath2 varchar(200),ImagePath3 varchar(200),ImagePath4 varchar(200),ImagePath5 varchar(200),ImagePath6 varchar(200),note_time varchar(20))");
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}
