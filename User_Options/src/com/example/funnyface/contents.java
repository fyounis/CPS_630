//Class to store components/contents of the bitmap images
package com.example.funnyface;

import android.graphics.Bitmap;

public class contents {
	public Bitmap bitmap;
	public Bitmap originalBitmap;
	public float x;
	public float y;
	
	//Constructor sets bitmap image
	public contents(Bitmap bitmap){
		this.bitmap = bitmap;
	}
	
	public void setXY(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	//Setter Method to store resized image	
	public void setOriginalBitmap(Bitmap resizedBitmap){
		this.originalBitmap = resizedBitmap;
	}
	
	public Bitmap getOriginalBitmap(){
		return originalBitmap;
	}
	
	public Bitmap getBitmap(){
		return bitmap;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
}
