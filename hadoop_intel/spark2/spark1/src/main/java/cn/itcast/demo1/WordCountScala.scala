package cn.itcast.demo1

import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ArrayBuffer


/**
  *
  */
object WordCountScala {
    def main(args: Array[String]): Unit = {
        //创建Spark配置对象
        val conf = new SparkConf()
          .setAppName("wordcount").setMaster("local[4]") //开几个线程
            val sc = new SparkContext(conf)

            //设置分区
            val dd = sc.textFile("e:/1.txt",4).flatMap(_.split("\\s+"))
             /* .mapPartitions(it =>{
                var buffer = new ArrayBuffer[String]()
                val threadName = Thread.currentThread().getName;
                println(threadName +" paration start")
                for (word <- it){
                  println(s" $word  ")
                buffer += ("_"+ word)
              }
              buffer.iterator
            })*/


             val rdd3 =  dd.map(word=>{
                 println(word)
                 (word,1)
             })//reduceByKey(_+_)//.sortBy(-_._2)//.saveAsTextFile("e:/out")
             rdd3.cache()//确实进行了重用
             rdd3.reduceByKey(_+_).foreach(println)
             rdd3.reduceByKey(_+_ ).foreach(println)


    }
}
