package app.temp.red.red.easylink.gateway;

import com.hkf.coffee.others.data.DataTypeUtil;

/**
 * Created by huangkangfa on 2017/8/5.
 */

public class JzCmdUtil {
    /*帧头与帧尾*/
    public static final String CMD_HEAD = "2a";
    public static final String CMD_END = "23";
    /*命令标识*/
    public static final String CMD_FLAG_TRANSPARENT = "07"; //命令标识 透传
    public static final String CMD_FLAG_WRITE = "02"; //命令标识写 OD
    public static final String CMD_FLAG_READ = "01";  //命令标识读 OD
    public static final String CMD_FLAG_SCENE = "50";  //命令标识 场景联动设置
    public static final String CMD_FLAG_NETWORK = "60";  //命令标识 入网
    /*指令作用对象*/
    public static final String CMD_ENTRY_ALL_NODE = "ff";  //广播所有设备指令
    public static final String CMD_ENTRY_NODE = "01";  //针对单个设备指令
    public static final String CMD_ENTRY_GATEWAY = "00";  //针对网关指令
    /*索引*/
    public static final String CMD_OD_1001 = "03e9";  //OD类别（1001）
    public static final String CMD_OD_1005 = "03ed";  //OD类别（1005）
    public static final String CMD_OD_1007 = "03ef";  //OD类别（1007）
    public static final String CMD_OD_4010 = "0faa";  //OD类别（4010）
    public static final String CMD_OD_4020 = "0fb4";  //OD类别（4020）
    public static final String CMD_OD_4030 = "0fbe";  //OD类别（4030）
    public static final String CMD_OD_4040 = "0fc8";  //OD类别（4040）
    public static final String CMD_OD_4070 = "0fe6";  //OD类别（4070）
    public static final String CMD_OD_5010 = "1392";  //OD类别（5010）
    public static final String CMD_OD_5020 = "139c";  //OD类别（5020）
    public static final String CMD_OD_5040 = "13b0";  //OD类别（5040）
    public static final String CMD_OD_5060 = "13c4";  //OD类别 (5060)
    public static final String CMD_OD_6001 = "1771";  //OD类别（6001）
    public static final String CMD_OD_6003 = "1773";  //OD类别（6003）

    //单址读取网关的zigbee的mac地址
    public static String getCmdLoginFrame_OnlyZbMac(){
        return addShellForCmd(CMD_FLAG_READ+CMD_ENTRY_GATEWAY+"0000000000000000"+CMD_OD_5010+"07");
    }
    //解析单址读取网关的zigbee的MAC地址的指令，获取mac
    public static String getZbMacFromFrame(String data){
        if(data.length()==50&&data.substring(26,28).equals("07")&&data.substring(28,30).equals("08")){
            return data.substring(30,46);
        }
        return "0000000000000000";
    }

    /**
     * 给指定字符串加壳
     */
    public static String addShellForCmd(String cmd) {
        return CMD_HEAD + DataTypeUtil.decimalToHex(cmd.length() / 2) + cmd + getAddCheck(cmd) + CMD_END;
    }

    //加法和校验值
    private static String getAddCheck(String checkStr) {
        byte[] data = DataTypeUtil.hexStringToBytes(checkStr);
        byte addSum = 0;
        for (int i = 0; i < data.length; i++) {
            addSum += data[i];
        }
        return String.format("%02x", addSum & 0xff);
    }
}
