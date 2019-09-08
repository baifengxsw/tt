package flume_sparkstreaming.sparkstreaming

import org.apache.spark.SparkConf
import org.apache.spark.ml.linalg.Vectors
import org.apache.spark.ml.tuning.CrossValidatorModel
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.flume.FlumeUtils
import org.apache.spark.streaming.{Milliseconds, StreamingContext, Time}

/**
  * 实时读取flumue数据并加载实时信用
  */
class StreamingCreditScoring {

}
case class  Record(features: org.apache.spark.ml.linalg.Vector)
object  StreamingCreditScoring{
  def main(args: Array[String]): Unit = {
    //  StreamingCreditScoring.setStreamingLogLevels()
    // val Array(host, IntParam(port)) = args
    val batchInterval = Milliseconds(10000)
    //create the context and set the batch size
    val conf = new SparkConf().setAppName("FlumeEventCount").setMaster("local[*]")
    val ssc = new StreamingContext(conf,batchInterval)

    //create a flume stream
    val stream = FlumeUtils.createStream(ssc,"172.22.8.157",55555,StorageLevel.MEMORY_AND_DISK_SER_2)
    val streamEvent = stream.map(e =>{ println(1) ;new String(e.event.getBody.array())})
     val creditRDD = streamEvent.flatMap(_.split(" "))
    val creditsModel = CrossValidatorModel.load("file:///e:/flume/result/out")
    stream.count().map(cnt => "Received" + cnt +"flume events." ).print()
    streamEvent.foreachRDD((rdds:RDD[String],time:Time) =>{
      val session  =SparkSessionSingleton.getInstance(conf)
      val requestArray = rdds.map(r=>r.asInstanceOf[String]).collect()
      val prin = requestArray.foreach(println)
      print(requestArray.length)
      if(requestArray.length >0){
        val requestRDD = session.sparkContext.parallelize(requestArray)
        import session.implicits._
        //convert RDD[String]  to RDD[case class] to DataFrame
        val creditDataFrame = rdds.map(w =>{printf(w) ;
          val ws = w.split(",").map(_.toDouble)

          Record(Vectors.dense(ws))}).toDF()
        val trainData = creditsModel.transform(creditDataFrame)
        //creditDataFrame.createOrReplaceTempView("words")
        trainData.show()
      }

    })
    ssc.start()
    ssc.awaitTermination()
  }


}

object SparkSessionSingleton {
  @transient
  private var instance: SparkSession = _

  def getInstance(sparkConf: SparkConf): SparkSession = {
    if (instance == null) {
      instance = SparkSession.builder().config(sparkConf).getOrCreate()

    }
    instance
  }



}
