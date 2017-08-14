package com.hkf.coffee.phone;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;

/**
 * Android振动器工具类
 * Created by huangkangfa on 2017/8/2.
 */

public class VibratorUtil {
    private static Vibrator mVibrator;  //声明一个振动器对象
    public static void init(Context context){
        /**
         * 想设置震动大小可以通过改变pattern来设定，如果开启时间太短，震动效果可能感觉不到
         */
        mVibrator = (Vibrator)context.getSystemService(Service.VIBRATOR_SERVICE);
    }

    /**
     * 是否处于震动中
     * @return
     */
    public static boolean isVibrator(){
        return mVibrator.hasVibrator();
    }

    /**
     * 短暂震动
     */
    public static void startWithShort(){
        start(new long[]{500, 500, 500, 500},false);
    }

    /**
     * 短暂震动
     */
    public static void startWithAlways(){
        start(new long[]{500, 500, 500, 500},true);
    }

    /**
     * 自定义震动
     */
    public static void start(long[] type,boolean isAlways){
        mVibrator.vibrate(type,isAlways?0: -1);
    }

    /**
     * 震动指定时长
     * @param time
     */
    public static void start(long time){
        mVibrator.vibrate(time);
    }

    /**
     * 停止震动
     */
    public static void stop(){
        mVibrator.cancel();
    }
}
