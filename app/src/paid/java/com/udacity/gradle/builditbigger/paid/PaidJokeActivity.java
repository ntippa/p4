package com.udacity.gradle.builditbigger.paid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;


import java.lang.String;
import com.udacity.gradle.builditbigger.R;

public class PaidJokeActivity extends AppCompatActivity {

    public static final String TAG = PaidJokeActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       // Log.d(TAG,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Toast.makeText(this,"Paid Version",Toast.LENGTH_LONG).show();
    }

}
