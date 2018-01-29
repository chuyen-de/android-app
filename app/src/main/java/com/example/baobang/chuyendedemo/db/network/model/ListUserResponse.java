package com.example.baobang.chuyendedemo.db.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by huuduc on 29/01/2018.
 */

public class ListUserResponse {
    @SerializedName("statuscode")
    int status;

    @SerializedName("results")
    List<User> user;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
