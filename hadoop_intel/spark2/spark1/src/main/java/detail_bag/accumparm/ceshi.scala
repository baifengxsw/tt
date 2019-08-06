package detail_bag.accumparm

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

object ceshi {
  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setMaster("local[*]").setAppName("Rdd moveice")
    val spark = SparkSession.builder().config(conf).getOrCreate()
    // 读取相应的文件 并进行缓存
    val sc = spark.sparkContext
    val myaccm = new MyAcculator
      //向spark注册 累加器
    sc.register(myaccm)
    sc.parallelize(Array("a","b","c","d")).foreach( x => myaccm.add(x))
    print(myaccm.value)
  }
}
