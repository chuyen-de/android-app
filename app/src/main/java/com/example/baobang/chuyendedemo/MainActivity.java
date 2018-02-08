package com.example.baobang.chuyendedemo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.example.baobang.chuyendedemo.constant.Constant;
import com.example.baobang.chuyendedemo.adapter.MyPagerAdapter;
import com.example.baobang.chuyendedemo.db.data.ApiUtils;
import com.example.baobang.chuyendedemo.db.data.SOService;
import com.example.baobang.chuyendedemo.db.network.model.ListUserResponse;
import com.example.baobang.chuyendedemo.db.network.model.User;
import com.example.baobang.chuyendedemo.db.network.model.UserResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private SOService mService;
//    private FragmentCommunicator communicator;


//    public void setCommunicator(FragmentCommunicator communicator) {
//        this.communicator = communicator;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getData();
        addControls();
        addEvents();

    }

    public void getData() {
        SharedPreferences preferences = getSharedPreferences(Constant.KEY_PREFERENCES, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String userString = preferences.getString(Constant.USER, "");
        if (!TextUtils.isEmpty(userString)){
            User user = gson.fromJson(userString, User.class);
//            communicator.passData(user.getId());
        }
    }

    private void addEvents() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void addControls() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        mService = ApiUtils.getSOService();
//        loadListCourse();
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
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

//    private void loadListCourse() {
//        mService.listAllCourse().enqueue(new Callback<ListCourseResponse>() {
//            @Override
//            public void onResponse(Call<ListCourseResponse> call, Response<ListCourseResponse> response) {
//                listCourse = (ArrayList<Course>) response.body().getCourseList();
//            }
//
//            @Override
//            public void onFailure(Call<ListCourseResponse> call, Throwable t) {
//
//            }
//        });
//    }




}
