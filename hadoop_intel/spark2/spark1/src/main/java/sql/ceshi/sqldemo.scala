package sql.ceshi

import java.util.Properties

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.jdbc.{JdbcDialect, JdbcDialects}
case  class  ceshi (id:Int,name:String)
private case object HiveSqlDialect extends JdbcDialect{
  override def canHandle(url: String): Boolean = url.startsWith("jdbc:hive2")

  override def quoteIdentifier(colName: String): String = {
    s"$colName"
  }

}

object sqldemo {

  def main(args: Array[String]): Unit = {
    val hiveSqlDialect1 =  HiveSqlDialect
    JdbcDialects.registerDialect(hiveSqlDialect1)

    val spark: SparkSession = SparkSession.builder.appName("mySql").config("spark.master", "local[1]").getOrCreate
    val jdbcDF = spark.read
      .format("jdbc")
      .option("url", "jdbc:hive2://192.168.2.50:10000/")
      .option("dbtable", "test1")
      .load()
    jdbcDF.show()

  }

}
