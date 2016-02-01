package com.example.wpchanger;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class DrawingTheBall extends View{
	Bitmap sprite, spriteold;
	int x,y;
	public DrawingTheBall(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		spriteold = BitmapFactory.decodeResource(getResources(), R.drawable.link);
		sprite = Bitmap.createScaledBitmap(spriteold, 100, 100, false);
		x = 0; 
		y = 0; 
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		// Paint a rectangle
		Rect ourRect = new Rect(); // Create a new rectangle
		ourRect.set(0,0,canvas.getWidth(),canvas.getHeight()/2);
		Paint blue = new Paint();
		blue.setColor(Color.BLACK);
		blue.setStyle(Paint.Style.FILL);
		
		canvas.drawRect(ourRect, blue); 
		x += 10 ; 
		y += 10; 
		// control that thee sprite doesn't go out of the screen; 
		if ( x < canvas.getWidth()) x+=10; 
		else x = 0;
		if ( y < canvas.getHeight()) y+=10; 
		else y = 0;
		
		canvas.drawBitmap(sprite, x, y, new Paint());
		invalidate();
	} 

}
