package com.example.vamsiboss;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import myapps.assignment1.loginapp.R;

public class FirstActivity extends Activity {
	
	private  final String TAG  =  getClass().getSimpleName();
	
	Button btn_login;
	EditText et_username,et_pswd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		initializeUI();
		
	}

	private void initializeUI() {
		et_username = (EditText) findViewById(R.id.et_username);
		et_pswd = (EditText) findViewById(R.id.et_password);
		
		btn_login = (Button) findViewById(R.id.btn_login);
		
		btn_login.setOnClickListener(loginBtnListener);
		
	}
	
	
	private OnClickListener loginBtnListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			
			if(isInputsValid()){
				String temp_uName = et_username.getText().toString().trim();
				String temp_pswd = et_pswd.getText().toString().trim();
				Log.d(TAG, "username: "+temp_uName + "  : "+temp_pswd);
				if (temp_uName.equals(Constants.HARDCODE_USERNAME)){
					Log.d(TAG, "correct username");
					if (temp_pswd.equals(Constants.HARDCODE_PSWD)) {
						Intent secondActivityIntent = new Intent(getApplicationContext(), SecondActivity.class);
						startActivity(secondActivityIntent);
						finish();
					}else{
						Log.d(TAG, "incorrect password");
					}
				}else{
					Log.d(TAG, "incorrect username");
					et_username.requestFocus();
					Toast.makeText(getApplicationContext(), "Invalid entry in username", Toast.LENGTH_SHORT).show();
				}
			}else{
				Log.d(TAG, "incorrect entry");
				et_username.requestFocus();
			}
		}
	};
	
	
	private boolean isInputsValid() {
		if (!Validator.isUserName(et_username, true)) {
			return false;
		}
		if (!Validator.hasText(et_pswd)) {
			return false;
		}
		
		return true;
	}
}
