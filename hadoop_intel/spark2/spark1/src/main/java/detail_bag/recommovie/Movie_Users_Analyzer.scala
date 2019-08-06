package detail_bag.recommovie

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

/**
  * 最受用户喜爱的movie top 10
  *
  *
  */
object  Movie_Users_Analyzer {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Rdd moveice")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    // 读取相应的文件 并进行缓存
    val sc = spark.sparkContext
    //进行日志级别的设置
    sc.setLogLevel("warn")
    val filepath = "file:///E:\\sample\\ml-1m\\ml-1m\\"
    val usersRDD = sc.textFile(filepath+"users.dat")
    val moviesRDD = sc.textFile(filepath +"movies.dat")
    val ratingsRDD = sc.textFile(filepath+"ratings.dat")
    println("所有电影中口碑最好的（平均得分最高）的电影")
    // movie id  + 电影标题
    val movieInfo = moviesRDD.map(_.split("::")).map(x =>(x(0),x(1))).cache()
    //userid ,moviedi , 评级
    val ratings = ratingsRDD.map(_.split("::")).map(x => (x(0),x(1),x(2))).cache()

    //进行map 获取movie 类似（x=>(x._2,(x._3.toDouble,1))
    val movieAndRatings = ratings.map(x=>(x._2,(x._3.toDouble,1))).reduceByKey((x,y) =>(x._1 +y._1,x._2+y._2))

    //计算最终结果
    val movieavgRatings = movieAndRatings.map(x => (x._1,x._2._1 / x._2._2))

    // 与 movie.dat 进行join
    val movielinekRating = movieavgRatings.join(movieInfo).map(x => (x._2._1,x._2._2))
    // 进行排序取前10位()
    val results = movielinekRating.sortBy( x =>  x._1,false).take(10)

    //进行打印

    results.foreach(x => println(x._2 +":评分为"+ x._1))


    println("-----------------------------------------------")
    println("深受男生和女生喜欢的电影")
    // user id   + user gender
    val usergenderMap = usersRDD.map(x => { val a = x .split("::") ; (a(0),a(1))})
    // user  + ( movie id + 评级)
    val ratingMap = ratings.map(x => (x._1,(x._1,x._2,x._3)))

    // 进行连接
    val user_rating = ratingMap.join(usergenderMap).cache()
    // 进行按性别进行分组


    //分别按男女进行分组
    val maleFilteredRatings = user_rating.filter(x => x._2._2 .equals("M")).map(x => x._2._1)
    val femaleFilteredRatings = user_rating.filter(x => x._2._2 .equals("F")).map(x => x._2._1)

    //最受男性喜欢的电影名称
    maleFilteredRatings.map(x => (x._2,(x._3.toDouble,1))).reduceByKey((x,y) =>(x._1+y._1,x._2+y._2))
      .map(x =>(x._1,x._2._1/x._2._2)).join(movieInfo).map(x => (x._2._1,x._2._2)).sortByKey(false).take(10)
      .foreach(x => println(x._2 +":评分为"+ x._1))
  }


}
