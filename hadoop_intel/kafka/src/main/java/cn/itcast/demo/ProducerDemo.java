package cn.itcast.demo;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.errors.RetriableException;

import java.util.Properties;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/***
 * 实现kafka 简单的消息设置发送设置，
 */
public class ProducerDemo {



    //simple kafka  producer
    public static void simpleProducer(){
        long start = System.currentTimeMillis();
        Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "slave1:9092,slave2:9092");
        //获得所有副本的确认 ，同步所有副本（0 1 -1（all)）
        kafkaProps.put("acks","all");
        //开启消息的重试 ，会可能造成消息的重复 ，要求再consumer中 进行去重  0.11 版本避免这个问题
        kafkaProps.put("retries",0);
        //发送的每一批 适当的调大 ，有益吞吐量
        kafkaProps.put("batch.size",16384);
        //batch.size 未满也可以进行发送
        kafkaProps.put("linger.ms",1);
        kafkaProps.put("buffer.memory",33554432);
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        final KafkaProducer<String ,String > producer = new KafkaProducer<>(kafkaProps);
        for (int i = 0;i<10000;i++) {
            ProducerRecord<String, String> record = new ProducerRecord<>("xia", "key", String.valueOf(i));//Topic Key Value

            producer.send(record, new Callback() {
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e != null) {//如果Kafka返回一个错误，onCompletion方法抛出一个non null异常（可重试异常，和不可重试异常)。
                        e.printStackTrace();//对异常进行一些处理，这里只是简单打印出来
                        if(e instanceof RetriableException){
                            //处理可重试异常
                        }else {
                            //处理不可重试异常
                        }
                        System.out.println("出现异常");
                    }else{
                        System.out.println(recordMetadata.toString()+"success!");
                        //消息发送成功
                    }
                }
            });//异步发送消息时，
            //传递一个回调对象，该回调对象必须实现org.apahce.kafka.clients.producer.Callback接口
            //生产环境是建议异步的
//        try{
//            producer.send(record).get(); //同步发送消息
//            //使用get 要一直等待下去，直至kafkabroker将发送结果返回给producer （要么发送相应的结果，要么抛出错误
//        } catch(Exception e) {
//            e.printStackTrace();//连接错误、No Leader错误都可以通过重试解决；消息太大这类错误kafkaProducer不会进行任何重试，直接抛出异常
//        }
        }
        producer.close();
        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000);
    }

    //保证发送数据的不重复，不乱序
    public static void perdataSureProducer(){
        long start = System.currentTimeMillis();
        final Properties kafkaProps = new Properties();
        kafkaProps.put("bootstrap.servers", "slave1:9092,slave2:9092");
        //发送缓冲区满 进行阻塞  并不是抛出异常
        kafkaProps.put("max.block.ms",Integer.MAX_VALUE);
        //获得所有副本的确认 ，同步所有副本（0 1 -1（all)）
        kafkaProps.put("acks","-1");
        //开启消息的重试 ，会可能造成消息的重复 ，要求再consumer中 进行去重  0.11 版本避免这个问题
        kafkaProps.put("retries",Integer.MAX_VALUE);
        kafkaProps.put("max.in.flight.requests.per.connection",1);
        kafkaProps.put("batch.size",16384);
        //batch.size 未满也可以进行发送
        kafkaProps.put("linger.ms",1);
        kafkaProps.put("buffer.memory",33554432);
        kafkaProps.put("unclean.leader.election.enable",false);
        kafkaProps.put("replication.factor",3);
        kafkaProps.put("min.insync.replicas",2);
        kafkaProps.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        kafkaProps.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        final KafkaProducer<String ,String > producer = new KafkaProducer<>(kafkaProps);

        public 

        for(int i= 0  ; i< 100000; i++) {

            ProducerRecord<String, String> record = new ProducerRecord<>("xia", "key", String.valueOf(i));//Topic Key Value
            producer.send(record, new Callback() {
                @Override
                public void onCompletion(RecordMetadata recordMetadata, Exception e) {
                    if (e == null) {
                        //发送成功
                        System.out.println(recordMetadata.toString() + "success!");
                    } else {
                        if (e instanceof RetriableException) {
                            //可重试异常
                        } else {
                            //不可重试异常
                        }
                        //这边应该进行处理 ，关闭连接 保存位移 ，然后重新建立连接 ，发送数据
                        //因为没有具体业务 ，没办法具体写
                        producer.close(0L,TimeUnit.MILLISECONDS);

                        //出现错误强制关闭连接
                    }
                }
            });//异步发送消息时，

        }

        producer.close();
        long end = System.currentTimeMillis();
        System.out.println((end - start)/1000);
    }

    public static void main(String[] args) {
        //simpleProducer();
        perdataSureProducer();

    }
}
