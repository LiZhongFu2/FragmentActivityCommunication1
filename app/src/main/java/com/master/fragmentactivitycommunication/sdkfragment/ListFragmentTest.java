package com.master.fragmentactivitycommunication.sdkfragment;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.master.fragmentactivitycommunication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hufan on 2018/2/15.
 *ListFragment的布局 listview的id固定 android:id="@id/android:list"
 * 绑定数据  setListAdapter(arrayAdapter)
 */

public class ListFragmentTest extends ListFragment{

    private List<String> list;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragmentlist_test_layout,container,false);//此处曾经因为加载布局错误而发生崩溃
        //准备数据
        list=new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            list.add("item"+i);
        }
        //适配数据和视图
        ArrayAdapter arrayAdapter=new ArrayAdapter(getActivity(),android.R.layout.simple_list_item_1,list);//android.R
        setListAdapter(arrayAdapter);//不需要findViewById,因为直接继承，所以直接进行适配
        return view;
    }

    /**
     * 为ListView定义每一项的点击事件
     * @param l
     * @param v
     * @param position
     * @param id
     */
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(),list.get(position)+"被点击",Toast.LENGTH_SHORT).show();
    }
}
