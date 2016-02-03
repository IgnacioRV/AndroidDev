package com.example.wpchanger;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;

public class Game extends Activity implements OnTouchListener{
	GameView v;
	Bitmap characterBitmap; 
	int x,y; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		v = new GameView(this);
		v.setOnTouchListener(this);
		x = 10;
		y = 10; 
		characterBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.link);
		
	}
	
	public class GameView extends SurfaceView implements Runnable{
		SurfaceHolder holder; 
		public GameView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
			holder = getHolder(); 
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
