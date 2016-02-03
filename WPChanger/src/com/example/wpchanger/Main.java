package com.example.wpchanger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Main extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button Draw = (Button) findViewById(R.id.draw);
		Draw.setOnClickListener(this);
		ImageView img = (ImageView) findViewById(R.id.fig);
		img.setOnClickListener(this);

	}

	public void onClick(View v) {
		switch(v.getId()){
		case R.id.draw:
			startActivity(new Intent("com.example.wpchanger.DRAW"));
			break;
		case R.id.fig:
			
			startActivity(new Intent("com.example.wpchanger.SVE"));
		break; 
		}
		
		}

}
