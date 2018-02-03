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
 * Created by huuduc on 31/01/2018.
 */

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseHolder>{

    private Context context;
    private ArrayList<Course> courseList;

    @Override
    public CourseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.course_card_view_item, parent, false);
        return new CourseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CourseHolder holder, int position) {
        CourseHolder courseHolder = (CourseHolder) holder;
        Course course = this.courseList.get(position);
        courseHolder.bindView(course);
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public int getItemCount() {
        return this.courseList.size();
    }

    public class CourseHolder extends RecyclerView.ViewHolder {

        private TextView txtCourseName;
        private TextView txtDescription;
        private Button btnSubmit;

        public CourseHolder(View itemView) {
            super(itemView);
            txtCourseName = itemView.findViewById(R.id.txtCourseName);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            btnSubmit = itemView.findViewById(R.id.btnSubmit);
        }

        public void bindView (Course course){
            txtCourseName.setText(course.getCourseName());
            txtDescription.setText(course.getDescription());
        }
    }
}
