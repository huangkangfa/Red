package com.hkf.coffee.phone;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.hkf.coffee.others.log.LogUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by huangkangfa on 2017/6/12.
 */

public class InfoUtil {
    private static String mPackageName;  //包名
    private static String mVersionName;  //版本名
    private static int mVersionCode;  //版本code
    private static String mMobileBrand;  //手机品牌
    private static String mMobileModel;  //手机型号
    private static String mUniqueId;  //uuid

    private InfoUtil(){}

    public static void init(Context context){
        try {
            mPackageName=context.getPackageName();
            mVersionName=context.getPackageManager().getPackageInfo(mPackageName, 0).versionName;
            mVersionCode=context.getPackageManager().getPackageInfo(mPackageName, 0).versionCode;
            mMobileModel=android.os.Build.MODEL; // 手机型号
            mMobileBrand=android.os.Build.BRAND; // android系统版本号
            mUniqueId=getUUID(context);
            LogUtil.d("当前手机的UUID："+mUniqueId);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static String getPackageName() {
        return mPackageName;
    }

    public static String getVersionName() {
        return mVersionName;
    }

    public static int getVersionCode() {
        return mVersionCode;
    }

    public static String getMobileBrand() {
        return mMobileBrand;
    }

    public static String getMobileModel() {
        return mMobileModel;
    }

    public static String getUniqueId(){
        return mUniqueId;
    }

    //UUID+设备号序列号 唯一识别码（不可变）
    private static String getUUID(Context context){
        final TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        final String tmDevice, tmSerial, tmPhone, androidId;
        tmDevice = "" + tm.getDeviceId();
        tmSerial = "" + tm.getSimSerialNumber();
        androidId = "" + android.provider.Settings.Secure.getString(context.getContentResolver(),android.provider.Settings.Secure.ANDROID_ID);
        UUID deviceUuid = new UUID(androidId.hashCode(), ((long)tmDevice.hashCode() << 32) | tmSerial.hashCode());
        String uniqueId = deviceUuid.toString();
        return uniqueId;
    }
    /**
     * 获取进程号对应的进程名
     *
     * @param pid 进程号
     * @return 进程名
     */
    public static String getProcessName(int pid) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("/proc/" + pid + "/cmdline"));
            String processName = reader.readLine();
            if (!TextUtils.isEmpty(processName)) {
                processName = processName.trim();
            }
            return processName;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }
}
