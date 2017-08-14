package app.temp.red.red;

import android.support.multidex.MultiDex;

import com.example.greendao.SqlDaoManager;
import com.example.greendao.SqlDbManager;
import com.hkf.coffee.BaseApplication;
import com.hkf.coffee.phone.InfoUtil;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by huangkangfa on 2017/8/5.
 */

public class RedApplication extends BaseApplication{
    @Override
    public void onCreate() {
        super.onCreate();
        /**
         * 解除64k方法数量限制
         */
        MultiDex.install(this);
        /**
         * 数据库相关
         */
        SqlDbManager.getInstance().init(this);
        SqlDaoManager.init(this);
        /**
         * 初始化bugly
         */
        initBugly();
    }

    /**
     * bug远程监控
     */
    private void initBugly() {
        // 获取当前进程名
        String processName = InfoUtil.getProcessName(android.os.Process.myPid());
        // 设置是否为上报进程
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
        strategy.setUploadProcess(processName == null || processName.equals(InfoUtil.getPackageName()));
        // 初始化Bugly
        CrashReport.initCrashReport(getApplicationContext(), "70f6b67156", false, strategy);
    }
}
