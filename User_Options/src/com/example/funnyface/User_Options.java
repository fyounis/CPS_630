package com.example.funnyface;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class User_Options extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_options);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		//getMenuInflater().inflate(R.menu.activity_user_options, menu);
		return true;
	}
	//When user clicks on 'Edit a Picture button'
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
}
