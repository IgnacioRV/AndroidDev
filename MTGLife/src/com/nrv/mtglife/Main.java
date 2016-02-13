package com.nrv.mtglife;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Main extends Activity implements OnClickListener{
	TextView s1,s2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainlayout);
		s1 = (TextView) findViewById(R.id.s1);
		s2 = (TextView) findViewById(R.id.s2);
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = sp.edit(); 
	}
	void addS1(int qty){
		int current = Integer.valueOf((String) s1.getText());
		current += qty; 
		s1.setText(current+"");
	}
	void addS2(int qty){
		int current = Integer.valueOf((String) s2.getText());
		current += qty; 
		s2.setText(current+"");
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()){
		case R.id.s1:
			addS1(1);
			break; 
		case R.id.sc11:
			addS1(5);
			break; 
		case R.id.sc12:
			addS1(1);
			break; 
		case R.id.sc13:
			addS1(-1);
			break; 
		case R.id.sc14:
			addS1(-5);
			break; 
		// ----- Change S2 ----
		case R.id.s2:
			addS2(1);
			break; 
		case R.id.sc21:
			addS2(5);
			break; 
		case R.id.sc22:
			addS2(1);
			break; 
		case R.id.sc23:
			addS2(-1);
			break; 
		case R.id.sc24:
			addS2(-5);
			break; 
		case R.id.comment: 
			startActivity(new Intent ("com.nrv.mtglife.COMMENT"));
			break;
			//TODO Implement Save, Comment and Settings
			
		}
		
	}

}
