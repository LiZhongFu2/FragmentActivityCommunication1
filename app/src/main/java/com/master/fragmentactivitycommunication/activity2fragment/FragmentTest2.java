package com.master.fragmentactivitycommunication.activity2fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.master.fragmentactivitycommunication.R;

/**
 * Created by hufan on 2018/2/14.
 * 向Activity传值
 * 与fragment1实现互传值
 */

public class FragmentTest2 extends Fragment implements View.OnClickListener {

    private TextView tv_fragment2;
    private Button btn_frag22frag1,btn_frag22act;
    private EditText edit_fragment2;
    private MyListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建listener具体对象，运用到多态的知识
        listener=(MyListener)getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_test2,container,false);
        findView(view);
        initView();
        return view;
    }

    /**
     * 动态改变TextView显示的内容
     */
    private void initView() {

    }

    /**
     * 关联视图
     * @param view
     */
    private void findView(View view) {
        tv_fragment2=view.findViewById(R.id.tv_fragment2);
        btn_frag22frag1=view.findViewById(R.id.btn_frag22frag1);
        btn_frag22act=view.findViewById(R.id.btn_frag22act);
        edit_fragment2=view.findViewById(R.id.edit_fragment2);
        btn_frag22act.setOnClickListener(this);//设置监听事件
        btn_frag22frag1.setOnClickListener(this);
    }

    /**
     * 集中处理单击事件
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_frag22act:
                // TODO: 2018/2/14  向activity传值
                String info=edit_fragment2.getText().toString().trim();//获得字符串
                listener.sendMessage(info);//接口回调的形式传递参数
                break;
            case R.id.btn_frag22frag1:
                // TODO: 2018/2/14  向Fragment传值
                String text=edit_fragment2.getText().toString().trim();//获得字符串
                TextView tv=getActivity().findViewById(R.id.tv_fragment1);//方式3
                tv.setText(text);
                break;

        }
    }

    /**
     * 定义接口 接口中定义回传数据的函数
     */
    public interface MyListener{
        void sendMessage(String info);
    }

    /**
     * 接收由Fragment传过来的数据并显示在当前fragment
     */
    public void ReceiveFragmentMessage(String text){
        tv_fragment2.setText(text);
    }
}
