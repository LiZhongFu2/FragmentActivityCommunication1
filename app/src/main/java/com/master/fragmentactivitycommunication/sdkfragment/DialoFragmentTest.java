package com.master.fragmentactivitycommunication.sdkfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.master.fragmentactivitycommunication.R;

/**
 * Created by hufan on 2018/2/15.
 * 相当于一个fragment来使用
 */

public class DialoFragmentTest extends DialogFragment {
    /**
    //使用自定义布局创建Dialog
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_dialog,container);
        return view;
    }
    */

    //使用AlertDialog创建Dialog
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setMessage("你真的学会使用我了吗？");
        builder.setTitle("DialogFragmentTest");
        // TODO: 2018/2/25 设置图标
        builder.setIcon(R.drawable.ic_issue_exp);
        // TODO: 2018/2/25 设置确定按钮和取消按钮的点击事件
        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setNegativeButton("取消",null);//如果没有监听事件，可以传null
        // TODO: 2018/2/25 返回创建的Dialog对象
        return builder.create();
    }
}
