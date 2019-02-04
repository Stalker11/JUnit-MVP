package com.example.testtask.models;

import com.google.gson.annotations.SerializedName;

import androidx.annotation.Nullable;

public class LogInResponseModel {
    @SerializedName("userEmail")
    private final String mUserEmail;
    @SerializedName("userPassword")
    private final String mUserPassword;

    public LogInResponseModel(@Nullable String userEmail, @Nullable String userPassword) {
        mUserEmail = userEmail;
        mUserPassword = userPassword;
    }
}
