package com.iadev.mobileilsin;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Schoolinfo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schoolinfo);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_schoolinfo, menu);
        return true;
    }
}
