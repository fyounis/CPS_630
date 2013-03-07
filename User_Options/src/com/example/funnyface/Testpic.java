package com.example.funnyface;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Path;
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
<<<<<<< HEAD
					CustomView.bitmap[CustomView.index] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
=======
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher));
>>>>>>> upstream/master
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
<<<<<<< HEAD
					CustomView.bitmap[CustomView.index] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.moustache));
=======
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.moustache));
>>>>>>> upstream/master
				} catch (NullPointerException e) {
					
				}
			}
		});
		
		final Button button3 = (Button) findViewById(R.id.button3);
		button3.setBackgroundColor(Color.BLACK);
		button3.setTextColor(Color.WHITE);
		final Button whiteColor = (Button) findViewById(R.id.button11);
		whiteColor.setBackgroundColor(Color.WHITE);
		final Button redColor = (Button) findViewById(R.id.button12);
		redColor.setBackgroundColor(Color.RED);
		final Button blueColor = (Button) findViewById(R.id.button13);
		blueColor.setBackgroundColor(Color.BLUE);
		final Button greenColor = (Button) findViewById(R.id.button14);
		greenColor.setBackgroundColor(Color.GREEN);
		final Button purpleColor = (Button) findViewById(R.id.button15);
		purpleColor.setBackgroundColor(Color.MAGENTA);
		final Button yellowColor = (Button) findViewById(R.id.button16);
		yellowColor.setBackgroundColor(Color.YELLOW);
		final Button cyanColor = (Button) findViewById(R.id.button17);
		cyanColor.setBackgroundColor(Color.CYAN);
		final Button ThinStroke = (Button) findViewById(R.id.button18);
		final Button MediumStroke = (Button) findViewById(R.id.button19);
		final Button ThickStroke = (Button) findViewById(R.id.button21);
		
	
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				try{
						CustomView.mode = "paint";
						button3.setBackgroundColor(Color.BLACK);
						button3.setTextColor(Color.WHITE);
						CustomView.colorValue = "BLACK";
				   }
				   catch(NullPointerException e)
				   {
					
				   }
				
			}
		});
		
			whiteColor.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				try{
						CustomView.mode = "paint";
						whiteColor.setBackgroundColor(Color.WHITE);
						whiteColor.setTextColor(Color.BLACK);
						CustomView.colorValue = "WHITE";
				   }
				   catch(NullPointerException e)
				   {
					
				   }
				
			}
		});
		
		redColor.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v)
			{
				try
				{
<<<<<<< HEAD
				// TODO Auto-generated method stub
<<<<<<< HEAD
				CustomView.index+=1;
=======
				CustomView.mode = "paint";
				}catch(NullPointerException e){
=======
					CustomView.mode = "paint";
					redColor.setBackgroundColor(Color.RED);
					CustomView.colorValue = "red";
				}
				catch(NullPointerException e)
				{
					
				}
			}
		
		});

		blueColor.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v)
			{
				try
				{
					CustomView.mode = "paint";
					blueColor.setBackgroundColor(Color.BLUE);
					CustomView.colorValue = "blue";
				}
				catch(NullPointerException e)
				{
					
				}
			}
		});
		greenColor.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v)
			{
				try
				{
					CustomView.mode = "paint";
					greenColor.setBackgroundColor(Color.GREEN);
					CustomView.colorValue = "green";
				}
				catch(NullPointerException e)
				{
					
				}
			}
		});
		yellowColor.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v)
			{
				try
				{
					CustomView.mode = "paint";			
					yellowColor.setBackgroundColor(Color.YELLOW);
					CustomView.colorValue = "yellow";
				}
				catch(NullPointerException e)
				{
					
				}
			}
		});
		purpleColor.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v)
			{
				try
				{
					CustomView.mode = "paint";
					purpleColor.setBackgroundColor(Color.GRAY);
					CustomView.colorValue = "purple";
				}
				catch(NullPointerException e)
				{
					
				}
			}
		});
		cyanColor.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v)
			{
				try
				{
					CustomView.mode = "paint";
					cyanColor.setBackgroundColor(Color.CYAN);
					CustomView.colorValue = "cyan";
				}
				catch(NullPointerException e)
				{
>>>>>>> upstream/master
					
				}
			}
		});
		ThinStroke.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) 
			{
				try
				{
					CustomView.strokeSize = "Size1";
				}
				catch(Exception e)
				{
					
				}
				
			}
	
		});
		MediumStroke.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) 
			{
				try
				{
					CustomView.strokeSize = "Size2";
				}
				catch(Exception e)
				{
					
				}
				
			}
	
		});
		ThickStroke.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) 
			{
				try
				{
					
					CustomView.strokeSize = "Size3";
				}
				catch(Exception e)
				{
					
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
>>>>>>> upstream/master
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
                			for(Path p: CustomView.paths)
                			{
                					p.reset( ); 

                			}
                			
                            if(CustomView.numberOfContents != 0){
                       
                               int i;
                               for(i=0;i<=CustomView.numberOfContents;i++)
                               {
                                  CustomView.bitmap[i]=null;
                               }
                      
                               Toast.makeText(getApplicationContext(), "Components Removed",Toast.LENGTH_LONG).show();
                            }
                            else{
                               Toast.makeText(getApplicationContext(), "No Components to Remove", Toast.LENGTH_LONG).show();
                            }
                            view.invalidate();
                }catch(NullPointerException e){
                        
                }
            }
        });
        
        final Button newPictureButton = (Button) findViewById(R.id.button11);
        newPictureButton.setOnClickListener(new View.OnClickListener()
        {
			@Override
			public void onClick(View v)
			{
				AlertDialog newPic = new AlertDialog.Builder(Testpic.this).create();
				newPic.setTitle("New Picture");
				newPic.setMessage("Are you sure you want to exit Editor? Your data will be lost.");
				newPic.setButton( Dialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() 
				{
			        public void onClick(DialogInterface dialog, int which)
			        { 
			        	try
			        	{

			        		//Upon exiting activity, I don't think its returning the memory back.
			        		//It fails when I try to pick a new pic
			        		finish( );
			        		Testpic.this.onDestroy();

			        		CustomView.backgroundImage.recycle();
			        		Intent newPic = new Intent(Testpic.this, UserPhotoOptions.class);
			        		startActivity(newPic);
			    
			        	}catch(Exception e){
			        		
			        	}
			        }
			     });
				
				newPic.setButton( Dialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() 
				{
			        public void onClick(DialogInterface dialog, int which)
			        { 
			            // Don't continue with delete
			        }
			     });
				newPic.show();
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
