package com.iadev.mobileilsin;

import com.fima.cardsui.views.CardUI;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import kr.iadev.bcilsin.R;
import com.fima.cardsui.objects.CardStack;
public class Home extends Activity {
	private CardUI mCardView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            
            // init CardView
            mCardView = (CardUI) findViewById(R.id.cardsview);
            mCardView.setSwipeable(false);
            
            MyPlayCard notificationscard = new MyPlayCard(
                    "공지사항", 
                    "",
                    "#FF0000", "#FF0000", false, true);
            notificationscard.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                        	Intent intent = new Intent(Home.this, Notification.class);
                            startActivity(intent);
                        }
                    });
            mCardView.addCard(notificationscard);
            
            MyPlayCard lunchcard = new MyPlayCard(
                    "점심메뉴", 
                    "", 
                    "#FFA500", "#FFA500", false, true);
            lunchcard.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                            Intent intent = new Intent(Home.this, Lunch.class);
                            startActivity(intent);
                        }
                    });
            mCardView.addCard(lunchcard);
            
            MyPlayCard schoolinfocard = new MyPlayCard(
                    "학교정보", 
                    "", 
                    "#00CD00", "#00CD00", false, true);
            schoolinfocard.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                        	Intent intent = new Intent(Home.this, Schoolinfo.class);
                            startActivity(intent);
                        }
                    });
            mCardView.addCard(schoolinfocard);
            

            
            MyPlayCard appinfocard = new MyPlayCard(
                    "어플리케이션 정보", 
                    "", 
                    "#0000A0", "#0000A0", false, true);
            appinfocard.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                        	Intent intent = new Intent(Home.this, Appinfo.class);
                            startActivity(intent);
                        }
                    });
            mCardView.addCard(appinfocard);
            
            MyPlayCard schoolalarmocard = new MyPlayCard(
                    "등교알람", 
                    "", 
                    "#808000", "#808000", false, true);
            schoolalarmocard.setOnClickListener(new OnClickListener() {
                        public void onClick(View v) {
                        	Intent intent = new Intent(Home.this, Schoolalarm.class);
                            startActivity(intent);
                        }
                    });
            mCardView.addCard(schoolalarmocard);
            
            
            // draw cards
            mCardView.refresh();
    }
    
    

        		 
        // TODO Action to perform
}