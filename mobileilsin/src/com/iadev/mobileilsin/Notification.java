package com.iadev.mobileilsin;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import kr.iadev.bcilsin.R;

import com.iadev.mobileilsin.Notification_parse;

public class Notification extends Activity {
	

	private ArrayList<HashMap<String, String>> data;
	private ListView list;
	private SimpleAdapter sa;
	private Notification_parse hp;
	
	private final Handler handler = new Handler()
	{
		@Override
		public void handleMessage(Message msg)
		{
			listUpdate();
		}
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        
        data = new ArrayList<HashMap<String, String>>();
        list = (ListView)findViewById(R.id.notificationlistView);
        
        hp = new Notification_parse(Notification.this, handler, data);
        
        sa = new SimpleAdapter(Notification.this, data, R.layout.notification_list_row,
        		new String[]{"title","writer","date"}, new int[]{R.id.tv_title, R.id.tv_writer, R.id.tv_date});
        list.setAdapter(sa);
        hp.open();
        
    }
    
    //업데이트하기
    
    public void onItemClick(AdapterView<?> parent, View v, final int position, long id)
    {
    	String link = data.get(position).get("link");
    	Intent intent = new Intent(Notification.this, webview.class);
    	SharedPreferences pref = getSharedPreferences("pref", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit(); 
		editor.putString("link", link);
		editor.commit();
    	startActivity(intent);
    }
   private void listUpdate(){
   	sa.notifyDataSetChanged();
   }
}