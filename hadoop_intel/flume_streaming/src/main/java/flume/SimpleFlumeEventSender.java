package flume;

import java.util.ArrayList;
import java.util.Random;

public class SimpleFlumeEventSender {
    public static void main(String[] args){
        MyRpcClientFacade client  = new MyRpcClientFacade();
        client.init("192.168.164.131",9999);
        ArrayList<String> list = new ArrayList<String>();
        list.add("1,18,4,2,1049,1,2,4,2,1,4,2,21,3,1,1,3,1,1,1");
        list.add("1,9,4,0,2799,1,3,2,3,1,2,1,36,3,1,2,3,2,1,1");
        list.add("2,12,2,9,841,2,4,2,2,1,4,1,23,3,1,1,2,1,1,1");
        for(int i = 0 ;i<10;i++){
            String datas = list.get((int)(Math.random()*list.size()));
            client.sendDataToFlume(datas);
        }
        client.cleanUp();
    }
}
