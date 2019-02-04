package com.example.testtask.ui.activities;

import android.os.Bundle;
import android.widget.EditText;

import com.example.testtask.R;
import com.example.testtask.ui.presenters.loginpresenter.LogInView;
import com.example.testtask.ui.presenters.loginpresenter.LoginPresenter;
import com.google.android.material.textfield.TextInputLayout;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LogInView {

    @BindView(R.id.sign_in_first_text)
    TextInputLayout mLogInInput;

    @BindView(R.id.sign_in_second_text)
    TextInputLayout mPasswordInput;

    @BindView(R.id.log_in_email)
    EditText mEmail;

    @BindView(R.id.log_in_password)
    EditText mPassword;

    @BindString(R.string.text_wrong_email)
    String mWrongEmail;

    @BindString(R.string.text_wrong_password)
    String mWrongPassword;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter = new LoginPresenter();
        mPresenter.bindView(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.unbindView();
    }

    @OnClick(R.id.sign_in_btn)
    void checkData() {
        mPasswordInput.setError(null);
        mLogInInput.setError(null);
        mPresenter.checkEmail(mEmail.getText().toString(), mPassword.getText().toString());
    }

    @Override
    public void wrongEmail() {
        mLogInInput.setError(mWrongEmail);
    }

    @Override
    public void wrongPassword() {
        mPasswordInput.setError(mWrongPassword);
    }

    @Override
    public void succeeded() {
        NextStepActivity.start(this);
        finish();
    }
}

