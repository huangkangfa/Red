package app.temp.red.red.ui.activity.others;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseActivity;

import java.util.HashMap;
import java.util.Map;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import app.temp.red.red.ui.view.CircleStage;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 手动模式详情界面   群组、场景、网关、设备手动模式详情复用
 * Created by huangkangfa on 2017/8/9.
 */
public class ManualModeActivity extends BaseActivity {
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.cs)
    CircleStage cs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_mode);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //顶部栏设置
        //顶部栏标题设置
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));
        headTxtOthers.setVisibility(View.VISIBLE);
        headTxtOthers.setText("更多");

        Map<Integer, String> map = new HashMap<>();
        map.put(3, "#ff0000");
        map.put(4, "#ff0000");
        map.put(5, "#00ff00");
        map.put(6, "#00ff00");
        map.put(7, "#00ff00");
        map.put(8, "#00ff00");
        map.put(9, "#0000ff");
        map.put(10, "#0000ff");
        map.put(11, "#0000ff");
        cs.setColors(map);
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
