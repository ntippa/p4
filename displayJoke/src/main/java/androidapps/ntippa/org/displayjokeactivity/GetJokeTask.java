package androidapps.ntippa.org.displayjokeactivity;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.util.Log;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;



/**
 * Created by Nalini on 4/5/2016.
 */
public class GetJokeTask extends AsyncTask<Pair<Context,String>,Void,String> {

    public static final String TAG = GetJokeTask.class.getSimpleName();
   // private static JokeApi jokeService = null;

    private Context context;
    private long id;
    private static JokeTaskListener jokeTaskListener = null;
    private Exception mError;

    @Override
    protected String doInBackground(Pair<Context, String>... pairs) {
//        if(jokeService == null){
//            JokeApi.Builder builder = new JokeApi.Builder(AndroidHttp.newCompatibleTransport(),
//                    new AndroidJsonFactory(),null)
//                    // options for running against local devappserver
//                    // - 10.0.2.2 is localhost's IP address in Android emulator
//                    // - turn off compression when running against local devappserver
//                   // .setRootUrl("http://10.0.2.2:8080/_ah/api/")
//                    .setRootUrl("https://builditbigger-1286.appspot.com/_ah/api/")
//                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
//                        @Override
//                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
//                            abstractGoogleClientRequest.setDisableGZipContent(true);
//                        }
//                    });
//            // end options for devappserver
//            jokeService = builder.build();
//        }
//
//        context = pairs[0].first;
//        id = Long.parseLong(pairs[0].second);
//
//        try {
//
//            //Joke joke =  jokeService.getJoke(id).execute();//poor choice of method names
//           // Log.d(TAG,"Joke returned from Servcie" + joke.getJoke());
//            //return joke.getJoke();
//        } catch (IOException e) {
//            mError = e;
//            return e.getMessage();
//        }

        return null;

    }

    @Override
    protected void onPostExecute(String result) {
        // result = "this is a joke from Async task";
        Log.d(TAG, "onPostExecute: result" + result);
        if(jokeTaskListener != null){
            jokeTaskListener.onComplete(result,mError);
        }
        Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCancelled() {
        if(jokeTaskListener != null){
            mError = new InterruptedException("Async task cancelled");
            jokeTaskListener.onComplete(null,mError);
        }
    }

    public GetJokeTask setListener(JokeTaskListener listener){
        jokeTaskListener = listener;
        return this;
    }

    public interface JokeTaskListener{
        void onComplete(String message, Exception errorMessage);
    }
}
