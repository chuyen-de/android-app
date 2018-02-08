package com.example.baobang.chuyendedemo.login.view;

import com.example.baobang.chuyendedemo.db.network.model.User;

/**
 * Created by baobang on 1/29/18.
 */

public interface ViewLoginListener {
    void onLoginSuccess(User user);
    void onLoginFailed();
}
