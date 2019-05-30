package sql

import org.apache.spark.sql.SparkSession

object HiveDemo {
  def main(args: Array[String]): Unit = {

    val spark=SparkSession.builder().appName("HiveMySQLApp").master("local[2]").enableHiveSupport().getOrCreate()
    //加载hive表
    val hiveDF=spark.table("emp")

    //关闭
    spark.close()


  }

}
