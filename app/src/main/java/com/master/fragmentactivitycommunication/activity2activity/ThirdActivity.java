package com.master.fragmentactivitycommunication.activity2activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.master.fragmentactivitycommunication.R;

/**
 * Created by hufan on 2018/2/26.
 * 显示由主活动传过来的数据
 * 1、Person p= (Person) intent.getSerializableExtra("personInfo");获得可序列化对象
 */

public class ThirdActivity extends Activity{

    private TextView userName,password,gender;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        findView();
        showText();

    }
    /**
     * 显示由第一个activity传过来的用户数据
     */
    private void showText() {
        Intent intent=getIntent();
        // TODO: 2018/2/26 取出Bundle中的person对象
        Person p= (Person) intent.getSerializableExtra("personInfo");
        userName.setText(p.getUserName());
        password.setText(p.getPassword());
        gender.setText(p.getGender());
    }

    private void findView() {
        userName=findViewById(R.id.tv_activity_third_username);
        password=findViewById(R.id.tv_activity_third_password);
        gender=findViewById(R.id.tv_activity_third_gender);
    }
}
