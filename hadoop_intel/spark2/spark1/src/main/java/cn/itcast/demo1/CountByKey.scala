package cn.itcast.demo1

import org.apache.spark.{SparkConf, SparkContext}

object CountByKey {
  def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("123").setMaster("local[3]")
      val sc = new SparkContext(conf)
      val ss = sc.textFile("e:/1.txt").flatMap(_.split("\\s+")).map((_,1))
      //这里不需要collect 因为 countByKey 是action
     ss.countByKey().foreach(println)
  }
}
