package com.iadev.mobileilsin;



import android.net.Uri;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.view.View;

public class Appinfo extends ListActivity {

  



	public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        String[] values = new String[] { "�� ����", "�� ������", "���Ƹ� Ȩ������ �湮",
            "�÷��� ������ ������Ʈ Ȯ��", "�� �Ұ�" };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);
            setListAdapter(adapter);
          }
    
	protected void onListItemClick(ListView l, View v, int position, long id) {
		  super.onListItemClick(l, v, position, id);
  	  
  	  if(position == 2){
  		Intent intent = new Intent();
        
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("http://iadev.3owl.com"));
        startActivity(intent);
  	  }
  	  
  	  else if(position == 3){
  	  Intent intent1 = new Intent( Appinfo.this, Launchmenu.class);
  	  startActivity(intent1);
  	  }
  	  
  	  else if(position == 4){
  	  Intent intent2 = new Intent( Appinfo.this, Schoolinfo.class);
  	  startActivity(intent2);
  	  }
  	  
    }
    
    
}
