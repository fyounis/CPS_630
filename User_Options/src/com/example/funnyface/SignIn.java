package com.example.funnyface;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.text.InputType;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class SignIn extends Activity {
	
	private static EditText clouduser;
	private static EditText cloudpass;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
	
		clouduser = new EditText(SignIn.this);
		clouduser = (EditText)findViewById(R.id.username);
		clouduser.setTextColor(Color.parseColor("#888888"));
		
		cloudpass= new EditText(SignIn.this);
		cloudpass = (EditText)findViewById(R.id.password);
		cloudpass.setTextColor(Color.parseColor("#888888"));
		cloudpass.setInputType(InputType.TYPE_CLASS_TEXT);

		clouduser.setOnFocusChangeListener(new View.OnFocusChangeListener()
		{

			@Override
			public void onFocusChange(View v, boolean hasFocus) 
			{
					if(hasFocus)
					{
						((EditText) findViewById(R.id.username)).setText("");
					}	
			}
		});
		cloudpass.setOnFocusChangeListener(new View.OnFocusChangeListener()
		{
			
			@Override
			public void onFocusChange(View v, boolean hasFocus)
			{
					if(hasFocus)
					{
						((EditText) findViewById(R.id.password)).setText("");
				 		cloudpass.setInputType(InputType.TYPE_CLASS_TEXT| InputType.TYPE_TEXT_VARIATION_PASSWORD);
					}
				
			}
		});
		
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sign_in, menu);
		return true;
	}
}
