package com.udacity.gradle.builditbigger;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

public class EndPointTask extends AsyncTask<MainActivityFragment, Void, String> {
    private static MyApi myApiService = null;

    private MainActivityFragment mainActivityFragment;

    @Override
    protected String doInBackground(MainActivityFragment... fragments) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/") // 10.0.2.2 is localhost's IP address in Android emulator
        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                @Override
                public void initialize(AbstractGoogleClientRequest<?>
                                               abstractGoogleClientRequest) throws IOException {
                    abstractGoogleClientRequest.setDisableGZipContent(true);
                }
            });


            myApiService = builder.build();
        }

        mainActivityFragment=fragments[0];



        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        //add retrieve joke to fetch joke variable in fragment
        mainActivityFragment.fetchedJoke = s;
        //launch android library to preview joke
        mainActivityFragment.launchJokeViewer();
    }
}
