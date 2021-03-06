package com.example.funnyface;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.samir.twitter.MainActivity;


public class User_Options extends Activity {

	private static final int SIGN_IN = 0;
	static int width;
	static int height;
	private int windowWidth;
	private int windowHeight;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_options);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_options, menu);
		//getMenuInflater().inflate(R.menu.activity_user_options, menu);
		return true;
	}
	//When user clicks on 'Edit a Picture button'
	/*
	@Override
	public void onWindowFocusChanged(boolean hasFocus)
	{
		super.onWindowFocusChanged(hasFocus);
		Display display = getWindowManager( ).getDefaultDisplay();
		width = display.getWidth();
		height = display.getHeight( );
		int button_Width = (width / 3);
		final ImageButton db_button = (ImageButton) findViewById(R.id.server);
		db_button.setMinimumWidth(button_Width);
		final ImageButton home_button = (ImageButton) findViewById(R.id.home);
		home_button.setMinimumWidth(button_Width);
		final ImageButton edit_button = (ImageButton) findViewById(R.id.picture);
		edit_button.setMinimumWidth(button_Width);
	}
	*/
	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
	   switch (item.getItemId())
	   {
	   	  case R.id.loginuser:
	      finish( );
          User_Options.this.onDestroy();
	      startActivity(new Intent(this, SignIn.class));
	      return true;
	  
	   	  default:
	      return super.onOptionsItemSelected(item);
	   }
	}

	public void GotoUserPhotoSelection(View view) 
	{
		Intent intent = new Intent(this, UserPhotoOptions.class);
		startActivity(intent);
	}
	//When user clicks on 'View Gallery button'
	public void GoToDatabase(View view)
	{
		Intent intent = new Intent(this, ViewDataBase.class);
		startActivity(intent);
	}
	
	public void GoToEmail(View view)
	{
		Intent intent = new Intent(this, Email.class);
		startActivity(intent);
	}
	public void GoToTwitter(View view)
	{
		
		Intent intent = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	public void GoToLogin(View view)
	{
		Intent intent = new Intent(this, SignIn.class);
		startActivity(intent);
	}
	          
	public void onWindowFocusChanged(boolean hasFocus) {

        super.onWindowFocusChanged(hasFocus);

        if(hasFocus) {
        	DisplayMetrics displaymetrics = new DisplayMetrics();
        	getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        	windowWidth=displaymetrics.widthPixels;
        	windowHeight=displaymetrics.heightPixels;
        	
        	ImageButton editButton = (ImageButton) findViewById(R.id.edit);
        	ImageButton emailButton = (ImageButton) findViewById(R.id.email);
        	ImageButton twitterButton = (ImageButton) findViewById(R.id.twitter);
        	ImageButton databaseButton = (ImageButton) findViewById(R.id.database);
        	
        }
	}
}
