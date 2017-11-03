package com.it.hungvt.mvvmdemo.model;

/**
 * Created by Administrator on 11/3/2017.
 */

public class User {
    private int imageUrl;
    private String name;

    public User() {
    }

    public User(int imageUrl, String name) {
        this.imageUrl = imageUrl;
        this.name = name;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

