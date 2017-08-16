package app.temp.red.red.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hkf.coffee.ui.fragment.BaseFragment;

import app.temp.red.red.R;
import app.temp.red.red.ui.GotoActivityManager;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 首页-我的模块
 * Created by huangkangfa on 2017/8/9.
 */
public class MineFragment extends BaseFragment {
    @Bind(R.id.head_img_back)
    ImageView headImgBack;
    @Bind(R.id.head_txt_title)
    TextView headTxtTitle;
    @Bind(R.id.head_txt_others)
    TextView headImgOthers;
    @Bind(R.id.rl_people)
    RelativeLayout rlPeople;
    @Bind(R.id.rl_mould)
    RelativeLayout rlMould;
    @Bind(R.id.rl_heating)
    RelativeLayout rlHeating;
    @Bind(R.id.rl_empower)
    RelativeLayout rlEmpower;
    @Bind(R.id.rl_help)
    RelativeLayout rlHelp;
    @Bind(R.id.rl_feedback)
    RelativeLayout rlFeedback;
    @Bind(R.id.rl_about)
    RelativeLayout rlAbout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = setContentView(inflater, R.layout.fragment_mine, container);
        ButterKnife.bind(this, view);
        headTxtTitle.setText("我");
        headImgOthers.setVisibility(View.GONE);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @OnClick({R.id.rl_people,R.id.rl_mould, R.id.rl_heating, R.id.rl_empower, R.id.rl_help, R.id.rl_feedback, R.id.rl_about})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_people:
                GotoActivityManager.goMyCenterActivity(mActivity);
                break;
            case R.id.rl_mould:
                //模板
                GotoActivityManager.goFormworkActivity1(mActivity,"设置");
                break;
            case R.id.rl_heating:
                //采暖季设置
                GotoActivityManager.goSeasonSetActivity(mActivity);
                break;
            case R.id.rl_empower:
                //授权中心
                GotoActivityManager.goAuthorize1Activity(mActivity);
                break;
            case R.id.rl_help:
                GotoActivityManager.goHelpActivity(mActivity);
                //帮助
                break;
            case R.id.rl_feedback:
                GotoActivityManager.goFeedbackActivity(mActivity);
                break;
            case R.id.rl_about:
                //关于
                GotoActivityManager.goAboutActivity(mActivity);
                break;
        }
    }
}
