package com.example.funnyface;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.Toast;

@SuppressLint("SdCardPath")
public class Testpic extends Activity
{
	private CustomView view;
	private boolean showToolBar=true;
	private Bitmap backgroundImage;
	FileOutputStream fos = null;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testpic);
		view = (CustomView) findViewById(R.id.imageView1);
		if(Global.mode.equals("Camera"))
		{
			try {
				//CustomView.backgroundImage=BitmapFactory.decodeFile(Global.picturePath);
				backgroundImage=BitmapFactory.decodeFile(Global.picturePath);
				view.setImageBitmap(backgroundImage);
			} catch (NullPointerException e){}
			
		}
		else if(Global.mode.equals("Gallery"))
		{
			try {
			//CustomView.backgroundImage=BitmapFactory.decodeFile(Global.picturePath);
				backgroundImage=BitmapFactory.decodeFile(Global.picturePath);
				view.setImageBitmap(backgroundImage);
			} catch (NullPointerException e){}
		}
		
			final ImageButton moustache = (ImageButton) findViewById(R.id.moustache);
			moustache.setBackgroundResource(R.drawable.moustache);
			final ImageButton octopus = (ImageButton) findViewById(R.id.octopus);
			octopus.setBackgroundResource(R.drawable.octopus);
			final ImageButton rain = (ImageButton) findViewById(R.id.rain);
			rain.setBackgroundResource(R.drawable.rain);
			final ImageButton rainbow = (ImageButton) findViewById(R.id.rainbow);
			rainbow.setBackgroundResource(R.drawable.rainbow);
			final ImageButton rainbow2 = (ImageButton) findViewById(R.id.rainbow2);
			rainbow2.setBackgroundResource(R.drawable.rainbow2);
			final ImageButton star = (ImageButton) findViewById(R.id.star);
			star.setBackgroundResource(R.drawable.star);
			final ImageButton sung = (ImageButton) findViewById(R.id.sung);
			sung.setBackgroundResource(R.drawable.sung);
			final ImageButton thought = (ImageButton) findViewById(R.id.thought);
			thought.setBackgroundResource(R.drawable.thought);
			final ImageButton tongue = (ImageButton) findViewById(R.id.tongue);
			tongue.setBackgroundResource(R.drawable.tongue);
			final ImageButton whiteg = (ImageButton) findViewById(R.id.whiteg);
			whiteg.setBackgroundResource(R.drawable.whiteg);
			final ImageButton hat = (ImageButton) findViewById(R.id.hat);
			hat.setBackgroundResource(R.drawable.hat);
			final ImageButton glasses = (ImageButton) findViewById(R.id.glasses);
			glasses.setBackgroundResource(R.drawable.glasses);
			final ImageButton mask = (ImageButton) findViewById(R.id.mask);
			mask.setBackgroundResource(R.drawable.mask);
			final ImageButton heart = (ImageButton) findViewById(R.id.heart);
			heart.setBackgroundResource(R.drawable.heart);
			final ImageButton angry = (ImageButton) findViewById(R.id.angry);
			angry.setBackgroundResource(R.drawable.angry);
			final ImageButton bird = (ImageButton) findViewById(R.id.bird);
			bird.setBackgroundResource(R.drawable.bird);
			final ImageButton firew = (ImageButton) findViewById(R.id.firew);
			firew.setBackgroundResource(R.drawable.firew);
			final ImageButton mono = (ImageButton) findViewById(R.id.mono);
			mono.setBackgroundResource(R.drawable.mono);
			final ImageButton ceyes = (ImageButton) findViewById(R.id.ceyes);
			ceyes.setBackgroundResource(R.drawable.ceyes);
			final ImageButton icream = (ImageButton) findViewById(R.id.icream);
			icream.setBackgroundResource(R.drawable.icream);
			final ImageButton lips = (ImageButton) findViewById(R.id.lips);
			lips.setBackgroundResource(R.drawable.lips);
			final ImageButton eyes = (ImageButton) findViewById(R.id.eyes);
			eyes.setBackgroundResource(R.drawable.eyes);
			final ImageButton stache_glasses = (ImageButton) findViewById(R.id.gstache);
			stache_glasses.setBackgroundResource(R.drawable.gstache);
			final ImageButton Caption = (ImageButton) findViewById(R.id.caption);
			Caption.setBackgroundResource(R.drawable.caption);
			
         
			

			Caption.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.caption));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.caption);
					} catch (NullPointerException e) {
							
					}
				}
			});
			stache_glasses.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.gstache));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.gstache);
					} catch (NullPointerException e) {
							
					}
				}
			});
			eyes.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.eyes));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.eyes);
					} catch (NullPointerException e) {
							
					}
				}
			});
			lips.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.lips));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lips);
					} catch (NullPointerException e) {
							
					}
				}
			});
			icream.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.icream));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icream);
					} catch (NullPointerException e) {
							
					}
				}
			});
			ceyes.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.ceyes));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ceyes);
					} catch (NullPointerException e) {
							
					}
				}
			});
			mono.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.mono));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mono);
					} catch (NullPointerException e) {
							
					}
				}
			});
			firew.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.firew));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.firew);
					} catch (NullPointerException e) {
							
					}
				}
			});
			bird.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.bird));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bird);
					} catch (NullPointerException e) {
							
					}
				}
			});
			angry.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.angry));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.angry);
					} catch (NullPointerException e) {
							
					}
				}
			});
			heart.setOnClickListener(new View.OnClickListener() {	
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.heart));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.heart);
					} catch (NullPointerException e) {
							
					}
				}
			});
			mask.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.mask));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.mask);
					} catch (NullPointerException e) {
							
					}
				}
			});
            glasses.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.glasses));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.glasses);
					} catch (NullPointerException e) {
							
					}
				}
			});
			
			hat.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					try {
						CustomView.mode="add_content";
						CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.hat));
						CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hat);
					} catch (NullPointerException e) {
							
					}
				}
			});
	
		moustache.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.moustache));
					CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.moustache);
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		octopus.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.octopus));
					CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.octopus);
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		rain.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.rain));
					CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rain);
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		rainbow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.rainbow));
					CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rainbow);
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		rainbow2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.rainbow2));
					CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.rainbow2);
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		star.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.star));
					CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.star);
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		sung.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.sung));
					CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sung);
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		thought.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.thought));
					CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.thought);
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		tongue.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.tongue));
					CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.tongue);
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		whiteg.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.whiteg));
					CustomView.bitmap[CustomView.numberOfContents].originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.whiteg);
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		
		final ImageButton blackColor = (ImageButton) findViewById(R.id.black);
		blackColor.setBackgroundColor(Color.BLACK);
		final ImageButton whiteColor = (ImageButton) findViewById(R.id.white);
		whiteColor.setBackgroundColor(Color.WHITE);
		final ImageButton redColor = (ImageButton) findViewById(R.id.red);
		redColor.setBackgroundColor(Color.RED);
		final ImageButton blueColor = (ImageButton) findViewById(R.id.blue);
		blueColor.setBackgroundColor(Color.BLUE);
		final ImageButton greenColor = (ImageButton) findViewById(R.id.green);
		greenColor.setBackgroundColor(Color.GREEN);
		final ImageButton purpleColor = (ImageButton) findViewById(R.id.purple);
		purpleColor.setBackgroundColor(Color.MAGENTA);
		final ImageButton yellowColor = (ImageButton) findViewById(R.id.yellow);
		yellowColor.setBackgroundColor(Color.YELLOW);
		final ImageButton cyanColor = (ImageButton) findViewById(R.id.cyan);
		cyanColor.setBackgroundColor(Color.CYAN);
		final ImageButton ThinStroke = (ImageButton) findViewById(R.id.thin);
		ThinStroke.setBackgroundResource(R.drawable.thinline);
		final ImageButton MediumStroke = (ImageButton) findViewById(R.id.medium);
		MediumStroke.setBackgroundResource(R.drawable.mediumline);
		final ImageButton ThickStroke = (ImageButton) findViewById(R.id.thick);
		ThickStroke.setBackgroundResource(R.drawable.thickline);
		
	
		blackColor.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				try{
						CustomView.mode = "paint";
						//blackColor.setBackgroundColor(Color.BLACK);
						blackColor.setColorFilter(Color.WHITE);
						//blackColor.setTextColor(Color.WHITE);
						CustomView.colorValue = "black";
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
						//whiteColor.setTextColor(Color.BLACK);
						CustomView.colorValue = "white";
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
					CustomView.mode = "paint";
					redColor.setBackgroundColor(Color.RED);
					//redColor.setTextColor(Color.WHITE);
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
					//blueColor.setTextColor(Color.WHITE);
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
					//greenColor.setTextColor(Color.WHITE);
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
					//yellowColor.setTextColor(Color.WHITE);
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
					purpleColor.setBackgroundColor(Color.MAGENTA);
					//purpleColor.setTextColor(Color.WHITE);
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
					//cyanColor.setTextColor(Color.WHITE);
					CustomView.colorValue = "cyan";
				}
				catch(NullPointerException e)
				{
					
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
	 
		final Button menuButton = (Button) findViewById(R.id.handle);
		menuButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.amenu));
		menuButton.setOnClickListener(new View.OnClickListener()
		{

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				
			}
			
		});

		final Button undoButton = (Button) findViewById(R.id.undoLast);
		undoButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.undoprevious));
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



		final Button UndoThis = (Button) findViewById(R.id.undoThis);
		UndoThis.setBackgroundDrawable(getResources().getDrawable(R.drawable.undopoint));
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
	
	
	    final Button ResetButton = (Button) findViewById(R.id.undoAll);
	    ResetButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.reseting));
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
	
        
        final Button newPictureButton = (Button) findViewById(R.id.newpic);
        newPictureButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.newpicture));
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
	
	
	
    final Button paintButton = (Button) findViewById(R.id.paint);
    paintButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.painting));
    paintButton.setOnClickListener(new View.OnClickListener(){

		@SuppressWarnings("static-access")
		@Override
		public void onClick(View v) 
		{
			 try
			 {
				 blackColor.setVisibility(view.VISIBLE);
				 whiteColor.setVisibility(view.VISIBLE); 
				 redColor.setVisibility(view.VISIBLE);
			     blueColor.setVisibility(view.VISIBLE);
			     greenColor.setVisibility(view.VISIBLE);
			     yellowColor.setVisibility(view.VISIBLE);
			     cyanColor.setVisibility(view.VISIBLE);
			     purpleColor.setVisibility(view.VISIBLE);
			     ThinStroke.setVisibility(view.VISIBLE);
			     MediumStroke.setVisibility(view.VISIBLE);
			     ThickStroke.setVisibility(view.VISIBLE);
			     
			     
				 undoButton.setVisibility(view.GONE);
				 UndoThis.setVisibility(view.GONE); 
				 ResetButton.setVisibility(view.GONE);
				 moustache.setVisibility(view.GONE);
				 octopus.setVisibility(view.GONE);
				 rain.setVisibility(view.GONE);
				 rainbow.setVisibility(view.GONE);
				 rainbow2.setVisibility(view.GONE);
				 star.setVisibility(view.GONE);
				 sung.setVisibility(view.GONE);
				 thought.setVisibility(view.GONE);
				 tongue.setVisibility(view.GONE);
				 whiteg.setVisibility(view.GONE);
				 hat.setVisibility(view.GONE);
				 glasses.setVisibility(view.GONE);
				 mask.setVisibility(view.GONE);
				 heart.setVisibility(view.GONE);
				 angry.setVisibility(view.GONE);
				 bird.setVisibility(view.GONE);
				 firew.setVisibility(view.GONE);
				 mono.setVisibility(view.GONE);
				 ceyes.setVisibility(view.GONE);
				 icream.setVisibility(view.GONE);
				 lips.setVisibility(view.GONE);
				 eyes.setVisibility(view.GONE);
				 stache_glasses.setVisibility(view.GONE);
				 Caption.setVisibility(view.GONE);
				 
			 }
			 catch(Exception e){}
		}
    });
	
      
    final Button editButton = (Button) findViewById(R.id.edit);
    editButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.editing));
    editButton.setOnClickListener(new View.OnClickListener(){

		@SuppressWarnings("static-access")
		@Override
		public void onClick(View v) 
		{
			try
			{
			  blackColor.setVisibility(view.GONE);
			  whiteColor.setVisibility(view.GONE); 
			  redColor.setVisibility(view.GONE);
		      blueColor.setVisibility(view.GONE);
		      greenColor.setVisibility(view.GONE);
		      yellowColor.setVisibility(view.GONE);
		      cyanColor.setVisibility(view.GONE);
		      purpleColor.setVisibility(view.GONE);
		      ThinStroke.setVisibility(view.GONE);
		      MediumStroke.setVisibility(view.GONE);
		      ThickStroke.setVisibility(view.GONE);
		      undoButton.setVisibility(view.VISIBLE);
			  UndoThis.setVisibility(view.VISIBLE); 
			  ResetButton.setVisibility(view.VISIBLE);
			  
			  moustache.setVisibility(view.GONE);
			  octopus.setVisibility(view.GONE);
			  rain.setVisibility(view.GONE);
			  rainbow.setVisibility(view.GONE);
			  rainbow2.setVisibility(view.GONE);
			  star.setVisibility(view.GONE);
			  sung.setVisibility(view.GONE);
			  thought.setVisibility(view.GONE);
			  tongue.setVisibility(view.GONE);
			  whiteg.setVisibility(view.GONE);
			  hat.setVisibility(view.GONE);
			  glasses.setVisibility(view.GONE);
			  mask.setVisibility(view.GONE);
			  heart.setVisibility(view.GONE);
			  angry.setVisibility(view.GONE);
			  bird.setVisibility(view.GONE);
			  firew.setVisibility(view.GONE);
			  mono.setVisibility(view.GONE);
			  ceyes.setVisibility(view.GONE);
			  icream.setVisibility(view.GONE);
			  lips.setVisibility(view.GONE);
			  eyes.setVisibility(view.GONE);
			  stache_glasses.setVisibility(view.GONE);
			  Caption.setVisibility(view.GONE);
			}
			catch(Exception e){}
		}
    	
    });
    final Button OverlaysButton = (Button) findViewById(R.id.overlays);
    OverlaysButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.overlaying));
    OverlaysButton.setOnClickListener(new View.OnClickListener(){

		@SuppressWarnings("static-access")
		@Override
		public void onClick(View v) 
		{
			try
			{
				blackColor.setVisibility(view.GONE);
				whiteColor.setVisibility(view.GONE); 
				redColor.setVisibility(view.GONE);
			    blueColor.setVisibility(view.GONE);
			    greenColor.setVisibility(view.GONE);
			    yellowColor.setVisibility(view.GONE);
			    cyanColor.setVisibility(view.GONE);
			    purpleColor.setVisibility(view.GONE);
			    ThinStroke.setVisibility(view.GONE);
			    MediumStroke.setVisibility(view.GONE);
			    ThickStroke.setVisibility(view.GONE);
			    
				 moustache.setVisibility(view.VISIBLE);
				 octopus.setVisibility(view.VISIBLE);
				 rain.setVisibility(view.VISIBLE);
				 rainbow.setVisibility(view.VISIBLE);
				 rainbow2.setVisibility(view.VISIBLE);
				 star.setVisibility(view.VISIBLE);
				 sung.setVisibility(view.VISIBLE);
				 thought.setVisibility(view.VISIBLE);
				 tongue.setVisibility(view.VISIBLE);
				 whiteg.setVisibility(view.VISIBLE);
				 hat.setVisibility(view.VISIBLE);
				 glasses.setVisibility(view.VISIBLE);
				 mask.setVisibility(view.VISIBLE);
				 heart.setVisibility(view.VISIBLE);
				 angry.setVisibility(view.VISIBLE);
				 bird.setVisibility(view.VISIBLE);
				 firew.setVisibility(view.VISIBLE);
				 mono.setVisibility(view.VISIBLE);
				 ceyes.setVisibility(view.VISIBLE);
				 icream.setVisibility(view.VISIBLE);
				 lips.setVisibility(view.VISIBLE);
				 eyes.setVisibility(view.VISIBLE);
				 stache_glasses.setVisibility(view.VISIBLE);
				 Caption.setVisibility(view.VISIBLE);
			}
			catch(Exception e){}
			
		}
    	
    });
    final Button SaveButton = (Button) findViewById(R.id.save);
    SaveButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.saving));
    SaveButton.setOnClickListener(new View.OnClickListener(){

		@SuppressWarnings("static-access")
		@Override
		public void onClick(View v) 
		{
			try
			{
				SaveButton.setEnabled(false);
				OverlaysButton.setEnabled(false);
				newPictureButton.setEnabled(false);
				editButton.setEnabled(false);
				paintButton.setEnabled(false);
				HorizontalScrollView hs1 =(HorizontalScrollView)findViewById(R.id.horizontalScrollView2);hs1.setVisibility(View.INVISIBLE);
				Toast.makeText(getApplicationContext(), "Saving ...",Toast.LENGTH_LONG).show();
				saveView(view);
				sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED, Uri.parse("file://" + Environment.getExternalStorageDirectory())));
				//SAVING
				   backgroundImage.recycle();
				Toast.makeText(getApplicationContext(), "Image saved to this location" + Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),Toast.LENGTH_LONG).show();
				AlertDialog decision = new AlertDialog.Builder(Testpic.this).create();
				decision.setTitle("Upload");
				decision.setMessage("Your Image is being saved, but would you like to upload this image to the database");
				decision.setButton( Dialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener()
				{
					public void onClick(DialogInterface dialog, int which)
					{
						try
						{
							Toast.makeText(getApplicationContext(), "Uploading ...",Toast.LENGTH_LONG).show();
							//UploadCode
							finish( );
			        		Testpic.this.onDestroy();
			        		CustomView.backgroundImage.recycle();
			        		Intent newPic = new Intent(Testpic.this, UserPhotoOptions.class);
			        		startActivity(newPic);
						}
						catch(Exception e)
						{
							
						}
			
					
					}
				});
				decision.setButton( Dialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() 
				{
					public void onClick(DialogInterface dialog, int which)
					{
						try
						{
							finish( );
			        		Testpic.this.onDestroy();
			        		
			        		backgroundImage.recycle();
			        		Intent newPic = new Intent(Testpic.this, UserPhotoOptions.class);
			        		startActivity(newPic);
						}
						catch(Exception e)
						{
							
						}
					}
				});
				decision.show();
			}
			catch(Exception e)
			{
				
			}
		}
    	
    });
    final Button UploadButton = (Button) findViewById(R.id.upload);
    UploadButton.setBackgroundDrawable(getResources().getDrawable(R.drawable.uploading));
    UploadButton.setOnClickListener(new View.OnClickListener(){

		@Override
		public void onClick(View v) 
		{
			try
			{
				
			}
			catch(Exception e)
			{
				
			}
			
		}
    
	});
}
	
    private void saveView( View view ) 
    { 
       Bitmap  b = Bitmap.createBitmap( view.getWidth(), view.getHeight (), Bitmap.Config.ARGB_8888); 
       Canvas c = new Canvas( b ); 
       view.draw( c ); 
       FileOutputStream fos; 

       SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd_HHmmss");
       String  imageID = time.format(new Date());
       String photoID = "EditMeNow_" + imageID + ".jpg";
       
       
       try 
       {    
    	   File path = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), photoID);
    	   if (path.createNewFile())
    	   {
    		   Toast.makeText(getApplicationContext(), "New File Created in " +  path,Toast.LENGTH_LONG).show();
    	   }
    	   
    	   fos = new FileOutputStream(path);      
           if ( fos != null ) 
           { 
                b.compress(Bitmap.CompressFormat.PNG, 90, fos ); 
                MediaStore.Images.Media.insertImage(getContentResolver(),
                path.getAbsolutePath(), path.getName(), path.getName());
                fos.flush();
                fos.close(); 
           } 
       } 
       catch( Exception e ) 
       { 
           Log.e("testSaveView", "Exception: " + e.toString() ); 
           Toast.makeText(getApplicationContext(), "DID NOT SAVE!",Toast.LENGTH_LONG).show();
       } 

    } 
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		//getMenuInflater().inflate(R.menu.activity_testpic, menu);
		return true;
	}
	
}
