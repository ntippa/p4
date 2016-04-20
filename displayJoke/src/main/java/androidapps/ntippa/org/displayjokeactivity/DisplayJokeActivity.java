package androidapps.ntippa.org.displayjokeactivity;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import androidapps.ntippa.builditbigger.gce.myJokeApi.MyJokeApi;
import androidapps.ntippa.builditbigger.gce.myJokeApi.model.MyJoke;

public class DisplayJokeActivity extends AppCompatActivity {

    private static final String TAG = DisplayJokeActivity.class.getSimpleName();
    public static final String JOKE_INTENT = "joke";
    TextView mJokeTextView;
    JokeTask mTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        Log.d(TAG, " launching Async task");
        mJokeTextView = (TextView) findViewById(R.id.jokeView);

//        String joke = getIntent().getStringExtra(JOKE_INTENT);
//        Log.d(TAG, "Joke received as Intent::" + joke);
//        Toast.makeText(this,joke,Toast.LENGTH_LONG).show();

        // new GetJokeTask().execute(new Pair<Context, String>(this, "4"));
        mTask = new JokeTask();
        mTask.setListener(new JokeTask.JokeTaskListener() {
            @Override
            public void onComplete(String message, Exception errorMessage) {
               Log.d(TAG,"onComplete: message" + message);
                mJokeTextView.setText(message);
            }
        });
        mTask.execute(new Pair<Context, String>(this, "1"));
    }
}
    class JokeTask extends AsyncTask<Pair<Context, String>, Void, String> {

        private Context mContext;
        private MyJokeApi myJokeService;

        private JokeTaskListener jokeTaskListener;
        private Exception mError;


        @Override
        protected String doInBackground(Pair<Context, String>... pairs) {
            if (myJokeService == null) {
                MyJokeApi.Builder builder = new MyJokeApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("https://builditbigger-1286.appspot.com/_ah/api/")
                                //.setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                myJokeService = builder.build();

            }

            mContext = pairs[0].first;
            long id = Long.parseLong(pairs[0].second);

            try {
                MyJoke joke = myJokeService.getMyJoke(id).execute();
                Log.d("MyJoke", "MyJokeService:" + joke.getJoke());
                return joke.getJoke();
            } catch (IOException e) {
                mError = e;
                return e.getMessage();
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Log.d("MyJoke", "onPostExecute: result" + result);
            if (this.jokeTaskListener != null) {
                this.jokeTaskListener.onComplete(result, mError);
            }


            Toast.makeText(mContext, result, Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onCancelled() {
            if (this.jokeTaskListener != null) {
                mError = new InterruptedException("Async task cancelled");
                jokeTaskListener.onComplete(null, mError);
            }
        }

        public JokeTask setListener(JokeTaskListener listener) {
            this.jokeTaskListener = listener;
            return this;
        }

        interface JokeTaskListener {
            void onComplete(String message, Exception errorMessage);
        }
    }

