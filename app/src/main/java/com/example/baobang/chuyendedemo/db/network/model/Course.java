package com.example.baobang.chuyendedemo.db.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by huuduc on 31/01/2018.
 */

public class Course {

    @SerializedName("id")
    private String id;

    @SerializedName("tenKH")
    private String courseName;

    @SerializedName("description")
    private String description;

    public Course() {
    }

    public Course(String id, String tenKH, String description) {
        this.id = id;
        this.courseName = tenKH;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
