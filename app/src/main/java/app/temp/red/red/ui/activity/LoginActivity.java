package app.temp.red.red.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hkf.coffee.ui.activity.BaseFragmentActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;

/**
 * 登录界面
 * Created by huangkangfa on 2017/8/6.
 */
public class LoginActivity extends BaseFragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        GotoActivityManager.goHomeActivity(mActivity);

    }

}
