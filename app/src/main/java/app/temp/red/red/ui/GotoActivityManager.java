package app.temp.red.red.ui;

import android.content.Intent;

import com.hkf.coffee.ui.ActivityManager;
import com.hkf.coffee.ui.activity.BaseActivity;

import app.temp.red.red.R;
import app.temp.red.red.ui.activity.HomeActivity;
import app.temp.red.red.ui.activity.IntroActivity;
import app.temp.red.red.ui.activity.WelcomeActivity;
import app.temp.red.red.ui.activity.formworks.FormworkTypeActivity;
import app.temp.red.red.ui.activity.formworks.TempTackActivity;
import app.temp.red.red.ui.activity.formworks.WeekProgramActivity;
import app.temp.red.red.ui.activity.groups.CreateGroupActivity;
import app.temp.red.red.ui.activity.groups.MyGroupDetailActivity;
import app.temp.red.red.ui.activity.groups.MyGroupListActivity;
import app.temp.red.red.ui.activity.login.LoginActivity;
import app.temp.red.red.ui.activity.login.RegisterActivity;
import app.temp.red.red.ui.activity.login.ResetPassword2Activity;
import app.temp.red.red.ui.activity.login.ResetPasswordActivity;
import app.temp.red.red.ui.activity.login.SetNameActivity;
import app.temp.red.red.ui.activity.me.AboutActivity;
import app.temp.red.red.ui.activity.me.FeedbackActivity;
import app.temp.red.red.ui.activity.me.HelpActivity;
import app.temp.red.red.ui.activity.me.MyCenterActivity;
import app.temp.red.red.ui.activity.me.RevisePasswordActivity;
import app.temp.red.red.ui.activity.me.SeasonSetActivity;
import app.temp.red.red.ui.activity.me.authorize.Authorize1Activity;
import app.temp.red.red.ui.activity.me.authorize.Authorize2Activity;
import app.temp.red.red.ui.activity.me.authorize.Authorize3Activity;
import app.temp.red.red.ui.activity.others.DetailActivity;
import app.temp.red.red.ui.activity.others.ManualModeActivity;
import app.temp.red.red.ui.activity.others.ShowListActivity;
import app.temp.red.red.ui.activity.others.TransitActivity;

/**
 * Created by huangkangfa on 2017/8/9.
 */

public class GotoActivityManager {
    public static final String HEAD_TITLE="head_title";  //顶部栏标题
    public static final String TYPE="type";  //类型

    //跳转至引导页
    public static void goIntroActivity(BaseActivity activity,int code){
        Intent it=new Intent(activity, IntroActivity.class);
        it.putExtra(HEAD_TITLE,"引导");
        activity.startActivityForResult(it,code);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至登录页
    public static void goLoginActivity(BaseActivity activity){
        Intent it=new Intent(activity, LoginActivity.class);
        it.putExtra(HEAD_TITLE,"登录");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
        ActivityManager.getActivity().finishExceptOne(LoginActivity.class);
    }
    //跳转至注册页
    public static void goRegisterActivity(BaseActivity activity){
        Intent it=new Intent(activity, RegisterActivity.class);
        it.putExtra(HEAD_TITLE,"注册");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至重置密码页
    public static void goResetPasswordActivity(BaseActivity activity){
        Intent it=new Intent(activity, ResetPasswordActivity.class);
        it.putExtra(HEAD_TITLE,"重置密码");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }

    //跳转至重置密码页2
    public static void goResetPassword2Activity(BaseActivity activity){
        Intent it=new Intent(activity, ResetPassword2Activity.class);
        it.putExtra(HEAD_TITLE,"重置密码");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至重命名界面
    public static void goSetNameActivity(BaseActivity activity,String name){
        Intent it=new Intent(activity, SetNameActivity.class);
        it.putExtra(HEAD_TITLE,"更改昵称");
        it.putExtra("name",name);
        activity.startActivityForResult(it,0);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至修改密码界面
    public static void goRevisePasswordActivity(BaseActivity activity){
        Intent it=new Intent(activity, RevisePasswordActivity.class);
        it.putExtra(HEAD_TITLE,"修改密码");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至关于界面
    public static void goAboutActivity(BaseActivity activity){
        Intent it=new Intent(activity, AboutActivity.class);
        it.putExtra(HEAD_TITLE,"关于");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }

    //跳转至没群组过渡页
    public static void goTransitActivity(BaseActivity activity){
        Intent it=new Intent(activity, TransitActivity.class);
        it.putExtra(HEAD_TITLE,"群组");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至首页
    public static void goHomeActivity(BaseActivity activity){
        Intent it=new Intent(activity, HomeActivity.class);
        it.putExtra(HEAD_TITLE,"集中温控");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
        ActivityManager.getActivity().finishExceptOne(HomeActivity.class);
    }
    //跳转至列表展示界面
    public static void goShowListActivity(BaseActivity activity,String type){
        Intent it=new Intent(activity, ShowListActivity.class);
        it.putExtra(HEAD_TITLE,type);
        it.putExtra(TYPE,type);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至场景详情页
    public static void goSceneDetailActivity(BaseActivity activity,String type){
        Intent it=new Intent(activity, DetailActivity.class);
        it.putExtra(HEAD_TITLE,type+"详情");
        it.putExtra(TYPE,type);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至导入模板1界面
    public static void goFormworkActivity1(BaseActivity activity,String type){
        Intent it=new Intent(activity, FormworkTypeActivity.class);
        it.putExtra(HEAD_TITLE,"模板");
        it.putExtra(TYPE,type);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至授权中心1界面
    public static void goAuthorize1Activity(BaseActivity activity){
        Intent it=new Intent(activity, Authorize1Activity.class);
        it.putExtra(HEAD_TITLE,"授权中心");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至授权中心2界面
    public static void goAuthorize2Activity(BaseActivity activity){
        Intent it=new Intent(activity, Authorize2Activity.class);
        it.putExtra(HEAD_TITLE,"授权中心");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至授权中心3界面
    public static void goAuthorize3Activity(BaseActivity activity){
        Intent it=new Intent(activity, Authorize3Activity.class);
        it.putExtra(HEAD_TITLE,"授权中心");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至反馈页
    public static void goFeedbackActivity(BaseActivity activity){
        Intent it=new Intent(activity, FeedbackActivity.class);
        it.putExtra(HEAD_TITLE,"反馈");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至帮助页
    public static void goHelpActivity(BaseActivity activity){
        Intent it=new Intent(activity, HelpActivity.class);
        it.putExtra(HEAD_TITLE,"帮助");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至手动模式界面
    public static void goManualModeActivity(BaseActivity activity,String type){
        Intent it=new Intent(activity, ManualModeActivity.class);
        it.putExtra(HEAD_TITLE,"手动模式");
        it.putExtra(TYPE,type);
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至个人中心
    public static void goMyCenterActivity(BaseActivity activity){
        Intent it=new Intent(activity, MyCenterActivity.class);
        it.putExtra(HEAD_TITLE,"个人信息");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至我的群组详情界面
    public static void goMyGroupDetailActivity(BaseActivity activity){
        Intent it=new Intent(activity, MyGroupDetailActivity.class);
        it.putExtra(HEAD_TITLE,"群组详情");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至群组列表界面
    public static void goMyGroupListActivity(BaseActivity activity){
        Intent it=new Intent(activity, MyGroupListActivity.class);
        it.putExtra(HEAD_TITLE,"群组列表");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至群组创建界面
    public static void goCreateGroupActivity(BaseActivity activity){
        Intent it=new Intent(activity, CreateGroupActivity.class);
        it.putExtra(HEAD_TITLE,"创建场景");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至采暖季节界面
    public static void goSeasonSetActivity(BaseActivity activity){
        Intent it=new Intent(activity, SeasonSetActivity.class);
        it.putExtra(HEAD_TITLE,"采暖季节设置");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至临时策略界面
    public static void goTempTackActivity(BaseActivity activity){
        Intent it=new Intent(activity, TempTackActivity.class);
        it.putExtra(HEAD_TITLE,"临时策略模板设置");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至启动页
    public static void goWelcomeActivity(BaseActivity activity){
        Intent it=new Intent(activity, WelcomeActivity.class);
        it.putExtra(HEAD_TITLE,"启动加载页");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
    //跳转至周编程界面
    public static void goWeekProgramActivity(BaseActivity activity){
        Intent it=new Intent(activity, WeekProgramActivity.class);
        it.putExtra(HEAD_TITLE,"周编程模板设置");
        activity.startActivity(it);
        ((BaseActivity) activity).overridePendingTransition(R.anim.start_to_activity, R.anim.finish_to_activity);
    }
}
