package cn.itcast.demo1

import scala.collection.mutable.ArrayBuffer

object HelloWorld {
  def main(args:Array[String]): Unit ={
    def m1( f1:(Int ,Int )=>Double ): Unit ={
         print(f1(2,23))
    }

    m1((a:Int,b:Int) => (a+b).toDouble)
    ArrayBuffer
    var f2:(Int ,Int )=>Double ={
        (a ,b)=>(a+b).toDouble
    }
    println("----------------")
    m1(f2)

  }
}
