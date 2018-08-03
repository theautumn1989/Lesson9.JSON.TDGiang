package com.example.tomato.lesson9jsontdgiang.model;

public class Post {

    private int mId;
    private int mUserId;
    private String mTitle;
    private String mBody;

    public Post(int id, int userId, String title, String body) {
        mId = id;
        mUserId = userId;
        mTitle = title;
        mBody = body;
    }

    public Post() {
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }
}
