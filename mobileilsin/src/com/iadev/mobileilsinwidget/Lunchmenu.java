package com.iadev.mobileilsinwidget;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.Calendar;

public class Lunchmenu extends Service {
	private Handler handler;
	String url;
	Document doc;
	Elements food;

	public void onCreate(){
		super.onCreate();
		
	}
	
	public int onStartCommand(Intent intent, int flags, int startId) {

		super.onStartCommand(intent, flags, startId);
		
		
		
		Log.d("LunchmenuService", "Getting Lunchmenu");
		IntentFilter filter = new IntentFilter();
		filter.addAction(Intent.ACTION_TIME_CHANGED);
		Log.d("LunchmenuService", "parsing");
		handler = new Handler();
		new Thread(runnable).start();
		return START_STICKY;
	}
	Runnable runnable = new Runnable(){
		public void run(){
			url = "http://www.bcilsin.ms.kr/main";
			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			handler.post(new Runnable(){
				public void run(){
					int mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
					SharedPreferences pref = getSharedPreferences("pref", Context.MODE_PRIVATE);
					int loadedmDay = pref.getInt("mDay",0);
					if(mDay != loadedmDay){
						Elements food = doc.select("div.menu > span");
						food = doc.select("div.menu > span");
						String foodstring = food.get(1).text().replaceAll(" ", "\n");
						SharedPreferences.Editor editor = pref.edit(); 
						editor.putString("foodvalue", foodstring);
						editor.putInt("mDay", mDay);
						editor.commit();
					}
				}
			});
		}
	};

	public IBinder onBind(Intent arg0) {
		return null;
	}
	public void onDestroy() {
		super.onDestroy();
	}
}
