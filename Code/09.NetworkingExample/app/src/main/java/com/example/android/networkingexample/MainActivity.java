package com.example.android.networkingexample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends Activity implements Callback<GitHubUser> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Gson gson = new GsonBuilder()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(GitHubAPI.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        GitHubAPI gitHubUserAPI = retrofit.create(GitHubAPI.class);

        // prepare call in Retrofit 2.0

        Call<GitHubUser> callUser = gitHubUserAPI.getUser("mandinga90");
        //asynchronous call
        callUser.enqueue(this);

    }

    @Override
    public void onResponse(Call<GitHubUser> call, Response<GitHubUser> response) {
        int code = response.code();
        if (code == 200) {
            GitHubUser user = response.body();
            Toast.makeText(this, "Got the user: " + user.name, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Did not work: " + String.valueOf(code), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onFailure(Call<GitHubUser> call, Throwable t) {
        Toast.makeText(this, "Nope", Toast.LENGTH_LONG).show();

    }
}