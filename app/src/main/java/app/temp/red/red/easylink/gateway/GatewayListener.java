package app.temp.red.red.easylink.gateway;

/**
 * Created by huangkangfa on 2017/8/5.
 */
public interface GatewayListener {
    //开始搜索
    void startSearchGateway();
    //搜索出不重复网关
    void findNewGateway(GatewayWifi gateway);
    //搜索结束
    void stopSearchGateway();
}
