package app.temp.red.red.ui.activity;

import android.Manifest;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.hkf.coffee.others.ToastUtil;
import com.hkf.coffee.others.log.LogUtil;
import com.hkf.coffee.phone.InfoUtil;
import com.hkf.coffee.ui.activity.BaseActivity;

import app.temp.red.red.R;
import app.temp.red.red.global.cache.AppCache;
import app.temp.red.red.global.cache.UserCache;
import app.temp.red.red.service.RedService;
import app.temp.red.red.ui.GotoActivityManager;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 启动页
 * Created by huangkangfa on 2017/8/6.
 */
public class WelcomeActivity extends BaseActivity {
    @Bind(R.id.bg_welcome)
    ImageView bgWelcome;

    private boolean isFirstUsedThisApp;  //是否是第一次使用该APP
    public static final int INTRO_CODE = 2;  //是否是引导页返回
    public static final int Permission = 3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);
        onCallPermission(new String[]{Manifest.permission.READ_PHONE_STATE});
    }

    private void init() {
        InfoUtil.init(getApplicationContext());
        /**
         * 启动mqtt服务
         */
        startService(new Intent(this, RedService.class));
        //逐渐显现
        ObjectAnimator.ofFloat(bgWelcome, "alpha", 0, 1).setDuration(1000).start();
        initData(500);
    }

    private void initData(int time) {
        //是否是第一次使用该APP
        isFirstUsedThisApp = AppCache.isFirstUsedThisApp();
        if (isFirstUsedThisApp) {
            //跳转到引导界面
            handler.sendEmptyMessageDelayed(1, time);
        } else {
            //跳转到主页或者登录界面
            handler.sendEmptyMessageDelayed(2, time);
        }
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1://引导
                    GotoActivityManager.goIntroActivity(mActivity,INTRO_CODE);
                    break;
                case 2://主页
                    String loginUser = UserCache.getLastLoginUser(); //前一个用户登录缓存
                    if (loginUser == null || "".equals(loginUser)) {
                        GotoActivityManager.goLoginActivity(mActivity);
                    } else {
                        GotoActivityManager.goTransitActivity(mActivity);
                    }
                    break;
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == INTRO_CODE) {
            initData(0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.e("welcome");
        ButterKnife.unbind(this);
    }

    @Override
    public void getAllPermissionsInFirstTime() {
        super.getAllPermissionsInFirstTime();
        init();
    }

    @Override
    public void getAllPermissionsInOtherTime() {
        super.getAllPermissionsInOtherTime();
        init();
    }

    @Override
    public void getAllPermissionsFail() {
        super.getAllPermissionsFail();
        ToastUtil.showShort(WelcomeActivity.this,"没有权限，无法进行下一步操作");
        finish();
    }

}
