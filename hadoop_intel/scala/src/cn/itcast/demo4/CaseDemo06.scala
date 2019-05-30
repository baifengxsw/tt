package cn.itcast.demo4

/**
  * 进行元组的匹配
  */
object CaseDemo06 extends App{
    val tup = (2,3,6)
    tup match {
      case (1,x,y) =>println(s"x:$x --- y:$y")
      case (_,z,5) => println("z:"+z)
      case _ => println("我也不知道这是啥")
    }

}
