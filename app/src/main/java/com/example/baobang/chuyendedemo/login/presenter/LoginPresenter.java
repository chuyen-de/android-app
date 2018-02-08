package com.example.baobang.chuyendedemo.login.presenter;

import com.example.baobang.chuyendedemo.db.network.model.User;
import com.example.baobang.chuyendedemo.login.model.ModelLogin;
import com.example.baobang.chuyendedemo.login.model.ModelResponseToPresenterListener;
import com.example.baobang.chuyendedemo.login.view.ViewLoginListener;

/**
 * Created by baobang on 1/29/18.
 */

public class LoginPresenter implements ModelResponseToPresenterListener {

    private ModelLogin modelLogin;
    private ViewLoginListener callback;

    public LoginPresenter(ViewLoginListener callback) {
        this.callback = callback;
    }

    public void receiveHandleLogin(String email, String password){
        modelLogin = new ModelLogin(this);
        modelLogin.handleLogin(email, password);
    }

    @Override
    public void onLoginSuccess(User user) {
        callback.onLoginSuccess(user);
    }

    @Override
    public void onLoginFailed() {
        callback.onLoginFailed();
    }
}
