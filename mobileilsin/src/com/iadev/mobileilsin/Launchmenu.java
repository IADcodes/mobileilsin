package com.iadev.mobileilsin;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;
import kr.iadev.bcilsin.R;

public class Launchmenu extends Activity {
	
	private Handler handler;
	String url;
	TextView text;
	Intent intent;
	Document doc;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launchmenu);
		text = (TextView)findViewById(R.id.text);
		handler = new Handler();
		new Thread(runnable).start();
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
					Elements food = doc.select("div.menu > span");
					if(food.size() > 0) {
						text.setText(food.get(1).text().replaceAll(" ", "\n"));
					}
				}
			});
		}
	};
}
