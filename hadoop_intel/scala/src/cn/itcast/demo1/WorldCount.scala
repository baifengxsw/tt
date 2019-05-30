package cn.itcast.demo1



object WorldCount {
  def main(args: Array[String]): Unit = {
    val words = Array("hello tom hello","hello tom hello tom","hello world hello jerry")
    //切分然后压平
    val word : Array[String] = words.flatMap(_.split(" "))
    //将单词和1 放在一起
    val worldAndOne: Array[(String, Int)] = word.map((_,1))
    //进行分组
    val grouped: Map[String, Array[(String, Int)]] = worldAndOne.groupBy(_._1)
    //进行单词个 数的统计
    val list = grouped.map(t=>(t._1,t._2.length)).toList.sortBy(_._2).reverse



    print(list)
  }
}
