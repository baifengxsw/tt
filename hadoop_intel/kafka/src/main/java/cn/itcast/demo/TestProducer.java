package cn.itcast.demo;



import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.producer.Producer;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class TestProducer {
    //生产者
    @Test
    public  void demo1(){
        Properties props = new Properties();
        //broker列表
        props.put("metadata.broker.list", "slave1:9092,slave2:9092");
        //串行化
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        //同步 异步确认 副本
        props.put("request.required.acks", "1");

        //创建生产者配置对象
        ProducerConfig config = new ProducerConfig(props);

        //创建生产者
        Producer<String, String> producer = new Producer<String, String>(config);

        KeyedMessage<String, String> msg = new KeyedMessage<String, String>("test3","100" ,"hello world tomas100");
        producer.send(msg);
        System.out.println("send over!");
    }

    /**
     * 消费者 要和zk 打交道
     */
    @Test
    public  void demo2(){
        //
        Properties props = new Properties();
        props.put("zookeeper.connect", "slave1:2181");
        //一个组只能有一个消费者消费该消息
        props.put("group.id", "g3");
        props.put("zookeeper.session.timeout.ms", "500");
        props.put("zookeeper.sync.time.ms", "250");
        props.put("auto.commit.interval.ms", "1000");
        props.put("auto.offset.reset", "smallest");
        //创建消费者配置对象
        ConsumerConfig config = new ConsumerConfig(props);
        //
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("test3", new Integer(1));
        //第一个返回一个流
        Map<String, List<KafkaStream<byte[], byte[]>>> msgs = Consumer.createJavaConsumerConnector(new ConsumerConfig(props)).createMessageStreams(map);
        List<KafkaStream<byte[], byte[]>> msgList = msgs.get("test3");
        for(KafkaStream<byte[],byte[]> stream : msgList){
            ConsumerIterator<byte[],byte[]> it = stream.iterator();
            while(it.hasNext()){
                byte[] message = it.next().message();
                System.out.println(new String(message));
            }
        }
    }
}
