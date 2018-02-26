package com.master.fragmentactivitycommunication.activity2activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.master.fragmentactivitycommunication.R;

/**
 * Created by hufan on 2018/2/25.
 * 练习使用主从Activity之间的数据传递,主要通过Bundle对象对数据进行加载
 * 1、intent.putExtras(data);向第二个活动传值
 * 2、调用startActivityForResult(intent,0);
 *    重写onActivityResult();方法
 *    cityData.getString("city");通过回调，得到被启动活动的参数值
 */

public class FirstActivity extends Activity{

    private EditText userName,password,city;
    private Button commit,choseCity;
    private RadioButton male;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        findView();
    }

    /**
     * 根据用户输入对Person对象进行初始化
     */
    private void initPersonData() {
        String gender=male.isChecked() ? "男" :"女";
        //实例化persson对象（可序列化）
        Person p=new Person(userName.getText().toString(),password.getText().toString(),gender);
        // TODO: 2018/2/26 创建Budle对象
        Bundle data=new Bundle();
        // TODO: 2018/2/26 创建Intent
        data.putSerializable("personInfo",p);
        Intent intent=new Intent(FirstActivity.this,ThirdActivity.class);
        intent.putExtras(data);//携带budle对象
        startActivity(intent);
    }

    /**
     * 定义按钮点击事件
     * @param view
     */
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_activity_first_commit://启动第二个活动，并传送用户数据
                initPersonData();
                break;
            case R.id.btn_activity_first_chosecity://启动第二个活动，选择城市信息
                Intent intent=new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,0);
                break;
        }
    }

    /**
     * 处理由第二个活动返回的数据信息
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0&&resultCode==0){
            // TODO: 2018/2/26 取出Intent里面的Extras数据
            Bundle cityData=data.getExtras();
            // TODO: 2018/2/26 取出Buddle里面的数据
            String cityResult=cityData.getString("city");//与secondActivity中“键”相对应
            // TODO: 2018/2/26 更新文本框
            city.setText(cityResult);
        }
    }

    private void findView() {
        userName=findViewById(R.id.edit_activity_first_username);
        password=findViewById(R.id.edit_activity_first_password);
        city=findViewById(R.id.edit_activity_first_city);
        commit=findViewById(R.id.btn_activity_first_commit);
        choseCity=findViewById(R.id.btn_activity_first_chosecity);
        male=findViewById(R.id.radio_activity_first_male);
    }
}
