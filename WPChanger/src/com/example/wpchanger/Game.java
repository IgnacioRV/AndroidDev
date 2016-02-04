package com.example.wpchanger;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class Game extends Activity implements OnTouchListener {

	GameView v;
	Bitmap characterBitmapold, characterBitmap;
	SpriteN character;
	float x, y, xSpeed,ySpeed;
	int score = 0; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		v = new GameView(this);
		v.setOnTouchListener(this);
		characterBitmapold = BitmapFactory.decodeResource(getResources(), R.drawable.link);
		characterBitmap = Bitmap.createScaledBitmap(characterBitmapold, 100, 100, false);
		x = 0;
		y = 0;
		xSpeed = ySpeed = 0; 

		setContentView(v);

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		v.pause();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		v.resume();
	}

	public class GameView extends SurfaceView implements Runnable {  //here we draw the screen, to do that we create a thread
		Thread t = null; // Set up empty thread
		SurfaceHolder holder;
		boolean runs = false; // checks if the thread is running

		public GameView(Context context) { // constructor
			super(context);
			// TODO Auto-generated constructor stub
			holder = getHolder();
		}

		// we create a thread to hold physics etc.
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (runs) {
				// perform canvas drawing
				if (!holder.getSurface().isValid()) {
					continue;
				}
				character = new SpriteN(GameView.this, characterBitmap);
				Canvas c = holder.lockCanvas();
				onDraw(c); // Draw everything
				holder.unlockCanvasAndPost(c); //Show what we have drawn
			}

		}

		protected void onDraw(Canvas canv) {
			canv.drawARGB(255, 255, 130, 22);
			x+=xSpeed; 
			y+=ySpeed;
			canv.drawBitmap(characterBitmap, x - (characterBitmap.getWidth() / 2), y + (characterBitmap.getHeight() / 2),
					null);
			character.updatePos();
			Paint paint = new Paint(); 
			paint.setColor(Color.BLACK); 
			paint.setTextSize(50); 
			canv.drawText("Score: "+Integer.toString(score), 10, 25, paint); 
			//character.onDraw(canv); // call Sprite's class onDraw method 
		}
		
		public void pause() {
			runs = false;
			while (true) {
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			t = null;
		}

		public void resume() {
			runs = true;
			t = new Thread(this);
			t.start();
		}

	}
	int k = 0; 
	@Override
	public boolean onTouch(View v, MotionEvent me) {
		score++;
		// TODO Auto-generated method stub
		Toast t = Toast.makeText(getApplicationContext(), "TOUCHED "+Integer.toString(k)+" TIMES", Toast.LENGTH_LONG);
		t.show();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float xPress = me.getX();
		float yPress = me.getY();
		if (xPress > x)
			xSpeed = 5;
		if (xPress < x)
			xSpeed = -5;
		if (yPress > y)
			ySpeed = 5;
		if (yPress < y)
			ySpeed = -5;
		return false;

	}

}
