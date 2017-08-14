package app.temp.red.red.global.cache;

import com.hkf.coffee.cache.SharedPreferenceManager;

/**
 * 账户相关缓存
 * Created by huangkangfa on 2017/8/7.
 */
public class UserCache {
    /**
     * 获取上一次登录的用户账号信息
     * @return
     */
    public static String getLastLoginUser(){
        return SharedPreferenceManager.getStringCache().get("login_user");
    }

    /**
     * 获取上一次登录的用户账号的密码信息
     * @return
     */
    public static String getLastLoginPwd(){
        return SharedPreferenceManager.getStringCache().get("login_pwd");
    }
}
