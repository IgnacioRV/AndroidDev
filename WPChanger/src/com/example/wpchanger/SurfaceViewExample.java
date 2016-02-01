package com.example.wpchanger;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View.OnTouchListener;

public class SurfaceViewExample extends Activity implements OnTouchListener{

	OurView v;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		v = new OurView(this);
		v.setOnTouchListener(this);
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
		boolean isOK = false;

		public OurView(Context context) {
			super(context);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (isOK) {
				//perform canvas drawing
				if (!holder.getSurface().isValid()){
					continue;
				}
				Canvas c = holder.lockCanvas();
				c.drawARGB(255, 255, 133, 51);
				holder.unlockCanvasAndPost(c);
			}
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

}
