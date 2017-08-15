package app.temp.red.red.ui.activity.formworks;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by huangkangfa on 2017/8/15.
 */

public class FormworkTypeActivity extends BaseActivity {
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.ll1)
    RelativeLayout ll1;
    @Bind(R.id.ll2)
    RelativeLayout ll2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formwork_1);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        //顶部栏标题设置
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.ll1, R.id.ll2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll1:
                //跳转至周编程模板导入界面
                GotoActivityManager.goShowListActivity(mActivity,"周编程模板");
                break;
            case R.id.ll2:
                //跳转至临时策略模板导入界面
                GotoActivityManager.goShowListActivity(mActivity,"临时策略模板");
                break;
        }
    }
}
