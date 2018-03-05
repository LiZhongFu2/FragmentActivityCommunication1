package com.master.fragmentactivitycommunication.activity2activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.master.fragmentactivitycommunication.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by hufan on 2018/2/26.
 * 显示由主活动传过来的数据
 * 1、Person p= (Person) intent.getSerializableExtra("personInfo");获得可序列化对象
 */

public class ThirdActivity extends Activity{

    private TextView userName,password,gender,showLastUserInfo;
    final String FILE_NAME="firstActivity.bin";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        findView();
        showText();
        showLastUserInfo();

    }

    // TODO: 2018/3/5 处理由存储文件保存过来的用户信息
    private void showLastUserInfo() {
        showLastUserInfo.setText(read());
    }

    /**
     * 文件流输出
     * @return
     */
    private String read(){
        try {
            FileInputStream fis = openFileInput(FILE_NAME);
            byte[] buff = new byte[1024];
            int hasRead = 0;
            StringBuilder sb = new StringBuilder("");
            while ((hasRead = fis.read(buff)) > 0) {
                sb.append(new String(buff, 0, hasRead));
            }
            fis.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

//    /**
//     * 在sd卡中读取文件
//     * @return
//     */
//    private String readBySdCard(){
//        try{
//
//        }
//        return null;
//    }

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
        showLastUserInfo=findViewById(R.id.tv_activity_show_last_userInfo);
    }
}
