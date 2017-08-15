package app.temp.red.red.ui;

import android.content.Intent;

import com.hkf.coffee.ui.ActivityManager;
import com.hkf.coffee.ui.activity.BaseActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.activity.groups.CreateGroupActivity;
import app.temp.red.red.ui.activity.others.DeviceListActivity;
import app.temp.red.red.ui.activity.me.FeedbackActivity;
import app.temp.red.red.ui.activity.me.HelpActivity;
import app.temp.red.red.ui.activity.HomeActivity;
import app.temp.red.red.ui.activity.IntroActivity;
import app.temp.red.red.ui.activity.login.LoginActivity;
import app.temp.red.red.ui.activity.others.ManualModeActivity;
import app.temp.red.red.ui.activity.me.MyCenterActivity;
import app.temp.red.red.ui.activity.groups.MyGroupDetailActivity;
import app.temp.red.red.ui.activity.groups.MyGroupListActivity;
import app.temp.red.red.ui.activity.login.RegisterActivity;
import app.temp.red.red.ui.activity.me.ResetPasswordActivity;
import app.temp.red.red.ui.activity.me.SeasonSetActivity;
import app.temp.red.red.ui.activity.me.TempTackActivity;
import app.temp.red.red.ui.activity.others.TransitActivity;
import app.temp.red.red.ui.activity.me.WeekProgramActivity;
import app.temp.red.red.ui.activity.WelcomeActivity;

/**
 * Created by huangkangfa on 2017/8/9.
 */

public class GotoActivityManager {
    //跳转至引导页
    public static void goIntroActivity(BaseActivity activity,int code){
        Intent it=new Intent(activity, IntroActivity.class);
        activity.startActivityForResult(it,code);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至登录页
    public static void goLoginActivity(BaseActivity activity){
        Intent it=new Intent(activity, LoginActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
        ActivityManager.getActivity().finishExceptOne(LoginActivity.class);
    }
    //跳转至注册页
    public static void goRegisterActivity(BaseActivity activity){
        Intent it=new Intent(activity, RegisterActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至重置密码页
    public static void goResetPasswordActivity(BaseActivity activity){
        Intent it=new Intent(activity, ResetPasswordActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至没群组过渡页
    public static void goTransitActivity(BaseActivity activity){
        Intent it=new Intent(activity, TransitActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至首页
    public static void goHomeActivity(BaseActivity activity){
        Intent it=new Intent(activity, HomeActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
        ActivityManager.getActivity().finishExceptOne(HomeActivity.class);
    }
    //跳转至设备详情页
    public static void goDeviceListActivity(BaseActivity activity){
        Intent it=new Intent(activity, DeviceListActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至反馈页
    public static void goFeedbackActivity(BaseActivity activity){
        Intent it=new Intent(activity, FeedbackActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至帮助页
    public static void goHelpActivity(BaseActivity activity){
        Intent it=new Intent(activity, HelpActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至手动模式界面
    public static void goManualModeActivity(BaseActivity activity){
        Intent it=new Intent(activity, ManualModeActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至个人中心
    public static void goMyCenterActivity(BaseActivity activity){
        Intent it=new Intent(activity, MyCenterActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至我的群组详情界面
    public static void goMyGroupDetailActivity(BaseActivity activity){
        Intent it=new Intent(activity, MyGroupDetailActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至群组列表界面
    public static void goMyGroupListActivity(BaseActivity activity){
        Intent it=new Intent(activity, MyGroupListActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至群组创建界面
    public static void goCreateGroupActivity(BaseActivity activity){
        Intent it=new Intent(activity, CreateGroupActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至采暖季节界面
    public static void goSeasonSetActivity(BaseActivity activity){
        Intent it=new Intent(activity, SeasonSetActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至临时策略界面
    public static void goTempTackActivity(BaseActivity activity){
        Intent it=new Intent(activity, TempTackActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至启动页
    public static void goWelcomeActivity(BaseActivity activity){
        Intent it=new Intent(activity, WelcomeActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至周编程界面
    public static void goWeekProgramActivity(BaseActivity activity){
        Intent it=new Intent(activity, WeekProgramActivity.class);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
}
