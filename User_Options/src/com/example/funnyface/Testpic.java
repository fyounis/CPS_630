package com.example.funnyface;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

@SuppressLint("SdCardPath")
public class Testpic extends Activity
{
	private ImageView view;
	private Bitmap bmp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testpic);
		view = (ImageView) findViewById(R.id.imageView1);
		if(Global.mode.equals("Camera"))
		{
			bmp = BitmapFactory.decodeFile("appPic");	//Getting the path wrong. 
			view.setImageBitmap(bmp);
			
		}
		else if(Global.mode.equals("Gallery"))
		{
				view.setImageBitmap(BitmapFactory.decodeFile(Global.picturePath));
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
		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				try
				{
				// TODO Auto-generated method stub
<<<<<<< HEAD
				CustomView.index+=1;
=======
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
					while(CustomView.numberOfContents != 0)
					{
						undoButton.setEnabled(true);
						if(undoButton.isPressed( ))
						{
							CustomView.numberOfContents-=1;
							Toast.makeText(getApplicationContext(), "Component Removed", Toast.LENGTH_LONG).show();
						}
					}
				}
				catch(NullPointerException e){
					
				}
>>>>>>> upstream/master
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

	
	public void viewPic(View view)
	{
			
	}
	
}