package cn.itcast.demo4

/**
  * 实现对数组的匹配
  */
object CaseDemo03 extends  App{
    val arr = Array(1,3,7,0)
    arr match {
      case Array(1,2,x,y) => print("第一个:x:"+x+"y:"+y)
      case Array(2,1,7,y) => print("第二个个:y"+y)
      case Array(0,_*) => println("0------------")
      case _ => println("something else")

    }

}
