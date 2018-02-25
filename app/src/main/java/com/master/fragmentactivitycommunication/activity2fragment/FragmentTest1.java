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
 * 接收Activity的传值
 * 与fragment2实现互传值
 */

public class FragmentTest1 extends Fragment {

    private TextView tv_fragment1;
    private Button btn_frag12frag2;
    private EditText edit_fragment1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_test1,container,false);
        findView(view);
        initView();
        return view;
    }

    /**
     * 动态加载textview内容
     */
    private void initView() {
        //接收Activity传过来的值并显示
        Bundle bundle=getArguments();//因为Bundle是Fragment的方法
        if(bundle!=null){
            String info=bundle.getString("info");
            tv_fragment1.setText(info);
        }
        //点击按钮开始向fragment2传值
        btn_frag12frag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=edit_fragment1.getText().toString().trim();//获得内容

                 //方式1：可以调用findFragmentById()方法根据id获得fragment的对象，调用fragment中的方法赋值
                 FragmentTest2 fragmentTest2=(FragmentTest2)getFragmentManager()
                 .findFragmentById(R.id.ll_fragment2_container);//获得fragment的具体对象
                 fragmentTest2.ReceiveFragmentMessage(text);

                /**
                 //方式2：获得fragmentmanager对象然后获得右侧fragment,再调用getView获得右侧fragment的View对象，最后调用view的findviewById获得赋值的控制
                 TextView tv=getFragmentManager().findFragmentById(R.id.ll_fragment2_container)
                 .getView().findViewById(R.id.tv_fragment2);
                 tv.setText(text);
                 */

                /**
                 //方式3：先调用getActivity()获得所属的Activity的对象，然后调用findviewbyid（）获取目标控件
                 TextView tv=getActivity().findViewById(R.id.tv_fragment2);
                 tv.setText(text);
                 */

            }
        });

    }

    /**
     * 关联各视图控件
     * @param view
     */
    private void findView(View view) {
        tv_fragment1=view.findViewById(R.id.tv_fragment1);
        btn_frag12frag2=view.findViewById(R.id.btn_frag12frag2);
        edit_fragment1=view.findViewById(R.id.edit_fragment1);
    }



}
