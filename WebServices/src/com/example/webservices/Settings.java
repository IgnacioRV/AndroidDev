package com.example.webservices;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Settings extends Activity implements OnClickListener {
	CheckBox cb;
	EditText et;
	Button b;
	TextView tv; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);
		cb = (CheckBox) findViewById(R.id.checkBox1);
		et = (EditText) findViewById(R.id.editText1);
		b = (Button) findViewById(R.id.button1);
		tv = (TextView) findViewById(R.id.Name);
		b.setOnClickListener(this);
		loadPreferences();
	}

	private void loadPreferences() {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		boolean cbValue = sp.getBoolean("CHECKBOX", false);
		String name = sp.getString("NAME", "Couldn't find name");
		if (cbValue) {
			cb.setChecked(true);
		} else {
			cb.setChecked(false);
		}
		tv.setText(name);
	}

	private void savePreferences(String key, String value) {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putString(key, value);
		edit.commit();
	}

	private void savePreferences(String key, boolean value) {
		SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putBoolean(key, value);
		edit.commit();
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		savePreferences("CHECKBOX", cb.isChecked());
		if (cb.isChecked())
			savePreferences("NAME", et.getText().toString());
		finish();

	}

}
