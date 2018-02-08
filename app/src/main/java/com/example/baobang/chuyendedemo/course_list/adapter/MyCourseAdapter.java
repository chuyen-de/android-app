package com.example.baobang.chuyendedemo.course_list.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.baobang.chuyendedemo.R;
import com.example.baobang.chuyendedemo.db.network.model.Course;

import java.util.ArrayList;

/**
 * Created by huuduc on 03/02/2018.
 */

public class MyCourseAdapter extends RecyclerView.Adapter<MyCourseAdapter.MyCourseViewHolder> {

    private ArrayList<Course> myCourseList;

    public void setMyCourseList(ArrayList<Course> myCourseList) {
        this.myCourseList = myCourseList;
    }

    @Override
    public MyCourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.my_course_item, parent, false);
        return new MyCourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyCourseViewHolder holder, int position) {
        Course course = myCourseList.get(position);
        holder.bindView(course);
    }

    @Override
    public int getItemCount() {
        return myCourseList.size();
    }

    public class MyCourseViewHolder extends RecyclerView.ViewHolder {

        private TextView txtCourseName;
        private TextView txtCourseDescription;
        private Button btnSubmit;

        public MyCourseViewHolder(View itemView) {
            super(itemView);
            txtCourseName = itemView.findViewById(R.id.txtCourseName);
            txtCourseDescription = itemView.findViewById(R.id.txtDescription);
            btnSubmit = itemView.findViewById(R.id.btnSubmit);
        }

        public void bindView (Course course) {
            txtCourseName.setText(course.getCourseName());
            txtCourseDescription.setText(course.getDescription());
        }
    }
}
