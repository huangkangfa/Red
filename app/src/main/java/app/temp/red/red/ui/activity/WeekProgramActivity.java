package app.temp.red.red.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.hkf.coffee.ui.activity.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import app.temp.red.red.R;
import app.temp.red.red.ui.view.HorizontalMenu;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 周编程详情界面   周编程模板设置与设备周编程详情复用
 * Created by huangkangfa on 2017/8/9.
 */
public class WeekProgramActivity extends BaseActivity {
    @Bind(R.id.horizontal_menu)
    HorizontalMenu horizontalMenu;

    List<String> data=new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weekprogram);
        ButterKnife.bind(this);
        data.add("周一");
        data.add("周二");
        data.add("周三");
        data.add("周四");
        data.add("周五");
        data.add("周六");
        data.add("周日");
        horizontalMenu.initMenu(data,0);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
