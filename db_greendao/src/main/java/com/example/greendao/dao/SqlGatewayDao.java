package com.example.greendao.dao;

import android.content.Context;

import com.example.greendao.bean.Gateway;
import com.example.greendao.gen.GatewayDao;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by huangkangfa on 2017/6/19.
 */

public class SqlGatewayDao extends SqlBaseDao<Gateway> {

    public SqlGatewayDao(Context context) {
        super(context);
    }

    /**
     * 查询某个ID的对象是否存在
     * @param
     * @return
     */
    public boolean isExitObject(long id){
        QueryBuilder<Gateway> qb = (QueryBuilder<Gateway>) daoSession.getDao(Gateway.class).queryBuilder();
        qb.where(GatewayDao.Properties.Id.eq(id));
        long length = qb.buildCount().count();
        return length>0 ? true:false;
    }
}
