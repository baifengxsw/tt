import cn.itcast.taggen.ReviewTag
import org.apache.spark.{SparkConf, SparkContext}

object TagGenerator {
  def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setMaster("local[4]").setAppName("标签生成")
      val sc = new SparkContext(conf)

    //从文件中读取相应的数据
    val poi_tags = sc.textFile("F:\\BaiduNetdiskDownload\\13-大数据实时计算Spark-2.1\\压缩包\\Spark-11\\Spark-11\\团购网站标签生成\\temptags.txt");

    //进行一系列mapreduce 操作
    //(商家号, “sdf ","fdsf","dsfd")
    //(过滤
    //(商家号，[sdf,gdsf,dffd])
    //调用函数 （商家号，sdf） （商家号，gdsf）（商家号，dffd）
    //((商家,sdf),1) ((商家号，gdsf），1），((商家号，dffd）1） ((商家号，dffd）1）
    //((商家,sdf),1) ((商家号，gdsf），1），((商家号，dffd）2）  reducebykey
    //（商家,[(sdf,1)])  （商家,[(sdf,1)]) （商家,[(sdf,1)])   包括下面进行合并
    //(商家,[(sdf,1),(sdf,13),(dsff,3)])


    val poi_tagList = poi_tags.map(x =>x.split("\t")).filter(e=>e.length==2).map(x =>(x(0),ReviewTag.extractTags(x(1))))
      .filter(x=>x._2.length>0).map(x=>(x._1,x._2.split(","))).flatMapValues(x=>x)
      .map(x=>((x._1,x._2),1)).reduceByKey(_+_).map(e=>(e._1._1,List((e._1._2,e._2))))
      //进行数组的拼接
      .reduceByKey(_:::_)
        .map(x =>(x._1,x._2.sortBy(x=>x._2).reverse.take(10).map(x=>(x._1+":"+x._2.toString()))))

    //保存到相应的文件
    poi_tagList.map(x=>(x._1+"\t"+x._2)).saveAsTextFile("e:/test" )

  }
}
