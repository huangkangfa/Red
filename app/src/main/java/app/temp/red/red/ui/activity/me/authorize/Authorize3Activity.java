package app.temp.red.red.ui.activity.me.authorize;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import app.temp.red.red.R;
import app.temp.red.red.entry.ExpandableListViewChildItemData;
import app.temp.red.red.entry.ExpandableListViewItemData;
import app.temp.red.red.ui.adapter.ExpandableListViewAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 授权中心3
 * Created by huangkangfa on 2017/8/15.
 */
public class Authorize3Activity extends BaseActivity {

    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.eLv)
    ExpandableListView eLv;

    List<ExpandableListViewItemData> data;
    ExpandableListViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorize3);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        headTxtOthers.setVisibility(View.VISIBLE);
        headTxtOthers.setText("确定");
        headTxtTitle.setText("授权中心");

        data = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<ExpandableListViewChildItemData> x = new ArrayList<>();
            for (int j = 0; j < 5; j++) {
                x.add(new ExpandableListViewChildItemData("测试子项" + j, false));
            }
            data.add(new ExpandableListViewItemData("测试项" + i, false, x));
        }
        adapter = new ExpandableListViewAdapter(mActivity, data);
        eLv.setAdapter(adapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.head_img_back, R.id.head_txt_others})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head_img_back:
                finish();
                break;
            case R.id.head_txt_others:
                break;
        }
    }
}
