package com.example.testtask.models;

import com.google.gson.annotations.SerializedName;

public class LogInRequestModel {
    @SerializedName("userId")
    private int mUserId;
    @SerializedName("userToken")
    private String mUserToken;
    @SerializedName("refreshToken")
    private String mRefreshToken;

    public int getUserId() {
        return mUserId;
    }

    public String getUserToken() {
        return mUserToken;
    }

    public String getRefreshToken() {
        return mRefreshToken;
    }
}
