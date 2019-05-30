package cn.itcast.demo3

 class Person  extends  Animal  with Fly {
   override def aaa(): String = {
     println("我想感受到你的心")
     ""
   }


   override def chi(str: String): Unit = {

   }

   override def fly(): Unit = {
     println("我能够飞 啊")
   }
 }
