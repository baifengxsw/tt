package streaming

import org.apache.spark.SparkConf
import org.apache.spark.streaming.{Seconds, StreamingContext}

object StreamDemo {
  def main(args: Array[String]): Unit = {
    //local 必须大于2
    val conf = new SparkConf().setMaster("local[2]").setAppName("NetworkWordCount")
    //创建流的上下文 批次时长的话1s
    val ssc = new StreamingContext(conf, Seconds(1))
    //创建socket 文本流
    val lines = ssc.socketTextStream("192.168.164.131", 9999)
    //分割
    val words = lines.flatMap(_.split(" "))

    val pairs = words.map(word => (word, 1))

    val wordCounts = pairs.reduceByKey(_ + _)

    wordCounts.print()
    //开始计算
    ssc.start();
    //等待结束
    ssc.awaitTermination();
  }

}
