package com.daimler.fb.android.myapplication.http;

import com.daimler.fb.android.myapplication.entities.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Apro on 12-06-2017.
 */

public interface UserService {

    @GET("/users")
    Call<List<User>> getUsers();

    @GET("/users/{userId}")
    Call<User> getUser(@Path("userId") String userId);
}
