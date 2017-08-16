package app.temp.red.red.ui.activity.me.authorize;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 授权中心2
 * Created by huangkangfa on 2017/8/15.
 */
public class Authorize2Activity extends BaseActivity {

    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.btn_next)
    Button btnNext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorize2);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        headTxtTitle.setText("授权中心");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GotoActivityManager.goAuthorize3Activity(mActivity);
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
