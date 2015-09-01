package com.example.vamsiboss;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import myapps.assignment1.loginapp.R;

public class SecondActivity extends Activity {
	
	Button btn_logout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		initializeUI();
		
	}
	
	private void initializeUI() {
		btn_logout = (Button) findViewById(R.id.btn_logout);
		btn_logout.setOnClickListener(logoutListener);
	}

	private OnClickListener logoutListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			showLogoutDialog();
		}
	};
	
	
	private void showLogoutDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);
		builder.setTitle("Logout");
		builder.setMessage("Do you want to logout ?");
		builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		});
		builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.dismiss();
			}
		});
		
		AlertDialog alert = builder.create();
		alert.show();
		
	}
	
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		startActivity(new Intent(getApplicationContext(), FirstActivity.class));
	}
}
