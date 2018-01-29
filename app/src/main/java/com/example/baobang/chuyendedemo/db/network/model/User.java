package com.example.baobang.chuyendedemo.db.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by huuduc on 29/01/2018.
 */

public class User {
    @SerializedName("gender")
    private Boolean gender;
    @SerializedName("course")
    private List<Object> course = null;
    @SerializedName("id")
    private String id;
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

    public User(Boolean gender, List<Object> course, String id, Integer role, String name, String email, String birthday) {
        this.gender = gender;
        this.course = course;
        this.id = id;
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

    public List<Object> getCourse() {
        return course;
    }

    public void setCourse(List<Object> course) {
        this.course = course;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
