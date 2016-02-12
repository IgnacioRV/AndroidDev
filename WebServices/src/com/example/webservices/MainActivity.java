package com.example.webservices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	Button width, height, calc, set;
	TextView area, h, w;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		width = (Button) findViewById(R.id.widthButton);
		height = (Button) findViewById(R.id.heightButton);
		calc = (Button) findViewById(R.id.button3);
		set = (Button) findViewById(R.id.setting);
		area = (TextView) findViewById(R.id.textView1);
		w = (TextView) findViewById(R.id.textView3);
		h = (TextView) findViewById(R.id.textView2);

		width.setOnClickListener(this);
		height.setOnClickListener(this);
		calc.setOnClickListener(this);
		set.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		Intent i = new Intent(this, Nums.class); // (Context, class we want to
													// open)
		switch (v.getId()) {
		case R.id.heightButton:
			// width
			i.putExtra("numbers", "height");
			startActivityForResult(i, 1);
			break;

		case R.id.widthButton:
			// height
			i.putExtra("numbers", "width");
			startActivityForResult(i, 1);
			break;

		case R.id.button3:
			// calc
			int a = Integer.valueOf(w.getText().toString());
			int b = Integer.valueOf(h.getText().toString());
			area.setText(a * b + " m ");
			break;
		case R.id.setting:
			// go to settings
			startActivity(new Intent(this, Settings.class));
			break;
		}
		// TODO Auto-generated method stub

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (data.getExtras().containsKey("widthInfo")) {
			w.setText(data.getStringExtra("widthInfo"));
		}

		if (data.getExtras().containsKey("heightInfo")) {
			h.setText(data.getStringExtra("heightInfo"));
		}
	}
}
