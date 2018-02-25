package com.master.fragmentactivitycommunication;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

/**
 * Created by hufan on 2018/2/10.
 * 专门用于设置选项参数，选项参数的值自行保存在Preference
 * 使用特殊的布局文件（以“PreferenceScreen”作为根元素）
 * PreferenceActivity加载选项设置列表布局；
 * PreferenceFragment加载选项设置布局
 */

public class PreferenceActivityTest extends PreferenceActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: 2018/2/10 为标题设置一个标题按钮，位于界面底部
        if(hasHeaders()){
            Button btn=new Button(this);
            btn.setText("设置操作");
            setListFooter(btn);//添加到该布局上
        }
    }

    // TODO: 2018/2/10 重写，负责加载界面布局
    @Override
    public void onBuildHeaders(List<Header> target) {
        loadHeadersFromResource(R.xml.preference_headers,target);
    }

    // TODO: 2018/2/10 重写，验证各PreferenceFragment是否有效
    @Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }

    // TODO: 2018/2/10 提供两个静态内部类，加载各自的布局文件
    public static class Prefers1Fragment extends PreferenceFragment{
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preferences);
        }
    }

    public static class Prefers2Fragment extends PreferenceFragment{
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.display_prefs);
            // TODO: 2018/2/10 获取传入该Fragment的参数
            String website=getArguments().getString("website");
            Toast.makeText(getActivity(),"网站域名是："+website,Toast.LENGTH_SHORT).show();
        }
    }
}
