package com.example.baobang.chuyendedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.baobang.chuyendedemo.R;
import com.example.baobang.chuyendedemo.db.network.model.Course;

import java.util.ArrayList;

/**
 * Created by huuduc on 08/02/2018.
 */

public class StudentCourseActivityAdapter extends RecyclerView.Adapter<StudentCourseActivityAdapter.StudentCourseViewHolder> {

    private ArrayList<Course> listStudentCourse;

    public void setListStudentCourse(ArrayList<Course> listStudentCourse) {
        this.listStudentCourse = listStudentCourse;
    }

    @Override
    public StudentCourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.course_item, parent, false);

        return new StudentCourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(StudentCourseViewHolder holder, int position) {
        Course course = listStudentCourse.get(position);
        holder.bindView(course);
    }

    @Override
    public int getItemCount() {
        return this.listStudentCourse.size();
    }

    public class StudentCourseViewHolder extends RecyclerView.ViewHolder{

        private TextView txtCourseID;
        private TextView txtCourseName;
        private TextView txtCourseDescrip;

        public StudentCourseViewHolder(View itemView) {
            super(itemView);
            txtCourseID = itemView.findViewById(R.id.txtCourseID);
            txtCourseName = itemView.findViewById(R.id.txtCourseName);
            txtCourseDescrip = itemView.findViewById(R.id.txtDescrip);
        }

        public void bindView(Course course) {
            txtCourseID.setText(course.getId());
            txtCourseName.setText(course.getCourseName());
            txtCourseDescrip.setText(course.getDescription());
        }
    }
}
