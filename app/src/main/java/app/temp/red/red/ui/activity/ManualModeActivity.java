package app.temp.red.red.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hkf.coffee.ui.activity.BaseActivity;

import app.temp.red.red.R;

/**
 * 手动模式详情界面   群组、场景、网关、设备手动模式详情复用
 * Created by huangkangfa on 2017/8/9.
 */
public class ManualModeActivity extends BaseActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manual_mode);
    }
}
