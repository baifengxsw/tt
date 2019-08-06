package detail_bag.recommovie


import org.apache.spark.SparkConf
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{DoubleType, StringType, StructField, StructType}

object moviebaseddataframe {
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
        println("通过dataFrame 实现某部电影中男性和女性不同年龄人数")
        //首先将列名进行格式化
        val schemaForUsers = StructType("UserID::Gender::Age::OccupationID::Zip-code".split("::").map(x => StructField(x,StringType,true)))
        //初始化数据
        val usersRDDRows = usersRDD.map(x => {val line = x.split("::") ;  Row(line(0).trim ,line(1).trim,line(2).trim,line(3).trim,line(4).trim) })
        // 这时候可以使用sparksession 的createDataFrame 方法
        val usersDataFrame = spark.createDataFrame(usersRDDRows,schemaForUsers)

        //格式化表
        val schemaforratings = StructType("UserID::MovieID".split("::").map( line => StructField(line,StringType,true))).add("Rating",DoubleType,true).add("Timestamp",StringType,true)
        val ratingsRDDRows = ratingsRDD.map(x => { val line = x.split("::"); Row(line(0).trim,line(1).trim,line(2).trim.toDouble,line(3).trim)})

        val ratingsDataFrame = spark.createDataFrame(ratingsRDDRows,schemaforratings)

        //格式化movie 的 dataFrame
        val schemaformovies = StructType("MovieID::Tittle::Genres".split("::").map(line => StructField(line,StringType,true)))
        val movieRDDRows = moviesRDD.map(x =>{ val line = x.split("::") ; Row(line(0).trim,line(1).trim,line(2).trim,line(3).trim)})
        val moviesDataFrame = spark.createDataFrame(movieRDDRows,schemaformovies)

        //这里能够直接通过列名过滤这个电影
        //join 的时候直接指定基于US二ID进行join， 相对于rdd 比较块一点
        val start1 = System.currentTimeMillis()
        ratingsDataFrame.filter("MovieID = 1193").join(usersDataFrame,"UserID").select("Gender","Age").groupBy("Gender","Age").count().show(10)
        val end1 = System.currentTimeMillis()
        println(end1 - start1)
        print("直接通过sql")
        val start2 = System.currentTimeMillis()
        ratingsDataFrame.createTempView("ratings")
        usersDataFrame.createTempView("users")
        val sql = "select Gender,Age,count(*) from ((select UserID,Gender,Age from users) u join ( select UserID from ratings where MovieID = 1193 ) as  r on u.UserID = r.UserID )  group by Gender,Age"
        spark.sql(sql).show(10)
        val end2 = System.currentTimeMillis()
        println(end2 - start2)

    // 如果会话结束，表也会消失， 那么创建一个application的表了  可以使用createGlobal TmepVime  ,同上
    //但是要在sql语句前加上global 语句

    //***** 我们也可以通过隐式转换
    import spark.implicits._
    ratingsDataFrame.select("MovieID","Rating").groupBy("MovieID").avg("Rating").orderBy($"avg(Rating)".desc).show(10)
    // 例如将avg（Rating）作为排序的字段降序排序 order by 传入的列名要一致

    //同时可以转换为rdd 进行相应的处理
    //ratingsDataFrame.rdd
  }
}
