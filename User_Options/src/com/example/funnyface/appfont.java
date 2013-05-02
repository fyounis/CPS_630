package com.example.funnyface;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class appfont extends Activity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_photo_options);
 
        TextView tv = (TextView) findViewById(R.id.customfont);
        Typeface tf = Typeface.createFromAsset(this.getAssets(),"fonts/Wagnasty.ttf");
        tv.setTypeface(tf);
    }
}