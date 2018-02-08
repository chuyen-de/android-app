package com.example.baobang.chuyendedemo.course_list.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baobang.chuyendedemo.R;
import com.example.baobang.chuyendedemo.course_list.adapter.CourseListAdapter;
import com.example.baobang.chuyendedemo.db.data.ApiUtils;
import com.example.baobang.chuyendedemo.db.data.SOService;
import com.example.baobang.chuyendedemo.db.network.model.Course;
import com.example.baobang.chuyendedemo.db.network.model.ListCourseResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by huuduc on 01/02/2018.
 */

public class CourseListFragment extends Fragment{

    private ArrayList<Course> courseList;
    private RecyclerView rvListCourse;
    private CourseListAdapter courseListAdapter;
    private SOService mService;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_list, container, false);
        addControls(view);

        return view;
    }

    private void addControls(View view) {

        rvListCourse = view.findViewById(R.id.rvListCourse);

        courseListAdapter = new CourseListAdapter();
        mService = ApiUtils.getSOService();

        loadListCourse(this.getContext());

    }

    private void loadListCourse(final Context context) {
        courseList = new ArrayList<>();
        mService.listAllCourse().enqueue(new Callback<ListCourseResponse>() {
            @Override
            public void onResponse(Call<ListCourseResponse> call, Response<ListCourseResponse> response) {
                courseList = (ArrayList<Course>) response.body().getCourseList();
                courseListAdapter.setCourseList(courseList);
                rvListCourse.setLayoutManager(new GridLayoutManager(context, 2));
                rvListCourse.setAdapter(courseListAdapter);
            }

            @Override
            public void onFailure(Call<ListCourseResponse> call, Throwable t) {

            }
        });
    }

    public void generateDummyData() {
        Course course1 = new Course("5a6d9ca9ff23095855446063", "Lap Trinh C++", "Khoa hoc C++ voi doi ngu chuyen nghiep hon bao gio het");
        Course course2 = new Course("5a6d9ca9ff23095855446064", "Lap Trinh C#", "Khoa hoc C# voi doi ngu chuyen nghiep hon bao gio het");
        Course course3 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh Python", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");
        Course course4 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh PHP", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");
        Course course5 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh JAVA", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");
        Course course6 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh NODE JS", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");
        Course course7 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh UNITY", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");
        Course course8 = new Course("5a6d9ca9ff23095855446065", "Lap Trinh ANDROID", "Khoa hoc Python voi doi ngu chuyen nghiep hon bao gio het");

        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);
        courseList.add(course4);
        courseList.add(course5);
        courseList.add(course6);
        courseList.add(course7);
        courseList.add(course8);
    }

}
