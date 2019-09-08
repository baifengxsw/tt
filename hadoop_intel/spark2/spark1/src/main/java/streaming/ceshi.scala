package streaming

import java.io.PrintWriter
import java.io.File
import java.io.FileWriter
import java.sql.{Date, Time}




object ceshi {
  def main(args: Array[String]): Unit = {

    val ssc = try {
       print(1/0)
    }catch {
      case ex: Exception => "unknown"
    }

    println(ssc)
  }
}
