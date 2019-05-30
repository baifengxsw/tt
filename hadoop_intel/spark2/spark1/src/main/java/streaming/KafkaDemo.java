package streaming;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Seconds;
import org.apache.spark.streaming.api.java.JavaInputDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import org.apache.spark.streaming.kafka010.ConsumerStrategies;
import org.apache.spark.streaming.kafka010.KafkaUtils;
import org.apache.spark.streaming.kafka010.LocationStrategies;
import scala.Tuple2;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * sparkStream 和kafka 的集成
 */
public class KafkaDemo {

    public static void main(String[] args) throws InterruptedException {

        SparkConf conf = new SparkConf();
        conf.setAppName("wc").setMaster("local[2]");
        JavaStreamingContext streamingContext = new JavaStreamingContext(conf, Seconds.apply(5));
        Map<String, Object> kafkaParams = new HashMap<>();
        kafkaParams.put("bootstrap.servers", "slave1:9092,slave2:9092");
        kafkaParams.put("key.deserializer", StringDeserializer.class);
        kafkaParams.put("value.deserializer", StringDeserializer.class);
        kafkaParams.put("group.id", "g1");
        kafkaParams.put("auto.offset.reset", "latest");
        kafkaParams.put("enable.auto.commit", false);

        Collection<String> topics = Arrays.asList("test1");

        final JavaInputDStream<ConsumerRecord<String, String>> stream =
                KafkaUtils.createDirectStream(
                        streamingContext,
                        LocationStrategies.PreferConsistent(),
                        ConsumerStrategies.<String, String>Subscribe(topics, kafkaParams)
                );

        JavaPairDStream<String,String> ds = stream.mapToPair(
                new PairFunction<ConsumerRecord<String, String>, String, String>() {
                    @Override
                    public Tuple2<String, String> call(ConsumerRecord<String, String> record) {
                        System.out.println("key:"+record.key()+"---value:"+record.value());
                        return new Tuple2<>(record.key(), record.value());
                    }
                });
        ds.print();
        streamingContext.start();
        streamingContext.awaitTermination();

    }
}
