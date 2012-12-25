package com.iadev.mobileilsin;

import android.os.Bundle;
import android.provider.AlarmClock;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import com.iadev.bcilsin.R;

public class Schoolalarm extends Activity{
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_schoolalarm);
		Button btnClose=(Button)findViewById(R.id.button1);
		btnClose.setOnClickListener(new Button.OnClickListener(){
		public void onClick(View v){
			Intent b = new Intent(AlarmClock.ACTION_SET_ALARM);
			b.putExtra(AlarmClock.EXTRA_HOUR, 7);
			b.putExtra(AlarmClock.EXTRA_MINUTES, 40);
			b.putExtra(AlarmClock.EXTRA_MESSAGE, "등교시간 알람(오전 7:40)"); 
			startActivity(b);
			
			Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
			i.putExtra(AlarmClock.EXTRA_HOUR, 8);
			i.putExtra(AlarmClock.EXTRA_MINUTES, 0);
			i.putExtra(AlarmClock.EXTRA_MESSAGE, "등교시간 알람(오전 8:00)"); 
			startActivity(i);
			
			Intent a = new Intent(AlarmClock.ACTION_SET_ALARM);
			a.putExtra(AlarmClock.EXTRA_HOUR, 8);
			a.putExtra(AlarmClock.EXTRA_MINUTES, 20);
			a.putExtra(AlarmClock.EXTRA_MESSAGE, "등교시간 알람(오전 8:20)"); 
			startActivity(a);
		}
		});
		}

		}