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
import com.iadev.bcilsin.R;
public class Lunch extends Activity implements OnItemClickListener{
GridView menu;
private String[] menu_text = {
"오늘 점심메뉴",
"이번달 식단표"};
private Integer[] menu_icon = {
R.drawable.icon_today,
R.drawable.icon_month};
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_lunch);
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
		  Intent intent = new Intent( Lunch.this, Launchmenu.class);
		  startActivity(intent);
		  }

		  else if(arg2 == 1){
		  Intent intent1 = new Intent( Lunch.this, Monthlunch.class);
		  startActivity(intent1);
		  }
// TODO Action to perform
}
}