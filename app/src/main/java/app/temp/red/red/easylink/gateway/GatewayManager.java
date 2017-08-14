package app.temp.red.red.easylink.gateway;

import android.content.Context;
import android.util.Log;

import com.hkf.coffee.others.data.DataTypeUtil;
import com.hkf.coffee.others.log.LogUtil;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import app.temp.red.red.easylink.EasyLinkWifiManager;
import app.temp.red.red.easylink.FirstTimeConfig;
import app.temp.red.red.easylink.FirstTimeConfigListener;

/**
 * Created by huangkangfa on 2017/8/5.
 */

public class GatewayManager implements FirstTimeConfigListener{
    private Context context;

    //easylink配置
    private FirstTimeConfig firstConfig; //easylink首次设置
    private EasyLinkWifiManager mWifiManager; //easylink管理者

    //IP地址获取
    private MulticastSocket multicastSocket; //ip组播端口
    private InetAddress serverAddress; //ip组播地址
    private Thread tr, ts; //接收跟发送线程

    //获取该局域网下的wifi网关设备信息的ip组播地址
    public static final String MulticastSocketIp="255.255.255.255";
    //获取该局域网下的wifi网关设备信息的组播端口号
    public static final int MulticastSocketPort=8089;
    //获取该局域网下的wifi网关设备信息
    public static final String MulticastSocketData="21000A000000D4FFFFFF";

    private List<GatewayWifi> DATA=new ArrayList<GatewayWifi>(); //网关数据
    private String SSID; //WiFi名称
    private String PWD; //WiFi密码
    private int PORT=8686;  //连接网关的端口号

    //扫描时间配置
    private int sum=0;  //累计搜索到相同网关的次数
    private int repeat_num=2;  //搜索网关的重复次数

    private boolean isConfigGatewayNet=false;  //是否网关组网中
    private boolean isSearchGateway=false;  //是否搜索网关中

    //网关监听
    private GatewayListener listener;

    /**
     * 实例化
     * @param context
     */
    public GatewayManager(Context context){
        this.context=context;
        this.SSID="";
        this.PWD="";
    }

    @Override
    public void onFirstTimeConfigEvent(FtcEvent paramFtcEvent, Exception paramException) {

    }

    /**
     *  获取网关信息初始化设置
     */
    private void initFirstConnfig() {
        try {
            multicastSocket = new MulticastSocket(MulticastSocketPort);
            serverAddress = InetAddress.getByName(MulticastSocketIp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ts = new Thread() {
            @Override
            public void run() {
                byte[] data = DataTypeUtil.hexStringToBytes(MulticastSocketData);
                while (isSearchGateway) {
                    DatagramPacket dp = new DatagramPacket(data, 0, data.length, serverAddress,MulticastSocketPort);
                    try {
                        multicastSocket.send(dp);
                        Thread.sleep(2500);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        tr = new Thread() {
            @Override
            public void run() {
                byte[] data = new byte[1024];
                while (isSearchGateway) {
                    DatagramPacket dp = new DatagramPacket(data, data.length);
                    try {
                        multicastSocket.receive(dp);
                        synchronized (this){
                            if (!DataTypeUtil.bytes2HexString(dp.getData(), dp.getData().length).contains(MulticastSocketData)) {
                                String s = DataTypeUtil.bytes2HexString(dp.getData(), dp.getData().length);
                                Log.d("搜索网关","接收到的数据："+s);
                                GatewayWifi gateway = getGatewayByString(s);
                                Log.d("数据解析","网关数据："+gateway.toString());
                                boolean f = true;
                                for (int i = 0; i < DATA.size(); i++)
                                    if (DATA.get(i).getIp().equals(gateway.getIp())) {
                                        f = false;
                                        if(sum>=repeat_num){
                                            //网关搜索完成,停止搜索
                                            stopSearchGateway();
                                        }else{
                                            sum++;
                                        }
                                        break;
                                    }
                                if (f) {
                                    //搜索出一个新的网关，添加
                                    gateway = setZbMac(gateway);
                                    DATA.add(gateway);
                                    if(listener!=null){
                                        listener.findNewGateway(gateway);
                                    }
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }

    //登入帧赋值ZigBee的mac
    private GatewayWifi setZbMac(GatewayWifi gateway) {
        try {
            Socket socket = new Socket(gateway.getIp(), PORT);
            socket.isConnected();
            OutputStream out = socket.getOutputStream();
            InputStream in = socket.getInputStream();
            out.write(DataTypeUtil.hexStringToBytes(JzCmdUtil.getCmdLoginFrame_OnlyZbMac())); //单址读取mac地址
            out.flush();
            int len = 0;
            byte[] buffer = new byte[1024];
            String tmpBuffer = "";
            if ((len = in.read(buffer)) > 0) {
                tmpBuffer = DataTypeUtil.bytes2HexString(buffer, len);
                String zb=JzCmdUtil.getZbMacFromFrame(tmpBuffer); //获取单址读取的mac地址
                StringBuffer zb_mac = new StringBuffer("");
                zb_mac.append(zb.substring(0, 2)).append(":")
                        .append(zb.substring(2, 4)).append(":")
                        .append(zb.substring(4, 6)).append(":")
                        .append(zb.substring(6, 8)).append(":")
                        .append(zb.substring(8, 10)).append(":")
                        .append(zb.substring(10, 12));
                gateway.setZb_mac(zb_mac.toString());
            }
            try {
                out.close();
                in.close();
                if (socket != null) {
                    socket.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gateway;
    }

    /**
     * easylink网关组网配置
     */
    private FirstTimeConfig getFirstTimeConfigInstance(FirstTimeConfigListener apiListener) throws Exception {
        byte[] totalBytes = null;
        SSID=getWiFiManagerInstance().getCurrentSSID();
        return new FirstTimeConfig(apiListener,PWD, totalBytes, getWiFiManagerInstance().getGatewayIpAddress(),SSID,"EMW3162");
    }
    public EasyLinkWifiManager getWiFiManagerInstance() {
        if (mWifiManager == null) {
            mWifiManager = new EasyLinkWifiManager(context);
        }
        return mWifiManager;
    }

    //获取网关设备信息
    public GatewayWifi getGatewayByString(String data) {
        data = data.trim().toLowerCase();
        GatewayWifi gateway = null;
        if (data.contains("21005400010089ff")) {
            data = data.substring(16, data.length() - 4);
            String[] temp = new String[3];
            temp[0] = data.substring(0, 32);  //ip
            temp[1] = data.substring(32, 68);  //mac
            temp[2] = data.substring(68, 148);  //device_name
            //获取ip
            String[] temp_ip = temp[0].split("2e");
            StringBuffer ip = new StringBuffer("");
            for (int i = 0; i < temp_ip.length; i++) {
                if (i != temp_ip.length - 1)
                    ip.append(StringUtil.getIpNum(temp_ip[i]));
                else ip.append(StringUtil.getIpNum(StringUtil.getDataEndWithoutZero((temp_ip[i]))));
                if (i != temp_ip.length - 1)
                    ip.append(".");
            }
            //获取mac
            String[] temp_mac = temp[1].split("2d");
            StringBuffer mac = new StringBuffer("");
            for (int i = 0; i < temp_mac.length; i++) {
                temp_mac[i] = temp_mac[i].substring(0, 4);
                mac.append((char) DataTypeUtil.hexStringToBytes(temp_mac[i].substring(0, 2))[0]).append((char) DataTypeUtil.hexStringToBytes(temp_mac[i].substring(2, 4))[0]);
                if (temp_mac.length - 1 != i)
                    mac.append(":");
            }
            //获取device_name
            StringBuffer device_name = new StringBuffer("");
            device_name.append(DataTypeUtil.hexStringToBytes(StringUtil.getDataEndWithoutZero(temp[2])));
            gateway = new GatewayWifi(ip.toString(), mac.toString(), "0:0:0:0:0:0",SSID);
        }
        return gateway;
    }

    /**
     * 开始搜索网关
     */
    public void startSearchGateway() {
        if (!isSearchGateway) {
            new Thread(){
                @Override
                public void run() {
                    super.run();
                    LogUtil.d("开始搜索网关");
                    isSearchGateway=true;
                    DATA.clear();
                    initFirstConnfig();
                    ts.start();
                    tr.start();
                    if(listener!=null){
                        listener.startSearchGateway();
                    }
                }
            }.start();
        }
    }

    /**
     * 停止搜索
     */
    public void stopSearchGateway() {
        if (isSearchGateway) {
            LogUtil.d("停止搜索网关");
            isSearchGateway=false;
            sum=0;
            tr = null;
            ts = null;
            if(listener!=null){
                listener.stopSearchGateway();
            }
        }
    }

    /**
     * 开始组网
     */
    public void startGatewayNetSet() {
        if (!isConfigGatewayNet) {
            isConfigGatewayNet=true;
            try {
                firstConfig = getFirstTimeConfigInstance(this);
                firstConfig.transmitSettings();
                LogUtil.d("开始组网(ssid:"+SSID+"     pwd:"+PWD+")");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 停止组网
     */
    public void stopGatewayNetSet(){
        if (isConfigGatewayNet) {
            isConfigGatewayNet=false;
            try {
                if (firstConfig != null) {
                    firstConfig.stopTransmitting();
                    LogUtil.d("停止组网");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 设置WiFi密码
     */
    public void setWifiPwd(String PWD){
        this.PWD=PWD;
    }

    /**
     * 设置连接网关的端口号
     */
    public void setPort(int Port){
        PORT=Port;
    }

    /**
     * 设置搜索网关的重复次数
     * @param num
     */
    public void setRepeatNum(int num){
        repeat_num=num;
    }

    /**
     * 网关监听设置
     */
    public void setListener(GatewayListener listener){
        this.listener=listener;
    }

    /**
     * 获取现有网关数据
     */
    public List<GatewayWifi> getGatewayListNow(){
        return DATA;
    }
}
