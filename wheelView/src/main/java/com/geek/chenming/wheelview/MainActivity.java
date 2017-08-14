package com.geek.chenming.wheelview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.geek.chenming.wheelview.view.LoopView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout layout;
    private LoopView loopView;
    private RelativeLayout.LayoutParams layoutParams;
    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (RelativeLayout) findViewById(R.id.layout);
        loopView = new LoopView(getBaseContext());
        loopView.setNotLoop();//不连滚
        loopView.measuredWidth = 300;
        layoutParams = new RelativeLayout.LayoutParams(300, 200);
        layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        list = new ArrayList<>();
        for (int i = 0; i < 32; i++) {
            list.add(i + "");
        }
        loopView.setItems(list);
        loopView.setInitPosition(0);

        layout.addView(loopView, layoutParams);

    }
}
