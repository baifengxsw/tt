package ml




import org.apache.spark.mllib.recommendation.{ALS, Rating}
import org.apache.spark.{SparkConf, SparkContext}

//1,2,3  1 用户 ，2 商品 ，3 对应的打分
object RecomDemo {
  def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("Recomm").setMaster("local[4]")
      val sc =  new SparkContext(conf)
      val data = sc.textFile("file:///e:/sample/data2.txt")
      //将数据变换为Rating
      data.map(_.split(",")).collect().foreach(
          x => {
            for (x1 <- x){
              println(x1)
            }
          }
      )
      val ratings = data.map(_.split(',') match { case Array(user, item, rate) =>
        Rating(user.toInt, item.toInt, rate.toDouble)
      })

      //使用最小二乘法构建推荐模型
      val rank = 10
      val numIterations = 10
      val model = ALS.train(ratings,rank,numIterations,0.01)
      //取出评分数据
      val usersProducets = ratings.map( _ match {case Rating(user,product,rate) => (user,product) })

      //通过模型对（user ,product) 进行预测
      val predictions = model.predict(usersProducets).map{ case Rating(user,product,rate) => ((user,product),rate)}

      predictions.collect().foreach(println)

      //对训练数据进行map
      val ratesAndPreds = ratings.map {
        case Rating(user,product,rate)=> ((user,product),rate)
      }.join(predictions)
      ratesAndPreds.collect().foreach(println)
      println("-----------------------------------")
      val MSE = ratesAndPreds.map{
        case ((user,producet),(error1,error2)) => {
          val error = error1 -error2
          error * error
        }
      }.mean()
      println(MSE)
      println("-----------------------------------")



  }
}
