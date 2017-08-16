package app.temp.red.red.ui.activity.others;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import app.temp.red.red.ui.adapter.HorizontalAdapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 列表展示界面
 * Created by huangkangfa on 2017/8/9.
 */
public class ShowListActivity extends BaseActivity {
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.lv)
    ListView lv;


    HorizontalAdapter adapter;
    List<String> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devicelist);
        ButterKnife.bind(this);

        init();
    }

    private void init() {
        //顶部栏标题设置
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));
        headTxtOthers.setVisibility(View.VISIBLE);
        headTxtOthers.setText("确定");

        data = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            data.add("测试" + i + "号");
        }
        adapter = new HorizontalAdapter(mActivity, data);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.setPosition(i);
            }
        });
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
