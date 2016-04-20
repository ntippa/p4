package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.Main;
//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdView;

import androidapps.ntippa.org.displayjokeactivity.*;
import androidapps.ntippa.org.displayjokeactivity.MainActivity;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public static final String TAG = MainActivityFragment.class.getSimpleName();

    public String mJoke;
    public Button mLaunchJokeActivity_Bttn;

    public MainActivityFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        TextView jokesDisplay = (TextView) root.findViewById(R.id.display);

        Main jokesLib = new Main();
        mJoke = jokesLib.fetchJoke();

        //jokesDisplay.setText("");//clear field to display joke
       // jokesDisplay.setText(mJoke);


//        AdView mAdView = (AdView) root.findViewById(R.id.adView);
//        // Create an ad request. Check logcat output for the hashed device ID to
//        // get test ads on a physical device. e.g.
//        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .build();
//        mAdView.loadAd(adRequest);

        mLaunchJokeActivity_Bttn = (Button) root.findViewById(R.id.launch);

//        mLaunchJokeActivity_Bttn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d(TAG, "launch button onClick event");
//
//                Intent jokeActivityIntent = new Intent(getActivity(), DisplayJokeActivity.class);
//                jokeActivityIntent.putExtra(DisplayJokeActivity.JOKE_INTENT,joke);
//                startActivity(jokeActivityIntent);
//
//            }
//        });

        return root;
    }

    public void tellJoke(View view){
        Log.d(TAG, "launch button onClick event");

        Intent jokeActivityIntent = new Intent(getActivity(), DisplayJokeActivity.class);
        jokeActivityIntent.putExtra(DisplayJokeActivity.JOKE_INTENT,mJoke);
        startActivity(jokeActivityIntent);

    }
}
