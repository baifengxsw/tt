package detail_bag.recommovie

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * 最受用户喜爱的movie top 10  实现时间戳的和评分的二次排序
  *
  *
  *
  */
object  Movie_Users_Analyzer1 {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Rdd moveice")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    // 读取相应的文件 并进行缓存
    val sc = spark.sparkContext
    //进行日志级别的设置
    sc.setLogLevel("warn")
    val filepath = "file:///E:\\sample\\ml-1m\\ml-1m\\"
    val usersRDD = sc.textFile(filepath + "users.dat")
    val moviesRDD = sc.textFile(filepath + "movies.dat")
    val ratingsRDD = sc.textFile(filepath + "ratings.dat")
    println("所有电影中口碑最好的（平均得分最高）的电影")
    // movie id  + 电影标题
    val pairWithSortkey = ratingsRDD.map(x => {
      val x1 = x.split("::");
      (new SecondarySortKey(x1(3).toDouble, x1(2).toDouble), x)
    })
    //这时候调用sortBykey 此时会按照之前的compare 方法进行排序 并且必须是 相应的k，v对
    val sorted = pairWithSortkey.sortByKey(false)
    sorted.map(x => x._2).take(10).foreach(println)
  }
}