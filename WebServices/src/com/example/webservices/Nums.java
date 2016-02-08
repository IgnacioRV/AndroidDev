package com.example.webservices;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Nums extends Activity implements OnClickListener{
	EditText number;
	Button sendInfo;
	@Override 
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.numbers);
		number = (EditText) findViewById(R.id.editText1);
		sendInfo = (Button) findViewById(R.id.button1);
		sendInfo.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	

}
