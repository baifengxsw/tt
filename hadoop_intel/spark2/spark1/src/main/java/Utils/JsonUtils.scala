package Utils

object JsonUtils {
  def byteArr2strArr(byteJson:Array[Byte]): Array[String] ={
    val listStr = new String(byteJson, "UTF-8")
    val str = listStr.substring(2, listStr.length - 2)
    val arr = str.split("\",\"")
    val jsonArr = arr.map(x=>x.replace("\\",""))
    jsonArr
  }
}
