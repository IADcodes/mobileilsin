package com.iadev.mobileilsin;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Notification extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_notification, menu);
        return true;
    }
}
