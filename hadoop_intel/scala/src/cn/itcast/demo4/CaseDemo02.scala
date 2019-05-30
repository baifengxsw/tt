package cn.itcast.demo4

import scala.util.Random

/**
  * 基于对象类型的匹配
  */
object CaseDemo02  extends  App{
    val arr = Array("xia",1,2.0,CaseDemo01,2L)
    val elem = arr(Random.nextInt(arr.length))
    println(elem)
    elem match{
      case x:Int => println("Int" +x)
      case y:Double =>{
        print("double"+y)
    }
      case c:String =>{
        print("String"+c)

      }
      case CaseDemo01 =>{
        println("case demo 2")
      }
      case _ => println("我也不知道你在说啥呢")
    }

}
