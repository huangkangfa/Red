package com.hkf.coffee;

import android.app.Application;
import android.content.Context;

import com.hkf.coffee.bitmap.BitmapManager;
import com.hkf.coffee.jars.nohttp.NoHttp;
import com.hkf.coffee.phone.ScreenUtil;
import com.hkf.coffee.phone.VibratorUtil;

/**
 * Created by huangkangfa on 2017/3/14 0014.
 */
public class BaseApplication extends Application{
    protected static Context context;  //全局上下文对象

    /**
     * 每次app开启会调用
     */
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        ScreenUtil.init(context);  //手机屏幕相关信息获取
        BitmapManager.init(context); //图片设置初始化
        NoHttp.init(this);   //网络工具初始化
        VibratorUtil.init(context); //震动初始化
    }

    /**
     * 全局上下文对象
     */
    public static Context getContext() {
        return context;
    }
}
