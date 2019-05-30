package cn.itcast.demo3

class Dog {

}


object  Dog{
  def main(args: Array[String]): Unit = {
      val dog = new Dog()with Fly
    dog.fly()
  }


}