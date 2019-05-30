package cn.itcast.demo1

import org.apache.spark.{SparkConf, SparkContext}


/**
  *
  */
object CoGroupDemo {
    def main(args: Array[String]): Unit = {
        //创建Spark配置对象
        val conf = new SparkConf()
          .setAppName("wordcount").setMaster("local[4]") //开几个线程
            val sc = new SparkContext(conf)
        //读取2 .txt
        val file2 = sc.textFile("e:/2.txt").map(x=> {
           val arr = x.split(" ")
          (arr(0),arr(1))
        })
      //读取3.txt
        val file3 = sc.textFile("e:/3.txt").map(x=> {
           val arr = x.split(" ")
          (arr(0),arr(1))
        })

      file2.cogroup(file3).collect.foreach(x=>{
          println(x._1 + "--------" +x._2)

      })


    }
}
