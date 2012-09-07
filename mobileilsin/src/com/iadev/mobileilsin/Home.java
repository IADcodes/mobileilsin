package com.iadev.mobileilsin;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Home extends Activity {
	ListView list;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
        list = (ListView)findViewById(R.id.listView1);
        
        ArrayList<String> dataArr = new ArrayList<String>();
        dataArr.add("��������");
        dataArr.add("���ɸ޴�");
        dataArr.add("�б�����");
        dataArr.add("�� ����");

        ArrayAdapter<String> Adapter = new ArrayAdapter<String>  (this, android.R.layout.simple_list_item_1, dataArr);

        list.setAdapter(Adapter);
    }

    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }
}
