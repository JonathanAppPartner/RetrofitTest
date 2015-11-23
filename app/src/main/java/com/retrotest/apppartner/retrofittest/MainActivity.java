package com.retrotest.apppartner.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

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
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RedditAPI redditAPI = retrofit.create(RedditAPI.class);

        Call<Object> call = redditAPI.getJson();

        call.enqueue(new Callback<Object>() {
            @Override
            public void onResponse(Response<Object> response, Retrofit retrofit) {
                Log.d("TEST", "Success");
                Log.d("TEST", "Raw: " + response.raw().toString());
                Log.d("TEST", "Message: " + response.message());
                Log.d("TEST", "Body: " + response.body().toString());
                Log.d("TEST", "Headers: " + response.headers().toString());
            }

            @Override
            public void onFailure(Throwable t) {

                Log.d("TEST", t.getCause().toString());
            }
        });


    }
}
