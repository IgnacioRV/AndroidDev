package com.example.wpchanger;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;

public class SurfaceViewExample extends Activity implements OnTouchListener {

	OurView v;
	Bitmap oldsprite, sprite, linkBitmap;
	float x, y;
	Sprite link;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	
		v = new OurView(this);
		v.setOnTouchListener(this); // added OnTouchListener
		oldsprite = BitmapFactory.decodeResource(getResources(), R.drawable.link);
		linkBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.spritesheet);
		sprite = Bitmap.createScaledBitmap(oldsprite, 100, 100, false);
		x = 0;
		y = 0;
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

	public class OurView extends SurfaceView implements Runnable {

		Thread t = null;
		SurfaceHolder holder;
		boolean isOK = false; // check if thread is running

		public OurView(Context context) {
			super(context);
			holder = getHolder();
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isOK) {
				// perform canvas drawing
				if (!holder.getSurface().isValid()) {
					continue;
				}
				link = new Sprite(OurView.this, linkBitmap);
				Canvas c = holder.lockCanvas();
				onDraw(c);
				holder.unlockCanvasAndPost(c);
			}
		}

		protected void onDraw(Canvas canv) {
			canv.drawARGB(255, 255, 133, 51);
			canv.drawBitmap(sprite, x - (sprite.getWidth() / 2), y - (sprite.getHeight() / 2), null);
			link.onDraw(canv);
		}

		public void pause() {
			isOK = false;
			while (true) {
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			t = null;
		}

		public void resume() {
			isOK = true;
			t = new Thread(this); // the run method is in this subclass
			t.start();
		}
	}

	@Override
	public boolean onTouch(View v, MotionEvent me) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switch (me.getAction()) {
		case MotionEvent.ACTION_MOVE:
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_DOWN:
			x = me.getX();
			y = me.getY();
			break;
		case MotionEvent.ACTION_UP:
			x = me.getX();
			y = me.getY();
			break;

		}
		return false;
	}

}
