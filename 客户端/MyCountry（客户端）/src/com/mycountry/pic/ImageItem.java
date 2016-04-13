package com.mycountry.pic;

import java.io.Serializable;

/**
 * 涓�涓浘鐗囧璞�
 * 
 * @author Administrator
 * 
 */
public class ImageItem implements Serializable {
	public String imageId;
	public String thumbnailPath;
	public String imagePath;
	public boolean isSelected = false;
}
