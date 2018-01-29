package com.example.baobang.chuyendedemo.db.data;

import com.example.baobang.chuyendedemo.db.network.model.LoginRequest;
import com.example.baobang.chuyendedemo.db.network.model.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface SOService {
    @POST("/user/login")
    Call<LoginResponse> login(@Body LoginRequest body);

}
