package com.master.fragmentactivitycommunication.adapterviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.master.fragmentactivitycommunication.R;

/**
 * Created by hufan on 2018/2/28.
 * 实现自动播放的图片库
 */

public class AdapterViewFlipperTest extends Activity {

    private int[] imageIds={R.drawable.shuangzi, R.drawable.shuangyu,
            R.drawable.chunv, R.drawable.tiancheng, R.drawable.tianxie,
            R.drawable.sheshou, R.drawable.juxie, R.drawable.shuiping,
            R.drawable.shizi, R.drawable.baiyang, R.drawable.jinniu,
            R.drawable.mojie };
    private AdapterViewFlipper flipper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adapter_view_flipper_test);
        flipper=findViewById(R.id.flipper_adapter_view_flipper_test);

        // TODO: 2018/2/28  采用扩展BaseAdapter
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // TODO: 2018/2/28 创建imageView并返回
                ImageView imageView=new ImageView(AdapterViewFlipperTest.this);
                imageView.setImageResource(imageIds[position]);
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                        , ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        };
        flipper.setAdapter(adapter);
    }

    /**
     * 显示前一张图片
     * @param view
     */
    public void prev(View view) {
        // TODO: 2018/2/28 显示上一个组件
        flipper.showPrevious();
        flipper.stopFlipping();
    }

    public void next(View view) {
        flipper.showNext();
        flipper.stopFlipping();
    }

    public void auto(View view) {
        flipper.startFlipping();//开始自动播放
    }
}
