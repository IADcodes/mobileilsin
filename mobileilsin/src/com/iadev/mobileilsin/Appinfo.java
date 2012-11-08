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


  



	public class Appinfo extends Activity implements OnItemClickListener {
		/** Called when the activity is first created. */

		ListView lview;
		Listview2textAdapter lviewAdapter;

		private final static String item[] = {"애플리케이션 버전","애플리케이션 개발자","IAD동아리 홈페이지 방문","앱 업데이트 확인","애플리케이션 소개"};

		private final static String subitem[] = {"0.3_2012.10.20_beta", "한영빈, 나일웅, 이석준","터치하여 동아리 홈페이지 방문", "Google Play Store에서 업대이트 확인",
			"애플리케이션에 대한 소개 보기"};

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
  	  
  	  if(position == 2){
  		Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://iadev.3owl.com"));
        startActivity(intent);
  	  }
  	  
  	  else if(position == 3){
  	  Intent intent1 = new Intent(Intent.ACTION_VIEW);
  	   intent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.iadev.mobileilsin&feature=search_result#?t=W251bGwsMSwyLDEsImNvbS5pYWRldi5tb2JpbGVpbHNpbiJd"));
  	  startActivity(intent1);
  	  }
  	  
  	  else if(position == 4){
  	  Intent intent2 = new Intent(Intent.ACTION_VIEW);
  	intent2.setData(Uri.parse("http://iadev.3owl.com/site/?project=%EA%B0%9C%EB%B0%9C%EC%A4%91%EB%AA%A8%EB%B0%94%EC%9D%BC%EC%9D%BC%EC%8B%A0"));
  	  startActivity(intent2);
  	  }
  	  
    }
	        
		}
	
    
    
	
