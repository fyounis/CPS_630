package com.example.funnyface;

import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
				final ProgressDialog progressDialog = new ProgressDialog(ViewDataBase.this);
				progressDialog.setMessage("Connecting ...");
				progressDialog.setCancelable(false);
			    progressDialog.setIndeterminate(true);
				progressDialog.show();
				cloudConnection = (WebView) findViewById(R.id.webView1);
				cloudConnection.getSettings().setJavaScriptEnabled(true);
				cloudConnection.getSettings().setBuiltInZoomControls(true);
				cloudConnection.setWebViewClient(new WebViewClient()
				{	
					@Override	
					public void onPageFinished(WebView view, String url)
					{
						super.onPageFinished(view, url);
						progressDialog.dismiss();
					}
				});
				cloudConnection.loadUrl("http://editmenow.herokuapp.com/users");
			}
			else
			{	

				//cloudConnection.loadUrl("nointernet.html");
				Toast.makeText(getApplicationContext(), "EditMeNow could not connect to cloud because there is no internet",Toast.LENGTH_LONG).show();
				new CountDownTimer(10000, 1000)
				{
				    public void onTick(long millisUntilFinished) 
				    {
				    	Toast.makeText(getApplicationContext(), "EditMeNow could not connect to cloud because there is no internet",Toast.LENGTH_LONG).show();
				    }
				    public void onFinish() 
				    {
				    	Toast.makeText(getApplicationContext(), "EditMeNow could not connect to cloud because there is no internet",Toast.LENGTH_LONG).show();
				    }
				}.start();
				
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
