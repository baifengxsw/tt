package detail_bag.recommovie

import org.apache.spark.SparkConf
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}
import org.apache.spark.sql.{Row, SparkSession}
case class User(UserID:String,Gender:String,Age:String,OccupationID:String,Zip_Code:String)
case class Rating(UserID:String,MovieID:String,Rating:Double,Timestamp:String)

object moviebaseddataset {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Rdd moveice")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    import spark.implicits._
    // 读取相应的文件 并进行缓存
    val sc = spark.sparkContext
    //进行日志级别的设置
    sc.setLogLevel("warn")
    val filepath = "file:///E:\\sample\\ml-1m\\ml-1m\\"
    val usersRDD = sc.textFile(filepath + "users.dat")
    val moviesRDD = sc.textFile(filepath + "movies.dat")
    val ratingsRDD = sc.textFile(filepath + "ratings.dat")
    println("通过dataFrame 实现某部电影中男性和女性不同年龄人数")
    val usersForDSRDD = usersRDD.map(_.split("::")).map(line => User(line(0).trim, line(1).trim, line(2).trim, line(3).trim, line(4).trim))
    val usersDataSet = spark.createDataset(usersForDSRDD)
    usersDataSet.show(10)

    val ratingsForDSRDD = ratingsRDD.map(_.split("::")).map(line => Rating(line(0).trim, line(1).trim, line(2).trim.toDouble, line(3).trim))
    val ratingsDataSet = spark.createDataset(ratingsForDSRDD)

    //join 的时候直接指定基于US二ID进行join， 相对于rdd 比较块一点

    ratingsDataSet.filter(s"MovieID = 1193").join(usersDataSet, "UserID").select("Gender", "Age").groupBy("Gender", "Age").count().show(10)
    

  }
}