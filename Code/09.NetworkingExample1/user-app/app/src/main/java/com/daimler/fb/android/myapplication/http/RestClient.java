package com.daimler.fb.android.myapplication.http;

import com.daimler.fb.android.myapplication.entities.User;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Apro on 12-06-2017.
 */

public class RestClient {
    // Localhost ip for the Android emulator;
    private static final String BASE_URL = "http://10.0.2.2:8080";
//    private static final String BASE_URL = "http://10.249.219.120:8080";

    private Retrofit retrofit;

    private RestClient() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new TypeToken<List<User>>(){}.getType(), new UserListDeserializer());

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .client(new OkHttpClient())
                .build();
    }

    private static final RestClient INSTANCE = new RestClient();

    public static RestClient getInstance() {
        return INSTANCE;
    }

    public <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
