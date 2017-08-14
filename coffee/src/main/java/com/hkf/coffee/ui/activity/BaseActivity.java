package com.hkf.coffee.ui.activity;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

import com.hkf.coffee.ui.ActivityManager;

import java.util.ArrayList;
import java.util.List;

/**
 * APP基础Activity
 * 提供Activity快捷功能
 * Created by huangkangfa on 16/3/23.
 */
public class BaseActivity extends AppCompatActivity {
    public BaseActivity mActivity;
    public LayoutInflater mInflater;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getActivity().add(this);
        mActivity = this;
        mInflater = LayoutInflater.from(this);
    }

    @Override
    protected void onDestroy() {
        ActivityManager.getActivity().remove(this);
        super.onDestroy();
    }

    List<String> temp=new ArrayList<>();
    public void onCallPermission(String[] permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//判断当前系统的SDK版本是否大于23
            boolean isHasPermission=true; //是否所有权限都允许了
            temp.clear();
            for(int i=0;i<permissions.length;i++){
                //如果当前申请的权限没有授权
                if (!(checkSelfPermission(permissions[i]) == PackageManager.PERMISSION_GRANTED)) {
                    //第一次请求权限的时候返回false,第二次shouldShowRequestPermissionRationale返回true
                    //如果用户选择了“不再提醒”永远返回false。
//                    if (shouldShowRequestPermissionRationale(permissions[i])) {
//                        ToastUtil.showShort(this, "这次必须给予许可，否则APP无法使用");
//                    }
                    //请求权限
                    temp.add(permissions[i]);
                    isHasPermission=false;
                }
            }
            if(isHasPermission){
                //已经授权了就走这条分支
                getAllPermissionsInFirstTime();
            }else{
                String[] t=new String[temp.size()];
                for(int i=0;i<temp.size();i++){
                    t[i]=temp.get(i);
                }
                requestPermissions(t,9999);
            }
        }else{
            getAllPermissionsInFirstTime();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == 9999) {
            boolean isHasPermission=true;
            if(permissions.length==temp.size()){
                for(int i=0;i<temp.size();i++){
                    if (permissions[i].equals(temp.get(i)) && grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                        //得到权限之后去做的业务
                    }else{
                        isHasPermission=false;
                    }
                }
                if(isHasPermission){
                    //获得到全部权限
                    getAllPermissionsInOtherTime();
                }else{
                    //没有获得到全部权限
                    getAllPermissionsFail();
                }
            }else{
                //没有获得到全部权限
                getAllPermissionsFail();
            }
        }
    }

    /**
     * 第一次检查就通过的情况下进行的操作
     */
    public void getAllPermissionsInFirstTime(){

    }

    /**
     * 用户允许通过的情况下进行的操作
     */
    public void getAllPermissionsInOtherTime(){

    }

    /**
     * 用户不允许通过的情况下进行的操作
     */
    public void getAllPermissionsFail(){

    }
}
