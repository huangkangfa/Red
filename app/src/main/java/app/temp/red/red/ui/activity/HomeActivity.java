package app.temp.red.red.ui.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hkf.coffee.ui.activity.BaseFragmentActivity;
import com.hkf.coffee.ui.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import app.temp.red.red.R;
import app.temp.red.red.global.TempData;
import app.temp.red.red.ui.dialog.ChooseDialog;
import app.temp.red.red.ui.fragment.GatewayFragment;
import app.temp.red.red.ui.fragment.MineFragment;
import app.temp.red.red.ui.fragment.SceneFragment;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页
 * Created by huangkangfa on 2017/8/9.
 */
public class HomeActivity extends BaseFragmentActivity implements ChooseDialog.ChooseItemClickListener{
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.bottom_bar_img1)
    ImageView bottomBarImg1;
    @Bind(R.id.btn_index1)
    RelativeLayout btnIndex1;
    @Bind(R.id.bottom_bar_img2)
    ImageView bottomBarImg2;
    @Bind(R.id.btn_index2)
    RelativeLayout btnIndex2;
    @Bind(R.id.bottom_bar_img3)
    ImageView bottomBarImg3;
    @Bind(R.id.btn_index3)
    RelativeLayout btnIndex3;
    @Bind(R.id.bottom_bar)
    LinearLayout bottomBar;
    @Bind(R.id.bottom_bar_txt1)
    TextView bottomBarTxt1;
    @Bind(R.id.bottom_bar_txt2)
    TextView bottomBarTxt2;
    @Bind(R.id.bottom_bar_txt3)
    TextView bottomBarTxt3;

    public static final String ACTION_NAME = "HomeActivity";

    private List<BaseFragment> fragemts=new ArrayList<>();
    private int position=0;  //当前碎片编号
    private ChooseDialog dialog_choose;

    private String[] data_choose1=new String[]{
            "导入模板","手动模式","设备锁","详情"
    };
    private String[] data_choose2=new String[]{
            "导入模板","手动模式","设备锁","工程锁","详情"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        registerBoradcastReceiver();

        fragemts.add(new SceneFragment());
        fragemts.add(new GatewayFragment());
        fragemts.add(new MineFragment());

        dialog_choose=new ChooseDialog(mActivity);
        dialog_choose.refreshView(data_choose1);
        dialog_choose.setChooseItemClickListener(this);

        viewPager.setAdapter(fragmentPagerAdapter);
        viewPager.setOnPageChangeListener(pageChangeListener);
        viewPager.setCurrentItem(0);
        changeBottomBtnStyle(0);
    }

    private FragmentPagerAdapter fragmentPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            return fragemts.get(position);
        }

        @Override
        public int getCount() {
            return fragemts.size();
        }
    };


    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            changeBottomBtnStyle(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    @OnClick({R.id.btn_index1, R.id.btn_index2, R.id.btn_index3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_index1:
                changeBottomBtnStyle(0);
                viewPager.setCurrentItem(0);
                break;
            case R.id.btn_index2:
                changeBottomBtnStyle(1);
                viewPager.setCurrentItem(1);
                break;
            case R.id.btn_index3:
                changeBottomBtnStyle(2);
                viewPager.setCurrentItem(2);
                break;
        }
    }

    private void changeBottomBtnStyle(int position){
        this.position=position;
        switch (position) {
            case 0:
                bottomBarTxt1.setTextColor(Color.parseColor("#000000"));
                bottomBarTxt2.setTextColor(Color.parseColor("#666666"));
                bottomBarTxt3.setTextColor(Color.parseColor("#666666"));
                break;
            case 1:
                bottomBarTxt1.setTextColor(Color.parseColor("#666666"));
                bottomBarTxt2.setTextColor(Color.parseColor("#000000"));
                bottomBarTxt3.setTextColor(Color.parseColor("#666666"));
                break;
            case 2:
                bottomBarTxt1.setTextColor(Color.parseColor("#666666"));
                bottomBarTxt2.setTextColor(Color.parseColor("#666666"));
                bottomBarTxt3.setTextColor(Color.parseColor("#000000"));
                break;
        }
    }

    /**
     * 接收广播
     */
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(ACTION_NAME)) {
                switch (intent.getStringExtra("类型")){
                    case "选择弹框":
                        if(TempData.hasProjectLock){
                            dialog_choose.refreshView(data_choose2);
                        }
                        dialog_choose.show();
                        break;
                }
            }
        }
    };

    /**
     * 注册广播
     */
    public void registerBoradcastReceiver() {
        IntentFilter myIntentFilter = new IntentFilter();
        myIntentFilter.addAction(ACTION_NAME);
        registerReceiver(mBroadcastReceiver, myIntentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(mBroadcastReceiver);
        ButterKnife.unbind(this);
    }

    @Override
    public void click(String type, String content, int index) {
        switch (content){
            case "导入模板":
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            break;

            case "手动模式":
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            break;

            case "设备锁":
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            break;

            case "工程锁":
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            break;

            case "重命名":
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            break;

            case "删除":
                switch (position){
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            break;
        }
    }
}
