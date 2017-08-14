package com.example.greendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 网关对象
 * Created by huangkangfa on 2017/8/5.
 */
@Entity
public class Gateway {
    @Id(autoincrement = true)
    private Long id;
    @Property(nameInDb ="mac")
    private String mac;     //网关mac
    @Property(nameInDb ="ssid")
    private String ssid;    //网关连接的WiFi名称
    @Property(nameInDb ="pwd")
    private String pwd;     //网关连接的WiFi密码
    @Property(nameInDb ="ip")
    private String ip;      //网关连接的ip地址
    @Property(nameInDb ="port")
    private int port;    //网关连接的端口号
    @Generated(hash = 2076060195)
    public Gateway(Long id, String mac, String ssid, String pwd, String ip,
            int port) {
        this.id = id;
        this.mac = mac;
        this.ssid = ssid;
        this.pwd = pwd;
        this.ip = ip;
        this.port = port;
    }
    @Generated(hash = 727810642)
    public Gateway() {
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
    public String getSsid() {
        return this.ssid;
    }
    public void setSsid(String ssid) {
        this.ssid = ssid;
    }
    public String getPwd() {
        return this.pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public String getIp() {
        return this.ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public int getPort() {
        return this.port;
    }
    public void setPort(int port) {
        this.port = port;
    }
}
