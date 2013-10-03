package com.devfest.androidcodelab;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

/**
 *
 * @author: Kioko
 * @description: This is activity enables a user to Register
 *
 */

public class RegisterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.register, menu);
        return true;
    }
    
}
