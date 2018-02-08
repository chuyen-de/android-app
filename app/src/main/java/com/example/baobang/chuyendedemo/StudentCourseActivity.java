package com.example.baobang.chuyendedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.example.baobang.chuyendedemo.adapter.StudentCourseActivityAdapter;
import com.example.baobang.chuyendedemo.constant.Constant;
import com.example.baobang.chuyendedemo.db.data.ApiUtils;
import com.example.baobang.chuyendedemo.db.data.SOService;
import com.example.baobang.chuyendedemo.db.network.model.Course;
import com.example.baobang.chuyendedemo.db.network.model.UserResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by huuduc on 08/02/2018.
 */

public class StudentCourseActivity extends AppCompatActivity {

    private String userID;
    private SOService mService;
    private RecyclerView rvListStudentCourse;
    private StudentCourseActivityAdapter adapter;
    private ArrayList<Course> listStudentCourse;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_course_list);

        mService = ApiUtils.getSOService();
        rvListStudentCourse = findViewById(R.id.rvListStudentCourse);
        adapter = new StudentCourseActivityAdapter();

        Intent intent = getIntent();
        if (!TextUtils.isEmpty(intent.getStringExtra(Constant.USER_ID))){
            userID = intent.getStringExtra(Constant.USER_ID);
            getListStudentCourse(this);
        }
    }

    private void getListStudentCourse(final Context context) {
        listStudentCourse = new ArrayList<>();
        mService.getUser(userID).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                int status = response.body().getStatus();
                if (status == 200){
                    listStudentCourse = response.body().getUser().getCourse();
                }
                adapter.setListStudentCourse(listStudentCourse);
                rvListStudentCourse.setLayoutManager(new LinearLayoutManager(context));
                rvListStudentCourse.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }
}
