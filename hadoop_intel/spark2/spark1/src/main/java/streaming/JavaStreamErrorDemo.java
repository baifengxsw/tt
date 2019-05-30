package streaming;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.function.Function0;
import org.apache.spark.streaming.Duration;
import org.apache.spark.streaming.api.java.JavaDStream;
import org.apache.spark.streaming.api.java.JavaStreamingContext;

public class JavaStreamErrorDemo {
    public static void main(String[] args) throws InterruptedException {
        Function0<JavaStreamingContext> contextFactory = new Function0<JavaStreamingContext>() {
            //首次创建context时调用该方法。
            public JavaStreamingContext call() {
                SparkConf conf = new SparkConf();
                conf.setMaster("local[4]");
                conf.setAppName("wc");
                JavaStreamingContext jssc = new JavaStreamingContext(conf,new Duration(2000*4));
                JavaDStream<String> lines = jssc.socketTextStream("192.168.164.131",9999);

                /*******  变换代码放到此处 ***********/
                JavaDStream<Long> dsCount = lines.countByWindow(new Duration(24 * 60 * 60 * 1000),new Duration(2000));
                dsCount.print();
                //设置检察点目录  下次读取的时候直接就可以从检查点开始读
                jssc.checkpoint("file:///d:/mr/check");
                return jssc;
            }
        };
        //失败重建时会经过检查点。
        JavaStreamingContext context = JavaStreamingContext.getOrCreate("file:///d:/mr/check", contextFactory);

        context.start();
        context.awaitTermination();
    }
}
