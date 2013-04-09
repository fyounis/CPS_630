package com.example.funnyface;

import java.util.ArrayList;
import java.util.HashMap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;


public class CustomView extends ImageView {
	private static final int INVALID_POINTER_ID = -1;
	
	protected static Bitmap backgroundImage;
	protected static contents[] bitmap = new contents[20];		//Extension of the class contents
	private float dx, dy;	//Drawing coordinates used to draw of what's suppose to be drawn
	private float x, y;		//Coordinates of the first finger
	//private float x2, y2;	//Coordinates of the second finger
	private int ptrID1; 	//To store the pointer ID of the first finger touching the screen
	private int ptrID2;		//To store the pointer ID of the second finger touching the screen
	private float xFirst, yFirst;		//The coordinates of the first time the first finger touch (without dragging)
	//private float x2First, y2First;		//The coordinates of the first time the second finger touch <without dragging)
	//private float distanceXfrommXLast,distanceYfrommYLast;		//Distance used to see how far the finger has moved
	protected static int numberOfContents;		//To store the index of the last content. (number of contents in the array)
	protected static int currentContentIndex;		//To store the index of the current content selected
	protected boolean moveContent;			//Boolean to determine whether to move the content or not
    protected static String colorValue;
    protected static String strokeSize;
	protected static String mode;
	
	protected static ArrayList<Path> paths;
	protected static Path path;
	private HashMap<Path, Integer> colorsMap; 
	private HashMap<Path, Integer> strokeMap;
	
	protected static RectF targetBox;
    protected static Rect upperLeft;
	protected static Rect lowerLeft;
	protected static Rect lowerRight;
	protected static Rect upperRight;
	
	protected static Bitmap toDisk;
	
	
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
		
		ptrID1=INVALID_POINTER_ID;
		ptrID2=INVALID_POINTER_ID;
		mode="add_content";
		moveContent=false;
		numberOfContents=0;
		path = new Path();
		paths = new ArrayList<Path>();
		colorsMap = new HashMap<Path, Integer>();
		strokeMap = new HashMap<Path, Integer>();
		
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
					currentContentIndex=numberOfContents;
					numberOfContents=numberOfContents+1;
					//prepareContentToDraw(currentContentIndex);
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
						
						if (lowerRight.right+10 > xFirst && lowerRight.left-10 < xFirst && lowerRight.top-10 < yFirst && lowerRight.bottom+10 > yFirst){
							currentContentIndex=i;
							moveContent=false;
							mode="scale";
							
						}
						else if (upperRight.right+10 > xFirst && upperRight.left-10 < xFirst && upperRight.top-10 < yFirst && upperRight.bottom+10 > yFirst){
							currentContentIndex=i;
							moveContent=false;
							mode="scale";
							
						}
						
						else if (lowerLeft.right+10 > xFirst && lowerLeft.left-10 < xFirst && lowerLeft.top-10 < yFirst && lowerLeft.bottom+10 > yFirst){
							currentContentIndex=i;
							moveContent=false;
							mode="scale";
						
						}
						else if (upperLeft.right+10 > xFirst && upperLeft.left-10 < xFirst && upperLeft.top-10 < yFirst && upperLeft.bottom+10 > yFirst){
							currentContentIndex=i;
							moveContent=false;
							mode="scale";
							
						}
	
						
					} catch (NullPointerException e){
						
					}
				}
			}
			
			//Else, Do Paint
			else if (mode.equals("paint")){
				//Add initial point to path of points using the .moveTo method
				path.moveTo(x, y);
				//Add initial point to Path of Points
				paths.add(path);
				//Set Default Color to black
				colorsMap.put(path,Color.WHITE);
				//Color is selected if a button is pressed to select it
				if(colorValue.equals("red")) 
					colorsMap.put(path,Color.RED);
				else if(colorValue.equals("blue"))
					colorsMap.put(path,Color.BLUE);
				else if(colorValue.equals("green"))
					colorsMap.put(path,Color.GREEN);
				else if(colorValue.equals("blue"))
					colorsMap.put(path,Color.RED);
				else if(colorValue.equals("purple"))
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
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			//Get the Action Index of the second finger
			int pointerIndex2 = MotionEventCompat.getActionIndex(event);
			//x2=MotionEventCompat.getX(event, pointerIndex2);
			//y2=MotionEventCompat.getY(event, pointerIndex2);
			
			//keep track of the first coordinates touched from the second finger
			//x2First=x2;
			//y2First=y2;
			
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
						float differenceX=0;
						differenceX=dx-xFirst;
						float differenceY=0;
						differenceY=dy-yFirst;
						
						bitmap[currentContentIndex].setXY(bitmap[currentContentIndex].getX()+differenceX, bitmap[currentContentIndex].getY()+differenceY);		//Set X and Y coordinates of the bitmap to be drawn		
						
						xFirst=dx;
						yFirst=dy;
						
					}catch (NullPointerException e) {
					}
				}
				else if (mode.equals("scale")) {
					float differenceX=0;
					differenceX=dx-xFirst;
					float differenceY=0;
					differenceY=dy-yFirst;
					
					bitmap[currentContentIndex].bitmap=getResizedBitmap(bitmap[currentContentIndex].originalBitmap, (int)(bitmap[currentContentIndex].bitmap.getHeight()+differenceY), (int)(bitmap[currentContentIndex].bitmap.getWidth()+differenceX));
					xFirst=dx;
					yFirst=dy;
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
			else if (ptrID1 != INVALID_POINTER_ID && ptrID2 != INVALID_POINTER_ID){
				pointerIndex = MotionEventCompat.findPointerIndex(event,  ptrID1);
				x=MotionEventCompat.getX(event, pointerIndex);
				y=MotionEventCompat.getY(event, pointerIndex);
				pointerIndex2 = MotionEventCompat.findPointerIndex(event,  ptrID2);
				//x2=MotionEventCompat.getX(event, pointerIndex2);
				//y2=MotionEventCompat.getY(event, pointerIndex2);
					
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
			else if (mode.equals("scale")){
				mode="move_content";
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
	
	public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth){
		
		if (newHeight>0 && newWidth>0){
			int width = bm.getWidth();
			int height = bm.getHeight();
			
			float scaleWidth = ((float) newWidth) / width;
			float scaleHeight = ((float) newHeight) / height;
	
			Matrix matrix = new Matrix();
	
			matrix.postScale(scaleWidth, scaleHeight);
	
			Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
			return resizedBitmap;
		}
		else {
			return bm;
		}
		
		
	}
	
	protected void prepareContentToDraw(int i){
		float upperX=bitmap[i].getX()-bitmap[i].bitmap.getWidth();
		float upperY=bitmap[i].getY()-bitmap[i].bitmap.getHeight();
		float lowerX=bitmap[i].getX()+bitmap[i].bitmap.getWidth();
		float lowerY=bitmap[i].getY()+bitmap[i].bitmap.getHeight();
		
		targetBox=new RectF(upperX,upperY,lowerX,lowerY);
		
		upperLeft=new Rect();
		upperLeft.set((int)targetBox.left-5, (int)targetBox.top-5, (int)targetBox.left+5, (int)targetBox.top+5);
		lowerLeft=new Rect();
		lowerLeft.set((int)targetBox.left-5, (int)targetBox.bottom-5, (int)targetBox.left+5, (int)targetBox.bottom+5);
		lowerRight=new Rect();
		lowerRight.set((int)targetBox.right-5, (int)targetBox.bottom-5, (int)targetBox.right+5, (int)targetBox.bottom+5);
		upperRight=new Rect();
		upperRight.set((int)targetBox.right-5, (int)targetBox.top-5, (int)targetBox.right+5, (int)targetBox.top+5);
	}
	
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		this.getDrawingCache(true);
		Paint paint = new Paint();
		
		paint.setStyle(Paint.Style.STROKE);			
		paint.setAntiAlias(true);
		
		paint.setStrokeWidth(1);
		for (int i=0; i<numberOfContents; i++){
			System.out.println("---index" + i);
			try {
				//Draw Original image
				if (bitmap[i].getBitmap()!=null){
					if (i==currentContentIndex){
						paint.setColor(Color.WHITE);
						
						prepareContentToDraw(i);
						
						canvas.drawBitmap(bitmap[i].bitmap, null, targetBox, paint);
						canvas.drawRect(targetBox, paint);
						paint.setStyle(Paint.Style.FILL);
						canvas.drawRect(upperLeft, paint);
						canvas.drawRect(lowerLeft, paint);
						canvas.drawRect(lowerRight, paint);
						canvas.drawRect(upperRight, paint);
						paint.setStyle(Paint.Style.STROKE);
					}
					else {
						prepareContentToDraw(i);
						canvas.drawBitmap(bitmap[i].bitmap, null, targetBox, paint);
					}
				}
		
			}
			catch (NullPointerException e){}
		}
		
		try
		{
			//canvas.drawBitmap(backgroundImage, 0, 0,paint);
			paint.setStyle(Paint.Style.STROKE);			
			paint.setAntiAlias(true);
			
			//Draw Paint
			for (Path p : paths){
				paint.setColor(colorsMap.get(p));
				paint.setStrokeWidth(strokeMap.get(p));
				canvas.drawPath(p,paint);
				
			}	
			
		}
		catch(Exception e){}
		
		
		
	}
}
