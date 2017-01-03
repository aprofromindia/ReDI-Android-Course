package com.github.aprofromindia.parcelable.entities;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

public class EMail implements Parcelable {
    public static final Creator<EMail> CREATOR = new Creator<EMail>() {
        @Override
        public EMail createFromParcel(Parcel source) {
            return new EMail(source);
        }

        @Override
        public EMail[] newArray(int size) {
            return new EMail[size];
        }
    };
    private String from;
    private String body;
    private String to;

    public EMail(@NonNull String from, @NonNull String body) {
        this.from = from;
        this.body = body;
    }

    private EMail(Parcel in) {
        this.from = in.readString();
        this.body = in.readString();
        this.to = in.readString();
    }

    @NonNull
    public String getFrom() {
        return from;
    }

    @NonNull
    public String getBody() {
        return body;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.from);
        dest.writeString(this.body);
        dest.writeString(this.to);
    }
}
