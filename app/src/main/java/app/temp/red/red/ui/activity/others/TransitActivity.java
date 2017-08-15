package app.temp.red.red.ui.activity.others;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.hkf.coffee.ui.activity.BaseFragmentActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 过渡界面界面
 * Created by huangkangfa on 2017/8/6.
 */
public class TransitActivity extends BaseFragmentActivity {
    @Bind(R.id.btn_add)
    Button btnAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transit);
        ButterKnife.bind(this);
        //判定该用户是否有群组，有的话跳转首页，没有停留该界面
    }

    @OnClick(R.id.btn_add)
    public void onViewClicked(View v) {
        GotoActivityManager.goCreateGroupActivity(mActivity);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
