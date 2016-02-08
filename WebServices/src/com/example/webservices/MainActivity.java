package com.example.webservices;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{
	Button width,height,calc; 
	TextView area;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		width = (Button) findViewById(R.id.button1);
		height = (Button) findViewById(R.id.button2);
		calc = (Button) findViewById(R.id.button3);
		area = (Button) findViewById(R.id.textView1);
		width.setOnClickListener(this);
		height.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()){
		case R.id.button1:
			//width
			
			break; 

		case R.id.button2:
			//height
			
			break; 

		case R.id.button3:
			//calc
			
			break; 
		}
		// TODO Auto-generated method stub
		
	}
}
