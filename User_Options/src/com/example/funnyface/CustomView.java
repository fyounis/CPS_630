package com.example.funnyface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

public class CustomView extends ImageView {

	private static final int INVALID_POINTER_ID = -1;
	protected static Bitmap mbitmap;
	protected static Bitmap resizeImage;
	private float dx, dy;
	private float x, y;
	private float x2=0, y2=0;
	private int ptrID1=INVALID_POINTER_ID; 
	private int ptrID2=INVALID_POINTER_ID;
	private float xFirst, x2First, yFirst, y2First;
	private float distanceXfrommXLast=0,distanceYfrommYLast=0;
	
	private boolean isScaling=false;
	
	public CustomView(Context context) {
		super(context);
		dx=0;
		dy=0;
	}
	
	public CustomView(Context context, AttributeSet attrs){
		super(context,attrs);
		dx=0;
		dy=0;
	}
	
	public CustomView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		dx=0;
		dy=0;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {	
		//Get Action event
		int action = MotionEventCompat.getActionMasked(event);
		
		switch(action) {
		case MotionEvent.ACTION_DOWN:
			isScaling=false;
			//Get the Action Index of the first finger
			int pointerIndex = MotionEventCompat.getActionIndex(event);
			x=MotionEventCompat.getX(event, pointerIndex);
			y=MotionEventCompat.getY(event, pointerIndex);
			
			//keep track of the first coordinates touched
			xFirst=x;
			yFirst=y;
			
			//Get the pointer ID of the first finger
			ptrID1=MotionEventCompat.getPointerId(event,0);
			ptrID1=INVALID_POINTER_ID;
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			isScaling=true;
			//Get the Action Index of the second finger
			int pointerIndex2 = MotionEventCompat.getActionIndex(event);
			x2=MotionEventCompat.getX(event, pointerIndex2);
			y2=MotionEventCompat.getY(event, pointerIndex2);
			
			//keep track of the first coordinates touched from the second finger
			x2First=x2;
			y2First=y2;
			
			//Get the pointer ID of the first finger
			ptrID2=MotionEventCompat.getPointerId(event,pointerIndex2);
			break;
		case MotionEvent.ACTION_MOVE:
			//Do Drag, if only 1 fingers
			ptrID1=event.getPointerId(0);
			if (ptrID1 != INVALID_POINTER_ID && ptrID2 == INVALID_POINTER_ID && isScaling==false){
				pointerIndex = MotionEventCompat.findPointerIndex(event,  ptrID1);
			   	try {
			   		x=MotionEventCompat.getX(event, pointerIndex);	
			   		y=MotionEventCompat.getY(event, pointerIndex);
			   	} catch (ArrayIndexOutOfBoundsException e){
			   		e.printStackTrace();
			   	}
				dx=x;
				dy=y;
				invalidate();	//To force View to Redraw itself
			}
			//Do otherwise, if 2 fingers
			else if (ptrID1 != INVALID_POINTER_ID && ptrID2 != INVALID_POINTER_ID && isScaling==true){
				pointerIndex = MotionEventCompat.findPointerIndex(event,  ptrID1);
				x=MotionEventCompat.getX(event, pointerIndex);
				y=MotionEventCompat.getY(event, pointerIndex);
				pointerIndex2 = MotionEventCompat.findPointerIndex(event,  ptrID2);
				x2=MotionEventCompat.getX(event, pointerIndex2);
				y2=MotionEventCompat.getY(event, pointerIndex2);

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
		invalidate();
	}
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint paint = new Paint();
		if (mbitmap!=null){
			resizeImage = Bitmap.createScaledBitmap(mbitmap, mbitmap.getWidth()+(int)distanceXfrommXLast*2, mbitmap.getHeight()+(int)distanceYfrommYLast*2, true);
			canvas.drawBitmap(resizeImage, dx-(resizeImage.getWidth()/2), dy-(resizeImage.getHeight()/2), paint);
		}	
		
	}
}
