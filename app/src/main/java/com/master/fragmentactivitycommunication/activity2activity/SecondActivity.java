package com.master.fragmentactivitycommunication.activity2activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.master.fragmentactivitycommunication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hufan on 2018/2/26.
 * 被启动活动返回数据
 * 1、SecondActivity.this.setResult(0,intent);设置返回结果
 * 2、通用SimpleAdapter的使用
 */

public class SecondActivity extends Activity{

    private ListView listCity;
    private String cityName[]={"广州","西安","咸阳","重庆","长沙","武汉","北京","榆林"};
    private String cityInfo[]={"广州风光秀丽","西安羊肉泡馍和兵马俑","秦始皇大一统，华夏文明的起源地"
            ,"重庆火锅和旅游","江南才子出身地，橘子洲","武汉热干面，岳阳楼","中华人民共和国省会城市","我老婆是榆林人"};
    private int cityImage[]={R.drawable.ic_logo_wankeboyu,R.drawable.ic_logo_wankeboyu,R.drawable.ic_logo_wankeboyu,
            R.drawable.ic_logo_wankeboyu,R.drawable.ic_logo_wankeboyu,R.drawable.ic_logo_wankeboyu,
            R.drawable.ic_logo_wankeboyu,R.drawable.ic_logo_wankeboyu};
    private final static String TAG="SecondActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initListView();
        handleListItems();
        Log.i(TAG, "onCreate: 1");

    }

    /**
     * 处理listView的每一项的点击事件,将所选取的城市信息返回给FirstActivity
     */
    private void handleListItems() {
        listCity.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO: 2018/2/26 获取启动该Activity之前的Activity对应的Intent
                Intent intent=getIntent();
                // TODO: 2018/2/26 附加数据并设置该Activity的结果码
                intent.putExtra("city",cityName[position]);
                SecondActivity.this.setResult(0,intent);
                SecondActivity.this.finish();
            }
        });
    }


    /**
     * 初始化通用listView
     */
    private void initListView() {
        // TODO: 2018/2/26 创建一个List集合，元素是Map
        List<Map<String,Object>> listItems=new ArrayList<>();
        // TODO: 2018/2/26 向List集合中每个listItem添加数据
        for (int i= 0; i <cityName.length ; i++) {
            Map<String,Object> listItem=new HashMap<>();
            listItem.put("cityName",cityName[i]);
            listItem.put("cityInfo",cityInfo[i]);
            listItem.put("cityImage",cityImage[i]);
            listItems.add(listItem);//逐个添加Map元素
        }
        // TODO: 2018/2/26 创建一个simpleAdapter并设置适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,listItems,R.layout.simple_adapter_item,
                new String[]{"cityName","cityInfo","cityImage"},new int[]{R.id.tv_simple_adapter_item_cityName,
        R.id.tv_simple_adapter_item_cityInfo,R.id.image_simple_adapter_item});//最后的两个参数由对应的关系
        listCity=findViewById(R.id.list_activity_second_city);
        listCity.setAdapter(simpleAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: 2");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: 6");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: 3");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: 7");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: 4");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: 5");
    }

}
