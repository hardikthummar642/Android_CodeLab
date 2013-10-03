package com.devfest.androidcodelab;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SplashScreen_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash_screen_, menu);
        return true;
    }
    
}
