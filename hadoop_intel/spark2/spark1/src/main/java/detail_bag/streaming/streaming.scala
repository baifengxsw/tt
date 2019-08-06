package detail_bag.streaming

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object streaming {
  def main(args: Array[String]): Unit = {


    val conf = new SparkConf().setMaster("local[*]").setAppName("StructuredNetworkCount")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    //引入dataFrame
    import spark.implicits._
    //创建流。配置从socket读取数据 地址和端口为localhost:9999
    val lines = spark.readStream.format("socket")
      .option("host", "localhost").option("port", "9999").load()

    //此时的dataFrame 可以使用 as 转化为Dataset
    val words = lines.as[String].flatMap(_.split(" "))
    val wordcount = words.groupBy("value").count()
    //创建查询句柄

    val query = wordcount.writeStream.outputMode("complete").format("console").start()

    query.awaitTermination()
  }

}
