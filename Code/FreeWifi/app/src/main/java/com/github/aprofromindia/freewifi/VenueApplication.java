package com.github.aprofromindia.freewifi;

import android.app.Application;

import com.facebook.stetho.Stetho;

public class VenueApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(getApplicationContext());
        }
    }
}
