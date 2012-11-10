

package com.iadev.mobileilsin;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.iadev.mobileilsin.Arrayadapter;



public class Home extends ListActivity {
	 
	static final String[] MAIN = 
               new String[] { "공지사항", "점심메뉴", "학교정보", "앱 정보"};
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
 
		setListAdapter(new Arrayadapter(this, MAIN));
 
	}
 
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
 
		 if(position == 0){
			  Intent intent = new Intent( Home.this, Notification.class);
			  startActivity(intent);
			  }

			  else if(position == 1){
			  Intent intent1 = new Intent( Home.this, Launchmenu.class);
			  startActivity(intent1);
			  }

			  else if(position == 2){
			  Intent intent2 = new Intent( Home.this, Schoolinfo.class);
			  startActivity(intent2);
			  }

			  else if(position == 3){
			  Intent intent3 = new Intent( Home.this, Appinfo.class);
			  startActivity(intent3);
			  }
		  }


		    // Do something with the data

		}
		  