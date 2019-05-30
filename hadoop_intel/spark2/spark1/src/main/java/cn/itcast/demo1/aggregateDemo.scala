package cn.itcast.demo1

import org.apache.spark.{SparkConf, SparkContext}


/**
  *
  */
object aggregateDemo {
    def main(args: Array[String]): Unit = {
        //创建Spark配置对象
        val conf = new SparkConf()
          .setAppName("wordcount").setMaster("local[4]") //开几个线程
            val sc = new SparkContext(conf)

            //设置分区
            val dd = sc.parallelize(List((1,3),(1,2),(1, 4),(2,3)))
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

              def seq(a:Int,b:Int) :Int = {
                  math.max(a,b)
              }
                def comb(a:Int,b:Int):Int={
                    a+b
                }
                //1 先对val  对 输入的值 进行大小比较  key （max）值 ，再进行聚合

                dd.aggregateByKey(5)(seq,comb).collect.foreach(print)


    }
}
