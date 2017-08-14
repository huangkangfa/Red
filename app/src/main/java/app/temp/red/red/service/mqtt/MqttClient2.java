package app.temp.red.red.service.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttClientPersistence;
import org.eclipse.paho.client.mqttv3.MqttException;

/**
 * Created by huangkangfa on 2017/7/27.
 */

public class MqttClient2 extends MqttClient {
    public MqttClient2(String serverURI, String clientId) throws MqttException {
        super(serverURI, clientId);
    }

    public MqttClient2(String serverURI, String clientId, MqttClientPersistence persistence) throws MqttException {
        super(serverURI, clientId, persistence);
    }


    public void mySubscribe(String topicFilter, int qos,IMqttActionListener listener) throws MqttException {
        this.mySubscribe(new String[]{topicFilter}, new int[]{qos},listener);
    }

    public void mySubscribe(String[] topicFilters, int[] qos,IMqttActionListener listener) throws MqttException {
        IMqttToken tok = this.aClient.subscribe(topicFilters, qos, (Object)null, listener);
        tok.waitForCompletion(this.getTimeToWait());
        int[] grantedQos = tok.getGrantedQos();

        for(int i = 0; i < grantedQos.length; ++i) {
            qos[i] = grantedQos[i];
        }

        if(grantedQos.length == 1 && qos[0] == 128) {
            throw new MqttException(128);
        }
    }

}
