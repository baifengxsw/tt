package cn.itcast03.Max_temp;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class YearPartitioner extends Partitioner<IntWritable,IntWritable> {

    @Override
    public int getPartition(IntWritable year, IntWritable temp, int numPartitions) {
        //numPartitions 分区树
        //或者进行if手动划分
      int y = year.get() -1970;
      if(y<=33){
          return 0;
      }else if(y>33&&y<66){
          return 1;
      }else {
          return 2;
      }


    }
}
