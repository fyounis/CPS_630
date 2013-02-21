package com.example.funnyface;

//import com.example.funnyface.CustomView;

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
			bmp = BitmapFactory.decodeFile("appPic");	//MUST FIX to make it work on all phones
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
				CustomView.mbitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
			}
		});
		
		final ImageButton button2 = (ImageButton) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CustomView.mbitmap = BitmapFactory.decodeResource(getResources(), R.drawable.moustache);
			}
		});
		
		final Button doneButton = (Button) findViewById(R.id.button7);
		doneButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
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