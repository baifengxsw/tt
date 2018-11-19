package cn.SS_Max_temp;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Partitioner;

public class YearPartitioner extends Partitioner<ComboKey,NullWritable> {
//对此必须按照年份进行分区  相同年份必须进入同一分区

    @Override
    public int getPartition(ComboKey comboKey, NullWritable nullWritable, int numPartitions) {
        int year = comboKey.getYear();
        return  year% numPartitions;
    }

}
