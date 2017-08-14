package com.example.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 设备对象
 * Created by huangkangfa on 2017/8/5.
 */
@Entity
public class Device {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb ="mac")
    private String mac;  //自身mac地址
    @Property(nameInDb ="od")
    private String od;  //OD索引
    @Property(nameInDb ="deviceType")
    private String deviceType;  //设备类别
    @Property(nameInDb ="sensorType")
    private String sensorType;  //产品类型
    @Property(nameInDb ="area")
    private String area;  //硬件所在区域
    @Property(nameInDb ="signalIntensity")
    private String signalIntensity;  //信号强度
    @Property(nameInDb ="connectionQuality")
    private String connectionQuality;  //连接质量
    @Property(nameInDb ="others")
    private String others;  //剩余参数

    @Property(nameInDb ="gatewayMac")
    private String gatewayMac;  //网关mac地址
    @Property(nameInDb ="updateTime")
    private String updateTime; //更新时间
    @Property(nameInDb ="whichType")
    private int whichType;  //何种类型   0：其他  1：执行设备   2：触发源设备


    @Generated(hash = 1216885173)
    public Device(Long id, String mac, String od, String deviceType,
            String sensorType, String area, String signalIntensity,
            String connectionQuality, String others, String gatewayMac,
            String updateTime, int whichType) {
        this.id = id;
        this.mac = mac;
        this.od = od;
        this.deviceType = deviceType;
        this.sensorType = sensorType;
        this.area = area;
        this.signalIntensity = signalIntensity;
        this.connectionQuality = connectionQuality;
        this.others = others;
        this.gatewayMac = gatewayMac;
        this.updateTime = updateTime;
        this.whichType = whichType;
    }

    @Generated(hash = 1469582394)
    public Device() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMac() {
        return this.mac;
    }
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getOd() {
        return this.od;
    }
    public void setOd(String od) {
        this.od = od;
    }
    public String getDeviceType() {
        return this.deviceType;
    }
    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    public String getSensorType() {
        return this.sensorType;
    }
    public void setSensorType(String sensorType) {
        this.sensorType = sensorType;
    }
    public String getArea() {
        return this.area;
    }
    public void setArea(String area) {
        this.area = area;
    }
    public String getSignalIntensity() {
        return this.signalIntensity;
    }
    public void setSignalIntensity(String signalIntensity) {
        this.signalIntensity = signalIntensity;
    }
    public String getConnectionQuality() {
        return this.connectionQuality;
    }
    public void setConnectionQuality(String connectionQuality) {
        this.connectionQuality = connectionQuality;
    }
    public String getOthers() {
        return this.others;
    }
    public void setOthers(String others) {
        this.others = others;
    }
    public String getGatewayMac() {
        return this.gatewayMac;
    }
    public void setGatewayMac(String gatewayMac) {
        this.gatewayMac = gatewayMac;
    }
    public String getUpdateTime() {
        return this.updateTime;
    }
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
    public int getWhichType() {
        return this.whichType;
    }
    public void setWhichType(int whichType) {
        this.whichType = whichType;
    }
}
