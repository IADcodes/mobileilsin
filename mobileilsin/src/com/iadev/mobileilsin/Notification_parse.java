package com.iadev.mobileilsin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Handler;

public class Notification_parse
{
	private String url;
	private Context context;
	private Handler handler;
	private ProgressDialog progressDialog;
	private Document doc;
	private ArrayList<HashMap<String, String>> data;
	
	public Notification_parse(Context context, Handler handler, ArrayList<HashMap<String, String>> data)
	{
		this.context = context;
		this.handler = handler;
		this.data = data;
	}
	
	public void open()
	{
		//부천일신중 공지사항
		url = "http://www.bcilsin.ms.kr/board.list?mcode=1128";
		
		//처리하기
		try
		{
			process();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	private void process() throws IOException
	{
		//상태 Progress 띄우기 위해서 사용함!
		final Handler mHandler = new Handler();
		new Thread()
		{

			@Override
			public void run()
			{
				try
				{
					doc = Jsoup.connect(url).get();
					mHandler.post(new Runnable(){

						public void run()
						{
							progressDialog = ProgressDialog.show(context, "", "Data loding...");
						}
					});
					data.clear();
					Elements table = doc.select("table.BoardList > tr");
					HashMap<String, String> hm = null;
					
					
					for(int i=1; i<22; i++)
					{
						Elements tr =table.select("td");
						hm = new HashMap<String, String>();
						
						hm.put("title", (tr.get(2).toString()));//title
						hm.put("writer", (tr.get(3).toString()));//writer
						hm.put("date", (tr.get(4).toString()));//date
						hm.put("link", ("http://www.bcilsin.ms.kr"+tr.get(2).select("[herf]").toString()));//link
						data.add(hm);
					}
					
					mHandler.post(new Runnable()
					{
						public void run()
						{
							progressDialog.cancel();
							//업데이트 완료를 핸들러로 보내줌
							handler.sendEmptyMessage(0);
						}
					});
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
				
			}
			
		}.start();
	}
}