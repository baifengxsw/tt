package flume_sparkstreaming.sparkstreaming

import org.apache.spark.SparkConf
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.classification.RandomForestClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.Binarizer
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.tuning.{CrossValidator, ParamGridBuilder}
import org.apache.spark.sql.SparkSession

object CreditsModel {
  def main(array: Array[String]): Unit ={
    val conf:SparkConf = new SparkConf().setAppName("creditsScoringtest").setMaster("local[4]")
    val session  = SparkSession.builder().config(conf).getOrCreate()
    val sc = session.sparkContext
    import session.implicits._
    val filename = "e:\\flume\\german_credit.csv"
    val trainData = DataProgress.prepareData(sc,filename).toDF()

    val binarizer = new Binarizer().setInputCol("features").setOutputCol("binaryFeatures").setThreshold(0.1)
    val rf = new RandomForestClassifier().setNumTrees(20).setFeaturesCol("binaryFeatures").setMaxDepth(100)

    val evaluator = new MulticlassClassificationEvaluator()
    val pipeLine = new Pipeline().setStages(Array(binarizer,rf))
    val paramGrid = new ParamGridBuilder().addGrid(rf.maxDepth,Array(3,5,8)).build()

    val cv = new  CrossValidator().setEstimator(pipeLine).setEvaluator(evaluator).setEstimatorParamMaps(paramGrid)

    val cvModel = cv.fit(trainData)
    cvModel.avgMetrics
    cvModel.save("file:///e:/flume/result/out")
  }

}
