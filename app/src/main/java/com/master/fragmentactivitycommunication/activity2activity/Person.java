package com.master.fragmentactivitycommunication.activity2activity;

import java.io.Serializable;

/**
 * Created by hufan on 2018/2/26.
 * 自定义可序列化对象
 * 用户信息类
 */

public class Person implements Serializable{

    private String userName;
    private String password;
    private String gender;

    public Person(String name,String password,String gender){
        this.userName=name;
        this.password=password;
        this.gender=gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
