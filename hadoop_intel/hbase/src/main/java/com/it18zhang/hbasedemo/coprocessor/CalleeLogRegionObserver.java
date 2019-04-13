package com.it18zhang.hbasedemo.coprocessor;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CoprocessorEnvironment;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.coprocessor.BaseRegionObserver;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.regionserver.wal.WALEdit;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 自定义区域观察者
 */
public class CalleeLogRegionObserver extends BaseRegionObserver {
    /**
     * 在插入一条数据后 跟随插入一条数据
     * @param e
     * @param put
     * @param edit
     * @param durability
     * @throws IOException
     */
    @Override
    public void postPut(ObserverContext<RegionCoprocessorEnvironment> e, Put put, WALEdit edit, Durability durability) throws IOException {
        super.postPut(e, put, edit, durability);

        TableName callLogs = TableName.valueOf("nn1:calllogs");
        TableName tableName = e.getEnvironment().getRegion().getRegionInfo().getTable();
        if(!callLogs.equals(tableName))
            return ;
        //得到主叫的rowkey
        //x , callerid ,time ,direction ,calleid ,duration
        String rowkey = Bytes.toString(put.getRow());

        String[] arr = rowkey.split(",");
        //避免循环调用
            if(arr[3].equals("1"))
                return ;
        String  hash = Util.getRegNo(arr[4],arr[2]);

        String newKey = hash+","+arr[4]+","+arr[2]+","+"1"+","+arr[1]+","+arr[5];
        Put newPut = new Put(Bytes.toBytes(newKey));
        newPut.addColumn(Bytes.toBytes("f1"),Bytes.toBytes("dummy"),Bytes.toBytes("no"));
        Table t = e.getEnvironment().getTable(tableName);
        t.put(newPut);
    }
}
