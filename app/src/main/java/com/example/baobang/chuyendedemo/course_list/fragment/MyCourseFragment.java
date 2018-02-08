package com.example.baobang.chuyendedemo.course_list.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baobang.chuyendedemo.constant.Constant;
import com.example.baobang.chuyendedemo.R;
import com.example.baobang.chuyendedemo.course_list.adapter.MyCourseAdapter;
import com.example.baobang.chuyendedemo.db.data.ApiUtils;
import com.example.baobang.chuyendedemo.db.data.SOService;
import com.example.baobang.chuyendedemo.db.network.model.Course;
import com.example.baobang.chuyendedemo.db.network.model.User;
import com.example.baobang.chuyendedemo.db.network.model.UserResponse;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by huuduc on 01/02/2018.
 */

public class MyCourseFragment extends Fragment {

    private RecyclerView rvMyCourse;
    private ArrayList<Course> myCourseList;
    private MyCourseAdapter myCourseAdapter;
    private SOService mService;
//    private MainActivity mainActivity;
//    private User user;
//    private String userID;

//    public MyCourseFragment() {
//        mainActivity = (MainActivity) getActivity();
//        mainActivity.setCommunicator(this);
//    }

//    public void getData(){
//        mainActivity.getData();
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MyCourseFragment myCourseFragment = new MyCourseFragment();
//        SharedPreferences preferences = this.getActivity().getSharedPreferences(Constant.KEY_PREFERENCES, Context.MODE_PRIVATE);
//        Gson gson = new Gson();
//        String userString = preferences.getString(Constant.USER, "");
//        if (!TextUtils.isEmpty(userString)) {
//            User user = gson.fromJson(userString, User.class);
//            Log.d("ID", user.getId());
//            loadUser(this.getContext(), user.getId());
//        }
//        myCourseFragment.getData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_course, container, false);

        addControls(view);
        return view;
    }

    private void addControls(View view) {
        rvMyCourse = view.findViewById(R.id.rvMyCourse);
        mService = ApiUtils.getSOService();

        SharedPreferences preferences = this.getActivity().getSharedPreferences(Constant.KEY_PREFERENCES, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String userString = preferences.getString(Constant.USER, "");
        if (!TextUtils.isEmpty(userString)) {
            User user = gson.fromJson(userString, User.class);
            Log.d("ID", user.getId());
            loadUser(this.getContext(), user.getId());
        }
//        myCourseAdapter = new MyCourseAdapter();
//        myCourseList = new ArrayList<>();
//        generateDummyData();
//        myCourseAdapter.setMyCourseList(myCourseList);
//        rvMyCourse.setLayoutManager(new GridLayoutManager(getContext(), 2));
//        rvMyCourse.setAdapter(myCourseAdapter);

    }
//    @Override
//    public void passData(String userID) {
//        this.userID = userID;
//        loadUser(this.getContext(), userID);
//    }

    private void loadUser(final Context context, String user_ID) {

        myCourseList = new ArrayList<>();
        Log.d("ID_", user_ID);
        mService.getUser(user_ID).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse = response.body();
                myCourseList = userResponse.getUser().getCourse();
                myCourseAdapter = new MyCourseAdapter();

                myCourseAdapter.setMyCourseList(myCourseList);
                rvMyCourse.setLayoutManager(new GridLayoutManager(context, 2));
                rvMyCourse.setAdapter(myCourseAdapter);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });
    }

    private void generateDummyData() {
        Course course1 = new Course("5a6d9ca9ff23095855446063", "Lap Trinh C++", "Khoa hoc C++ voi doi ngu chuyen nghiep hon bao gio het");
        Course course2 = new Course("5a6d9ca9ff23095855446064", "Lap Trinh C#", "Khoa hoc C# voi doi ngu chuyen nghiep hon bao gio het");
        Course course3 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh Python", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");
        Course course4 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh PHP", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");
        Course course5 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh JAVA", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");
        Course course6 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh NODE JS", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");
        Course course7 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh UNITY", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");
        Course course8 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh ANDROID", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");

        myCourseList.add(course1);
        myCourseList.add(course2);
        myCourseList.add(course3);
        myCourseList.add(course4);
        myCourseList.add(course5);
        myCourseList.add(course6);
        myCourseList.add(course7);
        myCourseList.add(course8);
    }


}
