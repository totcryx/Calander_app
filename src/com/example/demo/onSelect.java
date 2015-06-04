/**
 * 
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author Owner
 *
 */
public class onSelect extends Activity {
	


	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */public Intent intent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.onselectlayout);
		intent = getIntent();

		updateClasses();
		setHw();

		// TODO Auto-generated method stub

	}

	public void classSet(View v) {
		Intent start = new Intent(this, setClass.class);

		startActivity(start);
		finish();

	}

	public void setHw() {
		ArrayList<String> list = intent.getStringArrayListExtra("hw");
		EditText one = (EditText) findViewById(R.id.hw1);
		if (list != null)
			one.setText(list.get(0));
	}

	public void saveHw(View v) {
		EditText one = (EditText) findViewById(R.id.hw1);
		EditText two = (EditText) findViewById(R.id.hw2);
		EditText three = (EditText) findViewById(R.id.hw3);
		EditText four = (EditText) findViewById(R.id.hw4);
		EditText five = (EditText) findViewById(R.id.hw5);
		EditText six = (EditText) findViewById(R.id.hw6);
		EditText seven = (EditText) findViewById(R.id.hw7);
		
		Datastore data = new Datastore(this.getApplicationContext());
		String[] array= new String[7];
		

		array[0]=(one.getText().toString());
		array[1]=(two.getText().toString());
		array[2]=(three.getText().toString());
		array[3]=(four.getText().toString());
		array[4]=(five.getText().toString());
		array[5]=(six.getText().toString());
		array[6]=(seven.getText().toString());
		
		int count=0;
		for(String x: array){
		data.saveHw(intent.getStringExtra("Date")+count, x);
		count++;
		}
		
        Intent in = new Intent(this,MainActivity.class);
        startActivity(in);
		finish();

	}

	public void updateClasses() {
        int count=0;
		TextView one = (TextView) findViewById(R.id.class1);
		TextView two = (TextView) findViewById(R.id.class2);
		TextView three = (TextView) findViewById(R.id.class3);
		TextView four = (TextView) findViewById(R.id.class4);
		TextView five = (TextView) findViewById(R.id.class5);
		TextView six = (TextView) findViewById(R.id.class6);
		TextView seven = (TextView) findViewById(R.id.class7);
		ArrayList<String> classList = intent.getStringArrayListExtra("classes");
		if (!classList.isEmpty()){
			    if(count<classList.size()){
				one.setText(classList.get(0).toString());
				count++;
			    }
			    if(count<classList.size()){
				two.setText(classList.get(1));
				count++;
			    }
			    if(count<classList.size()){
				three.setText(classList.get(2));
				count++;
			    }
			    if(count<classList.size()){
				four.setText(classList.get(3));
				count++;
			    }
			    if(count<classList.size()){
				five.setText(classList.get(4));
				count++;
			    }
				
				if(count<classList.size()){
				six.setText(classList.get(5));
				count++;
				}
		        if(count<classList.size()){
				seven.setText(classList.get(6));
				count++;
				}
			
			
		}
		TextView hwone = (TextView) findViewById(R.id.hw1);
		TextView hwtwo = (TextView) findViewById(R.id.hw2);
		TextView hwthree = (TextView) findViewById(R.id.hw3);
		TextView hwfour = (TextView) findViewById(R.id.hw4);
		TextView hwfive = (TextView) findViewById(R.id.hw5);
		TextView hwsix = (TextView) findViewById(R.id.hw6);
		TextView hwseven = (TextView) findViewById(R.id.hw7);
		ArrayList<String> HwList = intent.getStringArrayListExtra("HwSet");
		if(HwList.size()>0){
		hwone.setText(HwList.get(0));
		hwtwo.setText(HwList.get(1));
		hwthree.setText(HwList.get(2));
		hwfour.setText(HwList.get(3));
		hwfive.setText(HwList.get(4));
		hwsix.setText(HwList.get(5));
		hwseven.setText(HwList.get(6));
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		// put your code here...

	}

}
