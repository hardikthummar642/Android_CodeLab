package com.devfest.androidcodelab;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Button;

/**
 *
 * @author: Kioko
 * @description: This is activity provides the user with an option to Register of Login
 *
 */

public class WelcomeActivity extends Activity {


    //Declaration
    private Button btnRegister, btnLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);

        btnRegister = (Button)findViewById(R.id.btnRegister);
        btnLogin = (Button) findViewById(R.id.btnLogin);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.welcome, menu);
        return true;
    }
    
}
