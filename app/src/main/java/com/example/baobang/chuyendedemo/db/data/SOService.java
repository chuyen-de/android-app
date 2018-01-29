package com.example.baobang.chuyendedemo.db.data;

import com.example.baobang.chuyendedemo.db.network.model.ListUserResponse;
import com.example.baobang.chuyendedemo.db.network.model.LoginRequest;
import com.example.baobang.chuyendedemo.db.network.model.LoginResponse;
import com.example.baobang.chuyendedemo.db.network.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface SOService {
    @POST("/user/login")
    Call<LoginResponse> login(@Body LoginRequest body);

    @GET("/user")
    Call<ListUserResponse> listAllUser();

    @GET("/user/{userID}")
    Call<UserResponse> getUser(@Path("userID") String userID);

}
