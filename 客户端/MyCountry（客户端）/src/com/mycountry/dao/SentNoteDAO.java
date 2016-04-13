/*package com.mycountry.dao;

import java.util.ArrayList;
import java.util.List;

import com.mycountry.model.Note;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class SentNoteDAO {
	private DatabaseHelper helper;// 锟斤拷锟斤拷DBOpenHelper锟斤拷锟斤拷
	private SQLiteDatabase db;// 锟斤拷锟斤拷SQLiteDatabase锟斤拷锟斤拷

	public SentNoteDAO(Context context) {
		helper = new DatabaseHelper(context);
	}

	*//**
	 * 锟斤拷颖锟斤拷锟斤拷锟较�
	 * 
	 * @param note
	 *//*
	public void add(Note note) {
		try {
			db = helper.getWritableDatabase();
			db.execSQL(
					"insert into note (note_id,note_title,note_content,ImagePath1,ImagePath2,ImagePath3,ImagePath4,ImagePath5,ImagePath6,note_time) values (?,?,?,?,?,?,?,?,?,?)",
					new Object[] { note.getNote_id(), note.getNote_title(),
							note.getNote_content(), note.getImagePath1(),
							note.getImagePath2(), note.getImagePath3(),
							note.getImagePath4(), note.getImagePath5(),
							note.getImagePath6(), note.getNote_time() });
		} finally {
			db.close();
		}

	}

	*//**
	 * 锟斤拷锟铰憋拷锟斤拷锟斤拷息
	 * 
	 * @param note
	 *//*
	public void upgrade(Note note) {

	}

	public int getMaxId() {
		try {
			db = helper.getWritableDatabase();// 锟斤拷始锟斤拷SQLiteDatabase锟斤拷锟斤拷
			Cursor cursor = db.rawQuery("select max(note_id) from note", null);// 锟斤拷取锟斤拷锟斤拷锟斤拷息锟斤拷锟叫碉拷锟斤拷锟斤拷锟�
			while (cursor.moveToLast()) {// 锟斤拷锟斤拷Cursor锟叫碉拷锟斤拷锟揭伙拷锟斤拷锟斤拷
				return cursor.getInt(0);// 锟斤拷取锟斤拷锟绞碉拷锟斤拷锟斤拷荩锟斤拷锟斤拷锟斤拷锟斤拷
			}
			return 0;// 锟斤拷锟矫伙拷锟斤拷锟捷ｏ拷锟津返伙拷0
		} finally {
			db.close();
		}
	}

	*//**
	 * 锟斤拷询锟斤拷锟斤拷锟斤拷息
	 * 
	 * @param id
	 *//*
	public Note find(int id) {
		try {
			db = helper.getWritableDatabase();
			Cursor cursor = db
					.rawQuery(
							"select note_id,note_title,note_content,ImagePath1,ImagePath2,ImagePath3,ImagePath4,ImagePath5,ImagePath6,note_time from note where note_id = ?",
							new String[] { String.valueOf(id) });// 锟斤拷荼锟脚诧拷锟斤拷锟斤拷锟斤拷锟斤拷息锟斤拷锟斤拷锟芥储锟斤拷Cursor锟斤拷锟斤拷
			if (cursor.moveToNext())// 锟斤拷锟斤拷锟斤拷业锟斤拷锟斤拷锟斤拷锟斤拷锟较�
			{
				// 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟较拷娲拷锟絥ote锟斤拷锟斤拷
				return new Note(
						cursor.getInt(cursor.getColumnIndex("note_id")),
						cursor.getString(cursor.getColumnIndex("note_title")),
						cursor.getString(cursor.getColumnIndex("note_content")),

						cursor.getString(cursor.getColumnIndex("ImagePath1")),
						cursor.getString(cursor.getColumnIndex("ImagePath2")),
						cursor.getString(cursor.getColumnIndex("ImagePath3")),
						cursor.getString(cursor.getColumnIndex("ImagePath4")),
						cursor.getString(cursor.getColumnIndex("ImagePath5")),
						cursor.getString(cursor.getColumnIndex("ImagePath6")),
						cursor.getString(cursor.getColumnIndex("note_time")));
			}
			return null;
		} finally {
			db.close();
		}

	}

	*//**
	 * 删锟斤拷锟斤拷息
	 * 
	 * @param note
	 *//*
	public void detele(Integer... ids) {
		if (ids.length > 0)// 锟叫讹拷锟角凤拷锟斤拷锟揭撅拷锟斤拷id
		{
			StringBuffer sb = new StringBuffer();// 锟斤拷锟斤拷StringBuffer锟斤拷锟斤拷
			for (int i = 0; i < ids.length; i++)// 锟斤拷锟斤拷要删锟斤拷锟絠d锟斤拷锟斤拷
			{
				sb.append('?').append(',');// 锟斤拷删锟斤拷锟斤拷锟斤拷锟斤拷拥锟絊tringBuffer锟斤拷锟斤拷锟斤拷
			}
			sb.deleteCharAt(sb.length() - 1);// 去锟斤拷锟斤拷锟揭伙拷锟斤拷锟�,锟斤拷锟街凤拷
			db = helper.getWritableDatabase();// 锟斤拷始锟斤拷SQLiteDatabase锟斤拷锟斤拷
			// 执锟斤拷删锟斤拷锟斤拷锟斤拷锟斤拷息锟斤拷锟斤拷
			db.execSQL("delete from note where note_id in (" + sb + ")",
					(Object[]) ids);
		}
	}

	*//**
	 * 锟斤拷取锟斤拷锟斤拷锟斤拷息
	 * 
	 * @param start
	 *            锟斤拷始位锟斤拷
	 * @param count
	 *            每页锟斤拷示锟斤拷锟斤拷
	 * @return
	 *//*
	public List<Note> getScrollData(int start, int count) {
		try {
			List<Note> note = new ArrayList<Note>();// 锟斤拷锟斤拷锟斤拷锟较讹拷锟斤拷
			db = helper.getWritableDatabase();// 锟斤拷始锟斤拷SQLiteDatabase锟斤拷锟斤拷
			// 锟斤拷取锟斤拷锟叫憋拷锟斤拷锟斤拷息
			Cursor cursor = db
					.rawQuery("select * from note limit ?,?", new String[] {
							String.valueOf(start), String.valueOf(count) });
			while (cursor.moveToNext())// 锟斤拷锟斤拷锟斤拷锟叫的憋拷锟斤拷锟斤拷息
			{
				// 锟斤拷锟斤拷锟斤拷谋锟斤拷锟斤拷锟较拷锟接碉拷锟斤拷锟斤拷锟斤拷
				note.add(new Note(cursor.getInt(cursor
						.getColumnIndex("note_id")), cursor.getString(cursor
						.getColumnIndex("note_title")), cursor.getString(cursor
						.getColumnIndex("note_content")), cursor
						.getString(cursor.getColumnIndex("ImagePath1")), cursor
						.getString(cursor.getColumnIndex("ImagePath2")), cursor
						.getString(cursor.getColumnIndex("ImagePath3")), cursor
						.getString(cursor.getColumnIndex("ImagePath4")), cursor
						.getString(cursor.getColumnIndex("ImagePath5")), cursor
						.getString(cursor.getColumnIndex("ImagePath6")), cursor
						.getString(cursor.getColumnIndex("note_time"))

				));
			}
			return note;// 锟斤拷锟截硷拷锟斤拷
		} finally {
			db.close();
		}
	}

	*//**
	 * 锟斤拷取锟杰硷拷录锟斤拷
	 * 
	 * @return
	 *//*
	public long getCount() {
		try {
			db = helper.getWritableDatabase();// 锟斤拷始锟斤拷SQLiteDatabase锟斤拷锟斤拷
			Cursor cursor = db
					.rawQuery("select count(note_id) from note", null);// 锟斤拷取锟斤拷锟斤拷锟斤拷息锟侥硷拷录锟斤拷
			if (cursor.moveToNext())// 锟叫讹拷Cursor锟斤拷锟角凤拷锟斤拷锟斤拷锟�
			{
				return cursor.getLong(0);// 锟斤拷锟斤拷锟杰硷拷录锟斤拷
			}
			return 0;// 锟斤拷锟矫伙拷锟斤拷锟捷ｏ拷锟津返伙拷0
		} finally {
			db.close();
		}
	}

}
*/