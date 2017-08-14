package app.temp.red.red.global.cache;

import com.hkf.coffee.cache.SharedPreferenceManager;

/**
 * APP相关缓存
 * Created by huangkangfa on 2017/8/7.
 */
public class AppCache {
    /**
     * 是否是第一次使用这个APP
     * @return
     */
    public static boolean isFirstUsedThisApp(){
        return SharedPreferenceManager.getBooleanCache().get("isFirstUsedThisApp", true);
    }

    /**
     * 设置是否是第一次使用这个APP
     * @param flag
     */
    public static void setFirstUsedThisApp(boolean flag){
        SharedPreferenceManager.getBooleanCache().put("isFirstUsedThisApp",flag);
    }
}
