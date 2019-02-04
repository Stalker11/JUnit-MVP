package com.example.testtask.ui.presenters;

public abstract class BasePresenter<V extends BaseView> {
    private V mView;

    public void bindView(V view) {
        mView = view;
        onViewAttach();
    }

    public void unbindView() {
        mView = null;
    }

    protected void onViewAttach() {
    }

    protected V getView() {
        return mView;
    }

    public boolean isViewAttached() {
        return mView != null;
    }
}
