package com.example.wpchanger;

import com.example.wpchanger.Game.GameView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class EnemyAI {
	int x, y, xSpeed, ySpeed;
	int height, width;
	Bitmap b;
	GameView gv;

	public EnemyAI(GameView gameView, Bitmap bm) { //Default enemy constructor 
		// TODO Auto-generated constructor stub
		b = bm;
		gv = gameView;
		height = b.getHeight();
		width = b.getWidth();
		x = y = 40;
		xSpeed = 0;
		ySpeed = 0;
	}
	
	public void updatePos(){
		
		x+=xSpeed; 
		y+=ySpeed;
		
	}
	
	public void xspeed(int k){
		xSpeed = k;
	}
	
	public void yspeed(int k){
		ySpeed = k;
	}
	public void onDraw(Canvas canv) {
		// TODO Auto-generated method stub
		int maxX = canv.getWidth();
		int maxH = canv.getHeight();
		
		updatePos();
		Rect src = new Rect(0, 0, width, height);
		Rect dst = new Rect(x, y, x + width, y + height);
		canv.drawBitmap(b, src, dst, null);

	}

}
