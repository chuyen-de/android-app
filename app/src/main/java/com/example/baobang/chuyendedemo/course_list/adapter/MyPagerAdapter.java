package com.example.baobang.chuyendedemo.course_list.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.baobang.chuyendedemo.course_list.fragment.CourseListFragment;
import com.example.baobang.chuyendedemo.course_list.fragment.MyCourseFragment;

/**
 * Created by huuduc on 01/02/2018.
 */

public class MyPagerAdapter extends FragmentPagerAdapter{

    public static final int FRAGMENT_COUNT = 2;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new CourseListFragment();
            case 1:
                return new MyCourseFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return FRAGMENT_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Course List";
            case 1:
                return "My Course";
            default:
                return "";
        }
    }
}
