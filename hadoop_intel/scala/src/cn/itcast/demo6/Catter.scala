package cn.itcast.demo6

import java.io.{FileOutputStream, InputStream}
import java.net.URL
import java.util.regex.Pattern

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

object Catter extends App {
  /*  val url = new URL("https://i0.hdslb.com/bfs/sycp/creative_img/201905/5be5f487cdc60235fa63c26108ebc084.jpg")
     val in: InputStream = url.openStream()
      var len = 0;
    val out = new FileOutputStream("e:/s.jpg")
    val arr = new Array[Byte](1024)
  while((len=in.read(arr))!= -1){
       out.write(arr,0,len)
      }
  out.close()
  in.close()*/

  //实现爬虫匹配
  val p = Pattern.compile("<a\\s*href=\"([\u0000-\uffff&&[^\u005c\u0022]]*)\"")
  val lines = Source.fromFile("e:/1.html").mkString

  val m = p.matcher(lines)
  while(m.find()){
    //这是匹配的值 如果要找相应的[]值 （1）
    println(m.group(1))
  }

}
