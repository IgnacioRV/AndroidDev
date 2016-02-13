package com.nrv.mtglife;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class Comment extends Activity implements OnClickListener{
	EditText title,content; 
	@Override
	//This comment will stay after we exit and we come back
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.addcomment);
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = sp.edit(); 
		title = (EditText) findViewById(R.id.title);
		content = (EditText) findViewById(R.id.content);
		loadPreferences();
	}
	
	void loadPreferences() {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		title.setText(sp.getString("TITLE", ""));
		content.setText(sp.getString("CONTENT", ""));
		finish();
	}

	void savePreferences() {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit =  sp.edit(); 
		edit.putString("TITLE", title.getText().toString());
		edit.putString("CONTENT", content.getText().toString());
		edit.commit();		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	

}
