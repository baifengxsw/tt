package cn.itcast

import scala.io.Source

object WordCount  extends App{
  val s = Source.fromFile("e:/1.txt")
  val lines = s.getLines();
   val list: List[(String, Int)] = lines.toArray.flatMap(_.split(" ")).map((_,1)).groupBy(_._1).map(x=>(x._1,x._2.length)).toList.sortBy(x=>x._2).reverse
  println(list)


}
