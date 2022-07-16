package com.example.recycleview;

public class Poetry {

    private String mPoetryName;
    private String mPoetryAuthor;

    public Poetry(String poetryName, String poetryAuthor) {
        this.mPoetryName = poetryName;
        this.mPoetryAuthor = poetryAuthor;
    }

    public String getPoetryName() {
        return mPoetryName;
    }

    public String getPoetryAuthor() {
        return mPoetryAuthor;
    }

}
