package cn.itcast.demo2

class Student {
  val id:Int = 1000
  private var name = "tomcat"
  val  age = 10
  //伴生对象中不可以访问
  private[this] var address ="灌云"

}
//静态方法
/**
  * 伴生对象 ，与类名相同 ，在同一文件中  main  必须为静态 外面才能进入
  *
  */
object  Student{
  def main(args: Array[String]): Unit = {
      print("123")
    println("--------------_")
    //实例化对象
    val s = new Student()
    println(s.id)
    //加private 依然可以拿到 因为这是伴生对象
    println(s.name)
    println("-------------")
  }
}
