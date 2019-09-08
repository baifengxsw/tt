package flume_sparkstreaming.sparkstreaming

import org.apache.spark.SparkContext
import org.apache.spark.ml.feature.LabeledPoint
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.rdd.RDD

object DataProgress {
  def prepareData(sc:SparkContext,fileName:String):RDD[LabeledPoint] = {
    val creditText = scala.io.Source.fromFile(fileName).mkString;
    val dataLines = creditText.split("\n").slice(1,creditText.size-1);
    val allDataset = sc.parallelize(dataLines).map( line  => {
      val arr = line.split(",").map(t => t.trim()).map( p => p.toDouble)
      new LabeledPoint(arr(0).asInstanceOf[Int],Vectors.dense(arr.slice(1,arr.length-1)))
    })
    allDataset

  }
}
