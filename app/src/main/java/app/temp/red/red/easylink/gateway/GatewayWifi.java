package app.temp.red.red.easylink.gateway;

/**
 * Created by Administrator on 2016/8/28 0028.
 * 网关信息对象
 */
public class GatewayWifi {
    private String ip;
    private String mac;
    private String zb_mac;
    private String ssid;

    public GatewayWifi() {
    }
    public GatewayWifi(String ip, String mac, String zb_mac, String ssid) {
        this.ip = ip;
        this.mac = mac;
        this.zb_mac = zb_mac;
        this.ssid=ssid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getZb_mac() {
        return zb_mac;
    }

    public void setZb_mac(String zb_mac) {
        this.zb_mac = zb_mac;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    @Override
    public String toString() {
        return "GatewayWifi{" +
                "ip='" + ip + '\'' +
                ", mac='" + mac + '\'' +
                ", zb_mac='" + zb_mac + '\'' +
                ", ssid='" + ssid + '\'' +
                '}';
    }
}
