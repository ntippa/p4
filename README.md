# Gradle for Android and Java Final Project
My submission contains the following projects/libraries ( uppercased)
### Required Components

* Project contains a Java library for supplying jokes
JAVAJOKELIB-Project contains a Java library for supplying jokes.
class com.example.Main.fetchJoke() is a simple method that returns a joke as string.

* Project contains an Android library with an activity that displays jokes passed to it as intent extras.
DISPLAYJOKE-Project contains an Android library with an activity that displays jokes passed to it as intent extras.
DisplayJokeActivity launches an AsyncTask to fetch jokes from GCEmodule.


* Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. Project loads jokes from GCE module via an async task.
GCEmodule-Project contains a Google Cloud Endpoints module that supplies jokes from the Java library. 
androidapps.ntippa.builditbigger.gce.MyJokeEndpoint contains the jokeApi that returns jokes from Java library.

* Project contains connected tests to verify that the async task is indeed loading jokes.
DISPLAYJOKE-Project contains connected tests to verify that the async task is indeed loading jokes.
androidapps.ntippa.org.displayjokeactivity.ApplicationTest ( connected test) verifies that the asynctask is indeed is returning a non empty joke string.

* Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.
APP- Project contains paid/free flavors. The paid flavor has no ads, and no unnecessary dependencies.


