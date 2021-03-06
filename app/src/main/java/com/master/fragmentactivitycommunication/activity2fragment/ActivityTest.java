package com.master.fragmentactivitycommunication.activity2fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.master.fragmentactivitycommunication.R;

/**
 * Created by hufan on 2018/2/14.
 * 测试Fragment与Activity之间的数据交互
 */

public class ActivityTest extends Activity implements FragmentTest2.MyListener{

    private TextView tv_activity,tv_count;
    private Button btn_activity;
    private EditText edit_activity;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        tv_activity=findViewById(R.id.tv_activity);
        btn_activity=findViewById(R.id.btn_activity);
        edit_activity=findViewById(R.id.edit_activity);
        tv_count=findViewById(R.id.tv_activity_test_count);

        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.ll_fragment1_container,new FragmentTest1());//此处使用官方包的Fragment
        fragmentTransaction.add(R.id.ll_fragment2_container,new FragmentTest2());//先开辟两个容器
        fragmentTransaction.commit();

        initView();
        getCount();
    }

    /**
     * 显示程序启动的次数
     */
    public void getCount() {
        sharedPreferences=getSharedPreferences("count",MODE_PRIVATE);
        int count=sharedPreferences.getInt("count",0);
        tv_count.setText("程序自运行到现在已经运行："+count+" 次");
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt("count",++count);//放入键值对
        editor.commit();
    }

    /**
     *
     */
    private void initView() {

    }


    /**
     * 单击按钮将信息传递给Fragment1
     * 通过bundle存取数据来实现的
     * @param view
     */
    public void sendMessage(View view) {
        String info=edit_activity.getText().toString().trim();
        Fragment frag1=new FragmentTest1();
        Bundle bundle=new Bundle();
        bundle.putString("info",info);//将数据存放到bundle中，键值对
        frag1.setArguments(bundle);//调用fragment的该方法

        fragmentManager=getFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ll_fragment1_container,frag1);//更换现在改变的Fragment(replace而不是add)
        //将事物添加到Back栈，允许用户按Back按键返回到替换Fragment前的状态
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    /**
     * 实现接口，获得数据，动态显示TextView的内容
     * 接收由fragment1传过来的数据
     * 此时函数名称其实并不太确切（自我感觉）
     * @param info
     */
    @Override
    public void sendMessage(String info) {
        if((info != null) && (info !="")){
            tv_activity.setText(info);
        }
    }
}
