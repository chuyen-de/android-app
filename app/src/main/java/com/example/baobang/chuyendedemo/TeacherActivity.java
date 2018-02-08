package com.example.baobang.chuyendedemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.baobang.chuyendedemo.adapter.TeacherAdapter;
import com.example.baobang.chuyendedemo.db.data.ApiUtils;
import com.example.baobang.chuyendedemo.db.data.SOService;
import com.example.baobang.chuyendedemo.db.network.model.ListUserResponse;
import com.example.baobang.chuyendedemo.db.network.model.User;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherActivity extends AppCompatActivity {

    private RecyclerView rvListStudent;
    private ArrayList<User> listStudent;
    private TeacherAdapter teacherAdapter;
    private SOService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        addControls();
        addEvents();
    }

    private void addControls() {
        rvListStudent = findViewById(R.id.rvListStudent);
        mService = ApiUtils.getSOService();

        teacherAdapter = new TeacherAdapter();

        loadListStudent(this);
    }

    private void loadListStudent(final Context context) {
        listStudent = new ArrayList<>();

        mService.listAllUser().enqueue(new Callback<ListUserResponse>() {
            @Override
            public void onResponse(Call<ListUserResponse> call, Response<ListUserResponse> response) {
                int status = response.body().getStatus();
                if (status == 200){
                    ArrayList<User> lists = response.body().getUser();
                    for (User user : lists){
                        if (user.getRole() == 0){
                            listStudent.add(user);
                        }
                    }
                }
                teacherAdapter.setListStudent(listStudent);
                rvListStudent.setLayoutManager(new LinearLayoutManager(context));
                rvListStudent.setAdapter(teacherAdapter);

            }

            @Override
            public void onFailure(Call<ListUserResponse> call, Throwable t) {

            }
        });
    }

    //Boolean gender, ArrayList<Course> course, String _id, Integer role, String name, String email, String birthday
    private void generateDummyData() {
        User user1 = new User(false, null, "123", 1, "adsa", "asdasd", "asdasd");
        User user2 = new User(false, null, "123", 1, "adsa", "asdasd", "asdasd");
        User user3 = new User(false, null, "123", 1, "adsa", "asdasd", "asdasd");
        User user4 = new User(false, null, "123", 1, "adsa", "asdasd", "asdasd");
        User user5 = new User(false, null, "123", 1, "adsa", "asdasd", "asdasd");
        User user6 = new User(false, null, "123", 1, "adsa", "asdasd", "asdasd");

        listStudent.add(user1);
        listStudent.add(user2);
        listStudent.add(user3);
        listStudent.add(user4);
        listStudent.add(user5);
        listStudent.add(user6);
    }

    private void addEvents() {

    }
}
