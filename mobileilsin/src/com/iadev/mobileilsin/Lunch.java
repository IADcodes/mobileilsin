package com.iadev.mobileilsin;

import android.app.TabActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import kr.iadev.bcilsin.R;

public class Lunch extends TabActivity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		
		TabHost tabHost=getTabHost();
		tabHost.addTab(tabHost.newTabSpec("tab1")
				.setIndicator("오늘 점심메뉴")
				.setContent(new Intent(this, Launchmenu.class)));
		
		tabHost.addTab(tabHost.newTabSpec("tab2")
				.setIndicator("이번달 식단표")
				.setContent(new Intent(this, Monthlunch.class)));
		
		tabHost.setCurrentTab(0);
	}
	

}
