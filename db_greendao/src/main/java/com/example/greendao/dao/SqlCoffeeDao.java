package com.example.greendao.dao;

import android.content.Context;

import com.example.greendao.bean.Coffee;
import com.example.greendao.gen.CoffeeDao;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by huangkangfa on 2017/6/19.
 */

public class SqlCoffeeDao extends SqlBaseDao<Coffee> {

    public SqlCoffeeDao(Context context) {
        super(context);
    }

    /**
     * 查询某个ID的对象是否存在
     * @param
     * @return
     */
    public boolean isExitObject(long id){
        QueryBuilder<Coffee> qb = (QueryBuilder<Coffee>) daoSession.getDao(Coffee.class).queryBuilder();
        qb.where(CoffeeDao.Properties.Id.eq(id));
        long length = qb.buildCount().count();
        return length>0 ? true:false;
    }
}
