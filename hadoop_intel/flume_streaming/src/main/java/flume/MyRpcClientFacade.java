package flume;



import org.apache.flume.Event;
import org.apache.flume.EventDeliveryException;
import org.apache.flume.api.RpcClient;
import org.apache.flume.api.RpcClientFactory;
import org.apache.flume.event.EventBuilder;

import java.nio.charset.Charset;

public class MyRpcClientFacade {
    private RpcClient client;
    private String hostname;
    private int  port;
    //初始化客户端
    public void init(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
        this.client = RpcClientFactory.getDefaultInstance(hostname,port);
    }
    public void sendDataToFlume(String data){
        //创建事件对象
        Event event = EventBuilder.withBody(data, Charset.forName("utf-8"));
        //进行事件的发送
        try {
            client.append(event);
        } catch (EventDeliveryException e) {
            //清除信息，重建Client
            client.close();
            client = null;
            client = RpcClientFactory.getDefaultInstance(hostname,port);
        }

    }

    public void  cleanUp(){
        //关闭rpc 连接
        client.close();
    }


}
