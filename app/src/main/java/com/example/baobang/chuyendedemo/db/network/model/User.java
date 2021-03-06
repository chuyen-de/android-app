package com.example.baobang.chuyendedemo.db.network.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by huuduc on 29/01/2018.
 */

public class User implements Serializable{
    @SerializedName("gender")
    private Boolean gender;
    @SerializedName("course")
    private ArrayList<Course> course = null;
    @SerializedName("_id")
    private String _id;
    @SerializedName("role")
    private Integer role;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("birthday")
    private String birthday;

    public User() {
    }

    public User(Boolean gender, ArrayList<Course> course, String _id, Integer role, String name, String email, String birthday) {
        this.gender = gender;
        this.course = course;
        this._id = _id;
        this.role = role;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public ArrayList<Course> getCourse() {
        return course;
    }

    public void setCourse(ArrayList<Course> course) {
        this.course = course;
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

}
