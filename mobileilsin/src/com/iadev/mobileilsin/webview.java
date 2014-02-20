package com.iadev.mobileilsin;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import kr.iadev.bcilsin.R;

public class webview extends Activity{
    
    private WebView mWebView;
     
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
         
        setLayout();
         
        // 웹뷰에서 자바스크립트실행가능
        mWebView.getSettings().setJavaScriptEnabled(true);
        SharedPreferences pref = getSharedPreferences("pref", Context.MODE_PRIVATE);
		 String loadedlink = pref.getString("link","");
        mWebView.loadUrl(loadedlink);
        // WebViewClient 지정
        mWebView.setWebViewClient(new WebViewClientClass());  
         
    }
     
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { 
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) { 
            mWebView.goBack(); 
            return true; 
        } 
        return super.onKeyDown(keyCode, event);
    }
     
    public class WebViewClientClass extends WebViewClient { 
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) { 
            view.loadUrl(url); 
            return true; 
        } 
    }
     
   
    private void setLayout(){
        mWebView = (WebView) findViewById(R.id.webview);
    }
}
