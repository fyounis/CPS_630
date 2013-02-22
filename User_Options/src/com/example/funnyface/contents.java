//Class to store components/contents of the bitmap images
package com.example.funnyface;

import android.graphics.Bitmap;

public class contents {
	public Bitmap bitmap;
	public Bitmap resizedBitmap;
	public float x;
	public float y;
	public boolean resized=false;
	
	//Constructor sets bitmap image
	public contents(Bitmap bitmap){
		this.bitmap = bitmap;
	}
	
	public void setXY(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	//Setter Method to store resized image
	public void setResizedBitmap(Bitmap resizedBitmap){
		this.resizedBitmap = resizedBitmap;
	}
	
	public Bitmap getResizedBitmap(){
		return resizedBitmap;
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
	
	//Setter method to determine is bitmap has been resized
	public void setBooleanResized(boolean resized){
		this.resized=resized;
	}
	
	//Getter method to return if the image has been resized or not
	public boolean getBooleanResized(){
		return resized;
	}
}
