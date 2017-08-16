package app.temp.red.red.ui.activity.me;

import android.content.Intent;
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
 * 个人中心
 * Created by huangkangfa on 2017/8/9.
 */
public class MyCenterActivity extends BaseActivity {

    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headTxtOthers;
    @Bind(R.id.rl_name)
    RelativeLayout rlName;
    @Bind(R.id.rl_revisepassword)
    RelativeLayout rlRevisepassword;
    @Bind(R.id.rl_out)
    RelativeLayout rlOut;
    @Bind(R.id.txt_name)
    TextView txtName;
    @Bind(R.id.rl_mycenter)
    RelativeLayout rlMycenter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycenter);
        ButterKnife.bind(this);
        headImgBack.setVisibility(View.VISIBLE);
        headTxtTitle.setText(getIntent().getStringExtra(GotoActivityManager.HEAD_TITLE));
    }

    @OnClick({R.id.head_img_back, R.id.rl_name, R.id.rl_revisepassword, R.id.rl_out,R.id.rl_mycenter})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.head_img_back:
                finish();
                break;
            case R.id.rl_name:
                GotoActivityManager.goSetNameActivity(MyCenterActivity.this, txtName.getText().toString());
                break;
            case R.id.rl_mycenter:
               //头像
                break;
            case R.id.rl_revisepassword:
                GotoActivityManager.goRevisePasswordActivity(MyCenterActivity.this);
                break;
            case R.id.rl_out:
                GotoActivityManager.goLoginActivity(MyCenterActivity.this);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (20 == resultCode) {
            String name = data.getExtras().getString("name");
            txtName.setText(name);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.rl_mycenter)
    public void onViewClicked() {
    }
}
