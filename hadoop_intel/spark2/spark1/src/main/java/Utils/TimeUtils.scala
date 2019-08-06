package Utils

import java.text.{ParseException, SimpleDateFormat}
import java.util.{Date, TimeZone}

import org.apache.commons.lang3.time.FastDateFormat

/**
  * Created with IntelliJ IDEA.
  * User :  Cheng ShaoPeng
  * Date :  2018/3/20
  * Time :  14:01
  * Describe :
  */


object TimeUtils {

  //2018-03-12 13:44:43
  val sdf =  FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")
 // val sdf1 =  FastDateFormat.getInstance("yyyy-MM-dd  ahh:mm:ss")
  //val sdf_d = new SimpleDateFormat("yyyyMMdd")
  val sdf_d =  FastDateFormat.getInstance("yyyyMMdd")

  def getTimeArea(ts:Long): Array[Long] ={
    val sdf: SimpleDateFormat =new SimpleDateFormat("HH")
    val hour: String = sdf.format(new Date(ts))
    if (hour.toInt <= 4){
      val tmp = TimeZone.getDefault().getRawOffset()
      val four = (ts+tmp)/(1000*3600*24)*(1000*3600*24)-tmp +14400*1000
      val yesFour = four - 86400*1000
      return Array(yesFour,four)
    }else{
      val tmp = TimeZone.getDefault().getRawOffset()
      val four = (ts+tmp)/(1000*3600*24)*(1000*3600*24)-tmp +14400*1000
      val tomFour = four + 86400*1000
      return Array(four,tomFour)
    }
  }

  def getTimestamp(eventTime:String):Long = {
    val date = sdf.parse(eventTime)
    date.getTime
  }

  def getTimestamp1(eventTime:String):Long = {
    if(eventTime.contains("上午")) {
      val strings = eventTime.split(" ")
      val hh = strings(1).split(":")(0).split("上午")(1)
      if(hh == 12){
        sdf.parse( strings(0)+" "+"0"+strings(1).charAt(2)+":"+strings(1).split(":")(1)+":"+strings(1).split(":")(2)).getTime
      }else{
        sdf.parse( strings(0)+" "+"00"+":"+strings(1).split(":")(1)+":"+strings(1).split(":")(2)).getTime
      }
    }else{
      val strings = eventTime.split(" ")
      val hh = strings(1).split(":")(0).split("下午")(1)
      if(hh == 12){
        sdf.parse( strings(0)+" "+"0"+strings(1).charAt(2)+":"+strings(1).split(":")(1)+":"+strings(1).split(":")(2)).getTime
      }else{
        sdf.parse( strings(0)+" "+"12"+":"+strings(1).split(":")(1)+":"+strings(1).split(":")(2)).getTime
      }
    }
  }

  def getEventDate(timestamp:Long):String = {
    val date = new Date()
    date.setTime(timestamp)
    sdf_d.format(date)
  }

  def isValidDate(str: String): Boolean = {
    var convertSuccess = true
    //指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    try { //设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
      format.setLenient(false)
      format.parse(str)
    } catch {
      case e: ParseException =>
        // e.printStackTrace();
        // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
        convertSuccess = false
    }
    convertSuccess
  }

}
