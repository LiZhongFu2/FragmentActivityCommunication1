package com.master.fragmentactivitycommunication.adapterviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.master.fragmentactivitycommunication.R;

/**
 * Created by hufan on 2018/2/27.
 * 实现垂直列表选项框
 */

public class SpinnerTest extends Activity {

    private Spinner spinner;
    private String [] figure={"鲁迅","高尔基","毛泽东","三毛","凡尔纳"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_test);
        spinner=findViewById(R.id.spinner);
        // TODO: 2018/2/27 创建ArraryAdapter对象
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_multiple_choice,figure);
        // TODO: 2018/2/27 为Spinner设置Adapter
        spinner.setAdapter(adapter);

        //为每一项设置选取事件
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // TODO: 2018/2/27
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO: 2018/2/27

            }
        });

    }

}
