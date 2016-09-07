package com.sanfrancisco.robotfragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 *
 */
public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                } finally {
                    Intent i1 = new Intent(SplashScreen.this, IntroductionActivity.class);
                    startActivity(i1);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish(); //if backward button is clicked at this time
    }

}