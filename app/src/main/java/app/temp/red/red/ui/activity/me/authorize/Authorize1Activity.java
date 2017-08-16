package app.temp.red.red.ui.activity.me.authorize;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import app.temp.red.red.ui.adapter.Horizontal2Adapter;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 授权中心3
 * Created by huangkangfa on 2017/8/15.
 */
public class Authorize1Activity extends BaseActivity {

    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.lv)
    ListView lv;

    Horizontal2Adapter adapter;
    List<String> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorize1);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        headTxtOthers.setVisibility(View.VISIBLE);
        headTxtOthers.setText("添加");
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));

        data = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            data.add("用户昵称" + i);
        }
        adapter = new Horizontal2Adapter(mActivity, data);
        lv.setAdapter(adapter);
        headTxtOthers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GotoActivityManager.goAuthorize2Activity(mActivity);
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
