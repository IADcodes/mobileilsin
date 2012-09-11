package com.iadev.mobileilsin;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Launchmenu extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launchmenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_launchmenu, menu);
        return true;
    }
}
