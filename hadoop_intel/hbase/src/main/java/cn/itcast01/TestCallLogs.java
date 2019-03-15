package cn.itcast01;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TestCallLogs {
    /**
     * rowkey 设计
     * 区号，主叫，或被叫，时间
     * xx,callerid,time,方向0主叫，1被， calleid  时长 ，duration
     * @throws Exception
     */
    @Test
    public void put() throws Exception {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        TableName tName = TableName.valueOf("nn1:calllogs");

        Table table = conn.getTable(tName);

        String callerId = "13845456767";
        String calleeId = "13968884545";

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyyMMddHHmmss");
        String callTime = sdf.format(new Date());
        int duration = 100;
        //因为是前包后不包  区域为 0到100
        //因为可能为负 与整数的最大值进行取模
        int hash = ((callerId +callTime.substring(0,6)).hashCode()& Integer.MAX_VALUE)%100;

        DecimalFormat df = new DecimalFormat();
        df.applyPattern("00");
        String regNo = df.format(hash);
        String rowKey  = regNo +','+callerId+','+callTime+','+"0"+','+calleeId+','+duration;
        byte[] rowid = Bytes.toBytes(rowKey);
        Put put = new Put(rowid);
        put.addColumn(Bytes.toBytes("fl"),Bytes.toBytes("callerPos"),Bytes.toBytes("河北"));
        put.addColumn(Bytes.toBytes("fl"),Bytes.toBytes("calleePos"),Bytes.toBytes("河男"));
        table.put(put);
        System.out.println("over");
        conn.close();

    }
}
