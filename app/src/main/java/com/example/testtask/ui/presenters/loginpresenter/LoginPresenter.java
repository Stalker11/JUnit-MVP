package com.example.testtask.ui.presenters.loginpresenter;

import com.example.testtask.ui.presenters.BasePresenter;
import com.example.testtask.utils.LoginValidator;

import androidx.annotation.NonNull;

public class LoginPresenter extends BasePresenter<LogInView> {
    public void checkEmail(@NonNull String email, @NonNull String password) {
        if (isViewAttached() && LoginValidator.isEmailValid(email)
                && LoginValidator.isPasswordLengthValid(password)) {
            getView().succeeded();
        }
        if (isViewAttached() && !LoginValidator.isPasswordLengthValid(password)) {
            getView().wrongPassword();
        }
        if (isViewAttached() && !LoginValidator.isEmailValid(email)) {
            getView().wrongEmail();
        }
    }
}
