package com.github.aprofromindia.recyclerViewSample.entities;

import android.support.annotation.AnyThread;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

/**
 * Created by achoudh on 27/11/2016.
 */

@AnyThread
public class Student {

    private String name;
    private String gender;
    @DrawableRes
    private int photo;

    public Student(@NonNull String name, @NonNull String gender, @DrawableRes int photo) {
        this.name = name;
        this.gender = gender;
        this.photo = photo;
    }

    @NonNull
    public String getName() {
        return name;
    }

    @NonNull
    public String getGender() {
        return gender;
    }

    @DrawableRes
    public int getPhoto() {
        return photo;
    }
}
