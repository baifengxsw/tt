package cn.itcast
import cn.itcast.UserDraw
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable

object Demo1 {

  def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("portrait").setMaster("local[4]")

      //构建spark上下文
      val sc = new SparkContext(conf)
      //获取相应的文件
      val files = sc.textFile("F:\\BaiduNetdiskDownload\\13-大数据实时计算Spark-2.1\\压缩包\\Spark-11\\Spark-11\\用户画像\\用户画像\\userdata*.txt")


      val result1 = files.map(x =>{
        val arrs = x.split("\\|");
        (arrs(0)+arrs(15),Array(arrs(11),arrs(0),arrs(15),"1",arrs(12)))
      })

     // result1.foreach(x => println)
       val result2 = result1.filter(x => {
         x._2(2)!= "" && x._1.length>7
       }
         ).reduceByKey((a,b)=>{
         Array(a(0),a(1),a(2),String.valueOf(a(3).toInt+b(3).toInt),String.valueOf(a(4).toLong+b(4).toLong))
       })
       var appMap = new mutable.HashMap[String,Array[String]]();
       var userDrawMap = new mutable.HashMap[String,UserDraw]();
      //加载标签库
        val appTab = sc.textFile("F:\\BaiduNetdiskDownload\\13-大数据实时计算Spark-2.1\\压缩包\\Spark-11\\Spark-11\\用户画像\\用户画像\\appTab.txt")
          .map(x => {
            val arr  = x.split("\\|")
            appMap.put(arr(0),Array(arr(1),arr(2),arr(3),arr(4),arr(5),arr(6),arr(7),arr(8)))
          }
          )
         println("成功加载标签库")
      val result3 = result2.map(x => (x._2(1),x._2)).reduceByKey((a,b) =>{
         val phone = a(1);
         val  appID = a(2);

         if(appMap.contains(phone)){
           val arrs = appMap.get(phone).get
           if(!userDrawMap.contains(phone)){
             userDrawMap.put(phone,createDrawData(a,arrs(2),arrs(1).toFloat,arrs(2).toFloat,arrs(3).toFloat,arrs(4).toFloat,arrs(5).toFloat,arrs(6).toFloat,arrs(7).toFloat))
           }else{
             val userDraw1= userDrawMap.get(phone).get
             //调整性别权重
             userDraw1.protraitSex(arrs(1).toDouble,arrs(2).toDouble,a(4).toLong)
             userDraw1.protraitAge(arrs(3).toDouble,arrs(4).toDouble,arrs(5).toDouble,arrs(6).toDouble,arrs(7).toDouble,a(4).toLong)


           }
         }

        val userDraw = new UserDraw()
        Array()
      })




  }
  def createDrawData( dataArray:Array[String],favourite:String,male:Float,female:Float,age1:Float,age2:Float,age3:Float,
                    ,age4:Float,age5:Float) :UserDraw = {
        val userDraw = new UserDraw();
        userDraw.setMDN(dataArray(1))
        userDraw.setStatTimeDay(dataArray(0))
        //进行初始化
        userDraw.initAge(age1,age2,age3,age4,age5)
        userDraw.initSex(male,female)
        userDraw
  }

}
