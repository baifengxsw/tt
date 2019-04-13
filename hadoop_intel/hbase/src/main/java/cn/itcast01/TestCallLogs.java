package cn.itcast01;

import com.it18zhang.hbasedemo.coprocessor.Util;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.Test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;


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
        DecimalFormat dff = new DecimalFormat();
        dff.applyPattern("00000");
        String durStr = dff.format(duration);
        //因为是前包后不包  区域为 0到100
        //因为可能为负 与整数的最大值进行取模（转为正）
        //这里就是按月份进行hash
        int hash = (callerId +callTime.substring(0,6)).hashCode();
        hash = (hash&Integer.MAX_VALUE)%100;
        //这里hash 需要格式化 ，01 112
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("00");
        String regNo = df.format(hash);
        String rowKey  = regNo +','+callerId+','+callTime+','+"0"+','+calleeId+','+durStr;
        byte[] rowid = Bytes.toBytes(rowKey);
        Put put = new Put(rowid);
        put.addColumn(Bytes.toBytes("f1"),Bytes.toBytes("callerPos"),Bytes.toBytes("河北"));
        put.addColumn(Bytes.toBytes("f1"),Bytes.toBytes("calleePos"),Bytes.toBytes("河南"));
        table.put(put);
        System.out.println("over");
        conn.close();

    }
    @Test
    public void puts() throws Exception {
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        TableName tName = TableName.valueOf("nn1:calllogs");

        Table table = conn.getTable(tName);

        String callerId = "18861375623";
        String calleeId = "13456788845";

        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyyMMddHHmmss");
        String callTime = sdf.format(new Date());
        int duration = 100;
        DecimalFormat dff = new DecimalFormat();
        dff.applyPattern("00000");
        String durStr = dff.format(duration);
        //因为是前包后不包  区域为 0到100
        //因为可能为负 与整数的最大值进行取模（转为正）
        //这里就是按月份进行hash
        int hash = (callerId +callTime.substring(0,6)).hashCode();
        hash = (hash&Integer.MAX_VALUE)%100;
        System.out.println(hash);
        //这里hash 需要格式化 ，01 112
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("00");
        String regNo = df.format(hash);
        String rowKey  = regNo +','+callerId+','+callTime+','+"0"+','+calleeId+','+durStr;
        byte[] rowid = Bytes.toBytes(rowKey);
        Put put = new Put(rowid);
        put.addColumn(Bytes.toBytes("f1"),Bytes.toBytes("callerPos"),Bytes.toBytes("河北"));
        put.addColumn(Bytes.toBytes("f1"),Bytes.toBytes("calleePos"),Bytes.toBytes("河南"));
        table.put(put);
        System.out.println("over");
        conn.close();

    }

    @Test
    public void demo1() throws Exception {
        for(int i = 0;i<10;i++){
            puts();
        }
    }

    /**
     * 查询清单
     */
    @Test
    public void printCallLogs() throws Exception{
        Configuration conf = HBaseConfiguration.create();
        Connection conn = ConnectionFactory.createConnection(conf);
        TableName tName = TableName.valueOf("nn1:calllogs");
        Table table = conn.getTable(tName);
        Scan scan = new Scan();
        String callerId = "13456788845";
        String month = "201904";
        String regNo = Util.getRegNo(callerId,month);
        System.out.println(regNo);
        String startkey = regNo +","+callerId+","+month;
        scan.setStartRow(Bytes.toBytes(startkey));
        //这里序号不变
        String endMonth = "201905";
        String stopKey = regNo+","+callerId+","+endMonth;
        scan.setStopRow(Bytes.toBytes(stopKey));
        ResultScanner results = table.getScanner(scan);
        Iterator<Result> it = results.iterator();
        while(it.hasNext()){
            System.out.println(Bytes.toString(it.next().getRow()));
        }
        System.out.println("over");
    }
}
