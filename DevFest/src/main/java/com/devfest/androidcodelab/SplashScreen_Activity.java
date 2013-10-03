package com.devfest.androidcodelab;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import java.io.IOException;

/**
 *
 * @author: Kioko
 * @description: This is the initial screen that is displayed when the application is started.
 *
 */

public class SplashScreen_Activity extends Activity {

    private int splashTime = 5000; //This is the number of seconds


    /** Called when the Activity is first Created  **/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        final SplashScreen_Activity splashScreenActivity = this;

        // We use a thread to display the Splash Screen
       Thread splashThread = new Thread(){
           @Override
           public void run() {

               try {

                   synchronized (this){

                       //Wait for 5 Sec
                       wait(splashTime);
                   }
               }catch(InterruptedException iE){

                   //Log your Error
               }finally {

                   //Start a New Activity
                   startActivity(new Intent(SplashScreen_Activity.this, WelcomeActivity.class));

                   //Finish this Activity
                   finish();
               }

           }
       }; splashThread.start();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.splash_screen_, menu);
        return true;
    }
    
}
