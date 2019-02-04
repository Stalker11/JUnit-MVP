package com.example.testtask;

import android.content.Context;

import com.example.testtask.ui.presenters.loginpresenter.LogInView;
import com.example.testtask.ui.presenters.loginpresenter.LoginPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
@RunWith(RobolectricTestRunner.class)
public class TestLoginPresenter {
    private LoginPresenter mPresenter;
    private LogInView mLogInView;
    private String mEmail = "hello@world.com";
    private String mPassword = "Qwertyui1234567";

    @Before
    public void initialize(){
        mPresenter = new LoginPresenter();
        mLogInView = mock(LogInView.class);
        mPresenter.bindView(mLogInView);
    }
    @Test
    public void testLogin(){
        mPresenter.checkEmail(mEmail,mPassword);
        verify(mLogInView, only()).succeeded();
    }
    @After
    public void delete(){
        mPresenter.unbindView();
    }
}
