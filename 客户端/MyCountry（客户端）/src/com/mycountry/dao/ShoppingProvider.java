package com.mycountry.dao;
import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
//收藏商品数据内容管理
public class ShoppingProvider extends ContentProvider{
	//商品内容数据库文件名
	private static final String SHOP_DATABASE="shop.db";
	//数据库表名
	private static final String SHOP_TABLE = "shop_item";
	private static final int SHOP_DATABASE_VERSION = 1;	
	private static final String TAG = "ShopProvider";	
	//URI
	public static final Uri SHOP_URI = Uri.parse("content://com.mycountry.details/shop");
	//列名
	public static final String SHOP_ID = "_id";
	public static final String SHOP_TITLE = "title";
	public static final String SHOP_PRICE = "price";
	public static final String SHOP_SALES = "sales";
	public static final String SHOP_PICTURE = "picture";
	
	//列的索引
	public static final int TITLE_INDEX = 1;
	public static final int PRICE_INDEX = 2;
	public static final int SALES_INDEX = 3;
	public static final int PICTURE_INDEX = 4;
	//创建表的sql语句
	private static final String SHOP_SQL = "CREATE TABLE " + SHOP_TABLE + "("
			+ SHOP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ SHOP_TITLE + " TEXT, "
			+ SHOP_PRICE + " TEXT, "
			+ SHOP_SALES + " TEXT, "
			+ SHOP_PICTURE + " TEXT);";
	SQLiteDatabase shopDb = null;
	
	//创建用来区分不同URI的常量
	private static final int SHOP = 1;
	private static final int SHOPID = 2;
	//uri地址匹配器
	private static UriMatcher uriMatcher;
	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI("content://com.mycountry.details", "shop", SHOP);
		uriMatcher.addURI("content://com.mycountry.details", "shop/#", SHOPID);
	}
	//创建管理数据的helper类
	private static class ShopDatabaseHelper extends SQLiteOpenHelper{

		public ShopDatabaseHelper(Context context) {
			super(context, SHOP_DATABASE, null, SHOP_DATABASE_VERSION);
			Log.v(TAG, "Shop database create successfully!");
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL(SHOP_SQL);	
			Log.v(TAG, "Shop table create successfully!");
		}
		//升级时调用
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + SHOP_TABLE);
			onCreate(db);//重新创建表	
			
		}
	}
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}
	//取得uri地址对应的操作
	@Override
	public String getType(Uri uri) {
		switch (uriMatcher.match(uri)) {
		case SHOP:
			return "vnd.android.cursor.dir/com.mycountry.details";
		case SHOPID:
			return "vnd.android.cursor.item/com.mycountry.details";
		default:
			throw new IllegalArgumentException("Unsupport URI:" + uri);
		}
	}
	//存储数据
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		Uri uri1 = null;
		long rowId = shopDb.insert(SHOP_TABLE, null, values);
		//返回的rowId > 0
		if(rowId > 0) {
			uri1 = ContentUris.withAppendedId(SHOP_URI, rowId);
			getContext().getContentResolver().notifyChange(uri1, null);
		}
		return uri1;
	}
	//初始化函数
	@Override
	public boolean onCreate() {
		Context context = getContext();
		//实例化数据库帮助类
		ShopDatabaseHelper shopDbHelper = new ShopDatabaseHelper(context);
		//获得对应的是数据库
		shopDb = shopDbHelper.getWritableDatabase();		
		return (shopDb == null) ? false : true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {

		SQLiteQueryBuilder sqb = new SQLiteQueryBuilder();
		sqb.setTables(SHOP_TABLE);//设置查询的表
		//筛选uri地址
		switch (uriMatcher.match(uri)) {
		//查询单个SHOP信息
		case SHOPID:
			sqb.appendWhere(SHOP_ID + "=" + uri.getPathSegments().get(1));			
			break;
		default:
			break;
		}
		String orderBy;		
		if(TextUtils.isEmpty(sortOrder)) {
			orderBy = SHOP_PICTURE;
		}else {
			orderBy = sortOrder;
		}		
		//对底层数据库的应用查询
		Cursor c = sqb.query(shopDb, projection, selection, selectionArgs, null, null, orderBy);
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		int count;
		//匹配uri地址
		switch (uriMatcher.match(uri)) {
		case SHOP:
			count = shopDb.update(SHOP_TABLE, values, selection, selectionArgs);
			break;
		case SHOPID:
			String segment = uri.getPathSegments().get(1);
			count = shopDb.update(SHOP_TABLE, values, SHOP_ID + "=" + segment
					+ (!TextUtils.isEmpty(selection) ? " AND ("
					+ selection +')' : ""), selectionArgs);
			break;
		default:
			throw new IllegalArgumentException("Unkown URI " + uri);
		}
		//通知更改
		getContext().getContentResolver().notifyChange(uri, null);
		return count;
	}
}


