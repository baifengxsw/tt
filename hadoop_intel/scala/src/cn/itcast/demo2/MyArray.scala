package cn.itcast.demo2

object MyArray {
  def apply(str:String): Unit ={
    println(str)
  }

  def main(args: Array[String]): Unit = {
      val m = MyArray("laozhoa")
      val  m1 =  MyArray
      println(m)
      println(m1)
  }
}
