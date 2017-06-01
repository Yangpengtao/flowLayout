package com.example.liushibujuview;

import com.example.liushibujuview.ui.BUILayout;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private BUILayout rl;

	private String[] strs = new String[] { "android", "android studio",
			"eclipse", "text", "example", "mainactivity", "settext",
			"onlayout", "layoutparams", "logcat", "wrap_content",
			"collectactivity", "setbackgroundcolor", "adb is running normally",
			"project","has","no","we are family","drawable",
			"setbackgroundresource","actionbaractivity","properties" };

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		rl = (BUILayout) findViewById(R.id.rl);

		LinearLayout.LayoutParams rlp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		rlp.setMargins(20, 0, 0, 0);

		TextView tv;
		for (int i = 0; i < strs.length; i++) {
			tv = new TextView(this);
			tv.setText(strs[i]);
			tv.setTextColor(0xffffffff);
			tv.setPadding(5, 5, 5, 5);
			tv.setBackgroundResource(R.drawable.bg);
			rl.addView(tv, rlp);
		}

	}

}
