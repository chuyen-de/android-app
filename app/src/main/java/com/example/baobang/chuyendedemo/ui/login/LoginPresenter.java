package com.example.baobang.chuyendedemo.ui.login;

import android.text.TextUtils;

import com.example.baobang.chuyendedemo.db.data.ApiUtils;
import com.example.baobang.chuyendedemo.db.data.SOService;
import com.example.baobang.chuyendedemo.db.network.model.LoginRequest;
import com.example.baobang.chuyendedemo.db.network.model.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by baobang on 1/29/18.
 */

public class LoginPresenter implements LoginMvpPresenter {

    private LoginView loginView;
    private SOService soService;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        soService = ApiUtils.getSOService();
    }

    @Override
    public void login(String username, String password) {

        if(TextUtils.isEmpty(username)){
            loginView.showMessage("Nhập vào tên đăng nhập");
            return;
        }
        if(TextUtils.isEmpty(password)){
            loginView.showMessage("Nhập vào tên đăng nhập");
            return;
        }

        LoginRequest loginRequest = new LoginRequest(username, password);

        soService.login(loginRequest).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                LoginResponse loginResponse = response.body();
                loginView.showMessage(loginResponse.getResults());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                loginView.showMessage(t.getMessage());
            }
        });

    }
}
