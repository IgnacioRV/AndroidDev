package com.example.wpchanger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Main extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button Draw = (Button) findViewById(R.id.wpchange);
		Draw.setOnClickListener(this);
		ImageView img = (ImageView) findViewById(R.id.fig);
		img.setOnClickListener(this);
		Button GoGame = (Button) findViewById(R.id.gogame);
		GoGame.setOnClickListener(this);
		Button test = (Button) findViewById(R.id.test1);
		test.setOnClickListener(this);
	}
	Toast t;
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.wpchange:
			t = Toast.makeText(this, "Start", Toast.LENGTH_LONG);
			t.show();
			startActivity(new Intent("com.example.wpchanger.WPCH"));
			break;
		case R.id.fig:
			t = Toast.makeText(this, "Start", Toast.LENGTH_LONG);
			t.show();
			startActivity(new Intent("com.example.wpchanger.SVE"));
			break;
		case R.id.gogame:
			t = Toast.makeText(this, "Start", Toast.LENGTH_LONG);
			t.show();			
			startActivity(new Intent("com.example.wpchanger.GAME"));
			break;
		case R.id.test1:
			startActivity(new Intent("com.example.wpchanger.DRAW"));
		break;
		}

	}

}
