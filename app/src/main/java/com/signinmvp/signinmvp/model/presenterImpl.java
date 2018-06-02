package com.signinmvp.signinmvp.model;

import android.text.TextUtils;

import com.signinmvp.signinmvp.presenter.LoginPresenter;
import com.signinmvp.signinmvp.view.LoginView;

public class presenterImpl implements LoginPresenter {
    LoginView mLoginView;

    public presenterImpl(LoginView loginView) {
        this.mLoginView = loginView;
    }


    @Override
    public void performLogin(String username, String password) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
        {
            mLoginView.loginValidations();
        }
        else
        {
            if (username.equals("Milan")&&password.equals("password"))
            {
                mLoginView.loginSuccess();
            }
            else
            {
                mLoginView.loginError();
            }
        }

    }
}
