package streaming

import java.io.{File, FileWriter}
import java.util.Date

import Utils.HbaseUtils
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.{Durations, StreamingContext}

//进行kafka 和 spark streaming 的集成  然后再进行写入Kafka

object KafkaDemo1 {
  def writeFile (filename:String,value:String):Unit ={
    val writer = new FileWriter(new File(filename),true)
    writer.write(value+"\n" )

    writer.close()
  }

  def main(args: Array[String]): Unit = {

    //初始定义变量
    val topic = "xia"
    val bootstrap_servers = "slave1:9092,slave2:9092"
    val group_id = "testgroup"

    //定义kafka的相关配置
    val kafkaParams = Map[String, Object](
      "bootstrap.servers" -> bootstrap_servers,
      "key.deserializer" -> classOf[StringDeserializer],
      "value.deserializer" -> classOf[StringDeserializer],
      "group.id" -> group_id,
      "auto.offset.reset" -> "earliest",
      "enable.auto.commit" -> (false: java.lang.Boolean)

    )
    //定义spark 配置local 2以上
    val conf = new SparkConf().setAppName("kafka-streaming-hbase").setMaster("local[*]").

      set("spark.serializer", "org.apache.spark.serializer.KryoSerializer") //开启kryo序列化
      .set("spark.streaming.backpressure.enabled", "true") //开启spark 动态反压机制
    //创建实时流上下文
    val ssc = new StreamingContext(conf, Durations.seconds(5))

    //创建实时流[String, String ] 消息 key value 序列化
    val stream = KafkaUtils.createDirectStream(ssc, LocationStrategies.PreferConsistent, ConsumerStrategies.Subscribe[String, String](
      Array[String](topic),
      kafkaParams
    )
    )
    //遍历所有Rdd 进行存储
    stream.foreachRDD(rdd => {
      //cordinator
      //取出位移
      val offsetRange = rdd.asInstanceOf[HasOffsetRanges].offsetRanges
      rdd.foreachPartition(partition => {
        //executer
        val conn = HbaseUtils.getConn("slave1:2181,slave2:2181,slave3:2181")
        partition.foreach(
          perrecord => {

        //writeFile("/root/result.txt",perrecord.value())
          printf(perrecord.value()+"\n")
            //直接设置时间戳为key
            val key = System.currentTimeMillis().toString
          HbaseUtils.addData("default:kafkademo",key,"f1",perrecord.value(),conn)
       })
      })

      //进行提交位移
      stream.asInstanceOf[CanCommitOffsets].commitAsync(offsetRange)
    })
    ssc.start()
    ssc.awaitTermination()

  }

}
