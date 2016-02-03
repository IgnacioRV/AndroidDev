package com.example.wpchanger;

import com.example.wpchanger.SurfaceViewExample.OurView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {
	int x,y,xSpeed,ySpeed; 	
	int height,width; 
	Bitmap b; 
	OurView ov; 
	
	public Sprite(OurView ourView, Bitmap bm) {
		// TODO Auto-generated constructor stub
		b = bm; 
		ov = ourView;
		height = b.getHeight();
		width = b.getWidth();
		x = y = 0; 
		xSpeed = 5; 
		ySpeed = 0; 
	}

	public void onDraw(Canvas canv) {
		// TODO Auto-generated method stub
		Rect src = new Rect (0,0,width,height);
		Rect dst = new Rect(x,y,x+width,y+height);
		canv.drawBitmap(b, src, dst, null);
	}

}
