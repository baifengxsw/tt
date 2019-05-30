package cn.itcast.demo1

import org.apache.spark.{SparkConf, SparkContext}


/**
  *
  */
object CartesianDemo {
    def main(args: Array[String]): Unit = {
        //创建Spark配置对象
        val conf = new SparkConf()
          .setAppName("wordcount").setMaster("local[4]") //开几个线程
            val sc = new SparkContext(conf)
          val rdd1 = sc.parallelize(Array("tmom","xia","wu"))
          val rdd3 = sc.parallelize(Array(1,2,3))
         rdd1.cartesian(rdd3).foreach(println)


    }
}
