package cn.itcast.demo2

/**
  * 定义主构造器
  */

class Person(val id:Long , val name:String = "tom", var age:Int){
  //根据类型自动赋值
  var gender:String = _
   println("主构造方法执行")
  def this(id:Long, name:String,age:Int,gender:String){
    this(id,name,age)
    println("福构造器执行")
    this.gender = gender
    print(gender)

  }

}

object  Person{
  def main(args: Array[String]): Unit = {
    var p = new Person(1,"",16,"王")
    print(p.name)
    print(p.id)
  }
}
