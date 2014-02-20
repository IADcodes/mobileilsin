package com.iadev.mobileilsinwidget;

import kr.iadev.bcilsin.R;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.TextView;

public class TodayLunchwidget extends AppWidgetProvider {
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
		Log.d("LunchmenuService", "start Lunchmenu");
		Intent intent_lunch = new Intent(context , com.iadev.mobileilsinwidget.Lunchmenu.class);
		context.startService(intent_lunch);
		
		for(int i=0; i<appWidgetIds.length; i++){ 
            int appWidgetId = appWidgetIds[i];
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_lunch);
            appWidgetManager.updateAppWidget(appWidgetId, views);
        } 

		
		}
	public void initUI(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		 SharedPreferences pref = context.getSharedPreferences("pref", Context.MODE_PRIVATE);
		 String loadedfoodstring = pref.getString("foodvalue","");
		 int loadedwidgetBackgroundId = pref.getInt("widgetBackgroundId", 0);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_lunch);
        views.setTextViewText(R.id.widgettext, "점심 메뉴 \n \n"+ loadedfoodstring);
        views.setImageViewResource(R.id.widgetbg ,loadedwidgetBackgroundId);
        for(int appWidgetId : appWidgetIds) {
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }

	
	public void onReceive(final Context context , Intent intent) {
		super.onReceive(context, intent);
        
        String action = intent.getAction();
        if(AppWidgetManager.ACTION_APPWIDGET_UPDATE.equals(action)){
        	AppWidgetManager manager = AppWidgetManager.getInstance(context);
            initUI(context, manager, manager.getAppWidgetIds(new ComponentName(context, getClass())));

        }
        else{}


		//RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget_lunch);
		//views.setTextViewText(R.id.text, );
		//AppWidgetManager wm = AppWidgetManager.getInstance(TodayLunchwidget.this);
		//ComponentName widget = new ComponentName(context, TodayLunchwidget.class);
		//wm.updateAppWidget(widget,views);
		}	

	

	public void onDeleted(Context context){
		Intent intent_lunch = new Intent(context , com.iadev.mobileilsinwidget.Lunchmenu.class);
		context.stopService(intent_lunch);
	}
}
