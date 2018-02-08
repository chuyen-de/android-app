package com.example.baobang.chuyendedemo.login.model;

import com.example.baobang.chuyendedemo.db.network.model.User;

/**
 * Created by huuduc on 04/02/2018.
 */

public interface ModelResponseToPresenterListener {
    void onLoginSuccess(User user);
    void onLoginFailed();
}
