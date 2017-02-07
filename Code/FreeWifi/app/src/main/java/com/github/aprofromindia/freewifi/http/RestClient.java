package com.github.aprofromindia.freewifi.http;

import android.util.Base64;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.github.aprofromindia.freewifi.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.schedulers.Schedulers;

public class RestClient {
    private static final String URL = "https://redi-free-wifi.herokuapp.com";
    private static final String USERNAME = "free_wifi@redi-school.org";
    private static final String PASSWORD = "y3LTqULBe45yRQ6R";
    private static final RestClient instance = new RestClient();
    private static final String AUTHORIZATION_KEY = "Authorization";
    private static final String ACCEPT_KEY = "Accept";
    private static final String APPLICATION_JSON_VALUE = "application/json";

    private OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
    private Retrofit.Builder retroBuilder = new Retrofit.Builder()
            .baseUrl(URL)
            .addCallAdapterFactory(RxJavaCallAdapterFactory
                    .createWithScheduler(Schedulers.io()))
            .addConverterFactory(JacksonConverterFactory.create());

    private RestClient() {
    }

    public static RestClient getInstance() {
        return instance;
    }

    public <S> S createService(Class<S> serviceClass) {
        final String credentials = USERNAME + ":" + PASSWORD;
        final String basic = "Basic " + Base64.encodeToString(credentials.getBytes(),
                Base64.NO_WRAP);

        if (BuildConfig.DEBUG){
            clientBuilder.addNetworkInterceptor(new StethoInterceptor());
        }

        clientBuilder.addInterceptor(chain -> {
            Request original = chain.request();
            Request request = original.newBuilder()
                    .header(AUTHORIZATION_KEY, basic)
                    .header(ACCEPT_KEY, APPLICATION_JSON_VALUE)
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);
        });

        Retrofit retrofit = retroBuilder.client(clientBuilder.build()).build();
        return retrofit.create(serviceClass);
    }
}
