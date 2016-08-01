package com.example.matthew.componentsandroid.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Observable;

/**
 * Created by gonde on 30/07/2016.
 */
public class TestComponents {
    @SerializedName("id")
    private int id;
    @SerializedName("title")
    private String name;
    @SerializedName("body")
    private String password;

    public TestComponents(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public TestComponents() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
