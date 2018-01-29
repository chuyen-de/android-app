package com.example.baobang.chuyendedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.baobang.chuyendedemo.db.data.ApiUtils;
import com.example.baobang.chuyendedemo.db.data.SOService;
import com.example.baobang.chuyendedemo.db.network.model.ListUserResponse;
import com.example.baobang.chuyendedemo.db.network.model.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private SOService mService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mService = ApiUtils.getSOService();

        loadListUser();
        loadUser();



    }

    private void loadUser() {
        mService.getUser("5a6f3c497745e90014c6c101").enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                // put stuff here
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }

    private void loadListUser() {
        mService.listAllUser().enqueue(new Callback<ListUserResponse>() {
            @Override
            public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                // put stuff here
            }

            @Override
            public void onFailure(Call<ListUserResponse> call, Throwable t) {

            }
        });
    }
}

//    Retrofit.Builder builder = new Retrofit.Builder()
//            .baseUrl("https://web-api-chuyen-de.herokuapp.com")
//            .addConverterFactory(GsonConverterFactory.create());
//
//    Retrofit retrofit = builder.build();
//
//    ApiService serverClient = retrofit.create(ApiService.class);
//    Call<ListUserResponse> callListUser = serverClient.listAllUser();
//
//        callListUser.enqueue(new Callback<ListUserResponse>() {
//@Override
//public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
//        Log.d("STATUS", response.body().getStatus() + "");
//        }
//
//@Override
//public void onFailure(Call<ListUserResponse> call, Throwable t) {
//
//        }
//        });
