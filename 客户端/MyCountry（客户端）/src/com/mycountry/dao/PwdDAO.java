package com.mycountry.dao;

import com.mycountry.model.Tb_pwd;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PwdDAO {
	private DatabaseHelper dbHelper;

	public PwdDAO(Context context) {
		dbHelper = new DatabaseHelper(context);
	}

	// µÇÂ¼ÓÃ
	public boolean login(String username, String password) {
		SQLiteDatabase sdb = dbHelper.getReadableDatabase();
		String sql = "select * from user where username=? and password=?";
		Cursor cursor = sdb.rawQuery(sql, new String[] { username, password });
		if (cursor.moveToFirst() == true) {
			cursor.close();
			return true;
		}
		return false;
	}

	// ×¢²áÓÃ
	public boolean register(Tb_pwd pwd) {
		SQLiteDatabase sdb = dbHelper.getReadableDatabase();
		String sql = "insert into user(username,password,repassword,email) values(?,?,?,?)";
		Object obj[] = { pwd.getUsername(), pwd.getPassword(),
				pwd.getRepassword(), pwd.getEmail() };
		sdb.execSQL(sql, obj);
		return true;
	}
}
