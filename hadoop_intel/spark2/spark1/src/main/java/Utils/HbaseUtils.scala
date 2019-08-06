package Utils

import java.io.IOException
import java.util

import com.alibaba.fastjson.{JSONArray, JSONObject}
import org.apache.hadoop.hbase.client._
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.hbase.{HBaseConfiguration, TableName}

import scala.collection.mutable.ListBuffer

/**
  * Created with IntelliJ IDEA.
  * User :  Cheng ShaoPeng
  * Date :  2018/4/1
  * Time :  15:58
  * Describe :
  */


object HbaseUtils {




  //hbase 表名

  def getConn(zookeeperList:String): Connection = {
    val config = HBaseConfiguration.create
    config.set("hbase.zookeeper.quorum", zookeeperList)
    val connection = ConnectionFactory.createConnection(config)
    connection
  }

  def addData(tableName: String, key: String, family: String, kv: util.HashMap[String, String], conn: Connection) = {
    val ht = conn.getTable(TableName.valueOf(tableName))
    val p = new Put(Bytes.toBytes(key))
    val it = kv.entrySet().iterator()
    while (it.hasNext) {
      val next = it.next()
      p.addColumn(Bytes.toBytes(family), Bytes.toBytes(next.getKey), Bytes.toBytes(next.getValue))
    }
    ht.put(p)
  }
  def addData(tableName: String, key: String, family: String, value:String, conn: Connection) = {
    val ht = conn.getTable(TableName.valueOf(tableName))
    val p = new Put(Bytes.toBytes(key))
    p.addColumn(Bytes.toBytes(family), Bytes.toBytes("c1"), Bytes.toBytes(value))
    ht.put(p)
  }
  def getData(tableName: String, key: String, family: String, kv: util.HashMap[String, String], conn: Connection): util.HashMap[String, String] = {
    val ht = conn.getTable(TableName.valueOf(tableName))
    val g = new Get(Bytes.toBytes(key))
    val result = ht.get(g)
    val hm=new util.HashMap[String,String]()
    if (result.isEmpty){
      return hm
    }else{
      val it = kv.entrySet().iterator()
      while (it.hasNext) {
        val next = it.next()
        val value = Bytes.toString(result.getValue(Bytes.toBytes(family),Bytes.toBytes(next.getKey)))
        hm.put(next.getKey,value)
      }
    }
    hm
  }
  def getFifterData(tableName: String,deviceId:String,conn: Connection): JSONArray = {
    var table: Table = null
    val json =new JSONArray()
    try {
      table = conn.getTable(TableName.valueOf(tableName))
      import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp
      import org.apache.hadoop.hbase.util.Bytes
      val filter = new SingleColumnValueFilter(Bytes.toBytes("c"), Bytes.toBytes("deviceId"), CompareOp.EQUAL, Bytes.toBytes(deviceId))
      filter.setFilterIfMissing(true)
      val scan: Scan = new Scan()
      scan.setFilter(filter)
      val results: ResultScanner = table.getScanner(scan)
      import scala.collection.JavaConversions._
      for (result <- results) {
        if (result.isEmpty){
        }else{
          val rowJson = new JSONObject()
          val key = new String(result.getRow())
          rowJson.put("key",key)
          for (cell <- result.rawCells) {
            val colName: String = Bytes.toString(cell.getQualifierArray, cell.getQualifierOffset, cell.getQualifierLength)
            val value: String = Bytes.toString(cell.getValueArray, cell.getValueOffset, cell.getValueLength)
            rowJson.put(colName,value)
          }
          json.add(rowJson)
        }
      }
      results.close()
    } catch {
      case e: IOException =>
        e.printStackTrace()
    }
    json
  }


}
