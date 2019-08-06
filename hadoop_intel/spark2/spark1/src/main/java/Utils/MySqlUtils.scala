package Utils

import java.sql.{Connection, DriverManager, ResultSet}



object MySqlUtils {
  def getConnBr(): Connection ={
    //mysql url
    val url = "jdbc:mysql://10.42.220.104:33306/br_sdk_druid?useUnicode=true&characterEncoding=utf-8&useSSL=false"
    //mysql user
    val user = "dsj"
    //mysql password
    val pass = "dsj@mysql"

    //注册Driver
    Class.forName("com.mysql.jdbc.Driver")
    //得到连接
    val connection: Connection = DriverManager.getConnection(url, user, pass)
    connection
  }
  def getConn(): Connection ={
    //mysql url
    val url = "jdbc:mysql://10.42.221.55:3306/cvm?useUnicode=true&characterEncoding=utf-8&useSSL=false&useServerPrepStmts=false&rewriteBatchedStatements=true"
    //mysql user
    val user = "cvmuser"
    //mysql password
    val pass = "Orbyun2018#"

    //注册Driver
    Class.forName("com.mysql.jdbc.Driver")
    //得到连接
    val connection: Connection = DriverManager.getConnection(url, user, pass)
    connection
  }
  def query(connection:Connection,sql:String):ResultSet   ={

    try {

      val statement = connection.createStatement
      //执行查询语句，并返回结果
      val rs: ResultSet = statement.executeQuery(sql)
      //打印返回结果
      rs
    }
  }
  def apply(connection:Connection,sql:String):Int   ={

    try {
      val statement = connection.createStatement
      //执行查询语句，并返回结果
      val rs: Int = statement.executeUpdate(sql)
      //打印返回结果
      rs
    }
  }
  def close(connection:Connection): Unit ={
    try{
      connection.close()
    }
    catch {
      case e: Exception =>
        e.printStackTrace()
    }
  }

}
