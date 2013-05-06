package com.samir.twitter;

import oauth.signpost.OAuth;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.Toast;
import com.example.funnyface.R;

import com.samir.twitter.twittclass.Twitt;

public class MainActivity extends Activity {
	public final String consumer_key = "SGiBBKT7OFKBMQKUGMkcg";
	public final String secret_key = "id0UW6UD7oSAjk9rNPoLQkcsVvW1WsgUedsf2pQvjE";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final Button TwitButton = (Button) findViewById(R.id.btn);
		TwitButton.performClick( );
	}

	public void onClickTwitt(View view) {
		if (isNetworkAvailable()) {
			Twitt twitt = new Twitt(MainActivity.this, consumer_key, secret_key);
			twitt.logoutTwitter();
			twitt.shareToTwitter("");
		} else {
			showToast("No Network Connection Available !!!");
		}
	}
	

	public boolean isNetworkAvailable() {
		ConnectivityManager connectivity = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		if (connectivity == null) {
			return false;
		} else {
			NetworkInfo[] info = connectivity.getAllNetworkInfo();
			if (info != null) {
				for (int i = 0; i < info.length; i++) {
					if (info[i].getState() == NetworkInfo.State.CONNECTED) {
						return true;
					}
				}
			}
		}
		return false;
	}
	private void showToast(String msg) {
		Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();

	}
}
