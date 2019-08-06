package detail_bag.accumparm

import org.apache.spark.util.AccumulatorV2

import scala.collection.mutable.ArrayBuffer

class MyAcculator extends  AccumulatorV2[String, ArrayBuffer[String] ]{
  private var result = ArrayBuffer[String]()
    //判断累加器当前是否是0值 ，在这里我们制定 数组的长度
  override def isZero: Boolean = {
    this.result.size == 0
  }
    //copy方法设置为新建累加器，并且把result赋值给新的累加器
  override def copy(): AccumulatorV2[String, ArrayBuffer[String]] ={
    val newAccum = new MyAcculator
    newAccum.result = this.result
    newAccum

  }

  override def reset(): Unit = {
    this.result = new ArrayBuffer[String]()
  }

  override def add(v: String): Unit = {
    //实现列表的相加
    this.result += v
  }
  //列表值的合并
  override def merge(other: AccumulatorV2[String, ArrayBuffer[String]]): Unit = {
    this.result.++=: (other.value)
  }

  // value 方法返回相应的值
  override def value: ArrayBuffer[String] = {
    this.result
  }
}
