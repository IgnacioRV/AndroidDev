package com.nrv.projectyasuo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TutorialOne extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ending);
		Button b = (Button) findViewById(R.id.back);
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent lastMenu = new Intent("com.nrv.projectyasuo.MENU");
				startActivity(lastMenu);
			}
		});
	}
	

}
