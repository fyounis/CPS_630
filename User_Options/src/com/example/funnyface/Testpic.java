package com.example.funnyface;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressLint("SdCardPath")
public class Testpic extends Activity
{
	private View view;
	private boolean showToolBar=true;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testpic);
		view = (ImageView) findViewById(R.id.imageView1);
		if(Global.mode.equals("Camera"))
		{
			try {
				CustomView.backgroundImage=BitmapFactory.decodeFile(Global.picturePath);
			} catch (NullPointerException e){}
			
		}
		else if(Global.mode.equals("Gallery"))
		{
			try {
			CustomView.backgroundImage=BitmapFactory.decodeFile(Global.picturePath);
			} catch (NullPointerException e){}
		}
	
		final ImageButton button = (ImageButton) findViewById(R.id.button1);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		final ImageButton button2 = (ImageButton) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.moustache));
				} catch (NullPointerException e) {
					
				}
			}
		});
		
		final Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				try
				{
				// TODO Auto-generated method stub
				CustomView.mode = "paint";
				}catch(NullPointerException e){
					
				}
			}
		});
		
		final Button undoButton = (Button) findViewById(R.id.button7);
		undoButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				try
				{
							System.out.println("*****before: " + CustomView.numberOfContents);
							CustomView.bitmap[CustomView.numberOfContents]=null;
							CustomView.numberOfContents=CustomView.numberOfContents-1;
							System.out.println("******after: " + CustomView.numberOfContents);
							if (CustomView.numberOfContents<=0){
								CustomView.bitmap[0]=null;
								CustomView.numberOfContents=0;
							}
							view.invalidate();
							Toast.makeText(getApplicationContext(), "Component Removed", Toast.LENGTH_LONG).show();
				}
				catch(NullPointerException e){
					
				}
			}
		});
		
		final Button UndoThis = (Button) findViewById(R.id.button10);
		UndoThis.setOnClickListener(new View.OnClickListener( ) {

			@Override
			public void onClick(View v) 
			{
				try
				{
							if(CustomView.numberOfContents != 0){
							   CustomView.bitmap[CustomView.currentContentIndex] = null;
							   Toast.makeText(getApplicationContext(), "Component Removed", Toast.LENGTH_LONG).show();
							   view.invalidate();
							}
							else{
							   Toast.makeText(getApplicationContext(), "No Components to Remove", Toast.LENGTH_LONG).show();
							}
				}catch(NullPointerException e){
					
				}
			}
		});
		
	    final Button ResetButton = (Button) findViewById(R.id.button9);
        ResetButton.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v)
           {
                try
                {
                            if(CustomView.numberOfContents != 0){
                               int i;
                               for(i=0;i<=CustomView.numberOfContents;i++)
                               {
                                  CustomView.bitmap[i]=null;
                               }
                               view.invalidate();
                               Toast.makeText(getApplicationContext(), "Components Removed",Toast.LENGTH_LONG).show();
                            }
                            else{
                               Toast.makeText(getApplicationContext(), "No Components to Remove", Toast.LENGTH_LONG).show();
                            }
                }catch(NullPointerException e){
                        
                }
            }
        });
		 
		final Button toolsButton = (Button) findViewById(R.id.button8);
        toolsButton.setTextColor(Color.parseColor("#FF0000"));
        toolsButton.setText("HideTools");
		toolsButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				try
				{
					if (showToolBar==true){
                    HorizontalScrollView hs1 =(HorizontalScrollView)findViewById(R.id.horizontalScrollView1);
                    hs1.setVisibility(View.INVISIBLE);
                    toolsButton.setTextColor(Color.parseColor("#00FF00"));
                    toolsButton.setText("ShowTools");
                    showToolBar=false;
					}
					else if (showToolBar==false) {
                        HorizontalScrollView hs1 = (HorizontalScrollView)findViewById(R.id.horizontalScrollView1);
                        hs1.setVisibility(View.VISIBLE);
                        toolsButton.setTextColor(Color.parseColor("#FF0000"));
                        toolsButton.setText("HideTools");
                        showToolBar=true;
					}
				}catch(NullPointerException e){
					
				}
			
			}
		});
		
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		//getMenuInflater().inflate(R.menu.activity_testpic, menu);
		return true;
	}
	
}
