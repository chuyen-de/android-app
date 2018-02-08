package com.example.baobang.chuyendedemo.login.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.baobang.chuyendedemo.MainActivity;
import com.example.baobang.chuyendedemo.R;
import com.example.baobang.chuyendedemo.TeacherActivity;
import com.example.baobang.chuyendedemo.constant.Constant;
import com.example.baobang.chuyendedemo.db.network.model.User;
import com.example.baobang.chuyendedemo.login.presenter.LoginPresenter;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity implements ViewLoginListener, View.OnClickListener {

    private LoginPresenter loginPresenter;
    private EditText txtUsername, txtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        addControls();
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences preferences = getSharedPreferences(Constant.KEY_PREFERENCES, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String userString = preferences.getString(Constant.USER, "");


        if (!TextUtils.isEmpty(userString)){
            Intent intent = new Intent(this, MainActivity.class);
//            User user = gson.fromJson(userString, User.class);
            intent.putExtra(Constant.USER, userString);
            startActivity(intent);
        }

    }

    private void addControls() {
        loginPresenter = new LoginPresenter(this);
        txtUsername = findViewById(R.id.txtUsername);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onLoginSuccess(User user) {

        SharedPreferences preferences = getSharedPreferences(Constant.KEY_PREFERENCES, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = gson.toJson(user);

        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(Constant.USER, json);
        editor.commit();

        if (user.getRole() == 0){
            Intent mainInter = new Intent(this, MainActivity.class);
            mainInter.putExtra(Constant.USER, json);
            startActivity(mainInter);
            finish();
        }else if (user.getRole() == 1){
            Intent teacherIntent = new Intent(this, TeacherActivity.class);
            teacherIntent.putExtra(Constant.USER, json);
            startActivity(teacherIntent);
        }
    }

    @Override
    public void onLoginFailed() {
        Toast.makeText(LoginActivity.this, "Email hoặc password sai. Vui lòng kiểm tra lại!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLogin:
                String email = txtUsername.getText().toString().trim();
                String password = txtPassword.getText().toString().trim();

                if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
                    loginPresenter.receiveHandleLogin(email, password);
                }else{
                    Toast.makeText(LoginActivity.this, "Vui lòng điền đủ thông tin!", Toast.LENGTH_SHORT).show();
                }
        }
    }
}
