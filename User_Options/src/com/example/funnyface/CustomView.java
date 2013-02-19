package com.example.funnyface;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.view.MotionEventCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
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
	
	private float mScaleFactor = 1.0f;
	private ScaleGestureDetector mScaleDetector;
	
	public CustomView(Context context) {
		super(context);
		//mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
		dx=0;
		dy=0;
	}
	
	public CustomView(Context context, AttributeSet attrs){
		super(context,attrs);
		mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
		dx=0;
		dy=0;
	}
	
	public CustomView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		//mScaleDetector = new ScaleGestureDetector(context, new ScaleListener());
		dx=0;
		dy=0;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		//mScaleDetector.onTouchEvent(event);
		
		
		//Get Action event
		int action = MotionEventCompat.getActionMasked(event);
		
		switch(action) {
		case MotionEvent.ACTION_DOWN:
			//Get the Action Index of the first finger
			int pointerIndex = MotionEventCompat.getActionIndex(event);
			x=MotionEventCompat.getX(event, pointerIndex);
			y=MotionEventCompat.getY(event, pointerIndex);
			//Get the pointer ID of the first finger
			ptrID1=MotionEventCompat.getPointerId(event,0);
			ptrID1=INVALID_POINTER_ID;
			break;
		case MotionEvent.ACTION_POINTER_DOWN:
			//Get the Action Index of the second finger
			int pointerIndex2 = MotionEventCompat.getActionIndex(event);
			x2=MotionEventCompat.getX(event, pointerIndex2);
			y2=MotionEventCompat.getY(event, pointerIndex2);
			//Get the pointer ID of the first finger
			ptrID2=MotionEventCompat.getPointerId(event,pointerIndex2);
			break;
		case MotionEvent.ACTION_MOVE:
			//Do Drag, if only 1 fingers
			ptrID1=event.getPointerId(0);
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
				invalidate();	//To force View to Redraw itself
			}
			//Do otherwise, if 2 fingers
			else if (ptrID1 != INVALID_POINTER_ID && ptrID2 != INVALID_POINTER_ID){
				
				pointerIndex = MotionEventCompat.findPointerIndex(event,  ptrID1);
				x=MotionEventCompat.getX(event, pointerIndex);
				y=MotionEventCompat.getY(event, pointerIndex);
				pointerIndex2 = MotionEventCompat.findPointerIndex(event,  ptrID2);
				x2=MotionEventCompat.getX(event, pointerIndex2);
				y2=MotionEventCompat.getY(event, pointerIndex2);

				
				
				System.out.println("x: "+ x + "y: " + y);
				System.out.println("x2: "+ x2 + "y2: " + y2);
				invalidate();
				
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
	
	
	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		Paint paint = new Paint();
		if (mbitmap!=null){
			//resizeImage = Bitmap.createScaledBitmap(mbitmap, mbitmap.getWidth()+(int)x2, mbitmap.getHeight()+(int)y2, true);
			//canvas.scale(mScaleFactor, mScaleFactor);
			canvas.drawBitmap(mbitmap, dx-(mbitmap.getWidth()/2), dy-(mbitmap.getHeight()/2), paint);
		}	
		
	}
	

	
	private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
		@Override
		public boolean onScale(ScaleGestureDetector detector) {
			mScaleFactor *= detector.getScaleFactor();
	        // Don't let the object get too small or too large.
	        mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 5.0f));
	        
	        invalidate();
			return true;
		}
	}
}
