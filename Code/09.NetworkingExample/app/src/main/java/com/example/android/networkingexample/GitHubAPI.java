package com.example.android.networkingexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Manuel on 03.01.2017.
 */

public interface GitHubAPI {

    String ENDPOINT = "https://api.github.com";

    @GET("/users/{user}")
    Call<GitHubUser> getUser(@Path("user") String user);

}
