package com.example.funnyface;

import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import android.graphics.Point;
>>>>>>> upstream/master
=======
import android.graphics.Path;
import android.graphics.RectF;
>>>>>>> upstream/master
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;


public class CustomView extends ImageView {
	private static final int INVALID_POINTER_ID = -1;
	
<<<<<<< HEAD
=======
	protected static Bitmap backgroundImage;
>>>>>>> upstream/master
	protected static contents[] bitmap = new contents[20];		//Extension of the class contents
	private float dx, dy;	//Drawing coordinates used to draw of what's suppose to be drawn
	private float x, y;		//Coordinates of the first finger
	private float x2, y2;	//Coordinates of the second finger
	private int ptrID1; 	//To store the pointer ID of the first finger touching the screen
	private int ptrID2;		//To store the pointer ID of the second finger touching the screen
	private float xFirst, yFirst;		//The coordinates of the first time the first finger touch (without dragging)
	private float x2First, y2First;		//The coordinates of the first time the second finger touch <without dragging)
	private float distanceXfrommXLast,distanceYfrommYLast;		//Distance used to see how far the finger has moved
<<<<<<< HEAD
	protected static int index;		//To store the index of current content selected
=======
	protected static int numberOfContents;		//To store the index of the last content. (number of contents in the array)
	protected static int currentContentIndex;		//To store the index of the current content selected
	protected boolean moveContent;			//Boolean to determine whether to move the content or not
    protected static String colorValue;
    protected static String strokeSize;
	protected static String mode;
<<<<<<< HEAD
	List<Point> points = new ArrayList<Point>();
>>>>>>> upstream/master
=======
	
	protected static ArrayList<Path> paths;
	protected static Path path;
	private HashMap<Path, Integer> colorsMap; 
	private HashMap<Path, Integer> strokeMap;
>>>>>>> upstream/master
	
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
		init(context);
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
<<<<<<< HEAD
		index=0;
		ptrID1=INVALID_POINTER_ID;
		ptrID2=INVALID_POINTER_ID;
=======
		ptrID1=INVALID_POINTER_ID;
		ptrID2=INVALID_POINTER_ID;
		mode="add_content";
		moveContent=false;
		numberOfContents=0;
<<<<<<< HEAD
>>>>>>> upstream/master
=======
		path = new Path();
		paths = new ArrayList<Path>();
		colorsMap = new HashMap<Path, Integer>();
		strokeMap = new HashMap<Path, Integer>();
>>>>>>> upstream/master
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
			
<<<<<<< HEAD
=======
			//If the mode is add content, add the the content in the array of contents (bitmap)
			if (mode.equals("add_content")){
				try {
					bitmap[numberOfContents].setXY(xFirst, yFirst);		
					moveContent=false;
					mode="move_content";
					currentContentIndex=numberOfContents;
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
			
<<<<<<< HEAD
>>>>>>> upstream/master
=======
			//Else, Do Paint
			else if (mode.equals("paint")){
				//Add initial point to path of points using the .moveTo method
				path.moveTo(x, y);
				//Add initial point to Path of Points
				paths.add(path);
				//Set Default Color to black
				colorsMap.put(path,Color.BLACK);
				//Color is selected if a button is pressed to select it
				if(colorValue.equals("red")) 
					colorsMap.put(path,Color.RED);
				else if(colorValue.equals("blue"))
					colorsMap.put(path,Color.BLUE);
				else if(colorValue.equals("green"))
					colorsMap.put(path,Color.GREEN);
				else if(colorValue.equals("blue"))
					colorsMap.put(path,Color.RED);
				else if(colorValue.equals("pruple"))
					colorsMap.put(path,Color.MAGENTA);
				else if(colorValue.equals("yellow"))
					colorsMap.put(path,Color.YELLOW);
				else if(colorValue.equals("cyan"))
					colorsMap.put(path,Color.CYAN);
				else if(colorValue.equals("black"))
					colorsMap.put(path,Color.BLACK);
				else if(colorValue.equals("white"))
					colorsMap.put(path,Color.WHITE);
				try
				{
					strokeMap.put(path, 1);
					if(strokeSize.equals("Size1"))
					{
						strokeMap.put(path, 1);
					}
					else if(strokeSize.equals("Size2"))
					{
						strokeMap.put(path, 5);
					}
					else
					{
						strokeMap.put(path, 15);
					}
				}
				catch(Exception e)
				{
					
				}
			}
>>>>>>> upstream/master
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
			
<<<<<<< HEAD
			//Do Drag, if only 1 finger is touching the screen
=======
			//Determine if 1 finger is touching the screen
>>>>>>> upstream/master
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
<<<<<<< HEAD
				try {
					bitmap[index].setXY(dx, dy);
				} catch (NullPointerException e) {
					
				}
				invalidate();	//To force View to Redraw itself
			}
			
			//Do Scaling, if 2 fingers are on the screen
=======
				
				//Do Drag (With Selected Content)
				if (mode.equals("move_content") && moveContent==true){
					try {
						/*float curX=bitmap[currentContentIndex].getX();
						float curY=bitmap[currentContentIndex].getY();
						if (dx<=curX && dy <=curY){
							bitmap[currentContentIndex].setXY(dx+(dx-curX), dy+(dy-curY));
						}*/
						bitmap[currentContentIndex].setXY(dx, dy);		//Set X and Y coordinates of the bitmap to be drawn
						
					}catch (NullPointerException e) {
					}
				}
				//Else, Do Paint (Draw)
				else if (mode.equals("paint")){
					//Adding point to path of points using the .lineTo method
					path.lineTo(x, y);	//SLOWS DOWN CONSIDERABLY AFTER DRAWING FOR A LONG TIME
				}
			       
				//To force View to Redraw itself
				invalidate();	
			}
			
			//Else, Determine if 2 fingers are on the screen
>>>>>>> upstream/master
			else if (ptrID1 != INVALID_POINTER_ID && ptrID2 != INVALID_POINTER_ID){
				pointerIndex = MotionEventCompat.findPointerIndex(event,  ptrID1);
				x=MotionEventCompat.getX(event, pointerIndex);
				y=MotionEventCompat.getY(event, pointerIndex);
				pointerIndex2 = MotionEventCompat.findPointerIndex(event,  ptrID2);
				x2=MotionEventCompat.getX(event, pointerIndex2);
				y2=MotionEventCompat.getY(event, pointerIndex2);
					
			}
			break;
			
		case MotionEvent.ACTION_UP:
			if (mode.equals("move_content")){
				moveContent=false;
			}
			else if (mode.equals("paint")){
				pointerIndex = MotionEventCompat.getActionIndex(event);
				x=MotionEventCompat.getX(event, pointerIndex);
				y=MotionEventCompat.getY(event, pointerIndex);
				path.lineTo(x,y);
				paths.add(path);
				//MUST create a new path object to make a new path of points, old object should get deleted automatically
				path = new Path();
			}
			ptrID1 = INVALID_POINTER_ID;
			break;		
		case MotionEvent.ACTION_POINTER_UP:
			ptrID2 = INVALID_POINTER_ID;
	        break;
		default: break;
		}
		return true;
	}
	
	protected static void undo(){
		numberOfContents = numberOfContents - 1;
	}
	
<<<<<<< HEAD
	
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
<<<<<<< HEAD
			if (bitmap[index].getBitmap()!=null){
				//Set the resized Image
				bitmap[index].setResizedBitmap(Bitmap.createScaledBitmap(bitmap[index].getBitmap(), bitmap[index].getBitmap().getWidth()+(int)distanceXfrommXLast*2, bitmap[index].getBitmap().getHeight()+(int)distanceYfrommYLast*2, true));
				//Set the boolean of resized, inside the contents class to true (So we know when to draw the resized image or the original image otherwise)
				bitmap[index].setBooleanResized(true);
=======
			if (bitmap[currentContentIndex].getBitmap()!=null){
				//Set the resized Image
				bitmap[currentContentIndex].setResizedBitmap(Bitmap.createScaledBitmap(bitmap[currentContentIndex].getBitmap(), bitmap[currentContentIndex].getBitmap().getWidth()+(int)distanceXfrommXLast*2, bitmap[currentContentIndex].getBitmap().getHeight()+(int)distanceYfrommYLast*2, true));
				//Set the boolean of resized, inside the contents class to true (So we know when to draw the resized image or the original image otherwise)
				bitmap[currentContentIndex].setBooleanResized(true);
>>>>>>> upstream/master
				invalidate();	//Force redraw
			}	
		}catch (NullPointerException e) {
			
		}
	}
	
	
=======
>>>>>>> upstream/master
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint paint = new Paint();
		
<<<<<<< HEAD
<<<<<<< HEAD
		for (int i=0; i<=index; i++){
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
=======
		//Draw Point
		for (Point point : points){
			canvas.drawCircle(point.x, point.y, 2, paint); 
>>>>>>> upstream/master
=======
		try
		{
			canvas.drawBitmap(backgroundImage, 0, 0,paint);
			paint.setStyle(Paint.Style.STROKE);			
			paint.setAntiAlias(true);
			
			//Draw Paint
			for (Path p : paths){
				paint.setColor(colorsMap.get(p));
				paint.setStrokeWidth(strokeMap.get(p));
				canvas.drawPath(p,paint);
				
			}	
			
>>>>>>> upstream/master
		}
		catch(Exception e){}
		paint.setStrokeWidth(1);
		for (int i=0; i<numberOfContents; i++){
			System.out.println("---index" + i);
			try {
				//Draw Original image
				if (bitmap[i].getBitmap()!=null && !bitmap[i].getBooleanResized()){
					if (i==currentContentIndex){
						paint.setColor(Color.WHITE);
						RectF targetBox=new RectF(bitmap[i].getX()-bitmap[i].bitmap.getWidth(), bitmap[i].getY()-bitmap[i].bitmap.getHeight(),bitmap[i].getX()+bitmap[i].bitmap.getWidth(), bitmap[i].getY()+bitmap[i].bitmap.getHeight());
						canvas.drawBitmap(bitmap[i].bitmap, null, targetBox, paint);
						canvas.drawRect(targetBox, paint);
						paint.setStyle(Paint.Style.FILL);
						canvas.drawCircle(bitmap[i].getX()-bitmap[i].bitmap.getWidth(), bitmap[i].getY()-bitmap[i].bitmap.getHeight(), 8, paint);
						canvas.drawCircle(bitmap[i].getX()+bitmap[i].bitmap.getWidth(), bitmap[i].getY()-bitmap[i].bitmap.getHeight(), 8, paint);
						canvas.drawCircle(bitmap[i].getX()+bitmap[i].bitmap.getWidth(), bitmap[i].getY()+bitmap[i].bitmap.getHeight(), 8, paint);
						canvas.drawCircle(bitmap[i].getX()-bitmap[i].bitmap.getWidth(), bitmap[i].getY()+bitmap[i].bitmap.getHeight(), 8, paint);
						paint.setStyle(Paint.Style.STROKE);
					}
					else {
						canvas.drawBitmap(bitmap[i].bitmap, bitmap[i].getX()-(bitmap[i].getBitmap().getWidth()/2), bitmap[i].getY()-(bitmap[i].getBitmap().getHeight()/2), paint);
					}
				}
				//Else, draw the resized image
				else if (bitmap[i].getResizedBitmap()!=null && bitmap[i].getBooleanResized()){
					canvas.drawBitmap(bitmap[i].getResizedBitmap(), bitmap[i].getX()-(bitmap[i].getResizedBitmap().getWidth()/2), bitmap[i].getY()-(bitmap[i].getResizedBitmap().getHeight()/2), paint);
				
				}
				
			}
			catch (NullPointerException e){}
		}
	}
}
