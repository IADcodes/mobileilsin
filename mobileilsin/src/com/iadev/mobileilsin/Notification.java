package com.iadev.mobileilsin;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import net.htmlparser.jericho.Source;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


public class Notification extends Activity
 {
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_notification);

	String yourUrl = "http://bcilsin.ms.kr/?act=news.main&comm=com";

	TextView tv = (TextView)findViewById(R.id.tv1);
	tv.setText(getHtmltoText(yourUrl));
	}

	public String getHtmltoText(String sourceUrlString) {
	Source source = null;
	String content = null;

	try {
	//url에서 html 소스를 읽어온다.
		URL sUrl = new URL(sourceUrlString);
		InputStream is = sUrl.openStream();
		Source source1= new Source(new InputStreamReader(is,"utf-8"));
	// 한글사용을 위해서는 윗 줄의 코드를 아래처럼 수정
	// URL sUrl = new URL(sourceUrlString);
	// InputStream is = sUrl.openStream();
	// Source source= new Source(new InputStreamReader(is,"euc-kr"));
	// "euc-kr" 부분은 charset에 맞춰 변경해준다. UTF-8, KSC5601 etc...

	// 전체 소스 구문을 분석한다.
	source1.fullSequentialParse();
	// HTML markup에서 text contents만 가져와서 스트링으로 변환한다.
	content=source1.getTextExtractor().toString();
	} catch (Exception e) {
	e.printStackTrace();
	}
	return content;
	}
	}




	
