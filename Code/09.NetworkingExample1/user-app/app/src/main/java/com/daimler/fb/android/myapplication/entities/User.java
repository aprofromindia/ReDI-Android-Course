package com.daimler.fb.android.myapplication.entities;

/**
 * Created by Apro on 12-06-2017.
 */

public class User {
    private String name;
    private int age;
    private String subject;

    public User(String name, int age, String subject) {
        this.name = name;
        this.age = age;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSubject() {
        return subject;
    }
}
