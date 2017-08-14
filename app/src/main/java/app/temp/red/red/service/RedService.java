package app.temp.red.red.service;

import android.content.Intent;

import com.hkf.coffee.others.log.LogUtil;
import com.hkf.coffee.phone.InfoUtil;

import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import app.temp.red.red.global.AllURL;
import app.temp.red.red.service.mqtt.MqttService;
import app.temp.red.red.service.mqtt.MqttUtil;
import app.temp.red.red.service.mqtt.entry.MqttMsg;
import app.temp.red.red.service.mqtt.entry.MqttQosLevel;

/**
 * Created by huangkangfa on 2017/8/5.
 */

public class RedService extends MqttService{
    private static final String TAG="红杉树服务";
    
    private static String clientId;            //客户端id

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.d(TAG+"成功创建");
        clientId = InfoUtil.getUniqueId().substring(InfoUtil.getUniqueId().length() - 10, InfoUtil.getUniqueId().length()) + System.currentTimeMillis();
        if (clientId.length() > 23) {
            clientId = clientId.substring(0, 23);
        }
        MqttUtil.getInstance().initMqtt(AllURL.MQTTHOST, AllURL.USERNAME, AllURL.PASSWORD, clientId, this);
        MqttUtil.getInstance().setQos(MqttQosLevel.AtLeastOnce.getVal());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * 丢失连接监听
     * @param throwable
     */
    @Override
    public void connectionLost(Throwable throwable) {
        super.connectionLost(throwable);  //断开重连已经设置了
        LogUtil.d(TAG+"mqtt服务断开重连");
    }

    /**
     * 接收订阅的消息
     * @param s
     * @param mqttMessage
     * @throws Exception
     */
    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {
        super.messageArrived(s, mqttMessage);
        String result=new String(mqttMessage.getPayload(), "utf-8");
        LogUtil.d(TAG+"接收mqtt数据："+result);
    }

    /**
     * mqtt服务器连接成功
     */
    @Override
    public void success() {
        super.success();
        LogUtil.d(TAG+"的mqtt连接成功");
    }

    /**
     * mqtt服务器连接失败
     */
    @Override
    public void failed() {
        super.failed();
        LogUtil.d(TAG+"的mqtt连接失败");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG+"成功销毁");
//        startService(new Intent(this, RedService.class));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMainEvent(MqttMsg event) {

    }
}
