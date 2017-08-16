package app.temp.red.red.ui.activity.me;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseActivity;

import app.temp.red.red.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 帮助界面
 * Created by huangkangfa on 2017/8/9.
 */
public class HelpActivity extends BaseActivity {
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        ButterKnife.bind(this);
        headImgBack.setVisibility(View.VISIBLE);
        headTxtTitle.setText("帮助");
    }


    @OnClick({R.id.head_img_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head_img_back:
                finish();
                break;
        }
    }
}
