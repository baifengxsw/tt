package cn.itcast.demo4

import scala.util.Random

/**
  * 进行字符串的模式匹配
  */
object CaseDemo01 extends  App {
  val arr = Array("xia","shuang","wu")
  val name = arr(Random.nextInt(arr.length))
  println(name)
  name match {
      case "xia" => println("第一个")
      case "shuang" => {
        println("第二个")

      }
      case _ => println("鬼知道你在说什么")
      }

  }


