package androidapps.ntippa.org.displayjokeactivity;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.lang.InterruptedException;
import java.util.concurrent.CountDownLatch;
import android.support.v4.util.Pair;
import android.content.Context;
import android.text.TextUtils;

import androidapps.ntippa.org.displayjokeactivity.JokeTask;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    private JokeTask mTask;

    String joke = null;
    Exception mError = null;
    CountDownLatch signal = null;

    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
        signal = new CountDownLatch(1);
    }

    @Override
    protected void tearDown() throws Exception {
        signal.countDown();
    }

    public void testJokeTask() throws InterruptedException{
        mTask = new JokeTask();
        mTask.setListener(new JokeTask.JokeTaskListener() {
            @Override
            public void onComplete(String message, Exception errorMessage) {
                joke = message;
                mError = errorMessage;
                signal.countDown();
            }
        }).execute(new Pair<Context,String>(getContext(),"4"));
        signal.await();

        assertNull(mError);
        assertFalse(TextUtils.isEmpty(joke));
       // assertEquals("this is a joke from",joke);
    }
}