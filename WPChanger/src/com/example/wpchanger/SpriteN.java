package com.example.wpchanger;

import com.example.wpchanger.Game.GameView;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.widget.Toast;

public class SpriteN {
	int x, y, xSpeed, ySpeed;
	int height, width;
	Bitmap b;
	GameView gv;

	public SpriteN(GameView gameView, Bitmap bm) {
		// TODO Auto-generated constructor stub
		b = bm;
		gv = gameView;
		height = b.getHeight();
		width = b.getWidth();
		x = y = 0;
		xSpeed = 5;
		ySpeed = 0;
	}
	public void updatePos(){
		x+=xSpeed; 
		y+=ySpeed;
		
	}
	public void onDraw(Canvas canv) {
		// TODO Auto-generated method stub
		x+=xSpeed; 
		y+=ySpeed;
		//this.updatePos();
		Rect src = new Rect(0, 0, width, height);
		Rect dst = new Rect(x, y, x + width, y + height);
		canv.drawBitmap(b, src, dst, null);

	}

}
