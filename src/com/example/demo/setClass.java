/**
 * 
 */
package com.example.demo;

import java.util.LinkedHashSet;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * @author Owner
 *
 */
public class setClass extends Activity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	public final Datastore start = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setclasslayout);
		// TODO Auto-generated method stub

	}

	public void saveClasses(View v) {
		TextView one = (TextView) findViewById(R.id.one);
		TextView two = (TextView) findViewById(R.id.two);
		TextView three = (TextView) findViewById(R.id.three);
		TextView four = (TextView) findViewById(R.id.four);
		TextView five = (TextView) findViewById(R.id.five);
		TextView six = (TextView) findViewById(R.id.six);
		TextView seven = (TextView) findViewById(R.id.seven);
		String [] array= new String[7];
		
		array[0]=(one.getText().toString()+" ");
		array[1]=(two.getText().toString()+" ");
		array[2]=(three.getText().toString()+" ");
		array[3]=(four.getText().toString()+" ");
		array[4]=(five.getText().toString()+" ");
		array[5]=(six.getText().toString()+" ");
		array[6]=(seven.getText().toString()+" ");
		Datastore data = new Datastore(this.getApplicationContext());
	
		data.saveClasses(array);
		data.loadClasses();
		data.StartActivity();
		finish();
	}

}
