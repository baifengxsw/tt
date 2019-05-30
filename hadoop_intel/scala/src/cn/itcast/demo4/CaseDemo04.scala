package cn.itcast.demo4

/**
  * 进行list 集合的配置  需要着重注意
  */
object CaseDemo04 extends  App {
    val list = List(0)
  list match {
    case 0 :: Nil => println("only 0")
    case x :: y :: b => println(s"x:$x-- y:$y --- b:$b")
    case 0:: a => println(s"`0  $a")
    case _ => println("我也不知道这是啥玩意")
  }

}
