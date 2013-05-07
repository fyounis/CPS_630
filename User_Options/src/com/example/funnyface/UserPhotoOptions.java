package com.example.funnyface;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class UserPhotoOptions extends Activity
{
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private static final int RESULT_LOAD_IMAGE= 1888;
	private Uri outputFileUri;		//Uri Object that'll point to the newly created file
	private int windowWidth;
	private int windowHeight;
    
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_photo_options);
		
		//Camera Button
		ImageButton buttonCamera= (ImageButton) findViewById(R.id.button1);
		//buttonCamera.setBackgroundResource(R.drawable.fromcamera);
		buttonCamera.setOnClickListener(new View.OnClickListener() {
			
			//Go to Camera Intent
			@Override
			public void onClick(View v) 
			{
				Global.mode = "Camera";
				
				//Set a new file, where the newly taken picture will be saved
				File storageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "picture.jpg");              
				
				//Create a Uri Object that'll point to the newly created file
				outputFileUri = Uri.fromFile(storageDir); 
				
				// create Intent to take a picture and return control to the calling application
			    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
			    
			    //Allows us to specify where we want the image to be saved
			    intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri); 
				
			    //Start the image capture Intent, (Will call the onActivityResult)
			    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
			}
		    
		});
		
		//Gallery Button
		final ImageButton buttonGallery= (ImageButton) findViewById(R.id.button2);
		//buttonGallery.setBackgroundResource(R.drawable.fromgallery);
		buttonGallery.setOnClickListener(new View.OnClickListener() {
			
			//Go to Gallery, Implement the Intent that you want to load the image gallery
			@Override
			public void onClick(View v) 
			{
				Global.mode = "Gallery";
				
				//Create Intent to go to Gallery
				Intent intent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				
				 //Start the Gallery Intent, (Will call the onActivityResult)
				startActivityForResult(intent, RESULT_LOAD_IMAGE);
			}
		    
		});
	}
	
	
	public void onActivityResult(int requestCode, int resultCode, Intent data)
	{
			super.onActivityResult(requestCode, resultCode, data);
			if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
		        if (resultCode == RESULT_OK) {
		        	// Image captured and saved to fileUri specified in the Intent 
		        	// Notify User where the image was saved
		        	Global.picturePath=outputFileUri.getPath();
		        	
		        	Toast.makeText(this, "Image saved to:\n" +
		        			  outputFileUri.getPath(), Toast.LENGTH_LONG).show();
		        	 
		        	/*
		        	 try {
		        	        File f = new File(Global.picturePath);
		        	        ExifInterface exif = new ExifInterface(f.getPath());
		        	        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

		        	        int angle = 0;

		        	        if (orientation == ExifInterface.ORIENTATION_ROTATE_90) {
		        	            angle = 90;
		        	        } 
		        	        else if (orientation == ExifInterface.ORIENTATION_ROTATE_180) {
		        	            angle = 180;
		        	        } 
		        	        else if (orientation == ExifInterface.ORIENTATION_ROTATE_270) {
		        	            angle = 270;
		        	        }

		        	        Matrix mat = new Matrix();
		        	        mat.postRotate(angle);

		        	        Bitmap bmp = BitmapFactory.decodeStream(new FileInputStream(f), null, null);
		        	        Bitmap correctBmp = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(), bmp.getHeight(), mat, true);                 
		        	    }
		        	    catch (IOException e) {
		        	        Log.w("TAG", "-- Error in setting image");
		        	    }   
		        	    catch(OutOfMemoryError oom) {
		        	        Log.w("TAG", "-- OOM Error in setting image");
		        	    }
		        	*/
		        	
		        	
		        	
		        	//Start the Testpic Activity (which will being it to the editor page)
		            startActivity(new Intent(this, Testpic.class));
		        }
			}
			
			else if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) 
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
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {

        super.onWindowFocusChanged(hasFocus);

        if(hasFocus) {
        	DisplayMetrics displaymetrics = new DisplayMetrics();
        	getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        	windowWidth=displaymetrics.widthPixels;
        	windowHeight=displaymetrics.heightPixels;
    
        	ImageButton cameraButton = (ImageButton) findViewById(R.id.button1);
        	ImageButton galleryButton = (ImageButton) findViewById(R.id.button2);
        	
        }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
}