package com.github.aprofromindia.databinding.entities;

/**
 * Created by achoudh on 31/01/2017.
 */

public class Student {
    private String foreName;
    private String surName;
    private int number;

    public Student(String foreName, String surName, int number) {
        this.foreName = foreName;
        this.surName = surName;
        this.number = number;
    }

    public String getForeName() {
        return foreName;
    }

    public String getSurName() {
        return surName;
    }

    public int getNumber() {
        return number;
    }
}
