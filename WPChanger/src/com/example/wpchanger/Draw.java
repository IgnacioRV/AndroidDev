package com.example.wpchanger;


import android.app.Activity;
import android.os.Bundle;

public class Draw extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		DrawingTheBall v;
		v = new DrawingTheBall(this);
		setContentView(v);
	}

}
