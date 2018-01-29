package com.example.baobang.chuyendedemo.db.data;

public class ApiUtils {
    public static final String BASE_URL = "https://web-api-chuyen-de.herokuapp.com";

    public static SOService getSOService() {
        return RetrofitClient.getClient(BASE_URL).create(SOService.class);
    }
}
