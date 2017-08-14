package com.example.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 简单示例实体类
 * Created by huangkangfa on 2017/6/19.
 */
@Entity
public class Coffee {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb ="NAME")
    private String name;
    @Property(nameInDb = "DESCRIBE")
    private String describe;
    @Generated(hash = 310358320)
    public Coffee(Long id, String name, String describe) {
        this.id = id;
        this.name = name;
        this.describe = describe;
    }
    @Generated(hash = 1336473093)
    public Coffee() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescribe() {
        return this.describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
