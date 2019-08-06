package detail_bag.recommovie

/**
  * 实现Rating 中 时间段和评分的二次排序
  */
class SecondarySortKey(val first:Double,val second:Double)extends Ordered[SecondarySortKey ] with Serializable {
  override def compare(other: SecondarySortKey): Int = {
      //先进行第一个字段的排序 ，然后再进行第二个字段的排序
     val num = (this.first - other.first).toInt

     if ( num == 0)
       (this.second - other.second).toInt
     else
       num

  }
}
