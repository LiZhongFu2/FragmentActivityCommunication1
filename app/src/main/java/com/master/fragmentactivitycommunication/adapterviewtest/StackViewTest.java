package com.master.fragmentactivitycommunication.adapterviewtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Adapter;
import android.widget.SimpleAdapter;
import android.widget.StackView;

import com.master.fragmentactivitycommunication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hufan on 2018/2/28.
 * 以“堆叠”的方式来显示多个列表项
 */

public class StackViewTest extends Activity {

    private StackView stackView;
    private int[] imageIds = new int[]
            {
                    R.drawable.bomb5 , R.drawable.bomb6 , R.drawable.bomb7
                    , R.drawable.bomb8 , R.drawable.bomb9 , R.drawable.bomb10
                    , R.drawable.bomb11 , R.drawable.bomb12	, R.drawable.bomb13
                    , R.drawable.bomb14 , R.drawable.bomb15 , R.drawable.bomb16
            };
    String[] imageInfo= new String[]{"1","2","3","1","2","3","1","2","3","1","2","3"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stack_view_test);
        stackView=findViewById(R.id.stackView_stack_view_test);

        List<Map<String,Object>> imageItems=new ArrayList<>();
        for (int i = 0; i < imageIds.length; i++) {
            Map<String,Object> imageItem=new HashMap<>();
            imageItem.put("image",imageIds[i]);
            imageItem.put("info",imageInfo[i]);
            imageItems.add(imageItem);
        }
        //创建适配器
        SimpleAdapter adapter=new SimpleAdapter(this,imageItems,R.layout.cell_stack_view
                ,new String[] {"image","info"},new int[]{R.id.image_cell,R.id.tv_cell_test_imageInfo});

        stackView.setAdapter(adapter);


    }

    public void prev(View view) {
        stackView.showPrevious();
    }

    /**
     * 向下滚动显示
     * @param view
     */
    public void next(View view) {
        stackView.showNext();
    }
}
