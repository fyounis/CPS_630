package com.example.funnyface;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignIn extends Activity {
	
	private static EditText clouduser;
	private static EditText cloudpass;
	private static String Username;
	private static String Password;
	
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
		
		Button SignIn = (Button) findViewById(R.id.signin);
		SignIn.setOnClickListener(new View.OnClickListener( ){

			@Override
			public void onClick(View v)
			{
				 Toast.makeText(getApplicationContext(), "Checking credentials ...", Toast.LENGTH_LONG).show();	
				 Username = clouduser.getText( ).toString();
				 Password = cloudpass.getText( ).toString();
				 System.out.println("username: " + Username);
				 System.out.println("password: " + Password);
				 //postCredentials( );
			}
			
		});
		
		Button SignUp = (Button) findViewById(R.id.signup);
		SignUp.setOnClickListener(new View.OnClickListener( )
		{
			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				finish( );
        		SignIn.this.onDestroy();
        		Intent goToSignUp = new Intent(SignIn.this, SignUp.class);
        		startActivity(goToSignUp);
			}	
		});
		
	
	}

/*
	public static void postCredentials()
	{
		RequestParams credentials = new RequestParams();
        credentials.put("user[username]", Username);
        credentials.put("user[password]", Password);
        AsyncHttpClient client = new AsyncHttpClient();
        client.post("http://editmenow.herokuapp.com/users/", credentials, new AsyncHttpResponseHandler()
        {
            @Override
            public void onSuccess(String response) {
                Log.w("async", "success!!!!");
            }                                                                                                                                                                     
        }); 
    }    
*/	

	public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK) {   	 
          finish( );
          SignIn.this.onDestroy();
  	      startActivity(new Intent(this, User_Options.class));
  	      return true;
        }

     return super.onKeyDown(keyCode, event);
  }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sign_in, menu);
		return true;
	}
}
