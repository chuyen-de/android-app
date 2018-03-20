package com.example.baobang.chuyendedemo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.baobang.chuyendedemo.adapter.TeacherAdapter;
import com.example.baobang.chuyendedemo.constant.Constant;
import com.example.baobang.chuyendedemo.db.data.ApiUtils;
import com.example.baobang.chuyendedemo.db.data.SOService;
import com.example.baobang.chuyendedemo.db.network.model.ListUserResponse;
import com.example.baobang.chuyendedemo.db.network.model.User;
import com.example.baobang.chuyendedemo.login.view.LoginActivity;

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

    private void addEvents() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout:
                logOut();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void logOut() {
        SharedPreferences preferences = getSharedPreferences(Constant.KEY_PREFERENCES, Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constant.USER, "");
        editor.apply();

        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
