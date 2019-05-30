package cn.itcast.demo1

import org.apache.spark.{SparkConf, SparkContext}

import scala.util.Random

object DateLean {
  def main(args: Array[String]): Unit = {
      val conf = new SparkConf()
      conf.setAppName("datelean").setMaster("local[3]")
      val sc = new SparkContext(conf)
      val map1 = sc.textFile("e:/1.txt",3).flatMap(_.split("\\s+")).map(x=>{
          val random = new Random()
          val key = x+":"+random.nextInt(100)
          println((key,1))
        (key,1)
      })
      val reduce1 = map1.reduceByKey(_+_,4)
       reduce1.collect().foreach(println)
    //进行第二次map reduce
    val map2 = reduce1.map(x=>{
        val value = x._2
        val arr = x._1.split(":")
      (arr(0),value)
    })
    val result = map2.reduceByKey(_+_,4).collect().foreach(println)

  }

}
