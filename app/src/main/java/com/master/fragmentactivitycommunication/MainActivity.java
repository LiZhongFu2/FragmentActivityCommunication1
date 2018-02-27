package com.master.fragmentactivitycommunication;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.master.fragmentactivitycommunication.activity2activity.FirstActivity;
import com.master.fragmentactivitycommunication.activity2fragment.ActivityTest;
import com.master.fragmentactivitycommunication.adapterviewtest.ExpandableListActivityTest;
import com.master.fragmentactivitycommunication.adapterviewtest.PreferenceActivityTest;

/**
 * Created by hufan on 2018/2/9.
 * 主活动
 */

public class MainActivity extends LauncherActivity {

    // TODO: 2018/2/10 定义Activity的名称
    private String[] names={"PreferenceActivityTest","ExpandableListActivityTest",
            "测试Activity和Fragment之间的传值","sdkFragmentTest","Activity之间传值测试"};
    // TODO: 2018/2/10 定义Activity对应的实现类
    Class<?>[] aClass={PreferenceActivityTest.class,ExpandableListActivityTest.class, ActivityTest.class,
            com.master.fragmentactivitycommunication.sdkfragment.ActivityTest.class,
            FirstActivity.class};

    // TODO: 2018/2/10 设置该窗口显示的列表所需的Adapter

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,names);
        setListAdapter(adapter);
    }

    /**
     *  根据列表项返回指定Activity对应的Intent
     */
    @Override
    protected Intent intentForPosition(int position) {
        return new Intent(MainActivity.this,aClass[position]);
    }
}
