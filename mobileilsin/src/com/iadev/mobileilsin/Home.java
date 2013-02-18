

package com.iadev.mobileilsin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import kr.iadev.bcilsin.R;
public class Home extends Activity implements OnItemClickListener{
GridView menu;
private String[] menu_text = {
"공지사항",
"점심메뉴",
"학교정보",
"등교시간 알람",
"앱 정보"};
private Integer[] menu_icon = {
R.drawable.icon_scnoti,
R.drawable.icon_lunch,
R.drawable.icon_scinfo,
R.drawable.icon_alarm,
R.drawable.icon_appinfo};
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_home);
menu = (GridView)findViewById(R.id.Menu);
menu.setOnItemClickListener(this);
menu.setAdapter(new MenuItem(this, R.layout.listrow, menu_text));
}
public class MenuItem extends ArrayAdapter {
public MenuItem(Context context, int textViewResourceId, String[] objects) {
super(context, textViewResourceId, objects);
}
public View getView(int position, View convertView, ViewGroup parent) {
LayoutInflater inflater=getLayoutInflater();
View row=inflater.inflate(R.layout.listrow, parent, false);
TextView tv=(TextView)row.findViewById(R.id.text);
tv.setText(menu_text[position]);
tv.setCompoundDrawablesWithIntrinsicBounds(0, menu_icon[position], 0, 0);
return row;
}
}
public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
	
	if(arg2 == 0){
		  Intent intent = new Intent( Home.this, Notification.class);
		  startActivity(intent);
		  }

		  else if(arg2 == 1){
		  Intent intent1 = new Intent( Home.this, Lunch.class);
		  startActivity(intent1);
		  }

		  else if(arg2 == 2){
		  Intent intent2 = new Intent( Home.this, Schoolinfo.class);
		  startActivity(intent2);
		  }

		  else if(arg2 == 3){
		  Intent intent3 = new Intent( Home.this, Schoolalarm.class);
		  startActivity(intent3);
		  }

		  else if(arg2 == 4){
		  Intent intent3 = new Intent( Home.this, Appinfo.class);
		  startActivity(intent3);
			  }
// TODO Action to perform
}
}