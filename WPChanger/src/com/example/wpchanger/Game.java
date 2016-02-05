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
	Bitmap characterBitmapold, characterBitmap, ghostO, ghost;
	SpriteN character;
	EnemyAI enemy; 
	float x, y, xSpeed,ySpeed;
	int score = 0; 
	boolean first = true; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// Set up the view with OnTouchListener
		v = new GameView(this);	
		v.setOnTouchListener(this);
		//Get bitmaps from /drawable
		characterBitmapold = BitmapFactory.decodeResource(getResources(), R.drawable.link);
		characterBitmap = Bitmap.createScaledBitmap(characterBitmapold, 100, 100, false);
		ghostO = BitmapFactory.decodeResource(getResources(), R.drawable.ghost);
		ghost = Bitmap.createScaledBitmap(ghostO, 100, 100, false);
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

	public class GameView extends SurfaceView implements Runnable {  //here we draw the screen, in order to do that we create a thread
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
			enemy = new EnemyAI(GameView.this, ghost);
			// TODO Auto-generated method stub
			while (runs) {
				// perform canvas drawing
				if (!holder.getSurface().isValid()) {
					continue;
				}
				if (first) {
				character = new SpriteN(GameView.this, characterBitmap);
				first = false; 
				}
				Canvas c = holder.lockCanvas();
				onDraw(c); // Draw everything
				holder.unlockCanvasAndPost(c); //Show what we have drawn
			}

		}

		protected void onDraw(Canvas canv) {
			canv.drawARGB(255, 255, 130, 22);
			//canv.drawBitmap(ghost, x - (characterBitmap.getWidth() / 2), y + (characterBitmap.getHeight() / 2),null);
			Paint paint = new Paint(); 
			paint.setColor(Color.BLACK); 
			paint.setTextSize(50); 
			//Keep track of score on top
			canv.drawText("Score: "+Integer.toString(score), 30, 30, paint); 
			character.onDraw(canv); // call Sprite's class onDraw method 
			enemy.onDraw(canv);
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
		k++;
		// TODO Auto-generated method stub
		try {
			
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float xPress = me.getX();
		float yPress = me.getY();
		if (xPress > enemy.x) {
			enemy.xspeed(5);
		}
		if (xPress < enemy.x){
			enemy.xspeed(-5);
		}
		if (yPress > enemy.y) {
			enemy.yspeed(5);
		}
		if (yPress < enemy.y){
			enemy.yspeed(-5);
		}
		return false;

	}

}
