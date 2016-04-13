package com.mycountry.activity;

import java.io.Serializable;

import android.graphics.Bitmap;
import android.net.Uri;

public class Imagehello implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 11;
	private Uri uri;
    private Bitmap bitmap;
	
	public Bitmap getBitmap() {
		return bitmap;
	}
	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}
	public Uri getUri() {
		return uri;
	}
	public void setUri(Uri uri) {
		this.uri = uri;
	}
}
