

package com.iadev.mobileilsin;

import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Home extends ListActivity {
  public void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    String[] values = new String[] { "공지사항", "점심메뉴", "학교정보",
        "앱 정보" };
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, values);
    setListAdapter(adapter);
  }
  
  @Override
  public void onListItemClick(ListView l, View v, int position, long id) {
	  Toast.makeText(getApplicationContext(),
		      "Click ListItem Number " + position, Toast.LENGTH_LONG)
		      .show();
		  }
		 
    // Do something with the data

  
  
} 