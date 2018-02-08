package com.example.baobang.chuyendedemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.baobang.chuyendedemo.R;
import com.example.baobang.chuyendedemo.StudentCourseActivity;
import com.example.baobang.chuyendedemo.constant.Constant;
import com.example.baobang.chuyendedemo.db.data.ApiUtils;
import com.example.baobang.chuyendedemo.db.data.SOService;
import com.example.baobang.chuyendedemo.db.network.model.Course;
import com.example.baobang.chuyendedemo.db.network.model.User;
import com.example.baobang.chuyendedemo.db.network.model.UserResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by huuduc on 05/02/2018.
 */

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {

    private List<User> listStudent;
    private SOService mService;
    boolean check = false;

    public void setListStudent(List<User> listStudent) {
        this.listStudent = listStudent;
    }

    @Override
    public TeacherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View itemView = layoutInflater.inflate(R.layout.student_item, parent, false);
        return new TeacherViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TeacherViewHolder holder, int position) {
        User user = listStudent.get(position);
        holder.bindView(user);

    }

    @Override
    public int getItemCount() {
        return listStudent.size();
    }

    public class TeacherViewHolder extends RecyclerView.ViewHolder{

        private ConstraintLayout layout;
        private TextView txtStudentID;
        private TextView txtStudentName;
        private TextView txtStudentEmail;

        public TeacherViewHolder(View itemView) {
            super(itemView);
            txtStudentID = itemView.findViewById(R.id.txtStudentID);
            txtStudentName = itemView.findViewById(R.id.txtStudentName);
            txtStudentEmail = itemView.findViewById(R.id.txtStudentEmail);
            layout = itemView.findViewById(R.id.layoutStudent);

        }

        public void bindView (final User user) {
            txtStudentID.setText("ID : " + user.getId());
            txtStudentName.setText("Name : " + user.getName());
            txtStudentEmail.setText("Email : " + user.getEmail());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    Context context = view.getContext();
                    Intent intent = new Intent(context, StudentCourseActivity.class);
                    Log.d("DAYNE__", String.valueOf(user.getId()));
                    checkStudentHaveCourse(user.getId());
                    if (check){
                        intent.putExtra(Constant.USER_ID, user.getId());
                        context.startActivity(intent);
                    }else{
                        Toast.makeText(context, "The Student have no course", Toast.LENGTH_LONG).show();
                    }

                }
            });
        }

        private void checkStudentHaveCourse(String id) {
            mService = ApiUtils.getSOService();
            mService.getUser(id).enqueue(new Callback<UserResponse>() {
                @Override
                public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                    int status = response.body().getStatus();
                    if (status == 200){
                        ArrayList<Course> lists = response.body().getUser().getCourse();
                        if (!lists.isEmpty()){
                            check = true;
                        }
                    }

                }

                @Override
                public void onFailure(Call<UserResponse> call, Throwable t) {

                }
            });
        }


    }
}
