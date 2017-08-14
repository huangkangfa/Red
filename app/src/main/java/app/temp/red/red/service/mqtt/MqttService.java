package app.temp.red.red.service.mqtt;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import app.temp.red.red.service.mqtt.interfaces.MqttConnectListener;

/**
 * Created by huangkangfa on 2017/6/20.
 */

public class MqttService extends Service implements MqttCallback,MqttConnectListener {

    @Override
    public void onCreate() {
        super.onCreate();
        EventBusUtil.register(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        MqttUtil.getInstance().setMqttConnectListener(this);
        MqttUtil.getInstance().startConnect();
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    /**
     * 丢失连接监听
     * @param throwable
     */
    @Override
    public void connectionLost(Throwable throwable) {
        MqttUtil.getInstance().connect();
    }

    /**
     * 接收订阅的消息
     * @param s
     * @param mqttMessage
     * @throws Exception
     */
    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

    }

    /**
     * 发送数据成功后执行
     */
    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }

    /**
     * mqtt服务器连接成功
     */
    @Override
    public void success() {

    }

    /**
     * mqtt服务器连接失败
     */
    @Override
    public void failed() {

    }

    /**
     * 服务摧毁时监听
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        MqttUtil.getInstance().stopConnect();
        EventBusUtil.unregister(this);
    }
}
