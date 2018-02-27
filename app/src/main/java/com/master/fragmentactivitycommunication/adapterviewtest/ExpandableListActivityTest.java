package com.master.fragmentactivitycommunication.adapterviewtest;

import android.app.ExpandableListActivity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.master.fragmentactivitycommunication.R;

/**
 * Created by hufan on 2018/2/10.
 * 生成一个显示可展开列表的窗口
 */

public class ExpandableListActivityTest extends ExpandableListActivity {

    private Context context=ExpandableListActivityTest.this;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 2018/2/10 为该活动传入一个ExpandableListAdapter对象
        ExpandableListAdapter adapter=new BaseExpandableListAdapter() {
            // TODO: 2018/2/10 传入图片,主标题，副标题
            int[] images={R.drawable.ic_apply_repair,R.drawable.ic_bill_payment,R.drawable.ic_clean_service};
            private String[] groupData={"修理","账单支付","服务"};
            private String[][] childrenData={{"a","b","c"},
                    {"d","e","f"},
                    {"g","h","i"}};
            // TODO: 2018/2/10  获取指定组位置，指定子列表项处的子列表项数据

            @Override
            public int getGroupCount() {
                return groupData.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return childrenData[groupPosition].length;
            }
            //获取指定组位置处的组数据
            @Override
            public Object getGroup(int groupPosition) {
                return groupData[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return childrenData[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }
            //具有固定ID
            @Override
            public boolean hasStableIds() {
                return true;
            }
            //决定每个组选项的外观
            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                // TODO: 2018/2/10 返回一个线性布局，包含一个ImageView和一个TextView
                LinearLayout linearLayout=new LinearLayout(context);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                linearLayout.setPadding(48,0,0,0);
                linearLayout.setGravity(Gravity.CENTER_VERTICAL);
                ImageView imageView=new ImageView(context);
                imageView.setImageResource(images[groupPosition]);
                linearLayout.addView(imageView);
                TextView textView=new TextView(context);
                textView.setText(getGroup(groupPosition).toString());//设置组选项显示的文字内容
                textView.setTextSize(16);
                textView.setPadding(48,0,0,0);
                linearLayout.addView(textView);
                return linearLayout;
            }
            //每个子选项的外观,返回一个视图
            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView textView=getTextView();
                textView.setText(getChild(groupPosition,childPosition).toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
            // TODO: 2018/2/10 动态设置TextView,返回一个TextView
            private TextView getTextView(){
                AbsListView.LayoutParams lp=new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,64);
                TextView textView=new TextView(context);
                textView.setLayoutParams(lp);//设置Text的属性
                textView.setGravity(Gravity.CENTER_VERTICAL| Gravity.LEFT);
                textView.setPadding(36,0,0,0);
                textView.setTextSize(20);
                return textView;
            }
        };
        // TODO: 2018/2/10 设置该窗口显示列表
        setListAdapter(adapter);
    }
}
