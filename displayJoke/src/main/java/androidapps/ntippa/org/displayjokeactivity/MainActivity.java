package androidapps.ntippa.org.displayjokeactivity;

import android.content.Context;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    public static final String JOKE_INTENT = "joke";

    TextView mDisplayJokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // mDisplayJokeTextView = (TextView) findViewById(R.id.display_joke);

        //String joke = getIntent().getStringExtra(JOKE_INTENT);
       // Log.d(TAG,"Joke received as Intent::" + joke);
        //mDisplayJokeTextView.setText(joke);

       // new GetJokeTask().execute(new Pair<Context,String>(this,"3"));
       // new JokeTask().execute(this);
    }
}
