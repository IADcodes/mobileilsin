package com.iadev.mobileilsin;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView.OnItemClickListener;


  



	public class Schoolinfo extends Activity implements OnItemClickListener {
		/** Called when the activity is first created. */

		ListView lview;
		Listview2textAdapter lviewAdapter;

		private final static String item[] = {"학교 홈페이지 방문","학교 전화번호","학교위치"};

		private final static String subitem[] = {"부천일신중학교 홈페이지 방문하기", "교무실: 070-7099-8711\n행정실: 070-7099-8703\n팩스: 032-351-0304","경기도 부천시 소사구 범안로96번길 44(범박동) 부천일신중학교\n\n클릭하여 Google지도에서 학교위치 자세히 보기"};

		@Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_appinfo);

	        lview = (ListView) findViewById(R.id.aplist);   
	        lviewAdapter = new Listview2textAdapter(this, item, subitem);

	        System.out.println("adapter => "+lviewAdapter.getCount());

	        lview.setAdapter(lviewAdapter);

	        lview.setOnItemClickListener(this);
	    }

		public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
			// TODO Auto-generated method stub
  	  
  	  if(position == 0){
  		Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://bcilsin.ms.kr"));
        startActivity(intent);
  	  }
  	  
  	  else if(position == 2){
  		Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse("http://goo.gl/maps/R6rzA"));
        startActivity(intent1);
  	  }
  	  
  	  
  	  
    }
	        
		}
	
    
    
	
