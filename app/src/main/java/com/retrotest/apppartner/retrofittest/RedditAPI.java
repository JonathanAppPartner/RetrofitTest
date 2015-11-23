package com.retrotest.apppartner.retrofittest;


import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Jonathan Muller on 11/20/15.
 */
public interface RedditAPI
{
    @GET(".json")
    Call<Object> getJson();
}
