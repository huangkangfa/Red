package com.example.greendao;

import android.content.Context;

import com.example.greendao.dao.SqlCoffeeDao;
import com.example.greendao.dao.SqlDeviceDao;
import com.example.greendao.dao.SqlGatewayDao;

/**
 * Created by huangkangfa on 2017/6/19.
 */

public class SqlDaoManager {
    private  static SqlCoffeeDao coffeeManager;
    private  static SqlDeviceDao deviceManager;
    private  static SqlGatewayDao gatewayManager;
    public  static Context context;

    public static void init(Context context){
        SqlDaoManager.context = context.getApplicationContext();
    }

    /**
     * 单列模式获取CustomerManager对象
     * @return
     */
    public static SqlCoffeeDao getSqlCoffeeDaoInstance(){
        if (coffeeManager == null) {
            coffeeManager = new SqlCoffeeDao(context);
        }
        return coffeeManager;
    }

    public static SqlDeviceDao getSqlDeviceDaoInstance(){
        if (deviceManager == null) {
            deviceManager = new SqlDeviceDao(context);
        }
        return deviceManager;
    }

    public static SqlGatewayDao getSqlGatewayDaoInstance(){
        if (gatewayManager == null) {
            gatewayManager = new SqlGatewayDao(context);
        }
        return gatewayManager;
    }
}
