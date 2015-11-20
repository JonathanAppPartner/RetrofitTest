package com.retrotest.apppartner.retrofittest;

import com.google.gson.Gson;

import org.json.JSONObject;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by Jonathan Muller on 11/20/15.
 */
public interface RedditAPI
{
    @GET(".json")
    Call<String> getJson();
}
