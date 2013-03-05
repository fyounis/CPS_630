package com.example.funnyface;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;


public class CustomView extends ImageView {
	private static final int INVALID_POINTER_ID = -1;
	
	protected static Bitmap backgroundImage;
	protected static contents[] bitmap = new contents[20];		//Extension of the class contents
	private float dx, dy;	//Drawing coordinates used to draw of what's suppose to be drawn
	private float x, y;		//Coordinates of the first finger
	private float x2, y2;	//Coordinates of the second finger
	private int ptrID1; 	//To store the pointer ID of the first finger touching the screen
	private int ptrID2;		//To store the pointer ID of the second finger touching the screen
	private float xFirst, yFirst;		//The coordinates of the first time the first finger touch (without dragging)
	private float x2First, y2First;		//The coordinates of the first time the second finger touch <without dragging)
	private float distanceXfrommXLast,distanceYfrommYLast;		//Distance used to see how far the finger has moved
	protected static int numberOfContents;		//To store the index of the last content. (number of contents in the array)
	protected static int currentContentIndex;		//To store the index of the current content selected
	protected boolean moveContent;			//Boolean to determine whether to move the content or not
    protected static String colorValue;

	protected static String mode;
	List<Point> points = new ArrayList<Point>();
	
	public CustomView(Context context) {
		super(context);
		init(context);
	}
	
	public CustomView(Context context, AttributeSet attrs){
		super(context,attrs);
		init(context);
	}
	
	public CustomView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	
	public void init(Context context){
		dx=0;
		dy=0;
		x=0;
		y=0;
		x2=0;
		y2=0;
		distanceXfrommXLast=0;
		distanceYfrommYLast=0;
		ptrID1=INVALID_POINTER_ID;
		ptrID2=INVALID_POINTER_ID;
		mode="add_content";
		moveContent=false;
		numberOfContents=0;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {	
		//Get Action event
		int action = MotionEventCompat.getActionMasked(event);
		
		switch(action) {
		case MotionEvent.ACTION_DOWN:
			//Get the Action Index of the first finger
			int pointerIndex = MotionEventCompat.getActionIndex(event);
			x=MotionEventCompat.getX(event, pointerIndex);
			y=MotionEventCompat.getY(event, pointerIndex);
			
			//keep track of the first coordinates touched from the first finger
			xFirst=x;
			yFirst=y;
			
			//Get the pointer ID of the first finger
			ptrID1=MotionEventCompat.getPointerId(event,0);
			ptrID1=INVALID_POINTER_ID;
			
			//If the mode is add content, add the the content in the array of contents (bitmap)
			if (mode.equals("add_content")){
				try {
					bitmap[numberOfContents].setXY(xFirst, yFirst);		
					moveContent=false;
					mode="move_content";
					numberOfContents=numberOfContents+1;
				} catch (NullPointerException e){
					
				}
				
			}
			//Else, if the mode selected is Move Contents around, then perform the following
			else if (mode.equals("move_content")){
				for (int i=0;i<numberOfContents;i++){
					try {
						//When getting the x and y coordinates of the content, 
						//it'll return the middle coordinates of the content.
						//Must do the following to get xMin, xMax, yMin, and yMax of content
						float xCoordinateOfBitmap=bitmap[i].getX()-bitmap[i].bitmap.getWidth();		
						float maxXCoordinateOfBitmap=bitmap[i].getX()+bitmap[i].bitmap.getWidth();
						float yCoordinateOfBitmap=bitmap[i].getY()-bitmap[i].bitmap.getHeight();
						float maxYCoordinateOfBitmap=bitmap[i].getY()+bitmap[i].bitmap.getHeight();
						
						//If the finger touched the content, then assign it the moveIndex ID
						if (xCoordinateOfBitmap < xFirst && xFirst < maxXCoordinateOfBitmap &&
								yCoordinateOfBitmap < yFirst && yFirst < maxYCoordinateOfBitmap){				
								currentContentIndex=i;
								moveContent=true;
						}
					} catch (NullPointerException e){
						
					}
				}
			}
			
			break;
			
		case MotionEvent.ACTION_POINTER_DOWN:
			//Get the Action Index of the second finger
			int pointerIndex2 = MotionEventCompat.getActionIndex(event);
			x2=MotionEventCompat.getX(event, pointerIndex2);
			y2=MotionEventCompat.getY(event, pointerIndex2);
			
			//keep track of the first coordinates touched from the second finger
			x2First=x2;
			y2First=y2;
			
			//Get the pointer ID of the second finger
			ptrID2=MotionEventCompat.getPointerId(event,pointerIndex2);
			break;
			
		case MotionEvent.ACTION_MOVE:
			ptrID1=event.getPointerId(0);	//Get the pointer ID of the first finger
			
			//Determine if 1 finger is touching the screen
			if (ptrID1 != INVALID_POINTER_ID && ptrID2 == INVALID_POINTER_ID){
				pointerIndex = MotionEventCompat.findPointerIndex(event,  ptrID1);
			   	try {
			   		x=MotionEventCompat.getX(event, pointerIndex);	
			   		y=MotionEventCompat.getY(event, pointerIndex);
			   	} catch (ArrayIndexOutOfBoundsException e){
			   		e.printStackTrace();
			   	}
				dx=x;
				dy=y;
				
				//Do Drag (With Selected Content)
				if (mode.equals("move_content") && moveContent==true){
					try {
						bitmap[currentContentIndex].setXY(dx, dy);		//Set X and Y coordinates of the bitmap to be drawn
						
					}catch (NullPointerException e) {
					}
				}
				//Else, Do Paint (Draw)
				else if (mode.equals("paint")){
					paintOnScreen(dx,dy,event);
				}
			       
				//To force View to Redraw itself
				invalidate();	
			}
			
			//Else, Determine if 2 fingers are on the screen
			else if (ptrID1 != INVALID_POINTER_ID && ptrID2 != INVALID_POINTER_ID){
				pointerIndex = MotionEventCompat.findPointerIndex(event,  ptrID1);
				x=MotionEventCompat.getX(event, pointerIndex);
				y=MotionEventCompat.getY(event, pointerIndex);
				pointerIndex2 = MotionEventCompat.findPointerIndex(event,  ptrID2);
				x2=MotionEventCompat.getX(event, pointerIndex2);
				y2=MotionEventCompat.getY(event, pointerIndex2);
				
				//scale image
				scaleImage(x,y,x2,y2);
				
			}
			break;
			
		case MotionEvent.ACTION_UP:
			ptrID1 = INVALID_POINTER_ID;	
			break;		
		case MotionEvent.ACTION_POINTER_UP:
			ptrID2 = INVALID_POINTER_ID;
	        break;
		default: break;
		}
		return true;
	}
	
	private void paintOnScreen(float x, float y, MotionEvent event){
		Point point = new Point();
		point.x = (int) event.getX();
		point.y = (int) event.getY();
		points.add(point);	
	}
	
	protected static void undo(){
		numberOfContents = numberOfContents - 1;
		
	}
	
	
	private void scaleImage(float x, float y, float x2, float y2){
		if (x2>x){
			distanceXfrommXLast=x2-x2First;
			if (distanceXfrommXLast<0){
				distanceXfrommXLast=0;
			}
		}
		else if (x>x2){
			distanceXfrommXLast=x-xFirst;
			if (distanceXfrommXLast<0){
				distanceXfrommXLast=0;
			}
		}
		if (y2>y) {
			distanceYfrommYLast=y2-y2First;
			if (distanceYfrommYLast<0){
				distanceYfrommYLast=0;
			}
		}
		else if (y>y2){
			distanceYfrommYLast=y-yFirst;
			if (distanceYfrommYLast<0){
				distanceYfrommYLast=0;
			}
		}
		try {
			if (bitmap[currentContentIndex].getBitmap()!=null){
				//Set the resized Image
				bitmap[currentContentIndex].setResizedBitmap(Bitmap.createScaledBitmap(bitmap[currentContentIndex].getBitmap(), bitmap[currentContentIndex].getBitmap().getWidth()+(int)distanceXfrommXLast*2, bitmap[currentContentIndex].getBitmap().getHeight()+(int)distanceYfrommYLast*2, true));
				//Set the boolean of resized, inside the contents class to true (So we know when to draw the resized image or the original image otherwise)
				bitmap[currentContentIndex].setBooleanResized(true);
				invalidate();	//Force redraw
			}	
		}catch (NullPointerException e) {
			
		}
	}
	
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint paint = new Paint();
		try
		{
			System.out.println(colorValue);
			if(colorValue.equals("red"))
			{
				paint.setColor(Color.RED);
				//Draw Point
			}
			else if(colorValue.equals("blue"))
			{
				paint.setColor(Color.BLUE);
			}
			else if(colorValue.equals("green"))
			{
				paint.setColor(Color.GREEN);
			}
			else if(colorValue.equals("blue"))
			{
				paint.setColor(Color.BLUE);
			}
			else if(colorValue.equals("pruple"))
			{
				paint.setColor(Color.MAGENTA);
			}
			else if(colorValue.equals("yellow"))
			{
				paint.setColor(Color.YELLOW);
			}
			else if(colorValue.equals("cyan"))
			{
				paint.setColor(Color.CYAN);
			}
			else if(colorValue.equals("black"))
			{
				paint.setColor(Color.BLACK);
			}
			else if(colorValue.equals("white"))
			{
				paint.setColor(Color.WHITE);
			}
			
			
		}
		catch(Exception e)
		{
			
		}
		
		try {
			canvas.drawBitmap(backgroundImage, 0, 0,paint);
		} catch (NullPointerException e){}
		
		//Draw Point
		for (Point point : points){
			canvas.drawCircle(point.x, point.y, 2, paint); 
		}
		
		for (int i=0; i<numberOfContents; i++){
			System.out.println("---index" + i);
			try {
				//Draw Original image
				if (bitmap[i].getBitmap()!=null && !bitmap[i].getBooleanResized()){
					canvas.drawBitmap(bitmap[i].bitmap, bitmap[i].getX()-(bitmap[i].getBitmap().getWidth()/2), bitmap[i].getY()-(bitmap[i].getBitmap().getHeight()/2), paint);
				}
				//Else, draw the resized image
				else if (bitmap[i].getResizedBitmap()!=null && bitmap[i].getBooleanResized()){
					canvas.drawBitmap(bitmap[i].getResizedBitmap(), bitmap[i].getX()-(bitmap[i].getResizedBitmap().getWidth()/2), bitmap[i].getY()-(bitmap[i].getResizedBitmap().getHeight()/2), paint);
				}
			}
			catch (NullPointerException e){
			}
		}
		
		
	}
}