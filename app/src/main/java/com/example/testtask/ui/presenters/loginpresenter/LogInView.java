package com.example.testtask.ui.presenters.loginpresenter;

import com.example.testtask.ui.presenters.BaseView;

public interface LogInView extends BaseView {
    void wrongEmail();
    void wrongPassword();
    void succeeded();
}
