package com.retrotest.apppartner.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.reddit.com/")
                .build();

        RedditAPI redditAPI = retrofit.create(RedditAPI.class);

        Call<String> call = redditAPI.getJson();

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Response<String> response, Retrofit retrofit) {
                Log.d("TEST", "Success");
                Log.d("TEST", "Headers: " + response.headers().toString());
                Log.d("TEST", "Body: " + response.body().toString());
                Log.d("TEST", "Message: " + response.message());
            }

            @Override
            public void onFailure(Throwable t) {

                Log.d("TEST", t.getCause().toString());
            }
        });


    }
}
