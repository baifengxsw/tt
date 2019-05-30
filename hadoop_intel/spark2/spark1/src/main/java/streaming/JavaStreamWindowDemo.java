package streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.Optional;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.streaming.Seconds;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaPairDStream;
import org.apache.spark.streaming.api.java.JavaReceiverInputDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;
import scala.Tuple2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JavaStreamWindowDemo {
    public static void main(String[] args) throws InterruptedException {
        SparkConf conf = new SparkConf();
                conf.setAppName("wc").setMaster("local[2]");
        JavaStreamingContext jsc = new JavaStreamingContext(conf, Seconds.apply(5));
        jsc.checkpoint("file:///e:/mr/");
        JavaReceiverInputDStream sock = jsc.socketTextStream("192.168.164.131",9999);
        JavaDStream<String> words = sock.flatMap(new FlatMapFunction<String,String>() {
            @Override
            public Iterator call(String str) throws Exception {
                List<String> list = new ArrayList<>();
                String[] arr = str.split("\\s+");
                for(String str1:arr){
                    list.add(str1);
                }
                return list.iterator();
            }
        });

        //映射
        JavaPairDStream<String ,Integer> jpd = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return  new Tuple2<String,Integer>(s,1);
            }
        });
        //按key和窗口进行聚合
        JavaPairDStream<String,Integer> counts = jpd.reduceByKeyAndWindow(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer v1, Integer v2) throws Exception {
                return v1+v2;
            }
        },Seconds.apply(15),Seconds.apply(10)); //4秒算一次

        //进行打印
        counts.print();
        jsc.start();
        jsc.awaitTermination();

    }
}
