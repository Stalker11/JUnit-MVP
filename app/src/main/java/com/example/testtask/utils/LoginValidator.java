package com.example.testtask.utils;

import android.util.Patterns;

public class LoginValidator {
    /**
     * Check valid email using regular expression Android Patterns
     *
     * @param email user email
     * @return boolean state true/false
     */
    public static boolean isEmailValid(CharSequence email) {
        return Patterns.EMAIL_ADDRESS.matcher(email.toString().trim()).matches();
    }

    /**
     * Check password length
     *
     * @param password user password
     * @return boolean state true/false
     */
    public static boolean isPasswordLengthValid(CharSequence password) {
        return password.toString().length() > AppConstants.MIN_PASSWORD_SIZE;
    }
}
