package cn.itcast.demo1

import org.apache.spark.{SparkConf, SparkContext}


/**
  *
  */
object PipeDemo {
    def main(args: Array[String]): Unit = {
        //创建Spark配置对象
        val conf = new SparkConf()
          .setAppName("wordcount").setMaster("local[4]") //开几个线程
        val sc = new SparkContext(conf)
        val rdd = sc.parallelize(Array("d:\\","e:\\"))
        val rdd1 = rdd.pipe("dir d:\\")
        rdd1.collect().foreach(println)


    }
}
