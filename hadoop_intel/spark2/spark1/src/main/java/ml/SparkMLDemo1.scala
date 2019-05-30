package ml
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.ml.param.ParamMap
import org.apache.spark.ml.linalg.{Vector, Vectors}
import org.apache.spark.sql.{Row, SparkSession}

object SparkMLDemo1 {
  def main(args: Array[String]): Unit = {
    //用于dataframe
    val session = SparkSession.builder().appName("ml").master("local[4]").getOrCreate();
    val sc = session.sparkContext;
    //数据目录
    val dataDir = "file:///e:/sample/winequality-red.csv";
    //定义样列类
    case class Wine(FixedAcidity: Double, VolatileAcidity: Double,
                    CitricAcid: Double, ResidualSugar: Double, Chlorides: Double,
                    FreeSulfurDioxide: Double, TotalSulfurDioxide: Double, Density: Double, PH:
                    Double, Sulphates: Double, Alcohol: Double, Quality: Double)

    //进行数据的分割
    val wineDataRDD = sc.textFile(dataDir ).map(_.split(";")).map(w => Wine(w(0).toDouble, w(1).toDouble,
    w(2).toDouble, w(3).toDouble, w(4).toDouble, w(5).toDouble, w(6).toDouble,
    w(7).toDouble, w(8).toDouble, w(9).toDouble, w(10).toDouble,
    w(11).toDouble))
    import session.implicits._
    //转换Rdd 成DataFrame
    val trainingDF = wineDataRDD.map(w => (w.Quality,
      Vectors.dense(w.FixedAcidity, w.VolatileAcidity, w.CitricAcid,
        w.ResidualSugar, w.Chlorides, w.FreeSulfurDioxide, w.TotalSulfurDioxide,
        w.Density, w.PH, w.Sulphates, w.Alcohol))).toDF("label", "features")

    trainingDF.show()
    println("-----------------------------------------------")

    //创建线性回归
    val lr = new LinearRegression()
    //设置最大迭代次数
    lr.setMaxIter(100)

    //通过线性回归拟合 生成模型
    val model = lr.fit(trainingDF)

    //创建内存数据框
    val testDF = session.createDataFrame(Seq((5.0, Vectors.dense(7.4,
      0.7, 0.0, 1.9, 0.076, 25.0, 67.0, 0.9968, 3.2, 0.68,9.8)),(5.0,
      Vectors.dense(7.8, 0.88, 0.0, 2.6, 0.098, 11.0, 34.0, 0.9978, 3.51, 0.56,
        9.4)),(7.0, Vectors.dense(7.3, 0.65, 0.0, 1.2, 0.065, 15.0, 18.0, 0.9968,
      3.36, 0.57, 9.5)))).toDF("label", "features")
    testDF.show()
    println("-----------------------------------------------------------")
    testDF.createOrReplaceTempView("test")
    val tested = model.transform(testDF).select("features", "label",
      "prediction")
    tested.show()
    println("------------------------------------------------------------")
    val featureDF = session.sql("select features from test")
    featureDF.show()
    val tested1 = model.transform(featureDF).select("features","prediction")

    tested1.show()
  }

}
