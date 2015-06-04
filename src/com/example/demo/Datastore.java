/**
 * 
 */
package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * @author Owner
 *
 */
public class Datastore extends Activity {

	public static final String Prefs_File = "DATA";
	public Editor editor=null;
	public SharedPreferences Prefs;
	public Intent intent;
	public Context ctx;
	public String date;

	
	
	

	public Datastore(Context context) {
		
		Prefs= context.getSharedPreferences(Prefs_File,MODE_PRIVATE);
		 
		ctx=context.getApplicationContext();
		 intent= new Intent(ctx,onSelect.class);
		 
	}

	public Datastore() {

	}
	public void loadHw(String Date) {
		date=Date;
		intent.putExtra("Date", date);
		ArrayList<String> list= new ArrayList<String>();
		
	int count=0;
	String key=date+""+count;
	while(Prefs.contains(key)){
		list.add(Prefs.getString(key, null));
		count++;
		key=date+""+count;
	}
	intent.putExtra("HwSet", list);
		
	
	
		
	}
	public void loadClasses(){
//		Set<String> temp= Prefs.getStringSet("classes", null);
//		
  ArrayList<String> a= new ArrayList<String>();

  int count=0;
String key= "class"+count;
		while(Prefs.contains(key)){
			a.add(Prefs.getString(key, null));
			count++;
			key="class"+count;
		}
		
		
	  intent.putStringArrayListExtra("classes", a);
	}

	public void saveClasses(String[] setToSave){
		editor=Prefs.edit();
		int count=0;
		for(String x:setToSave){
			editor.putString("class"+count, x);
			count++;
		}
		
		editor.commit();
		
	}
	public void StartActivity(){
	
intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	ctx.startActivity(intent);
	}
	
	public void saveHw(String date,String hw){
		editor=Prefs.edit();
		editor.putString(date, hw);
		editor.commit();
		
	}
	public void setDate(String dat){
		date=dat;
	}
	public String getDate(){
		return date;
	}
	public Context getContext(){
		return ctx;
	}
	public void refreshMain(Context context){
	 Intent inten= new Intent(context.getApplicationContext(),MainActivity.class);
	 inten.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	 MainActivity a = new MainActivity();
	 a.finish();
	 startActivity(inten);
	 
	}
}
