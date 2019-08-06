package cn.itcast.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

public class ComsumerDemo {
    public  static void simpleComsumer(){
        Properties props = new Properties();
        props.put("bootstrap.servers","slave1:9092,slave2:9092");
        props.put("group.id","xia");
        props.put("enable.auto.commit","true");
        props.put("auto.commit.interval.ms","1000");
        props.put("key.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer","org.apache.kafka.common.serialization.StringDeserializer");
        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList("xia"));
        try {
            while (true) {
                //要么拿到默认的500条 ，要么超时返回
                ConsumerRecords<String, String> records = consumer.poll(1000);
                for (ConsumerRecord<String, String> record : records) {
                    System.out.println("offset:" + record.offset() + "---" + "key:" + record.key() + "----" + "value:" + record.value());
                }

        }  }finally {
            consumer.close();
        }
    }

    public static void main(String[] args) {
        simpleComsumer();
    }
}
