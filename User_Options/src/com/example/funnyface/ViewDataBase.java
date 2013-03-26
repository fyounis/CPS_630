package com.example.funnyface;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.Menu;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ViewDataBase extends Activity 
{
	 WebView cloudConnection;
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_data_base);
		ConnectivityManager cloudconnection = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		try
		{
			if(cloudconnection.getActiveNetworkInfo( ) != null && cloudconnection.getActiveNetworkInfo( ).isAvailable() && cloudconnection.getActiveNetworkInfo( ).isConnected( ))
			{	
				Toast.makeText(getApplicationContext(), "Connecting ...",Toast.LENGTH_LONG).show();
				cloudConnection = (WebView) findViewById(R.id.webView1);
				cloudConnection.getSettings().setJavaScriptEnabled(true);
				cloudConnection.getSettings().setBuiltInZoomControls(true);
				cloudConnection.loadUrl("http://editmenow.herokuapp.com/users");
			}
			else
			{	
				Toast.makeText(getApplicationContext(), "No Connection, try again.",Toast.LENGTH_LONG).show();
					
			}
		}
		catch(Exception e)
		{
			
		}
	}


	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		//getMenuInflater().inflate(R.menu.activity_view_data_base, menu);
		return true;
	}
	
	

}
