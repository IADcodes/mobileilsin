package com.iadev.mobileilsin;



import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.view.View;
import kr.iadev.bcilsin.R;


  



	public class Appinfo extends Activity implements OnItemClickListener {
		/** Called when the activity is first created. */

		ListView lview;
		Listview2textAdapter lviewAdapter;

		private final static String item[] = {"앱 패키지 네임 / 앱 버전","모바일일신 초기버전 개발자", "모바일일신 이전 개발자", "현재 모바일일신 개발자","IAD동아리 홈페이지 방문","앱 업데이트 확인","애플리케이션 소개", "오픈소스 라이센스"};

		private final static String subitem[] = {"kr.iadev.bcilsin / 0.5.4", "한영빈, 나일웅, 이석준(2012년)","한영빈, 나일웅, 이석준(2012년)", "이재진","터치하여 동아리 홈페이지 방문", "Google Play Store에서 업데이트 확인",
			"애플리케이션에 대한 소개 보기", "이 애플리케이션은 오픈소스이며,\nMozilla Public License 2.0에 의거하여 \n소스코드가 공개되어 있습니다 "};

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
  	  
  	  if(position == 4){
  		Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://iadev.3owl.com"));
        startActivity(intent);
  	  }
  	  
  	  else if(position == 5){
  	  Intent intent1 = new Intent(Intent.ACTION_VIEW);
  	   intent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.iadev.bcilsin"));
  	  startActivity(intent1);
  	  }
  	  
  	  else if(position == 6){
  	  Intent intent2 = new Intent(Intent.ACTION_VIEW);
  	intent2.setData(Uri.parse("http://iadev.3owl.com/site/?project=%EA%B0%9C%EB%B0%9C%EC%A4%91%EB%AA%A8%EB%B0%94%EC%9D%BC%EC%9D%BC%EC%8B%A0"));
  	  startActivity(intent2);
  	  }
  	  
  	  
  	else if(position == 7){
		  Intent intent3 = new Intent( Appinfo.this, License.class);
		  startActivity(intent3);
		  }
    }
	        
		}
	
    
    
	
