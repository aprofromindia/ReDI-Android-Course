package com.github.aprofromindia.recyclerViewSample.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.AnyThread;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

/**
 * Created by achoudh on 27/11/2016.
 */

@AnyThread
public class Student implements Parcelable {

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.gender);
        dest.writeInt(this.photo);
    }

    protected Student(Parcel in) {
        this.name = in.readString();
        this.gender = in.readString();
        this.photo = in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel source) {
            return new Student(source);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };
}
