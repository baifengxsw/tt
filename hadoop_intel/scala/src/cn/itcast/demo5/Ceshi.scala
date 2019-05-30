package cn.itcast.demo5

import scala.util.Random

case class Sumbit (id:String,name:String)  //这个可以new 也可以不new
case class Heart(time:Long)
case object  Check
object Ceshi  extends  App {

  val arr = Array(Check,new Heart(123),new Sumbit("1","xia"),new Random())
  val a = arr(Random.nextInt(arr.length))
  println(a)
  a match {
    case Sumbit(id,name) =>{
      println(s"$id----$name")

    }
    case Heart(time) =>{
      println(time)

    }
    case Check =>{
      println("check")
    }
    case _ =>{
      println("懵逼")
    }

  }
}
