package com.example.greendao.dao;

import android.content.Context;

import com.example.greendao.bean.Device;
import com.example.greendao.gen.DeviceDao;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by huangkangfa on 2017/6/19.
 */

public class SqlDeviceDao extends SqlBaseDao<Device> {

    public SqlDeviceDao(Context context) {
        super(context);
    }

    /**
     * 查询某个ID的对象是否存在
     * @param
     * @return
     */
    public boolean isExitObject(long id){
        QueryBuilder<Device> qb = (QueryBuilder<Device>) daoSession.getDao(Device.class).queryBuilder();
        qb.where(DeviceDao.Properties.Id.eq(id));
        long length = qb.buildCount().count();
        return length>0 ? true:false;
    }
}
