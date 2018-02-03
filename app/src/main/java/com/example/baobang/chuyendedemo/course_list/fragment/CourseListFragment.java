package com.example.baobang.chuyendedemo.course_list.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.baobang.chuyendedemo.R;
import com.example.baobang.chuyendedemo.course_list.adapter.CourseListAdapter;
import com.example.baobang.chuyendedemo.db.network.model.Course;

import java.util.ArrayList;

/**
 * Created by huuduc on 01/02/2018.
 */

public class CourseListFragment extends Fragment {

    private ArrayList<Course> courseList;
    private RecyclerView rvListCourse;
    private CourseListAdapter courseListAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_course_list, container, false);
        addControls(view);

        return view;
    }

    private void addControls(View view) {

        rvListCourse = view.findViewById(R.id.rvListCourse);

        courseListAdapter = new CourseListAdapter();
        courseList = new ArrayList<>();
        generateDummyData();

        courseListAdapter.setCourseList(courseList);
        rvListCourse.setLayoutManager(new GridLayoutManager(this.getContext(), 2));
        rvListCourse.setAdapter(courseListAdapter);
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
