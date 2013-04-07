package com.example.funnyface;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class SignUp extends Activity
{
	private static EditText newcloudUser;
	private static EditText newcloudEmail;
	private static EditText newcloudPass;
	
	private static String newUsername;
	private static String newUserEmail;
	private static String newPassword;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		
		
		newcloudUser = new EditText(SignUp.this);
		newcloudUser = (EditText)findViewById(R.id.userID);
		newcloudUser.setTextColor(Color.parseColor("#888888"));
		
		newcloudEmail = new EditText(SignUp.this);
		newcloudEmail = (EditText)findViewById(R.id.emailID);
		newcloudUser.setTextColor(Color.parseColor("#888888"));
		
		newcloudPass= new EditText(SignUp.this);
		newcloudPass = (EditText)findViewById(R.id.passwd);
		newcloudPass.setTextColor(Color.parseColor("#888888"));
		newcloudPass.setInputType(InputType.TYPE_CLASS_TEXT);
		

		newcloudUser.setOnFocusChangeListener(new View.OnFocusChangeListener()
		{

			@Override
			public void onFocusChange(View v, boolean hasFocus) 
			{
					if(hasFocus)
					{
						((EditText) findViewById(R.id.userID)).setText("");
					}	
			}
		});
		newcloudEmail.setOnFocusChangeListener(new View.OnFocusChangeListener()
		{

			@Override
			public void onFocusChange(View v, boolean hasFocus) 
			{
					if(hasFocus)
					{
						((EditText) findViewById(R.id.emailID)).setText("");
					}	
			}
		});
		newcloudPass.setOnFocusChangeListener(new View.OnFocusChangeListener()
		{
			
			@Override
			public void onFocusChange(View v, boolean hasFocus)
			{
					if(hasFocus)
					{
						((EditText) findViewById(R.id.passwd)).setText("");
				 		newcloudPass.setInputType(InputType.TYPE_CLASS_TEXT| InputType.TYPE_TEXT_VARIATION_PASSWORD);
					}
				
			}
		});
		
		Button createAccount = (Button) findViewById(R.id.create_an_account);
		createAccount.setOnClickListener(new View.OnClickListener( ){

			@Override
			public void onClick(View v)
			{
				 Toast.makeText(getApplicationContext(), "creating an account ...", Toast.LENGTH_LONG).show();	
				 newUsername = newcloudUser.getText( ).toString();
				 newPassword = newcloudPass.getText( ).toString();
				 newUserEmail = newcloudEmail.getText().toString( );
				 System.out.println("new username: " + newUsername);
				 System.out.println("new password: " + newPassword);
				 System.out.println("new email: " + newUserEmail);
				 //postnewCredentials( );
			}
			
		});
	}
		
	/*	
		public static void postnewCredentials()
		{
			RequestParams newcredentials = new RequestParams();
	        newcredentials.put("user[newusername]", newUsername);
	        newcredentials.put("user[newpassword]", newPassword);
	        newcredentials.put("user[newemail]", newUserEmail);
	        
	        AsyncHttpClient client = new AsyncHttpClient();
	        client.post("http://editmenow.herokuapp.com/users/", newcredentials, new AsyncHttpResponseHandler()
	        {
	            @Override
	            public void onSuccess(String response) {
	                Log.w("async", "success!!!!");
	            }                                                                                                                                                                     
	        });  
	
	}
*/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_sign_up, menu);
		return true;
	}

}
