package com.master.fragmentactivitycommunication.sdkfragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.master.fragmentactivitycommunication.R;

/**
 * Created by hufan on 2018/2/15.
 * 利用google sdk中写好的fragment进行再开发
 */

public class ActivityTest extends Activity{

    private Button button;//点击出现对话框

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sdkfragment_activity_test);
    }

    // TODO: 2018/2/25 定义按钮的点击事件，创建对话框
    public void onClick(View view) {
//        new AlertDialog.Builder(this).setTitle("hehe").setPositiveButton();
        DialogFragment dialogFragment=new DialoFragmentTest();
        dialogFragment.show(getFragmentManager(),"dialog1");//.show()用于创建
    }
}
