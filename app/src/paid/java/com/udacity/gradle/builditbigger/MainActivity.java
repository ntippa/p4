package com.udacity.gradle.builditbigger;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import com.udacity.gradle.builditbigger.paid.PaidJokeActivity;
import androidapps.ntippa.org.displayjokeactivity.*;
import android.util.Log;

import java.lang.String;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view){

        Log.d(TAG,"tellJoke paid version");

//        Intent jokeIntent = new Intent(this,PaidJokeActivity.class);
//        startActivity(jokeIntent);
        // this wil launch the async task to fetch joke from java lib via GCE
        Intent jokeActivityIntent = new Intent(this, DisplayJokeActivity.class);
        Log.d(TAG,"Launching Async task intent");
        //jokeActivityIntent.putExtra(DisplayJokeActivity.JOKE_INTENT,mJoke);
        startActivity(jokeActivityIntent);

    }
}
