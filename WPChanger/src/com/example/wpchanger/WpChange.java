package com.example.wpchanger;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class WpChange extends Activity implements OnClickListener{
	ImageView bigimg;
	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wpselector);
		
		bigimg = (ImageView) findViewById(R.id.bigimg);
		ImageView img1 = (ImageView) findViewById(R.id.img1);
		ImageView img2 = (ImageView) findViewById(R.id.img2);
		ImageView img3 = (ImageView) findViewById(R.id.img3);

	
		Button submit = (Button) findViewById(R.id.button1);
		
		submit.setOnClickListener(this);
		img1.setOnClickListener(this);
		img2.setOnClickListener(this);
		img3.setOnClickListener(this);



	}
	

	@Override
	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.img1:
			bigimg.setImageResource(R.drawable.mtg1);
		break;
		case R.id.img2:
			bigimg.setImageResource(R.drawable.mtg2);
			break;
		case R.id.img3:
			bigimg.setImageResource(R.drawable.mtg3);
			break;
		case R.id.bigimg:
			
			
			break; 
		}
	}
	
	
	

}
