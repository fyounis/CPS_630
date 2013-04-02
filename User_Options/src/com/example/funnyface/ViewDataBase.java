package com.example.funnyface;

import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
				progressDialog.setMessage("Connecting to the cloud ...");
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
					AlertDialog.Builder noInternet = new AlertDialog.Builder(ViewDataBase.this);
					noInternet.setTitle("EditMeNow connectivity");
					noInternet.setIcon(R.drawable.cloudicon);
					noInternet.setMessage("Access to the cloud requires an internet connection.");
					noInternet.setCancelable(true);
					noInternet.setPositiveButton("Ok", new DialogInterface.OnClickListener() 
					{
		                public void onClick(DialogInterface dialog, int id)
		                {  
		                    dialog.cancel();
		                    finish( );
			        		ViewDataBase.this.onDestroy();
			        		Intent home = new Intent(ViewDataBase.this, User_Options.class);
			        		startActivity(home);
		                }
		            });
					noInternet.show( );
				
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
