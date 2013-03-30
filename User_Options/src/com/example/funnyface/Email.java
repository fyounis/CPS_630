package com.example.funnyface;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import java.util.ArrayList;

import android.net.ConnectivityManager;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class Email extends Activity {
	//buttons,views,edittext
	EditText edittextEmailAddress;
	EditText edittextEmailSubject;
	EditText edittextEmailText;
	Button btnAddFile, btnSend;
	ListView listViewFiles;
	
	//arraylist
	ArrayList<Uri> arrayUri = new ArrayList<Uri>();
	ArrayAdapter<Uri> myFileListAdapter;
	
	//constants
	final int RQS_LOADIMAGE = 0;
	final int RQS_SENDEMAIL = 1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);
		edittextEmailAddress = (EditText)findViewById(R.id.email_address);
		edittextEmailSubject = (EditText)findViewById(R.id.email_subject);
		edittextEmailText = (EditText)findViewById(R.id.email_text);
		
		//buttons
		btnAddFile = (Button)findViewById(R.id.addphoto);
		btnSend = (Button)findViewById(R.id.send);
		btnAddFile.setOnClickListener(btnAddFileOnClickListener);
		btnSend.setOnClickListener(btnSendOnClickListener);
		
		myFileListAdapter = new ArrayAdapter<Uri>(
				Email.this, android.R.layout.simple_list_item_1,
				arrayUri);
		listViewFiles = (ListView)findViewById(R.id.filelist);
		listViewFiles.setAdapter(myFileListAdapter);
	}
	
	OnClickListener btnAddFileOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent(Intent.ACTION_PICK, 
					android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(intent, RQS_LOADIMAGE);
		}
	};
	
	OnClickListener btnSendOnClickListener = new OnClickListener() {
		
	
	  @Override
	  public void onClick(View v) {
	   String emailAddress = edittextEmailAddress.getText().toString();
	   String emailSubject = edittextEmailSubject.getText().toString();
	   String emailText = edittextEmailText.getText().toString();
	   String emailAddressList[] = {emailAddress};
	   
	   Intent intent = new Intent();
	   intent.putExtra(Intent.EXTRA_EMAIL, emailAddressList);  
	   intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject); 
	   intent.putExtra(Intent.EXTRA_TEXT, emailText);
	   
	   
	   ConnectivityManager emailConnection = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
	   
	   if(arrayUri.isEmpty())
	   {
		   try
		   {
			   if(emailConnection.getActiveNetworkInfo( ) != null && emailConnection.getActiveNetworkInfo( ).isAvailable() && emailConnection.getActiveNetworkInfo( ).isConnected( ))
			   {
				   //Send email without photo attached
				   intent.setAction(Intent.ACTION_SEND);
				   intent.setType("plain/text"); 
		       }
			   else
			   {
					   Toast.makeText(getApplicationContext(), "No internet connection, try Again.",Toast.LENGTH_LONG).show();
			   }
		   }
		   catch(Exception e){}
	   }
	   
	   
	   else if(arrayUri.size() == 1)
	   {
		   try
		   {
			   if(emailConnection.getActiveNetworkInfo( ) != null && emailConnection.getActiveNetworkInfo( ).isAvailable() && emailConnection.getActiveNetworkInfo( ).isConnected( ))
			   {
				   	//Send email with ONE photo attached
				   	intent.setAction(Intent.ACTION_SEND); 
				   	intent.putExtra(Intent.EXTRA_STREAM, arrayUri.get(0));
				   	intent.setType("image/*");
				   	
			   }
			   else
			   {
				   Toast.makeText(getApplicationContext(), "No internet connection, try Again.",Toast.LENGTH_LONG).show();
			   }
		   }
		   catch(Exception e)
		   {
			   
		   }
	   }
	   else 
	   {
		   try
		   {
			   if(emailConnection.getActiveNetworkInfo( ) != null && emailConnection.getActiveNetworkInfo( ).isAvailable() && emailConnection.getActiveNetworkInfo( ).isConnected( ))
			   {
				   //Send email with MULTI photo attached
				   intent.setAction(Intent.ACTION_SEND_MULTIPLE);
				   intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, arrayUri);
				   intent.setType("image/*");
				   
			   }
		   }
		   catch(Exception e)
		   {
			   
		   }
	   }
	   
	   startActivityForResult(Intent.createChooser(intent, "Choose Email Client:"), RQS_SENDEMAIL);
	  }};
	  
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		//super.onActivityResult(requestCode,  resultCode, data);
		
		if (requestCode == RQS_LOADIMAGE){
			if (resultCode == RESULT_OK) {
			 Uri imageUri = data.getData();
			 arrayUri.add(imageUri);
			 myFileListAdapter.notifyDataSetChanged();
			 Toast.makeText(getApplicationContext(), "Photo Added", Toast.LENGTH_LONG).show();
			}
		}
		if (requestCode == RQS_SENDEMAIL){
			Toast.makeText(getApplicationContext(), "Email Send", Toast.LENGTH_LONG).show();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
