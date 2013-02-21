package com.example.funnyface;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.MediaStore.Images.Media;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class UserPhotoOptions extends Activity
{
    private static final int CAMERA_REQUEST= 1888;
    private static final int RESULT_LOAD_IMAGE= 1888;
    Intent cameraIntent;
	//private String cPath;
    File sdImageMainDirectory;
    File storageDir;
    File picPath;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	//comment for testing
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_photo_options);
		try {

            super.onCreate(savedInstanceState);
            
            //new code
            File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
            storageDir.mkdirs( );
            picPath = new File(storageDir,"appPic");
            /*
            File root = new File(Environment.getExternalStorageDirectory() + File.separator + "myDir" + File.separator);
            root.mkdirs();
            sdImageMainDirectory = new File(root, "myPicName");
			*/
        } catch (Exception e) {
            finish();
            Toast.makeText(this, "Error occured. Please try again later.",
            Toast.LENGTH_SHORT).show();
        }
		// Show the Up button in the action bar.

		
		Button buttonCamera= (Button) findViewById(R.id.button1);
		buttonCamera.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
			    cameraIntent =new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				cameraIntent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
				startActivityForResult(cameraIntent, CAMERA_REQUEST);
				Global.mode = "Camera";
			}
		    
		});
		
		Button buttonGallery= (Button) findViewById(R.id.button2);
		buttonGallery.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) 
			{
				// TODO Auto-generated method stub
				Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				startActivityForResult(i, RESULT_LOAD_IMAGE);
				Global.mode = "Gallery";
			}
		    
		});
		//getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		//getMenuInflater().inflate(R.menu.activity_user_photo_options, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
			case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@SuppressWarnings("deprecation")
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
		if(Global.mode.equals("Camera"))
		{
			switch (resultCode) {
	        case 0:
	            finish();
	            break;
	
	        case -1:
	
	            try {
	                StoreImage(this, Uri.parse(data.toURI()),  picPath);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	
	            finish();
	            startActivity(new Intent(this, Testpic.class));
	        }
		}
		else if(Global.mode.equals("Gallery"))
		{
			super.onActivityResult(requestCode, resultCode, data);
	        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) 
	        {
	            Uri selectedImage = data.getData();
	            String[] filePathColumn = { MediaStore.Images.Media.DATA };
	            Cursor cursor = getContentResolver().query(selectedImage,filePathColumn, null, null, null);
	            cursor.moveToFirst();
	            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
	            Global.picturePath = cursor.getString(columnIndex);
	            cursor.close();
	            startActivity(new Intent(this, Testpic.class));
	        }
		}
	}
	
	public static void StoreImage(Context mContext, Uri imageLoc, File imageDir) {
        Bitmap bm = null;
        try {
            bm = Media.getBitmap(mContext.getContentResolver(), imageLoc);
            FileOutputStream out = new FileOutputStream(imageDir);
            bm.compress(Bitmap.CompressFormat.JPEG, 100, out);
            bm.recycle();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}