package com.it18zhang.hbasedemo.coprocessor;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CoprocessorEnvironment;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Durability;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.coprocessor.BaseRegionObserver;
import org.apache.hadoop.hbase.coprocessor.ObserverContext;
import org.apache.hadoop.hbase.coprocessor.RegionCoprocessorEnvironment;
import org.apache.hadoop.hbase.regionserver.wal.WALEdit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 自定义区域观察者
 */
public class MyRegionObserver  extends BaseRegionObserver {
    private void outInfo(String str){
        try{
            FileWriter fw = new FileWriter("/home/hadoop/coprocessor.txt",true);
            fw.write(str+"\r\n");
            fw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void start(CoprocessorEnvironment e) throws IOException {
        super.start(e);
        outInfo("MyRegionObserver.start()");
    }

    @Override
    public void preGetOp(ObserverContext<RegionCoprocessorEnvironment> e, Get get, List<Cell> results) throws IOException {
        super.preGetOp(e, get, results);
        outInfo("MyRegionObserver.preGetOp()"+get.getRow());
    }

    @Override
    public void postGetOp(ObserverContext<RegionCoprocessorEnvironment> e, Get get, List<Cell> results) throws IOException {
        super.postGetOp(e, get, results);
        outInfo("MyRegionObserver.postGetOp()"+get.getRow());
    }

    @Override
    public void stop(CoprocessorEnvironment e) throws IOException {
        super.stop(e);
        outInfo("MyRegionObserver.stop()");
    }

    @Override
    public void preOpen(ObserverContext<RegionCoprocessorEnvironment> e) throws IOException {
        super.preOpen(e);
        outInfo("MyRegionObserver.preOpen");
    }

    @Override
    public void postOpen(ObserverContext<RegionCoprocessorEnvironment> e) {
        super.postOpen(e);
        outInfo("MyRegionObserver.postOpen");
    }

    @Override
    public void prePut(ObserverContext<RegionCoprocessorEnvironment> e, Put put, WALEdit edit, Durability durability) throws IOException {
        super.prePut(e, put, edit, durability);
        outInfo("MyRegionObserver.prePut+"+put.getRow());
    }

    @Override
    public void postPut(ObserverContext<RegionCoprocessorEnvironment> e, Put put, WALEdit edit, Durability durability) throws IOException {
        super.postPut(e, put, edit, durability);
        outInfo("MyRegionObserver.postPut"+put.getRow());
    }

    @Override
    public void preDelete(ObserverContext<RegionCoprocessorEnvironment> e, Delete delete, WALEdit edit, Durability durability) throws IOException {
        super.preDelete(e, delete, edit, durability);
        outInfo("MyRegionObserver.preDelete"+delete.getRow());
    }

    @Override
    public void postDelete(ObserverContext<RegionCoprocessorEnvironment> e, Delete delete, WALEdit edit, Durability durability) throws IOException {
        super.postDelete(e, delete, edit, durability);
        outInfo("MyRegionObserver.postDelete"+delete.getRow());
    }
}
