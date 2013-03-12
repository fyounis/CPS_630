package com.example.funnyface;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
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
	private CustomView view;
	private boolean showToolBar=true;
	private Bitmap backgroundImage;
	
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
		
			final ImageButton mono = (ImageButton) findViewById(R.id.mono);
			final ImageButton moustache = (ImageButton) findViewById(R.id.moustache);
			final ImageButton octopus = (ImageButton) findViewById(R.id.octopus);
			final ImageButton rain = (ImageButton) findViewById(R.id.rain);
			final ImageButton rainbow = (ImageButton) findViewById(R.id.rainbow);
			final ImageButton rainbow2 = (ImageButton) findViewById(R.id.rainbow2);
			final ImageButton star = (ImageButton) findViewById(R.id.star);
			final ImageButton sung = (ImageButton) findViewById(R.id.sung);
			final ImageButton thought = (ImageButton) findViewById(R.id.thought);
			final ImageButton tongue = (ImageButton) findViewById(R.id.tongue);
			final ImageButton whiteg = (ImageButton) findViewById(R.id.whiteg);
		
		mono.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				try {
					CustomView.mode="add_content";
					CustomView.bitmap[CustomView.numberOfContents] = new contents(BitmapFactory.decodeResource(getResources(), R.drawable.mono));
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
				} catch (NullPointerException e) {
						
				}
			}
		});
		
		
		final Button blackColor = (Button) findViewById(R.id.black);
		blackColor.setBackgroundColor(Color.BLACK);
		blackColor.setTextColor(Color.WHITE);
		final Button whiteColor = (Button) findViewById(R.id.white);
		whiteColor.setBackgroundColor(Color.WHITE);
		final Button redColor = (Button) findViewById(R.id.red);
		redColor.setBackgroundColor(Color.RED);
		final Button blueColor = (Button) findViewById(R.id.blue);
		blueColor.setBackgroundColor(Color.BLUE);
		final Button greenColor = (Button) findViewById(R.id.green);
		greenColor.setBackgroundColor(Color.GREEN);
		//final Button grayColor = (Button) findViewById(R.id.gray);
		//grayColor.setBackgroundColor(Color.MAGENTA);
		final Button yellowColor = (Button) findViewById(R.id.yellow);
		yellowColor.setBackgroundColor(Color.YELLOW);
		final Button cyanColor = (Button) findViewById(R.id.cyan);
		cyanColor.setBackgroundColor(Color.CYAN);
		final Button ThinStroke = (Button) findViewById(R.id.thin);
		ThinStroke.setBackgroundDrawable(getResources().getDrawable(R.drawable.thinline));
		final Button MediumStroke = (Button) findViewById(R.id.medium);
		MediumStroke.setBackgroundDrawable(getResources().getDrawable(R.drawable.mediumline));
		final Button ThickStroke = (Button) findViewById(R.id.thick);
	    ThickStroke.setBackgroundDrawable(getResources().getDrawable(R.drawable.thickline));
	    
	
		blackColor.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				try{
						CustomView.mode = "paint";
						blackColor.setBackgroundColor(Color.BLACK);
						blackColor.setTextColor(Color.WHITE);
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
					CustomView.mode = "paint";
					redColor.setBackgroundColor(Color.RED);
					redColor.setTextColor(Color.WHITE);
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
					blueColor.setTextColor(Color.WHITE);
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
					greenColor.setTextColor(Color.WHITE);
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
					yellowColor.setTextColor(Color.WHITE);
					CustomView.colorValue = "yellow";
				}
				catch(NullPointerException e)
				{
					
				}
			}
		});
		/*grayColor.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v)
			{
				try
				{
					CustomView.mode = "paint";
					grayColor.setBackgroundColor(Color.GRAY);
					grayColor.setTextColor(Color.WHITE);
					CustomView.colorValue = "purple";
				}
				catch(NullPointerException e)
				{
					
				}
			}
		});*/
		cyanColor.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v)
			{
				try
				{
					CustomView.mode = "paint";
					cyanColor.setBackgroundColor(Color.CYAN);
					cyanColor.setTextColor(Color.WHITE);
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
			    // grayColor.setVisibility(view.VISIBLE);
			     ThinStroke.setVisibility(view.VISIBLE);
			     MediumStroke.setVisibility(view.VISIBLE);
			     ThickStroke.setVisibility(view.VISIBLE);
				 undoButton.setVisibility(view.GONE);
				 UndoThis.setVisibility(view.GONE); 
				 ResetButton.setVisibility(view.GONE);
				 
				 mono.setVisibility(view.GONE);
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
		     // grayColor.setVisibility(view.GONE);
		      ThinStroke.setVisibility(view.GONE);
		      MediumStroke.setVisibility(view.GONE);
		      ThickStroke.setVisibility(view.GONE);
		      undoButton.setVisibility(view.VISIBLE);
			  UndoThis.setVisibility(view.VISIBLE); 
			  ResetButton.setVisibility(view.VISIBLE);
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
			   // grayColor.setVisibility(view.GONE);
			    ThinStroke.setVisibility(view.GONE);
			    MediumStroke.setVisibility(view.GONE);
			    ThickStroke.setVisibility(view.GONE);
				 
				 mono.setVisibility(view.VISIBLE);
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
				//SAVING
				//SAVING
				//SAVING
				Toast.makeText(getApplicationContext(), "Image saved to this location",Toast.LENGTH_LONG).show();
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
			        		CustomView.backgroundImage.recycle();
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
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		//getMenuInflater().inflate(R.menu.activity_testpic, menu);
		return true;
	}
	
}
